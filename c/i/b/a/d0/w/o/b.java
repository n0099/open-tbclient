package c.i.b.a.d0.w.o;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final int f33374c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33375d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33376e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33377f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33378g;

    /* renamed from: h  reason: collision with root package name */
    public final int f33379h;

    /* renamed from: i  reason: collision with root package name */
    public final int f33380i;

    /* renamed from: j  reason: collision with root package name */
    public final long f33381j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final DrmInitData n;
    public final a o;
    public final List<a> p;
    public final long q;

    /* loaded from: classes4.dex */
    public static final class a implements Comparable<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f33382e;

        /* renamed from: f  reason: collision with root package name */
        public final long f33383f;

        /* renamed from: g  reason: collision with root package name */
        public final int f33384g;

        /* renamed from: h  reason: collision with root package name */
        public final long f33385h;

        /* renamed from: i  reason: collision with root package name */
        public final String f33386i;

        /* renamed from: j  reason: collision with root package name */
        public final String f33387j;
        public final long k;
        public final long l;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, long j2, long j3) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Long) objArr2[1]).longValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4], (String) objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l)) == null) {
                if (this.f33385h > l.longValue()) {
                    return 1;
                }
                return this.f33385h < l.longValue() ? -1 : 0;
            }
            return invokeL.intValue;
        }

        public a(String str, long j2, int i2, long j3, String str2, String str3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {str, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str2, str3, Long.valueOf(j4), Long.valueOf(j5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33382e = str;
            this.f33383f = j2;
            this.f33384g = i2;
            this.f33385h = j3;
            this.f33386i = str2;
            this.f33387j = str3;
            this.k = j4;
            this.l = j5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, List<String> list, long j2, long j3, boolean z, int i3, int i4, int i5, long j4, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, list, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j4), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), drmInitData, aVar, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33374c = i2;
        this.f33376e = j3;
        this.f33377f = z;
        this.f33378g = i3;
        this.f33379h = i4;
        this.f33380i = i5;
        this.f33381j = j4;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = drmInitData;
        this.o = aVar;
        this.p = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.q = aVar2.f33385h + aVar2.f33383f;
        } else {
            this.q = 0L;
        }
        if (j2 == -9223372036854775807L) {
            j5 = -9223372036854775807L;
        } else {
            j5 = j2 >= 0 ? j2 : this.q + j2;
        }
        this.f33375d = j5;
    }

    public b a(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? new b(this.f33374c, this.f33388a, this.f33389b, this.f33375d, j2, true, i2, this.f33379h, this.f33380i, this.f33381j, this.k, this.l, this.m, this.n, this.o, this.p) : (b) invokeCommon.objValue;
    }

    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l ? this : new b(this.f33374c, this.f33388a, this.f33389b, this.f33375d, this.f33376e, this.f33377f, this.f33378g, this.f33379h, this.f33380i, this.f33381j, this.k, true, this.m, this.n, this.o, this.p) : (b) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33376e + this.q : invokeV.longValue;
    }

    public boolean d(b bVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar == null || (i2 = this.f33379h) > (i3 = bVar.f33379h)) {
                return true;
            }
            if (i2 < i3) {
                return false;
            }
            int size = this.p.size();
            int size2 = bVar.p.size();
            if (size <= size2) {
                return size == size2 && this.l && !bVar.l;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
