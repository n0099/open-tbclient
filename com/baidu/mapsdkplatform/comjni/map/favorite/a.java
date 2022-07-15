package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public JNIFavorite b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0114a {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1725453534, "Lcom/baidu/mapsdkplatform/comjni/map/favorite/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1725453534, "Lcom/baidu/mapsdkplatform/comjni/map/favorite/a$a;");
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                a = true;
            }
        }
    }

    public a() {
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
        this.a = 0L;
        this.b = null;
        this.b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            try {
                return this.b.GetAll(this.a, bundle);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long Create = this.b.Create();
            this.a = Create;
            return Create;
        }
        return invokeV.longValue;
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.b.SetType(this.a, i) : invokeI.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.b.Remove(this.a, str) : invokeL.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            C0114a.b();
            return this.b.Add(this.a, str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? this.b.Load(this.a, str, str2, str3, i, i2, i3) : invokeCommon.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b.Release(this.a) : invokeV.intValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                return this.b.GetValue(this.a, str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            C0114a.b();
            return this.b.Update(this.a, str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b.Clear(this.a) : invokeV.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                return this.b.IsExist(this.a, str);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b.SaveCache(this.a) : invokeV.booleanValue;
    }
}
