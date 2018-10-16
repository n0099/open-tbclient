package com.baidu.searchbox.ng.ai.apps.address.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChooseAddressAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/chooseAddress";
    private static final String KEY_ADDR_PARAMS = "addrParams";
    private static final String KEY_AIAPP_ID = "appId";
    private static final String KEY_AIAPP_KEY = "appKey";
    private static final String KEY_CB = "cb";
    private static final String KEY_DATA = "data";
    private static final String KEY_HOST_KEY_HASH = "keyHash";
    private static final String KEY_OPEN_SOURCE = "openSource";
    private static final String KEY_PACKAGE_NAME = "pkgName";
    private static final String KEY_PARAMS = "params";
    public static final String MODULE_TAG = "ChooseAddress";
    private static final String OPEN_SOURCE_AIAPP = "aiapp";
    private static final int STATUS_CANCEL_CHOOSE = 1002;
    private String mCallback;

    public ChooseAddressAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.i(MODULE_TAG, "aiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        this.mCallback = parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            AiAppsLog.i(MODULE_TAG, "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CHOOSE_ADDRESS, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.address.action.ChooseAddressAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    ChooseAddressAction.this.startChooseAddressActivity(context, unitedSchemeEntity, callbackHandler, aiApp);
                    return;
                }
                AiAppsLog.i(ChooseAddressAction.MODULE_TAG, "Permission denied");
                callbackHandler.handleSchemeDispatchCallback(ChooseAddressAction.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private JSONObject parseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChooseAddressActivity(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        ActivityResultDispatcher resultDispatcher;
        Intent activityIntent = AiAppsRuntime.getAiAppChooseAddressRuntime().getActivityIntent(context);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_OPEN_SOURCE, OPEN_SOURCE_AIAPP);
        bundle.putString("appId", aiApp.id);
        bundle.putString("appKey", aiApp.getAppKey());
        bundle.putString(KEY_PACKAGE_NAME, OAuthUtils.getAppContext().getPackageName());
        bundle.putString(KEY_HOST_KEY_HASH, OAuthUtils.getKeyHash());
        activityIntent.putExtra(KEY_ADDR_PARAMS, bundle);
        if ((context instanceof ActivityResultDispatcherHolder) && (resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher()) != null) {
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.searchbox.ng.ai.apps.address.action.ChooseAddressAction.2
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
                    if (i == -1) {
                        ChooseAddressAction.this.chooseAddressFinish(unitedSchemeEntity, callbackHandler, intent);
                        return true;
                    } else if (i == 0) {
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "用户取消操作").toString(), ChooseAddressAction.this.mCallback);
                        return true;
                    } else {
                        return true;
                    }
                }
            });
            resultDispatcher.startActivityForResult(activityIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseAddressFinish(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Intent intent) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        String stringExtra = intent.getStringExtra("data");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                AiAppsLog.i(MODULE_TAG, "chooseAddress finish");
                jSONObject = new JSONObject(stringExtra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.mCallback);
        }
        jSONObject = jSONObject2;
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.mCallback);
    }
}
