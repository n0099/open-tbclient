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
    public int f34515a;

    /* renamed from: b  reason: collision with root package name */
    public int f34516b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34517c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34518d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34519e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34520f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34521g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34522h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34523i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f34524j;
    public Object k;

    /* renamed from: c.p.a.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1519a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f34525a;

        public C1519a() {
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
            this.f34525a = new a();
        }

        public C1519a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34525a.f34515a = i2;
                return this;
            }
            return (C1519a) invokeI.objValue;
        }

        @Deprecated
        public C1519a b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.f34525a.k = obj;
                return this;
            }
            return (C1519a) invokeL.objValue;
        }

        public C1519a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f34525a.f34517c = z;
                return this;
            }
            return (C1519a) invokeZ.objValue;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34525a : (a) invokeV.objValue;
        }

        public C1519a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f34525a.f34516b = i2;
                return this;
            }
            return (C1519a) invokeI.objValue;
        }

        public C1519a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f34525a.f34518d = z;
                return this;
            }
            return (C1519a) invokeZ.objValue;
        }

        @Deprecated
        public C1519a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? this : (C1519a) invokeZ.objValue;
        }

        public C1519a h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f34525a.f34519e = z;
                return this;
            }
            return (C1519a) invokeZ.objValue;
        }

        public C1519a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f34525a.f34520f = z;
                return this;
            }
            return (C1519a) invokeZ.objValue;
        }

        public C1519a j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.f34525a.f34523i = z;
                return this;
            }
            return (C1519a) invokeZ.objValue;
        }

        public C1519a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.f34525a.f34524j = z;
                return this;
            }
            return (C1519a) invokeZ.objValue;
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
        this.f34520f = true;
        this.f34522h = true;
        this.f34523i = true;
        this.f34524j = true;
    }

    @Override // c.p.a.a.a.d.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34515a : invokeV.intValue;
    }

    @Override // c.p.a.a.a.d.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34516b : invokeV.intValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34517c : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34518d : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34520f : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34521g : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34522h : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34523i : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34524j : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f34516b = i2;
        }
    }

    @Override // c.p.a.a.a.d.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f34515a = i2;
        }
    }

    @Override // c.p.a.a.a.d.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f34522h = z;
        }
    }
}
