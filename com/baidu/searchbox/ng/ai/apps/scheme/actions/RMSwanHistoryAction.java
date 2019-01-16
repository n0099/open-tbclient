package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
import rx.a.b.a;
import rx.d;
import rx.functions.b;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class RMSwanHistoryAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/deleteHistory";
    private static final String MODULE_TAG = "history";
    private static final String PARAMS_KEY_APP_ID = "appid";

    public RMSwanHistoryAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e("history", "none aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty aiApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("history", "empty joParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e("history", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
            return false;
        }
        final String optString2 = optParamsAsJo.optString("appid");
        if (TextUtils.isEmpty(optString2)) {
            AiAppsLog.e("history", "empty appId");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
            return false;
        } else if (!(context instanceof Activity)) {
            AiAppsLog.e("history", "error context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else {
            aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_MAPP_I_DELETE_HISTORY, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.RMSwanHistoryAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        RMSwanHistoryAction.this.handleRemoveHistory(unitedSchemeEntity, callbackHandler, optString2, optString);
                        return;
                    }
                    AiAppsLog.e("history", "Permission denied");
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRemoveHistory(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final String str2) {
        AiAppsLog.i("history", "start remove history");
        d.just(str).subscribeOn(Schedulers.io()).map(new f<String, Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.RMSwanHistoryAction.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            public Boolean call(String str3) {
                return Boolean.valueOf(AiAppsRuntime.getHistoryRuntime().removeSwanHistory(str3, false));
            }
        }).observeOn(a.cew()).subscribe(new b<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.RMSwanHistoryAction.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Boolean bool) {
                AiApp aiApp;
                AiAppsMessengerClient msgClient;
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(str) && (aiApp = AiApp.get()) != null && (msgClient = aiApp.getMsgClient()) != null) {
                        msgClient.sendMessage(8, str);
                    }
                    AiAppsLog.i("history", "remove success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), str2);
                    return;
                }
                AiAppsLog.w("history", "execute fail --- no match app id");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), str2);
            }
        });
    }
}
