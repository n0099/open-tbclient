package com.baidu.searchbox.ng.ai.apps.setting.oauth.request;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode;
import com.baidu.searchbox.ng.ai.apps.setting.SettingDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.AuthorizeListener;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthException;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Authorize extends OAuthRequest<Result> implements SettingDef, OAuthDef {
    private final Activity mActivity;
    private final boolean mExplicitly;
    private boolean mFlagPermit;
    private boolean mFlagTryLogin;
    private final String mScope;
    private ScopeInfo mScopeInfo;
    private String mStoken;

    public Authorize(Activity activity, boolean z, String str, boolean z2) {
        super("ma/accredit_v1");
        this.mFlagTryLogin = false;
        this.mActivity = activity;
        this.mScope = str;
        this.mFlagPermit = z;
        this.mExplicitly = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public boolean onInitialPrepare() {
        if (requireAiApp().getAccount().isLogin(this.mActivity)) {
            offerPreparation(new LoginPreparation());
        } else {
            offerPreparation(new ListPreparation());
        }
        return super.onInitialPrepare();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public boolean onFinalPrepare() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", requireAiApp().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AiAppsApsUtils.APP_KEY, requireAiApp().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", OAuthUtils.getKeyHash());
            jSONObject2.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            String hostApiKey = AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey();
            if (!TextUtils.isEmpty(hostApiKey)) {
                jSONObject2.put("host_api_key", hostApiKey);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.mFlagPermit));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        addQuery("data", jSONObject.toString());
        return super.onFinalPrepare();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public Result parse(JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("errno", 11001);
        handleBdussInvalid(this.mActivity, jSONObject);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + jSONObject.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new Result(this.mFlagPermit, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest
    protected void onRequestSuccess() {
        super.onRequestSuccess();
        AiAppsAccreditNode.cleanAccreditListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ListPreparation extends Preparation {
        private ListPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            AiAppsAccreditNode.getAccreditListData(Authorize.this.mScope, new TypedCallback<ScopeInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize.ListPreparation.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(ScopeInfo scopeInfo) {
                    Authorize.this.mScopeInfo = scopeInfo;
                    if (scopeInfo == null) {
                        ListPreparation.this.notifyReady(new Exception("no such scope"));
                        return;
                    }
                    if (scopeInfo.isUidScope() && !Authorize.this.mFlagTryLogin) {
                        Authorize.this.offerPreparation(new LoginPreparation());
                    } else {
                        Authorize.this.offerPreparation(new AuthDialogPreparation());
                    }
                    ListPreparation.this.notifyReady();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class LoginPreparation extends Preparation implements OnAiAppLoginResultListener {
        private LoginPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            Authorize.this.mFlagTryLogin = true;
            Authorize.this.requireAiApp().getAccount().login(Authorize.this.mActivity, this);
            return false;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
        public void onResult(int i) {
            OAuthUtils.log("onResult :: " + i, false);
            switch (i) {
                case -2:
                    OAuthUtils.log("login error ERR_BY_UESR_REFUSE", true);
                    notifyReady(new OAuthException("login cancel by user", 10004));
                    return;
                case -1:
                default:
                    OAuthUtils.log("login error ERR_BY_LOGIN", true);
                    notifyReady(new OAuthException("system login error", 10004));
                    return;
                case 0:
                    OAuthUtils.log("Login Preparation ok, is already login", false);
                    Authorize.this.offerPreparation(new StokenPreparation());
                    notifyReady();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class StokenPreparation extends Preparation {
        private StokenPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(Authorize.this.mActivity, new TypedCallback<Bundle>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize.StokenPreparation.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle == null) {
                        StokenPreparation.this.notifyReady(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(OAuthDef.TPL, "");
                    if (!TextUtils.isEmpty(string)) {
                        Authorize.this.mStoken = string;
                        Authorize.this.offerPreparation(new ListPreparation());
                        StokenPreparation.this.notifyReady();
                        return;
                    }
                    StokenPreparation.this.notifyReady(new OAuthException("empty stoken", 10001));
                }
            }, OAuthDef.TPL);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AuthDialogPreparation extends Preparation {
        private AuthDialogPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            final ScopeInfo scopeInfo = Authorize.this.mScopeInfo;
            if (scopeInfo == null || scopeInfo.forbidden) {
                Authorize.this.finish(new OAuthException("Illegal ScopeInfo", scopeInfo == null ? 10006 : 10005));
                return true;
            } else if (Authorize.this.mExplicitly || !Authorize.this.mFlagPermit) {
                return true;
            } else {
                if (scopeInfo.tipStatus < 0) {
                    Authorize.this.updateResultData(new Result(false, null));
                    Authorize.this.finish();
                    return true;
                } else if (scopeInfo.tipStatus > 0) {
                    Authorize.this.updateResultData(new Result(true, null));
                    Authorize.this.finish();
                    return true;
                } else {
                    OAuthUtils.postToMain(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize.AuthDialogPreparation.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OAuthUtils.showAuthDialog(Authorize.this.mActivity, Authorize.this.requireAiApp(), scopeInfo, new AuthorizeListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize.AuthDialogPreparation.1.1
                                @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.AuthorizeListener
                                public void onResult(boolean z) {
                                    Authorize.this.mFlagPermit = z;
                                    AuthDialogPreparation.this.notifyReady();
                                }
                            });
                        }
                    });
                    return false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Result {
        public final String code;
        public final boolean permit;

        private Result(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.permit = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.permit), this.code);
        }
    }
}
