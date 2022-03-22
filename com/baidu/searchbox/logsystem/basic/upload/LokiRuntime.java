package com.baidu.searchbox.logsystem.basic.upload;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s3.f;
import c.a.p0.s3.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityNeedContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes4.dex */
public class LokiRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static final ILokiIdentityContext EMPTY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-76905253, "Lcom/baidu/searchbox/logsystem/basic/upload/LokiRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-76905253, "Lcom/baidu/searchbox/logsystem/basic/upload/LokiRuntime;");
                return;
            }
        }
        EMPTY = new ILokiIdentityContext() { // from class: com.baidu.searchbox.logsystem.basic.upload.LokiRuntime.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getBDVCInfo() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getC3Aid() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getCfrom() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getDeviceScore() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getFrom() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getIID() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getSchemeHeader() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getSid() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public String getZid() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
            public boolean hasPrivacyAuthority() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
    }

    public LokiRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Inject(force = false)
    public static ILokiIdentityContext getIdentityContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f.a() : (ILokiIdentityContext) invokeV.objValue;
    }

    @Inject
    public static ILokiIdentityNeedContext getIdentityNeedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? l.a() : (ILokiIdentityNeedContext) invokeV.objValue;
    }
}
