package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.security.SchemeSecurity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class UnitedSchemeBaseDispatcher implements UnitedSchemeAbsDispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_KEY = "action";
    public static final boolean DEBUG;
    public static final String DISPATCHER_NOT_FIRST_LEVEL = "dispatcher_not_first_level";
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, UnitedSchemeBaseAction> schemeActionMap;

    /* loaded from: classes2.dex */
    public interface ConfirmDialogCallback {
        void onCancel();

        void onConfirm();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-488128274, "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-488128274, "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseDispatcher;");
                return;
            }
        }
        DEBUG = UnitedSchemeConstants.DEBUG;
        TAG = UnitedSchemeBaseDispatcher.class.getSimpleName();
    }

    public UnitedSchemeBaseDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.schemeActionMap = new HashMap();
    }

    private boolean checkConfirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, context, unitedSchemeEntity, callbackHandler)) == null) ? SchemeSecurity.needShowConfirmWindow(context, unitedSchemeEntity, callbackHandler) : invokeLLL.booleanValue;
    }

    private boolean needConfirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDispatcher(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        char c2;
        boolean invoke;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String path = unitedSchemeEntity.getPath(true);
            if (!TextUtils.isEmpty(path)) {
                Class<? extends UnitedSchemeAbsDispatcher> subDispatcher = getSubDispatcher(path);
                if (subDispatcher != null) {
                    try {
                        return subDispatcher.newInstance().dispatch(context, unitedSchemeEntity, callbackHandler);
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InstantiationException e3) {
                        e3.printStackTrace();
                    }
                } else if (!unitedSchemeEntity.isAction()) {
                    c2 = 301;
                    invoke = invoke(context, unitedSchemeEntity, callbackHandler);
                    if (!invoke && (jSONObject = unitedSchemeEntity.result) != null && jSONObject.optInt("status", -1) == 302 && c2 == 301) {
                        try {
                            unitedSchemeEntity.result.put("status", String.valueOf(301));
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return invoke;
                }
            }
            c2 = 0;
            invoke = invoke(context, unitedSchemeEntity, callbackHandler);
            if (!invoke) {
                unitedSchemeEntity.result.put("status", String.valueOf(301));
            }
            return invoke;
        }
        return invokeLLL.booleanValue;
    }

    public void addRedirectScheme(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
        }
    }

    public boolean checkPermission(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) {
                return false;
            }
            if (TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) || TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                return true;
            }
            if (DEBUG) {
                Log.d(TAG, "invoke from outside");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void confirm(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            SchemeRuntime.getSchemeIoc().showConfirmDialog(context, new ConfirmDialogCallback(this, context, unitedSchemeEntity, callbackHandler) { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UnitedSchemeBaseDispatcher this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ UnitedSchemeEntity val$entity;
                public final /* synthetic */ CallbackHandler val$handler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, unitedSchemeEntity, callbackHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$entity = unitedSchemeEntity;
                    this.val$handler = callbackHandler;
                }

                @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.ConfirmDialogCallback
                public void onCancel() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        UnitedSchemeUtility.callCallback(this.val$handler, this.val$entity, UnitedSchemeUtility.wrapCallbackParams(401));
                    }
                }

                @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher.ConfirmDialogCallback
                public void onConfirm() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.onDispatcher(this.val$context, this.val$entity, this.val$handler);
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, unitedSchemeEntity)) == null) ? dispatch(context, unitedSchemeEntity, null) : invokeLL.booleanValue;
    }

    public abstract String getDispatcherName();

    public abstract Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str);

    public abstract boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    public void regAction(UnitedSchemeBaseAction unitedSchemeBaseAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeBaseAction) == null) {
            if (DEBUG && this.schemeActionMap.containsKey(unitedSchemeBaseAction.getActionName())) {
                throw new IllegalArgumentException("duplicate action: " + unitedSchemeBaseAction);
            }
            this.schemeActionMap.put(unitedSchemeBaseAction.getActionName(), unitedSchemeBaseAction);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
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
        return invokeLLL.booleanValue;
    }
}
