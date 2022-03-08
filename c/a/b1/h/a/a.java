package c.a.b1.h.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import java.io.File;
import java.util.List;
@Singleton
@Service
/* loaded from: classes.dex */
public class a extends LoggerManager.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // com.baidu.yalog.LoggerManager.c
    public List<String> a(long j2, long j3, String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) ? b.o(j2, j3, str, str2, z, z2, str3) : (List) invokeCommon.objValue;
    }

    @Override // com.baidu.yalog.LoggerManager.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator + ".yalog";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.yalog.LoggerManager.c
    public Logger d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new b(str) : (Logger) invokeL.objValue;
    }

    @Override // com.baidu.yalog.LoggerManager.c
    public List<String> e(long j2, long j3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2})) == null) ? b.y(j2, j3, str, str2) : (List) invokeCommon.objValue;
    }

    @Override // com.baidu.yalog.LoggerManager.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.z();
        }
    }
}
