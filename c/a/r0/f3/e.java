package c.a.r0.f3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes3.dex */
public class e implements c.a.n.c.c, ILokiIdentityContext {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f17619a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1783895885, "Lc/a/r0/f3/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1783895885, "Lc/a/r0/f3/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.n.c.c
    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) ? str : (String) invokeLZ.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getBDVCInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getCfrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbConfig.getCurrentFrom() : (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c
    public String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? AppCuidRuntime.getAppCuidManager().getCuid() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getDeviceScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TbConfig.getFrom() : (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getSchemeHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TbSingleton.getInstance().getSampleId() : (String) invokeV.objValue;
    }

    @Override // c.a.n.c.c, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? f17619a : (String) invokeV.objValue;
    }
}
