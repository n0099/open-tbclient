package c.a.t0.m0.h.i;

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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: c.a.t0.m0.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1192a {
        void a(c.a.t0.m0.e.a aVar, long j2, c.a.t0.m0.j.b bVar, c.a.t0.m0.a aVar2);
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public IntRange f19777b;

        public b(d dVar, IntRange range) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, range};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(range, "range");
            this.a = dVar;
            this.f19777b = range;
        }

        public final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (d) invokeV.objValue;
        }

        public final IntRange b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19777b : (IntRange) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

    float a(c.a.t0.m0.e.a aVar, long j2, c.a.t0.m0.j.b bVar, c.a.t0.m0.a aVar2);

    void b(c.a.t0.m0.e.a aVar);

    void clear();

    void update(int i2, int i3);

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public d f19778b;

        /* renamed from: c  reason: collision with root package name */
        public d f19779c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19780d;

        public c(int i2, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, boolean z, boolean z2, boolean z3, boolean z4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), dVar, dVar2, dVar3, dVar4, dVar5, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f19778b = dVar2;
            this.f19779c = dVar5;
            this.f19780d = z4;
        }

        public final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19778b : (d) invokeV.objValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19780d : invokeV.booleanValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
        }

        public final d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19779c : (d) invokeV.objValue;
        }

        public final void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f19778b = dVar;
            }
        }

        public final void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.f19780d = z;
            }
        }

        public final void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.a = i2;
            }
        }

        public final void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
                this.f19779c = dVar;
            }
        }

        public /* synthetic */ c(int i2, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, boolean z, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : dVar, (i3 & 4) != 0 ? null : dVar2, (i3 & 8) != 0 ? null : dVar3, (i3 & 16) != 0 ? null : dVar4, (i3 & 32) == 0 ? dVar5 : null, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? false : z2, (i3 & 256) != 0 ? false : z3, (i3 & 512) == 0 ? z4 : false);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.t0.m0.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final long f19781b;

        /* renamed from: c  reason: collision with root package name */
        public int f19782c;

        /* renamed from: d  reason: collision with root package name */
        public int f19783d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19784e;

        /* renamed from: f  reason: collision with root package name */
        public final int f19785f;

        /* renamed from: g  reason: collision with root package name */
        public int f19786g;

        /* renamed from: h  reason: collision with root package name */
        public final int f19787h;

        /* renamed from: i  reason: collision with root package name */
        public long f19788i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1607426470, "Lc/a/t0/m0/h/i/a$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1607426470, "Lc/a/t0/m0/h/i/a$d;");
            }
        }

        public d(c.a.t0.m0.e.a item, long j2, int i2, int i3, int i4, int i5, int i6, int i7, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {item, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(item, "item");
            this.a = item;
            this.f19781b = j2;
            this.f19782c = i2;
            this.f19783d = i3;
            this.f19784e = i4;
            this.f19785f = i5;
            this.f19786g = i6;
            this.f19787h = i7;
            this.f19788i = j3;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19782c + this.f19785f : invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19785f : invokeV.intValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19786g : invokeV.intValue;
        }

        public final c.a.t0.m0.e.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (c.a.t0.m0.e.a) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19783d + this.f19784e : invokeV.intValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19781b + this.f19788i : invokeV.longValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19782c : invokeV.intValue;
        }

        public final void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f19786g = i2;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (((((((((((((((((((((this.a.hashCode() * 31) + defpackage.a.a(this.f19781b)) * 31) + this.f19782c) * 31) + this.f19783d) * 31) + this.f19784e) * 31) + this.f19785f) * 31) + this.f19786g) * 31) + this.f19787h) * 31) + defpackage.a.a(this.f19788i)) * 31) + a()) * 31) + e()) * 31) + defpackage.a.a(f()) : invokeV.intValue;
        }

        public final void i(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.f19782c = i2;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "{time: " + this.f19781b + ", range: [" + this.f19782c + IStringUtil.TOP_PATH + (this.f19782c + this.f19785f) + "], index: " + this.f19786g + ", w: " + this.f19784e + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ d(c.a.t0.m0.e.a aVar, long j2, int i2, int i3, int i4, int i5, int i6, int i7, long j3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, j2, i2, i3, i4, i5, (i8 & 64) != 0 ? -1 : i6, (i8 & 128) != 0 ? 0 : i7, (i8 & 256) != 0 ? 0L : j3);
        }
    }
}
