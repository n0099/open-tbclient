package b.i.b.a.d0.w.o;

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
/* loaded from: classes6.dex */
public final class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final int f32202c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32203d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32204e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f32205f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32206g;

    /* renamed from: h  reason: collision with root package name */
    public final int f32207h;

    /* renamed from: i  reason: collision with root package name */
    public final int f32208i;
    public final long j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final DrmInitData n;
    public final a o;
    public final List<a> p;
    public final long q;

    /* loaded from: classes6.dex */
    public static final class a implements Comparable<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f32209e;

        /* renamed from: f  reason: collision with root package name */
        public final long f32210f;

        /* renamed from: g  reason: collision with root package name */
        public final int f32211g;

        /* renamed from: h  reason: collision with root package name */
        public final long f32212h;

        /* renamed from: i  reason: collision with root package name */
        public final String f32213i;
        public final String j;
        public final long k;
        public final long l;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
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
                if (this.f32212h > l.longValue()) {
                    return 1;
                }
                return this.f32212h < l.longValue() ? -1 : 0;
            }
            return invokeL.intValue;
        }

        public a(String str, long j, int i2, long j2, String str2, String str3, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), str2, str3, Long.valueOf(j3), Long.valueOf(j4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32209e = str;
            this.f32210f = j;
            this.f32211g = i2;
            this.f32212h = j2;
            this.f32213i = str2;
            this.j = str3;
            this.k = j3;
            this.l = j4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, List<String> list, long j, long j2, boolean z, int i3, int i4, int i5, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, list, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j3), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), drmInitData, aVar, list2};
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
        this.f32202c = i2;
        this.f32204e = j2;
        this.f32205f = z;
        this.f32206g = i3;
        this.f32207h = i4;
        this.f32208i = i5;
        this.j = j3;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = drmInitData;
        this.o = aVar;
        this.p = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.q = aVar2.f32212h + aVar2.f32210f;
        } else {
            this.q = 0L;
        }
        if (j == -9223372036854775807L) {
            j4 = -9223372036854775807L;
        } else {
            j4 = j >= 0 ? j : this.q + j;
        }
        this.f32203d = j4;
    }

    public b a(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? new b(this.f32202c, this.f32214a, this.f32215b, this.f32203d, j, true, i2, this.f32207h, this.f32208i, this.j, this.k, this.l, this.m, this.n, this.o, this.p) : (b) invokeCommon.objValue;
    }

    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l ? this : new b(this.f32202c, this.f32214a, this.f32215b, this.f32203d, this.f32204e, this.f32205f, this.f32206g, this.f32207h, this.f32208i, this.j, this.k, true, this.m, this.n, this.o, this.p) : (b) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32204e + this.q : invokeV.longValue;
    }

    public boolean d(b bVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar == null || (i2 = this.f32207h) > (i3 = bVar.f32207h)) {
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
