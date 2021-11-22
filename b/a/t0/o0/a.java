package b.a.t0.o0;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements b.a.t0.n0.a {
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

    @Override // b.a.t0.n0.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, i2);
        }
    }

    @Override // b.a.t0.n0.a
    public String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? z ? "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc" : "https://tcbox.baidu.com/ztbox?action=zubc" : (String) invokeZ.objValue;
    }

    @Override // b.a.t0.n0.a
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? CommonUrlParamManager.getInstance().processUrl(str) : (String) invokeL.objValue;
    }

    @Override // b.a.t0.n0.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0) : invokeV.intValue;
    }

    @Override // b.a.t0.n0.a
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? CommonUrlParamManager.getInstance().spliceNoPrivacyParams(str) : (String) invokeL.objValue;
    }

    @Override // b.a.t0.n0.a
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    @Override // b.a.t0.n0.a
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) ? b.a.t0.m0.b.d().getInt(str, i2) : invokeLI.intValue;
    }

    @Override // b.a.t0.n0.a
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) ? b.a.t0.m0.b.d().getLong(str, j) : invokeLJ.longValue;
    }

    @Override // b.a.t0.n0.a
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? AppConfig.isDebug() : invokeV.booleanValue;
    }

    @Override // b.a.t0.n0.a
    public void putInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i2) == null) {
            b.a.t0.m0.b.d().putInt(str, i2);
        }
    }

    @Override // b.a.t0.n0.a
    public void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, str, j) == null) {
            b.a.t0.m0.b.d().putLong(str, j);
        }
    }

    @Override // b.a.t0.n0.a
    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            b.a.t0.m0.b.d().putString(str, str2);
        }
    }
}
