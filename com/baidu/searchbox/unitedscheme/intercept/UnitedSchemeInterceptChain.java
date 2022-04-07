package com.baidu.searchbox.unitedscheme.intercept;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class UnitedSchemeInterceptChain {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InterceptChain";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, UnitedSchemeBaseInterceptor> mInterceptors;

    public UnitedSchemeInterceptChain() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInterceptors = Collections.synchronizedMap(new LinkedHashMap());
    }

    public void addInterceptor(UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, unitedSchemeBaseInterceptor) == null) || unitedSchemeBaseInterceptor == null) {
            return;
        }
        this.mInterceptors.put(unitedSchemeBaseInterceptor.getInterceptorName(), unitedSchemeBaseInterceptor);
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInterceptors.isEmpty() : invokeV.booleanValue;
    }

    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            try {
                for (Map.Entry<String, UnitedSchemeBaseInterceptor> entry : this.mInterceptors.entrySet()) {
                    UnitedSchemeBaseInterceptor value = entry.getValue();
                    if (value != null && value.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                if (SchemeConfig.DEBUG) {
                    Log.e(TAG, "error:" + e.getMessage());
                    return false;
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
