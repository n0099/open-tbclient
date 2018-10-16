package com.baidu.searchbox.ng.ai.apps.console.debugger;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppStreamUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DebuggerLaunchAction extends AiAppAction {
    private static final String APP_ZIP = "/app.zip";
    public static final String DATA_ERROR_URL = "errorURL";
    public static final String DATA_REMOTE_DEBUG_SWITCH = "enableSwitch";
    public static final String DATA_WHITE_LIST = "authWlist";
    private static final String ERROR_PAGE_PARAM_AUTHEN = "401";
    private static final String ERROR_PAGE_PARAM_IP = "404";
    private static final String MODULE_NAME = "/swan/debuggerlaunch";
    public static final String ON = "1";
    protected static final String TAG = "DebuggerLaunchAction";
    private static final int THREAD_POOL_SIZE = 4;
    private static final int TIME_OUT_MS = 3000;
    private static Set<String> mDeveloperCache = new HashSet();
    private static Set<String> mWhiteList;
    private RemoteDebugModel mDebugModel;
    private int mThreadCompletionCount;
    private ExecutorService mThreadService;

    public DebuggerLaunchAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        String string = AiAppsSpHelper.getsInstance().getString(DATA_REMOTE_DEBUG_SWITCH, "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !TextUtils.equals(string, "1")) {
            AiAppsLog.e(TAG, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.mDebugModel = RemoteDebugModel.obtainDebugModel(optParamsAsJo);
        if (this.mDebugModel == null) {
            Log.e(TAG, "Remote Debug params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!isModelValid()) {
            showErrorPage(context, ERROR_PAGE_PARAM_IP);
            return false;
        } else {
            if (getWhiteList().contains(AiAppsRuntime.getAiAppAccountRuntime().getUid(context)) || mDeveloperCache.contains(buildDeveloperKey(context))) {
                downloadBundle(context, unitedSchemeEntity, callbackHandler);
            } else {
                AiAppsRuntime.getAiAppAccountRuntime().developerAuthentication(this.mDebugModel.appKey, new IAiAppAccountIoc.CheckDeveloperCallback() { // from class: com.baidu.searchbox.ng.ai.apps.console.debugger.DebuggerLaunchAction.1
                    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc.CheckDeveloperCallback
                    public void onCheckFail(Exception exc) {
                        AiAppsLog.e(DebuggerLaunchAction.TAG, "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        DebuggerLaunchAction.this.showErrorPage(context, DebuggerLaunchAction.ERROR_PAGE_PARAM_AUTHEN);
                    }

                    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc.CheckDeveloperCallback
                    public void onCheckSuccess(boolean z) {
                        if (z) {
                            AiAppsLog.e(DebuggerLaunchAction.TAG, "Authentication Success");
                            DebuggerLaunchAction.mDeveloperCache.add(DebuggerLaunchAction.this.buildDeveloperKey(context));
                            DebuggerLaunchAction.this.downloadBundle(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        AiAppsLog.e(DebuggerLaunchAction.TAG, "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        DebuggerLaunchAction.this.showErrorPage(context, DebuggerLaunchAction.ERROR_PAGE_PARAM_AUTHEN);
                    }
                });
            }
            return true;
        }
    }

    private Set<String> getWhiteList() {
        if (mWhiteList == null) {
            mWhiteList = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(AiAppsSpHelper.getsInstance().getString(DATA_WHITE_LIST, ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    mWhiteList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
            }
        }
        return mWhiteList;
    }

    private boolean isModelValid() {
        return (this.mDebugModel.hostArray == null || this.mDebugModel.hostArray.length() <= 0 || TextUtils.isEmpty(this.mDebugModel.port)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildDeveloperKey(Context context) {
        return AiAppsRuntime.getAiAppAccountRuntime().getUid(context) + this.mDebugModel.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadBundle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        final File debugBundleFile = AiAppsBundleHelper.RemoteDebugBundleHelper.getDebugBundleFile();
        if (debugBundleFile.exists()) {
            debugBundleFile.delete();
        }
        this.mThreadService = Executors.newFixedThreadPool(4);
        this.mThreadCompletionCount = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mDebugModel.hostArray.length()) {
                final String remoteUrl = this.mDebugModel.getRemoteUrl(i2);
                if (TextUtils.isEmpty(remoteUrl)) {
                    int i3 = this.mThreadCompletionCount + 1;
                    this.mThreadCompletionCount = i3;
                    if (i3 >= this.mDebugModel.hostArray.length()) {
                        AiAppsLog.e(TAG, "IPs are invalid");
                        showErrorPage(context, ERROR_PAGE_PARAM_IP);
                    }
                } else {
                    this.mThreadService.execute(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.console.debugger.DebuggerLaunchAction.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DebuggerLaunchAction.this.startDownload(context, remoteUrl, debugBundleFile, unitedSchemeEntity, callbackHandler);
                        }
                    });
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = HttpManager.getDefault(context.getApplicationContext()).getRequest().url(str + APP_ZIP).connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                AiAppStreamUtils.streamToFile(executeSync.body().byteStream(), file);
                AiAppsLaunchParams aiAppsLaunchParams = new AiAppsLaunchParams();
                aiAppsLaunchParams.mAppId = this.mDebugModel.appId;
                aiAppsLaunchParams.mIsDebug = false;
                aiAppsLaunchParams.mNotInHistory = "1";
                Intent createLaunchParamsIntent = AiAppsLaunchParams.createLaunchParamsIntent(context, aiAppsLaunchParams);
                createLaunchParamsIntent.putExtra(RemoteDebugger.EXTRA_REMOTE_DEBUG_URL, str);
                context.startActivity(createLaunchParamsIntent);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.mThreadService != null) {
                    this.mThreadService.shutdownNow();
                    this.mThreadService = null;
                }
            }
        } catch (IOException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            int i = this.mThreadCompletionCount + 1;
            this.mThreadCompletionCount = i;
            if (i >= this.mDebugModel.hostArray.length()) {
                AiAppsLog.e(TAG, "IPs are invalid");
                showErrorPage(context, ERROR_PAGE_PARAM_IP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage(Context context, String str) {
        AiAppsRuntime.getDebugRuntime().showDebugErrorPage(context, AiAppsSpHelper.getsInstance().getString(DATA_ERROR_URL, "") + "?" + str);
    }
}
