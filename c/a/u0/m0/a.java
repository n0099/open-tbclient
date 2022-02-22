package c.a.u0.m0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final C1199a x;
    public static int y = 52428800;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long f19460b;

    /* renamed from: c  reason: collision with root package name */
    public long f19461c;

    /* renamed from: d  reason: collision with root package name */
    public long f19462d;

    /* renamed from: e  reason: collision with root package name */
    public float f19463e;

    /* renamed from: f  reason: collision with root package name */
    public float f19464f;

    /* renamed from: g  reason: collision with root package name */
    public float f19465g;

    /* renamed from: h  reason: collision with root package name */
    public float f19466h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19467i;

    /* renamed from: j  reason: collision with root package name */
    public int f19468j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public List<? extends c.a.u0.m0.f.d.e.b> u;
    public List<? extends Object> v;
    public int w;

    /* renamed from: c.a.u0.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1199a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1199a() {
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

        public /* synthetic */ C1199a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.y : invokeV.intValue;
        }

        public final void c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                BdLog.d("DanmakuEngine Generation[" + str + "] update to " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1571232552, "Lc/a/u0/m0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1571232552, "Lc/a/u0/m0/a;");
                return;
            }
        }
        x = new C1199a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue(), ((Float) objArr[4]).floatValue(), ((Float) objArr[5]).floatValue(), ((Float) objArr[6]).floatValue(), ((Float) objArr[7]).floatValue(), ((Boolean) objArr[8]).booleanValue(), ((Integer) objArr[9]).intValue(), ((Boolean) objArr[10]).booleanValue(), ((Boolean) objArr[11]).booleanValue(), ((Integer) objArr[12]).intValue(), ((Integer) objArr[13]).intValue(), ((Integer) objArr[14]).intValue(), ((Integer) objArr[15]).intValue(), ((Integer) objArr[16]).intValue(), ((Integer) objArr[17]).intValue(), ((Integer) objArr[18]).intValue(), ((Integer) objArr[19]).intValue(), (List) objArr[20], (List) objArr[21], ((Integer) objArr[22]).intValue(), (DefaultConstructorMarker) objArr[23]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public a(int i2, long j2, long j3, long j4, float f2, float f3, float f4, float f5, boolean z, int i3, boolean z2, boolean z3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, List<? extends c.a.u0.m0.f.d.e.b> dataFilter, List<? extends Object> layoutFilter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), dataFilter, layoutFilter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i12 = newInitContext.flag;
            if ((i12 & 1) != 0) {
                int i13 = i12 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dataFilter, "dataFilter");
        Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
        this.a = i2;
        this.f19460b = j2;
        this.f19461c = j3;
        this.f19462d = j4;
        this.f19463e = f2;
        this.f19464f = f3;
        this.f19465g = f4;
        this.f19466h = f5;
        this.f19467i = z;
        this.f19468j = i3;
        this.k = z2;
        this.l = z3;
        this.m = i4;
        this.n = i5;
        this.o = i6;
        this.p = i7;
        this.q = i8;
        this.r = i9;
        this.s = i10;
        this.t = i11;
        this.u = dataFilter;
        this.v = layoutFilter;
        this.w = i4 + i5 + i6 + i7 + i8 + i9 + i10;
    }

    public final void A(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f19462d = j2;
        }
    }

    public final void B(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f19463e = f2;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.o + 1;
            this.o = i2;
            this.w++;
            x.c("cache", i2);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.q + 1;
            this.q = i2;
            this.w++;
            x.c(CloudControlRequest.REQUEST_KEY_FILTER, i2);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t++;
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.n + 1;
            this.n = i2;
            this.w++;
            x.c("layout", i2);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.p + 1;
            this.p = i2;
            this.w++;
            x.c("measure", i2);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.s++;
            this.w++;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i2 = this.r + 1;
            this.r = i2;
            this.w++;
            x.c("retainer", i2);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i2 = this.m + 1;
            this.m = i2;
            this.w++;
            x.c("visibility", i2);
        }
    }

    public final a b(int i2, long j2, long j3, long j4, float f2, float f3, float f4, float f5, boolean z, int i3, boolean z2, boolean z3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, List<? extends c.a.u0.m0.f.d.e.b> dataFilter, List<? extends Object> layoutFilter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), dataFilter, layoutFilter})) == null) {
            Intrinsics.checkNotNullParameter(dataFilter, "dataFilter");
            Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
            return new a(i2, j2, j3, j4, f2, f3, f4, f5, z, i3, z2, z3, i4, i5, i6, i7, i8, i9, i10, i11, dataFilter, layoutFilter);
        }
        return (a) invokeCommon.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.intValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.f19460b == aVar.f19460b && this.f19461c == aVar.f19461c && this.f19462d == aVar.f19462d && Intrinsics.areEqual((Object) Float.valueOf(this.f19463e), (Object) Float.valueOf(aVar.f19463e)) && Intrinsics.areEqual((Object) Float.valueOf(this.f19464f), (Object) Float.valueOf(aVar.f19464f)) && Intrinsics.areEqual((Object) Float.valueOf(this.f19465g), (Object) Float.valueOf(aVar.f19465g)) && Intrinsics.areEqual((Object) Float.valueOf(this.f19466h), (Object) Float.valueOf(aVar.f19466h)) && this.f19467i == aVar.f19467i && this.f19468j == aVar.f19468j && this.k == aVar.k && this.l == aVar.l && this.m == aVar.m && this.n == aVar.n && this.o == aVar.o && this.p == aVar.p && this.q == aVar.q && this.r == aVar.r && this.s == aVar.s && this.t == aVar.t && Intrinsics.areEqual(this.u, aVar.u) && Intrinsics.areEqual(this.v, aVar.v);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f19466h : invokeV.floatValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f19467i : invokeV.booleanValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int a = ((((((((((((((this.a * 31) + defpackage.a.a(this.f19460b)) * 31) + defpackage.a.a(this.f19461c)) * 31) + defpackage.a.a(this.f19462d)) * 31) + Float.floatToIntBits(this.f19463e)) * 31) + Float.floatToIntBits(this.f19464f)) * 31) + Float.floatToIntBits(this.f19465g)) * 31) + Float.floatToIntBits(this.f19466h)) * 31;
            boolean z = this.f19467i;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int i3 = (((a + i2) * 31) + this.f19468j) * 31;
            boolean z2 = this.k;
            int i4 = z2;
            if (z2 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z3 = this.l;
            return ((((((((((((((((((((i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u.hashCode()) * 31) + this.v.hashCode();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<? extends c.a.u0.m0.f.d.e.b>, java.util.List<c.a.u0.m0.f.d.e.b> */
    public final List<c.a.u0.m0.f.d.e.b> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.u : (List) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f19468j : invokeV.intValue;
    }

    public final long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f19461c : invokeV.longValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q : invokeV.intValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t : invokeV.intValue;
    }

    public final List<Object> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : invokeV.intValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.p : invokeV.intValue;
    }

    public final long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f19460b : invokeV.longValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.r : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.a : invokeV.intValue;
    }

    public final long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f19462d : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "DanmakuConfig(retainerPolicy=" + this.a + ", preCacheTimeMs=" + this.f19460b + ", durationMs=" + this.f19461c + ", rollingDurationMs=" + this.f19462d + ", textSizeScale=" + this.f19463e + ", timeFactor=" + this.f19464f + ", screenPart=" + this.f19465g + ", alpha=" + this.f19466h + ", bold=" + this.f19467i + ", density=" + this.f19468j + ", visibility=" + this.k + ", allowOverlap=" + this.l + ", visibilityGeneration=" + this.m + ", layoutGeneration=" + this.n + ", cacheGeneration=" + this.o + ", measureGeneration=" + this.p + ", filterGeneration=" + this.q + ", retainerGeneration=" + this.r + ", renderGeneration=" + this.s + ", firstShownGeneration=" + this.t + ", dataFilter=" + this.u + ", layoutFilter=" + this.v + ')';
        }
        return (String) invokeV.objValue;
    }

    public final float u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f19465g : invokeV.floatValue;
    }

    public final float v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f19463e : invokeV.floatValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void y(List<? extends c.a.u0.m0.f.d.e.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.u = list;
        }
    }

    public final void z(List<? extends Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.v = list;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(int i2, long j2, long j3, long j4, float f2, float f3, float f4, float f5, boolean z, int i3, boolean z2, boolean z3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, List list, List list2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r5, (i12 & 8) != 0 ? r5 : j4, (i12 & 16) != 0 ? 1.0f : f2, (i12 & 32) != 0 ? 1.0f : f3, (i12 & 64) != 0 ? 1.0f : f4, (i12 & 128) == 0 ? f5 : 1.0f, (i12 & 256) != 0 ? false : z, (i12 & 512) != 0 ? 160 : i3, (i12 & 1024) != 0 ? true : z2, (i12 & 2048) != 0 ? false : z3, (i12 & 4096) != 0 ? 0 : i4, (i12 & 8192) != 0 ? 0 : i5, (i12 & 16384) != 0 ? 0 : i6, (i12 & 32768) != 0 ? 0 : i7, (i12 & 65536) != 0 ? 0 : i8, (i12 & 131072) != 0 ? 0 : i9, (i12 & 262144) != 0 ? 0 : i10, (i12 & 524288) != 0 ? 0 : i11, (i12 & 1048576) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i12 & 2097152) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
        int i13 = (i12 & 1) != 0 ? 1 : i2;
        long j5 = (i12 & 2) != 0 ? 100L : j2;
        long j6 = (i12 & 4) != 0 ? 13000L : j3;
    }
}
