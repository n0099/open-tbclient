package com.baidu.sapi2;

import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ShareAccountAccessor {
    public static /* synthetic */ Interceptable $ic;
    public static ShareAccountAccessor accessor;
    public transient /* synthetic */ FieldHolder $fh;

    public ShareAccountAccessor() {
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

    public static ShareAccountAccessor getAccessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ShareAccountAccessor shareAccountAccessor = accessor;
            if (shareAccountAccessor != null) {
                return shareAccountAccessor;
            }
            try {
                Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
            } catch (Exception e2) {
                Log.e(e2);
            }
            return accessor;
        }
        return (ShareAccountAccessor) invokeV.objValue;
    }

    public static void setShareAccountAccessor(ShareAccountAccessor shareAccountAccessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, shareAccountAccessor) == null) {
            if (accessor == null) {
                accessor = shareAccountAccessor;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public abstract String getExtra(SapiAccount sapiAccount);

    public abstract String getPtoken(SapiAccount sapiAccount);

    public abstract String getStoken(SapiAccount sapiAccount);

    public abstract void setAccountPkg(SapiAccount sapiAccount, String str);

    public abstract void setExtra(SapiAccount sapiAccount, String str);

    public abstract void setPtoken(SapiAccount sapiAccount, String str);

    public abstract void setStoken(SapiAccount sapiAccount, String str);

    public abstract void updatePtoken(SapiAccount sapiAccount);

    public abstract void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2);
}
