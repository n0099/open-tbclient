package com.baidu.sapi2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class SapiAccountAccessorImpl extends ShareAccountAccessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SapiAccountAccessorImpl() {
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

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public String getExtra(SapiAccount sapiAccount) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sapiAccount)) == null) ? sapiAccount.extra : (String) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public String getPtoken(SapiAccount sapiAccount) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount)) == null) ? sapiAccount.ptoken : (String) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public String getStoken(SapiAccount sapiAccount) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sapiAccount)) == null) ? sapiAccount.stoken : (String) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setAccountPkg(SapiAccount sapiAccount, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, sapiAccount, str) == null) {
            sapiAccount.setAccountPkg(str);
        }
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setExtra(SapiAccount sapiAccount, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sapiAccount, str) == null) {
            sapiAccount.extra = str;
        }
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setPtoken(SapiAccount sapiAccount, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, sapiAccount, str) == null) {
            sapiAccount.ptoken = str;
        }
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setStoken(SapiAccount sapiAccount, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, sapiAccount, str) == null) {
            sapiAccount.stoken = str;
        }
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void updatePtoken(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sapiAccount) == null) {
            sapiAccount.updatePtoken();
        }
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sapiAccount, sapiAccount2) == null) {
            sapiAccount.updateSession(sapiAccount2);
        }
    }
}
