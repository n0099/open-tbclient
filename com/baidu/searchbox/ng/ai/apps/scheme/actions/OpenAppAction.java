package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.download.DownloadActionCallback;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.util.AiAppActivityUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OpenAppAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/openApp";
    public static final String APPSEARCH_PACKAGE_NAME = "com.baidu.appsearch";
    public static final boolean DEBUG = false;
    public static final String DOWNLOAD_FROM_LOCAL = "local";
    public static final String DOWNLOAD_FROM_PLUGIN = "plugin";
    public static final String MODULE_TAG = "OpenApp";
    private static final String PARAMS_DOWNLOAD_FROM = "from";
    public static final String PARAMS_DOWNLOAD_KEY = "download";
    private static final String PARAMS_DOWNLOAD_URL = "url";
    public static final String PARAMS_OPEN_KEY = "open";
    public static final String TAG = "OpenAppAction";

    public OpenAppAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        boolean z;
        if (aiApp == null) {
            AiAppsLog.i(MODULE_TAG, "aiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            AiAppsLog.i(MODULE_TAG, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        String optString = paramAsJo.optString("open");
        if (TextUtils.isEmpty(optString)) {
            z = false;
        } else {
            AiAppsLog.i(MODULE_TAG, "open app: url=" + optString);
            z = launchApp(context, optString);
        }
        if (!z) {
            final String optString2 = paramAsJo.optString(PARAMS_DOWNLOAD_KEY);
            if (!TextUtils.isEmpty(optString2)) {
                try {
                    JSONObject jSONObject = new JSONObject(optString2);
                    String optString3 = jSONObject.optString("url");
                    String optString4 = jSONObject.optString("from");
                    if (!TextUtils.isEmpty(optString3)) {
                        AiAppsLog.i(MODULE_TAG, "download app: from=" + optString4 + ", params=" + optString2);
                        z = AiAppsRuntime.getAppDownloadRuntime().downloadApp(context, optString4, optString2, new DownloadActionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction.1
                            @Override // com.baidu.searchbox.ng.ai.apps.download.DownloadActionCallback
                            public void onActionDone(boolean z2) {
                                AiAppsLog.i(OpenAppAction.MODULE_TAG, "download status: " + z2);
                            }
                        });
                    }
                } catch (JSONException e) {
                }
            }
        }
        AiAppsLog.i(MODULE_TAG, "open app: executeResult=" + z);
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return true;
    }

    private boolean launchApp(Context context, String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setFlags(268435456);
            if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) == null) {
                return false;
            }
            AiAppActivityUtils.startActivitySafely(context, parseUri);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
