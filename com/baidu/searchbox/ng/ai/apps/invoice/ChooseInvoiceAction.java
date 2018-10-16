package com.baidu.searchbox.ng.ai.apps.invoice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
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
public class ChooseInvoiceAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/chooseInvoiceTitle";
    public static final String KEY_INVOICE = "invoice_info";
    public static final String MODULE_TAG = "chooseInvoiceTitle";
    private static final int STATUS_CODE_CANCELED = 1002;
    private static final int STATUS_CODE_CHOOSE_FAILED = 1003;

    public ChooseInvoiceAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        AiAppsLog.i(MODULE_TAG, "发票调起");
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "empty aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        } else if (TextUtils.isEmpty(aiApp.getAppKey())) {
            AiAppsLog.e(MODULE_TAG, "empty clientId");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                AiAppsLog.e(MODULE_TAG, "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                AiAppsLog.e(MODULE_TAG, "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_INVOICE, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.invoice.ChooseInvoiceAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(Boolean bool) {
                        if (bool.booleanValue()) {
                            AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, OAuthResult.RESULT_MSG_SUCCESS);
                            ChooseInvoiceAction.this.handleAuthorized(context, callbackHandler, unitedSchemeEntity, aiApp, optString);
                            return;
                        }
                        AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, OAuthResult.ERROR_MSG_UNKNOWN);
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "Permission denied").toString(), optString);
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, AiApp aiApp, final String str) {
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher != null) {
            Intent invoiceChooseIntent = getInvoiceChooseIntent(context, aiApp.id, aiApp.getAppKey());
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.searchbox.ng.ai.apps.invoice.ChooseInvoiceAction.2
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
                    String jSONObject;
                    if (i == -1 && intent != null) {
                        AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "选择成功");
                        jSONObject = UnitedSchemeUtility.wrapCallbackParamsWithEncode(ChooseInvoiceAction.parseInvoiceJson(intent.getStringExtra(ChooseInvoiceAction.KEY_INVOICE)), 0).toString();
                    } else if (i == 0) {
                        AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "取消选择");
                        jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose canceled").toString();
                    } else {
                        AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "选择失败");
                        jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose failed").toString();
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, jSONObject, str);
                    return true;
                }
            });
            resultDispatcher.startActivityForResult(invoiceChooseIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject parseInvoiceJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    private Intent getInvoiceChooseIntent(Context context, String str, String str2) {
        return AiAppsRuntime.getAiAppChooseInvoiceRuntime().getInvoiceChooseIntent(context, str, str2);
    }
}
