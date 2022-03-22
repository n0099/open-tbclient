package c.a.p0.n0.h.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: c.a.p0.n0.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1235a {
        void a(c.a.p0.n0.e.a aVar, long j, c.a.p0.n0.j.b bVar, c.a.p0.n0.a aVar2);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public IntRange f16496b;

        public b(d dVar, IntRange range) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, range};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(range, "range");
            this.a = dVar;
            this.f16496b = range;
        }

        public final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (d) invokeV.objValue;
        }

        public final IntRange b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16496b : (IntRange) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d o1, d o2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o1, o2)) == null) {
                Intrinsics.checkNotNullParameter(o1, "o1");
                Intrinsics.checkNotNullParameter(o2, "o2");
                return o2.g() - o1.g();
            }
            return invokeLL.intValue;
        }
    }

    float a(c.a.p0.n0.e.a aVar, long j, c.a.p0.n0.j.b bVar, c.a.p0.n0.a aVar2);

    void b(c.a.p0.n0.e.a aVar);

    void clear();

    void update(int i, int i2);

    /* loaded from: classes2.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public d f16497b;

        /* renamed from: c  reason: collision with root package name */
        public d f16498c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16499d;

        public c(int i, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, boolean z, boolean z2, boolean z3, boolean z4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), dVar, dVar2, dVar3, dVar4, dVar5, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f16497b = dVar2;
            this.f16498c = dVar5;
            this.f16499d = z4;
        }

        public final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16497b : (d) invokeV.objValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16499d : invokeV.booleanValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
        }

        public final d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16498c : (d) invokeV.objValue;
        }

        public final void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f16497b = dVar;
            }
        }

        public final void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.f16499d = z;
            }
        }

        public final void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.a = i;
            }
        }

        public final void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
                this.f16498c = dVar;
            }
        }

        public /* synthetic */ c(int i, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, boolean z, boolean z2, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : dVar, (i2 & 4) != 0 ? null : dVar2, (i2 & 8) != 0 ? null : dVar3, (i2 & 16) != 0 ? null : dVar4, (i2 & 32) == 0 ? dVar5 : null, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? false : z3, (i2 & 512) == 0 ? z4 : false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.p0.n0.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final long f16500b;

        /* renamed from: c  reason: collision with root package name */
        public int f16501c;

        /* renamed from: d  reason: collision with root package name */
        public int f16502d;

        /* renamed from: e  reason: collision with root package name */
        public final int f16503e;

        /* renamed from: f  reason: collision with root package name */
        public final int f16504f;

        /* renamed from: g  reason: collision with root package name */
        public int f16505g;

        /* renamed from: h  reason: collision with root package name */
        public final int f16506h;
        public long i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1832709611, "Lc/a/p0/n0/h/i/a$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1832709611, "Lc/a/p0/n0/h/i/a$d;");
            }
        }

        public d(c.a.p0.n0.e.a item, long j, int i, int i2, int i3, int i4, int i5, int i6, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {item, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(item, "item");
            this.a = item;
            this.f16500b = j;
            this.f16501c = i;
            this.f16502d = i2;
            this.f16503e = i3;
            this.f16504f = i4;
            this.f16505g = i5;
            this.f16506h = i6;
            this.i = j2;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16501c + this.f16504f : invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16504f : invokeV.intValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16505g : invokeV.intValue;
        }

        public final c.a.p0.n0.e.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (c.a.p0.n0.e.a) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16502d + this.f16503e : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                d dVar = obj instanceof d ? (d) obj : null;
                return Intrinsics.areEqual(dVar != null ? dVar.a : null, this.a);
            }
            return invokeL.booleanValue;
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16500b + this.i : invokeV.longValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16501c : invokeV.intValue;
        }

        public final void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.f16505g = i;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (((((((((((((((((((((this.a.hashCode() * 31) + defpackage.a.a(this.f16500b)) * 31) + this.f16501c) * 31) + this.f16502d) * 31) + this.f16503e) * 31) + this.f16504f) * 31) + this.f16505g) * 31) + this.f16506h) * 31) + defpackage.a.a(this.i)) * 31) + a()) * 31) + e()) * 31) + defpackage.a.a(f()) : invokeV.intValue;
        }

        public final void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                this.f16501c = i;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "{time: " + this.f16500b + ", range: [" + this.f16501c + IStringUtil.TOP_PATH + (this.f16501c + this.f16504f) + "], index: " + this.f16505g + ", w: " + this.f16503e + '}';
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ d(c.a.p0.n0.e.a aVar, long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, j, i, i2, i3, i4, (i7 & 64) != 0 ? -1 : i5, (i7 & 128) != 0 ? 0 : i6, (i7 & 256) != 0 ? 0L : j2);
        }
    }
}
