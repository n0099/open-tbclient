package com.baidu.searchbox.ng.ai.apps.setting.opendata;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.AuthorizeListener;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthErrorCode;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskState;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Accredit;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.searchbox.ng.ai.apps.util.task.Task;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class OpenData implements OAuthDef, OAuthErrorCode, ErrDef {
    private static final boolean DEBUG = false;
    public static final String LOG_TAG = "OpenData";
    private static final Map<String, OpenData> sSessions = new HashMap();
    public final Activity mActivity;
    private AiApp mAiApp;
    public JSONObject mOpenData;
    public final String mScope;
    private final Set<TypedCallback<OpenData>> mCallbacks = new HashSet();
    private TaskState mState = TaskState.INIT;
    private boolean mIsLogin = false;
    public final ErrCode mErr = new ErrCode().feature(8).detail(LOG_TAG);
    private boolean mIsGetUserInfo = false;
    private final Task mTask = new Task() { // from class: com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData.1
        @Override // java.lang.Runnable
        public void run() {
            OpenData.this.onStart();
        }
    };

    public static void get(Activity activity, String str, TypedCallback<OpenData> typedCallback) {
        synchronized (sSessions) {
            OpenData openData = sSessions.get(str);
            if (openData == null) {
                OpenData openData2 = new OpenData(activity, str);
                sSessions.put(str, openData2);
                openData2.start(typedCallback);
            } else {
                AiAppsLog.i(LOG_TAG, "reuse session : " + openData.toString());
                openData.addCallback(typedCallback);
            }
        }
    }

    public boolean isResultOK() {
        return TaskState.FINISHED == this.mState && 0 == this.mErr.code() && this.mOpenData != null;
    }

    public boolean isUserInfoResultOK() {
        return TaskState.FINISHED == this.mState && this.mOpenData != null;
    }

    private OpenData(Activity activity, String str) {
        this.mActivity = activity;
        this.mScope = str;
    }

    private OpenData addCallback(TypedCallback<OpenData> typedCallback) {
        if (typedCallback != null) {
            synchronized (this.mCallbacks) {
                this.mCallbacks.add(typedCallback);
            }
        }
        return this;
    }

    private void start(TypedCallback<OpenData> typedCallback) {
        AiAppsLog.i(LOG_TAG, "start session : " + this.mScope);
        this.mState = TaskState.CALLING;
        this.mIsGetUserInfo = TextUtils.equals(this.mScope, ScopeInfo.SCOPE_ID_USERINFO);
        addCallback(typedCallback);
        this.mAiApp = AiApp.get();
        if (this.mAiApp == null) {
            this.mErr.code(11L).detail("AiApp is null");
            finish();
            return;
        }
        this.mAiApp.getSetting().mAuthorizeQueue.offer(this.mTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.mAiApp.getAccount().isLogin(this.mActivity);
        requestMaOpenData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestMaOpenData() {
        new MaOpenDataRequest().regCallback(new TypedCallback<TaskResult<JSONObject>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(TaskResult<JSONObject> taskResult) {
                if (taskResult == null || !taskResult.isOk() || taskResult.mData == null) {
                    OpenData.this.mErr.code(10002L).detail("bad MaOpenData response");
                    OpenData.this.finish();
                    return;
                }
                AiAppsLog.i(OpenData.LOG_TAG, taskResult.mData.toString());
                OpenData.this.mErr.code(taskResult.mData.optInt("errno", 11001));
                OpenData.this.mErr.detail(taskResult.mData.optString("errmsg", ""));
                if (0 != OpenData.this.mErr.error()) {
                    OpenData.this.mErr.detail("by errno");
                    OpenData.this.finish();
                    return;
                }
                JSONObject optJSONObject = taskResult.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    OpenData.this.mErr.code(14L).detail("by data parse");
                    OpenData.this.finish();
                    return;
                }
                ScopeInfo parse = ScopeInfo.parse(optJSONObject.optJSONObject("scope"));
                if (parse == null) {
                    OpenData.this.mErr.code(14L).detail("illegal scope");
                    OpenData.this.finish();
                    return;
                }
                OpenData.this.mOpenData = optJSONObject.optJSONObject("opendata");
                if (parse.tipStatus < 0) {
                    OpenData.this.mErr.code(10005L).detail("by tipStatus");
                    OpenData.this.finish();
                } else if (parse.tipStatus <= 0) {
                    if (OpenData.this.mIsLogin || !parse.isUidScope()) {
                        OAuthUtils.showAuthDialog(OpenData.this.mActivity, OpenData.this.mAiApp, parse, new AuthorizeListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData.2.1
                            @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.AuthorizeListener
                            public void onResult(boolean z) {
                                if (!z) {
                                    OpenData.this.mErr.code(10003L).detail("by dialog cancel");
                                }
                                OpenData.this.requestAuth(z);
                            }
                        });
                    } else {
                        OpenData.this.login();
                    }
                } else {
                    OpenData.this.mOpenData = optJSONObject.optJSONObject("opendata");
                    OpenData.this.finish();
                }
            }
        }).call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.mAiApp.getAccount().login(this.mActivity, new OnAiAppLoginResultListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData.3
            @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
            public void onResult(int i) {
                OAuthUtils.log("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        OAuthUtils.log("login error ERR_BY_UESR_REFUSE", true);
                        OpenData.this.mErr.code(10004L).detail("login cancel by user");
                        OpenData.this.finish();
                        return;
                    case -1:
                    default:
                        OAuthUtils.log("login error ERR_BY_LOGIN", true);
                        OpenData.this.mErr.code(10004L).detail("system login error");
                        OpenData.this.finish();
                        return;
                    case 0:
                        OAuthUtils.log("Login Preparation ok, is already login", false);
                        OpenData.this.mIsLogin = true;
                        OpenData.this.requestMaOpenData();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAuth(final boolean z) {
        new Accredit(this.mActivity, z, this.mScope).regCallback(new TypedCallback<TaskResult<Accredit.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(TaskResult<Accredit.Result> taskResult) {
                if (!z && !OpenData.this.mIsGetUserInfo) {
                    OpenData.this.finish();
                } else if (taskResult == null || !taskResult.isOk() || taskResult.mData == null || taskResult.mData.openData == null) {
                    OpenData.this.mErr.code(10002L).detail("bad Accredit response");
                    OpenData.this.finish();
                } else {
                    OpenData.this.mOpenData = taskResult.mData.openData;
                    OpenData.this.finish();
                }
            }
        }).call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.mTask.finish();
        synchronized (sSessions) {
            sSessions.remove(this.mScope);
        }
        this.mState = TaskState.FINISHED;
        if (this.mOpenData == null && 0 == this.mErr.code()) {
            this.mErr.code(15L);
        }
        AiAppsLog.i(LOG_TAG, "onFinish" + toString());
        OAuthUtils.postToMain(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (OpenData.this.mCallbacks) {
                    for (TypedCallback typedCallback : OpenData.this.mCallbacks) {
                        typedCallback.onCallback(OpenData.this);
                    }
                    OpenData.this.mCallbacks.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", LOG_TAG, this.mScope, Boolean.valueOf(isResultOK()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.mErr));
        if (this.mOpenData != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.mOpenData));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class MaOpenDataRequest extends OAuthRequest<JSONObject> {
        private MaOpenDataRequest() {
            super("ma/open/data");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
        public boolean onFinalPrepare() {
            JSONObject jSONObject = new JSONObject();
            try {
                AiApp requireAiApp = requireAiApp();
                jSONObject.put("ma_id", requireAiApp.id);
                jSONObject.put("scope", OpenData.this.mScope);
                jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject.put("host_key_hash", OAuthUtils.getKeyHash());
                jSONObject.put(AiAppsApsUtils.APP_KEY, requireAiApp.getAppKey());
                String hostApiKey = AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey();
                if (!TextUtils.isEmpty(hostApiKey)) {
                    jSONObject.put("host_api_key", hostApiKey);
                }
            } catch (JSONException e) {
            }
            addQuery("data", jSONObject.toString());
            return super.onFinalPrepare();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
        public JSONObject parse(JSONObject jSONObject) throws JSONException {
            int optInt = jSONObject.optInt("errno", 11001);
            if (optInt != 0) {
                throw new JSONException("Illegal errno=" + optInt + " errms=" + jSONObject.optString("errms"));
            }
            return jSONObject;
        }
    }
}
