package com.baidu.searchbox.ng.ai.apps.core.console;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.console.ConsoleController;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ConsoleAction extends AiAppAction {
    private static final String ACTION_HIDE = "/swan/sConsole/hide";
    private static final String ACTION_REQUEST_SAN_FULL = "/swan/sConsole/getSanDataFromActiveSlave";
    private static final String ACTION_SAN_FULL = "/swan/sConsole/sanFullData2Console";
    private static final String ACTION_SAN_INC = "/swan/sConsole/sanIncData2Console";
    private static final String ACTION_SHOW = "/swan/sConsole/show";
    private static final String ACTION_SWITCH = "/swan/sConsole/debugSwitch";
    private static final String ACTION_TYPE = "/swan/sConsole";
    private static final boolean DEBUG = false;
    private static final String KEY_DATA = "data";
    private static final String KEY_DEBUG_SWITCH = "enableDebug";
    private static final String KEY_MSG = "errmsg";
    private static final String KEY_RELATE = "relate";
    private static final String TAG = "ConsoleAction";

    public ConsoleAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        boolean optBoolean;
        if (!ConsoleController.isConsoleEnabled() && !AiAppsLog.getConsoleSwitch() && !TextUtils.equals(str, ACTION_SWITCH)) {
            return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        char c = 65535;
        switch (str.hashCode()) {
            case -1742105685:
                if (str.equals(ACTION_SWITCH)) {
                    c = 0;
                    break;
                }
                break;
            case -1379115294:
                if (str.equals(ACTION_SAN_FULL)) {
                    c = 4;
                    break;
                }
                break;
            case 445086889:
                if (str.equals(ACTION_SAN_INC)) {
                    c = 3;
                    break;
                }
                break;
            case 1128561559:
                if (str.equals(ACTION_REQUEST_SAN_FULL)) {
                    c = 5;
                    break;
                }
                break;
            case 1874836862:
                if (str.equals(ACTION_HIDE)) {
                    c = 2;
                    break;
                }
                break;
            case 1875163961:
                if (str.equals(ACTION_SHOW)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (optParamsAsJo == null || (optBoolean = optParamsAsJo.optBoolean(KEY_DEBUG_SWITCH)) == ConsoleController.isConsoleEnabled()) {
                    return true;
                }
                switchConsole(context, optBoolean);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                AiAppsLog.i(TAG, " sConsole switch：" + optParamsAsJo.optBoolean(KEY_DEBUG_SWITCH));
                return true;
            case 1:
                AiAppsController.getInstance().getConsoleManager().setConsoleVisible(true);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                AiAppsLog.i(TAG, "sConsole show");
                return true;
            case 2:
                AiAppsController.getInstance().getConsoleManager().setConsoleVisible(false);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                AiAppsLog.i(TAG, "sConsole hide");
                return true;
            case 3:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    AiAppsLog.i(TAG, "send san inc data");
                    ConsoleMessageHelper.sendIncSan2Console(optParamsAsJo.toString());
                    return true;
                }
                AiAppsLog.e(TAG, "san inc data is null");
                return true;
            case 4:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    AiAppsLog.i(TAG, "send san full data");
                    ConsoleMessageHelper.sendFullSan2Console(optParamsAsJo.toString());
                    return true;
                }
                AiAppsLog.e(TAG, "san full data is null");
                return true;
            case 5:
                AiAppsLog.i(TAG, "request san full data");
                ConsoleMessageHelper.requestFullSanData();
                return true;
            default:
                return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        }
    }

    private void switchConsole(final Context context, final boolean z) {
        AiAppsRuntime.getAiAppAccountRuntime().developerAuthentication(new IAiAppAccountIoc.CheckDeveloperCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.console.ConsoleAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc.CheckDeveloperCallback
            public void onCheckFail(Exception exc) {
                authenticateFail(exc.getMessage());
                AiAppsLog.e(ConsoleAction.TAG, "onFail : Authentication exception :", exc);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc.CheckDeveloperCallback
            public void onCheckSuccess(boolean z2) {
                if (z2) {
                    ConsoleController.switchConsole(context, z);
                    AiAppsLog.e(ConsoleAction.TAG, "Authentication Success");
                    return;
                }
                AiAppsLog.e(ConsoleAction.TAG, "Authentication Fail : Not developer");
            }

            private void authenticateFail(String str) {
                String str2;
                if (TextUtils.isEmpty(str)) {
                    str2 = context.getString(R.string.aiapps_authenticate_fail);
                } else {
                    str2 = context.getString(R.string.aiapps_authenticate_fail) + "\n" + str;
                }
                new AiAppAlertDialog.Builder(context).setTitle(context.getString(R.string.aiapps_debug_switch_title)).setMessage(str2).setDecorate(new AiAppsDialogDecorate()).setPositiveButton(R.string.aiapps_confirm, (DialogInterface.OnClickListener) null).show();
            }
        });
    }
}
