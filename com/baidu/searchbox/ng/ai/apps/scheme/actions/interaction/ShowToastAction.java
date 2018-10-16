package com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShowToastAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/showToast";
    private static final boolean DEBUG = false;
    public static final int MAX_NUMBER = 14;
    public static final String PARAM_TOAST_MESSAGE_KEY = "message";
    public static final String PARAM_TOAST_PARAM_KEY = "params";
    public static final String PARAM_TOAST_TIME_KEY = "time";
    public static final String PARAM_TOAST_TYPE_KEY = "type";
    private static final String TAG = "ShowToastAction";
    public static final int TOAST_DEFAULT_MAX_LINES = 2;
    public static final String TOAST_TYPE_HIGHLIGHT = "2";
    public static final String TOAST_TYPE_HIGHLOADING = "3";
    public static final String TOAST_TYPE_NORMAL = "1";

    public ShowToastAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        if (params == null || params.size() == 0 || TextUtils.isEmpty(str)) {
            AiAppsLog.e(TAG, "params is wrong");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type", "1");
            final int duration = getDuration(jSONObject);
            final String optString2 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                AiAppsLog.e(TAG, "message is null");
                return false;
            }
            char c = 65535;
            switch (optString.hashCode()) {
                case 49:
                    if (optString.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction.ShowToastAction.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ShowToastAction.this.showNormalToast(context, callbackHandler, unitedSchemeEntity, optString2, duration);
                        }
                    });
                    break;
                case 1:
                    AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction.ShowToastAction.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ShowToastAction.this.showHighLightToast(context, callbackHandler, unitedSchemeEntity, optString2, duration);
                        }
                    });
                    break;
                case 2:
                    AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction.ShowToastAction.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ShowToastAction.this.showHighLoadingToast(context, callbackHandler, unitedSchemeEntity, optString2, duration);
                        }
                    });
                    break;
                default:
                    handleUnknownTypeToast(unitedSchemeEntity);
                    return false;
            }
            return true;
        } catch (JSONException e) {
            AiAppsLog.e(TAG, "json exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private int getDuration(JSONObject jSONObject) {
        int stringToInt = stringToInt(jSONObject.optString("time"));
        if (stringToInt <= 0) {
            return 2;
        }
        return stringToInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i) {
        UniversalToast.makeText(context, str).setDuration(i).setMaxLines(2).showToast();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHighLightToast(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i) {
        UniversalToast.makeText(context, getSubStringCN(str, 14)).setHighlightDrawable((Drawable) null).setDuration(i).showHighlightToast();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHighLoadingToast(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i) {
        UniversalToast.makeText(context, getSubStringCN(str, 14)).setDuration(i).showHighLoadingToast();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void handleUnknownTypeToast(UnitedSchemeEntity unitedSchemeEntity) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }

    public String getSubStringCN(String str, int i) {
        char[] charArray;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.trim().toCharArray()) {
            if (c >= 161) {
                i2 += 2;
                if (i2 > i) {
                    break;
                }
                stringBuffer.append(c);
            } else {
                i2++;
                if (i2 > i) {
                    break;
                }
                stringBuffer.append(c);
            }
        }
        if (i2 > i) {
            stringBuffer.append("...");
        }
        return stringBuffer.toString();
    }

    private int stringToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
