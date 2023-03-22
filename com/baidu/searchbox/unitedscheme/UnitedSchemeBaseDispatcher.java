package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.security.SchemeSecurity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class UnitedSchemeBaseDispatcher implements UnitedSchemeAbsDispatcher {
    public static final String ACTION_KEY = "action";
    public static final String DISPATCHER_NOT_FIRST_LEVEL = "dispatcher_not_first_level";
    public final Map<String, UnitedSchemeBaseAction> schemeActionMap = new HashMap();
    public static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    public static final String TAG = UnitedSchemeBaseDispatcher.class.getSimpleName();

    /* loaded from: classes2.dex */
    public interface ConfirmDialogCallback {
        void onCancel();

        void onConfirm();
    }

    private boolean needConfirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    public void addRedirectScheme(HashMap<String, String> hashMap) {
    }

    public abstract String getDispatcherName();

    public abstract Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str);

    public abstract boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    private boolean checkConfirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return SchemeSecurity.needShowConfirmWindow(context, unitedSchemeEntity, callbackHandler);
    }

    public void confirm(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        SchemeRuntime.getSchemeIoc().showConfirmDialog(context, new ConfirmDialogCallback() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.1
            @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.ConfirmDialogCallback
            public void onCancel() {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(401));
            }

            @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.ConfirmDialogCallback
            public void onConfirm() {
                UnitedSchemeBaseDispatcher.this.onDispatcher(context, unitedSchemeEntity, callbackHandler);
            }
        });
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (!checkPermission(context, unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
            return false;
        } else if (needConfirm(context, unitedSchemeEntity, callbackHandler) && checkConfirm(context, unitedSchemeEntity, callbackHandler)) {
            confirm(context, unitedSchemeEntity, callbackHandler);
            return true;
        } else {
            return onDispatcher(context, unitedSchemeEntity, callbackHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDispatcher(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        char c;
        boolean invoke;
        JSONObject jSONObject;
        String path = unitedSchemeEntity.getPath(true);
        if (!TextUtils.isEmpty(path)) {
            Class<? extends UnitedSchemeAbsDispatcher> subDispatcher = getSubDispatcher(path);
            if (subDispatcher != null) {
                try {
                    return subDispatcher.newInstance().dispatch(context, unitedSchemeEntity, callbackHandler);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
            } else if (!unitedSchemeEntity.isAction()) {
                c = 301;
                invoke = invoke(context, unitedSchemeEntity, callbackHandler);
                if (!invoke && (jSONObject = unitedSchemeEntity.result) != null && jSONObject.optInt("status", -1) == 302 && c == 301) {
                    try {
                        unitedSchemeEntity.result.put("status", String.valueOf(301));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                return invoke;
            }
        }
        c = 0;
        invoke = invoke(context, unitedSchemeEntity, callbackHandler);
        if (!invoke) {
            unitedSchemeEntity.result.put("status", String.valueOf(301));
        }
        return invoke;
    }

    public boolean checkPermission(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) {
            return false;
        }
        if (TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) || TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            return true;
        }
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "invoke from outside");
        return true;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return dispatch(context, unitedSchemeEntity, null);
    }

    public void regAction(UnitedSchemeBaseAction unitedSchemeBaseAction) {
        if (DEBUG && this.schemeActionMap.containsKey(unitedSchemeBaseAction.getActionName())) {
            throw new IllegalArgumentException("duplicate action: " + unitedSchemeBaseAction);
        }
        this.schemeActionMap.put(unitedSchemeBaseAction.getActionName(), unitedSchemeBaseAction);
    }
}
