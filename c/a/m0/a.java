package c.a.m0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Deprecated
    public int a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public int f3860b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public int f3861c;

    /* renamed from: d  reason: collision with root package name */
    public String f3862d;

    /* renamed from: e  reason: collision with root package name */
    public String f3863e;

    /* renamed from: f  reason: collision with root package name */
    public Tri f3864f;

    /* renamed from: g  reason: collision with root package name */
    public Tri f3865g;

    /* renamed from: h  reason: collision with root package name */
    public Tri f3866h;

    /* renamed from: i  reason: collision with root package name */
    public Tri f3867i;

    /* renamed from: j  reason: collision with root package name */
    public int f3868j;

    /* renamed from: k  reason: collision with root package name */
    public int f3869k;
    public int l;
    public int m;

    /* renamed from: c.a.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0154a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a a;

        public C0154a() {
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
            this.a = new a();
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (a) invokeV.objValue;
        }

        public C0154a b(Tri tri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tri)) == null) {
                this.a.f3865g = tri;
                return this;
            }
            return (C0154a) invokeL.objValue;
        }

        public C0154a c(Tri tri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tri)) == null) {
                this.a.f3864f = tri;
                return this;
            }
            return (C0154a) invokeL.objValue;
        }

        public C0154a d(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
                if (i2 > 0 && i3 <= 100 && i3 >= i2) {
                    this.a.f3868j = i2;
                    this.a.f3869k = i3;
                    return this;
                }
                throw new IllegalArgumentException("argument out of valid range!");
            }
            return (C0154a) invokeII.objValue;
        }

        public C0154a e(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
                if (i2 >= 10 && i3 <= 100 && i3 >= i2 && i2 % 10 == 0 && i3 % 10 == 0) {
                    this.a.l = i2;
                    this.a.m = i3;
                    return this;
                }
                throw new IllegalArgumentException("argument out of valid range!");
            }
            return (C0154a) invokeII.objValue;
        }
    }

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
                return;
            }
        }
        this.a = 0;
        this.f3860b = 0;
        this.f3861c = 32;
        Tri tri = Tri.UNDEFINED;
        this.f3864f = tri;
        this.f3865g = tri;
        this.f3866h = tri;
        this.f3867i = tri;
    }

    public Tri g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3867i : (Tri) invokeV.objValue;
    }

    public Tri h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3866h : (Tri) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3860b : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3863e : (String) invokeV.objValue;
    }

    public Tri l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3864f : (Tri) invokeV.objValue;
    }

    public Tri m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3865g : (Tri) invokeV.objValue;
    }

    @Deprecated
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3861c : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3869k : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3868j : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f3862d : (String) invokeV.objValue;
    }
}
