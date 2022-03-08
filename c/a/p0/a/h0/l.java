package c.a.p0.a.h0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class l implements c.a.p0.a.e2.f.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.e2.f.e a;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.X(n.p(), n.t());
    }

    @Override // c.a.p0.a.e2.f.d
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? n.Y(str) : (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!a.USER_DATA_PATH.equals(str)) {
                    if (str.startsWith(a.USER_DATA_PATH + File.separator)) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return n.N("bdfile://tmp" + File.separator + str);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    @NonNull
    public synchronized c.a.p0.a.e2.f.e d() {
        InterceptResult invokeV;
        c.a.p0.a.e2.f.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new m();
                }
                eVar = this.a;
            }
            return eVar;
        }
        return (c.a.p0.a.e2.f.e) invokeV.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (c.a.p0.a.e2.b.s(str) == PathType.RELATIVE) {
                return n.Y(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? n.P(a.USER_DATA_PATH) : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? n.Z(str) : (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? g(str) : (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String B = n.B(str);
            if (TextUtils.isEmpty(B)) {
                return null;
            }
            return B;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) ? n.V(str) : invokeLZ.booleanValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? n.N("bdfile://tmp") : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.a.e2.f.d
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? e(str) : (String) invokeL.objValue;
    }
}
