package c.p.a.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements c.p.a.a.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34492a;

    /* renamed from: b  reason: collision with root package name */
    public int f34493b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34494c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34495d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34496e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34497f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34498g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34499h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34500i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f34501j;
    public Object k;

    /* renamed from: c.p.a.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1520a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f34502a;

        public C1520a() {
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
            this.f34502a = new a();
        }

        public C1520a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34502a.f34492a = i2;
                return this;
            }
            return (C1520a) invokeI.objValue;
        }

        @Deprecated
        public C1520a b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.f34502a.k = obj;
                return this;
            }
            return (C1520a) invokeL.objValue;
        }

        public C1520a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f34502a.f34494c = z;
                return this;
            }
            return (C1520a) invokeZ.objValue;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34502a : (a) invokeV.objValue;
        }

        public C1520a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f34502a.f34493b = i2;
                return this;
            }
            return (C1520a) invokeI.objValue;
        }

        public C1520a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f34502a.f34495d = z;
                return this;
            }
            return (C1520a) invokeZ.objValue;
        }

        @Deprecated
        public C1520a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? this : (C1520a) invokeZ.objValue;
        }

        public C1520a h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f34502a.f34496e = z;
                return this;
            }
            return (C1520a) invokeZ.objValue;
        }

        public C1520a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f34502a.f34497f = z;
                return this;
            }
            return (C1520a) invokeZ.objValue;
        }

        public C1520a j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.f34502a.f34500i = z;
                return this;
            }
            return (C1520a) invokeZ.objValue;
        }

        public C1520a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.f34502a.f34501j = z;
                return this;
            }
            return (C1520a) invokeZ.objValue;
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
        this.f34497f = true;
        this.f34499h = true;
        this.f34500i = true;
        this.f34501j = true;
    }

    @Override // c.p.a.a.a.d.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34492a : invokeV.intValue;
    }

    @Override // c.p.a.a.a.d.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34493b : invokeV.intValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34494c : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34495d : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34497f : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34498g : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34499h : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34500i : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34501j : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f34493b = i2;
        }
    }

    @Override // c.p.a.a.a.d.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f34492a = i2;
        }
    }

    @Override // c.p.a.a.a.d.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f34499h = z;
        }
    }
}
