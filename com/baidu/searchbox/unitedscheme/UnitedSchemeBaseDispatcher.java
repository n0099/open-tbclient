package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.security.SchemeSecurity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes14.dex */
public abstract class UnitedSchemeBaseDispatcher implements UnitedSchemeAbsDispatcher {
    public static final String ACTION_KEY = "action";
    private static final boolean DEBUG = false;
    public static final String DISPATCHER_NOT_FIRST_LEVEL = "dispatcher_not_first_level";
    private static final String TAG = UnitedSchemeBaseDispatcher.class.getSimpleName();
    protected final Map<String, UnitedSchemeBaseAction> schemeActionMap = new HashMap();

    /* loaded from: classes14.dex */
    public interface ConfirmDialogCallback {
        void onCancel();

        void onConfirm();
    }

    public abstract String getDispatcherName();

    public abstract Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str);

    public abstract boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    public void addRedirectScheme(HashMap<String, String> hashMap) {
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return dispatch(context, unitedSchemeEntity, null);
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
        boolean z;
        boolean invoke;
        String path = unitedSchemeEntity.getPath(true);
        if (!TextUtils.isEmpty(path)) {
            Class<? extends UnitedSchemeAbsDispatcher> subDispatcher = getSubDispatcher(path);
            if (subDispatcher != null) {
                try {
                    return subDispatcher.newInstance().dispatch(context, unitedSchemeEntity, callbackHandler);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    z = false;
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                    z = false;
                }
            } else if (!unitedSchemeEntity.isAction()) {
                z = true;
            }
            invoke = invoke(context, unitedSchemeEntity, callbackHandler);
            if (!invoke && unitedSchemeEntity.result != null && unitedSchemeEntity.result.optInt("status", -1) == 302 && z) {
                try {
                    unitedSchemeEntity.result.put("status", String.valueOf(301));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return invoke;
        }
        z = false;
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
        return TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) || TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
    }

    private boolean needConfirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    private boolean checkConfirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return SchemeSecurity.needShowConfirmWindow(context, unitedSchemeEntity, callbackHandler);
    }

    public void confirm(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        SchemeRuntime.getSchemeIoc().showConfirmDialog(context, new ConfirmDialogCallback() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.1
            @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.ConfirmDialogCallback
            public void onConfirm() {
                UnitedSchemeBaseDispatcher.this.onDispatcher(context, unitedSchemeEntity, callbackHandler);
            }

            @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.ConfirmDialogCallback
            public void onCancel() {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(401));
            }
        });
    }

    public void regAction(UnitedSchemeBaseAction unitedSchemeBaseAction) {
        this.schemeActionMap.put(unitedSchemeBaseAction.getActionName(), unitedSchemeBaseAction);
    }
}
