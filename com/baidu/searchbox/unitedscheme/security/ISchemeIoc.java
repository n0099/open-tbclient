package com.baidu.searchbox.unitedscheme.security;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public interface ISchemeIoc {
    public static final ISchemeIoc EMPTY = new ISchemeIoc() { // from class: com.baidu.searchbox.unitedscheme.security.ISchemeIoc.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void doStatistic(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void processSchemeFromMobsdk(UnitedSchemeEntity unitedSchemeEntity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, context, confirmDialogCallback) == null) {
            }
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void showSchemeNotSupportDialog(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            }
        }
    };

    void doStatistic(String str, String str2);

    boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    void processSchemeFromMobsdk(UnitedSchemeEntity unitedSchemeEntity, int i2);

    void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback);

    void showSchemeNotSupportDialog(Context context);
}
