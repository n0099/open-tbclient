package b.i.b.a.d0.v.g;

import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f32129a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32130b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32131c;

    /* loaded from: classes6.dex */
    public static abstract class a extends h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final int f32132d;

        /* renamed from: e  reason: collision with root package name */
        public final long f32133e;

        /* renamed from: f  reason: collision with root package name */
        public final List<d> f32134f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, long j, long j2, int i2, long j3, List<d> list) {
            super(fVar, j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {fVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((f) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32132d = i2;
            this.f32133e = j3;
            this.f32134f = list;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32132d : invokeV.intValue;
        }

        public abstract int d(long j);

        public final long e(int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                List<d> list = this.f32134f;
                if (list != null) {
                    return (list.get(i2 - this.f32132d).f32139b * 1000000) / this.f32130b;
                }
                int d2 = d(j);
                return (d2 == -1 || i2 != (c() + d2) + (-1)) ? (this.f32133e * 1000000) / this.f32130b : j - g(i2);
            }
            return invokeCommon.longValue;
        }

        public int f(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                int c2 = c();
                int d2 = d(j2);
                if (d2 == 0) {
                    return c2;
                }
                if (this.f32134f == null) {
                    int i2 = this.f32132d + ((int) (j / ((this.f32133e * 1000000) / this.f32130b)));
                    return i2 < c2 ? c2 : d2 == -1 ? i2 : Math.min(i2, (c2 + d2) - 1);
                }
                int i3 = (d2 + c2) - 1;
                int i4 = c2;
                while (i4 <= i3) {
                    int i5 = ((i3 - i4) / 2) + i4;
                    int i6 = (g(i5) > j ? 1 : (g(i5) == j ? 0 : -1));
                    if (i6 < 0) {
                        i4 = i5 + 1;
                    } else if (i6 <= 0) {
                        return i5;
                    } else {
                        i3 = i5 - 1;
                    }
                }
                return i4 == c2 ? i4 : i3;
            }
            return invokeCommon.intValue;
        }

        public final long g(int i2) {
            InterceptResult invokeI;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                List<d> list = this.f32134f;
                if (list != null) {
                    j = list.get(i2 - this.f32132d).f32138a - this.f32131c;
                } else {
                    j = (i2 - this.f32132d) * this.f32133e;
                }
                return v.F(j, 1000000L, this.f32130b);
            }
            return invokeI.longValue;
        }

        public abstract f h(g gVar, int i2);

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32134f != null : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final List<f> f32135g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, long j, long j2, int i2, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i2, j3, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {fVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((f) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (List) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32135g = list2;
        }

        @Override // b.i.b.a.d0.v.g.h.a
        public int d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.f32135g.size() : invokeJ.intValue;
        }

        @Override // b.i.b.a.d0.v.g.h.a
        public f h(g gVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i2)) == null) ? this.f32135g.get(i2 - this.f32132d) : (f) invokeLI.objValue;
        }

        @Override // b.i.b.a.d0.v.g.h.a
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final j f32136g;

        /* renamed from: h  reason: collision with root package name */
        public final j f32137h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, long j, long j2, int i2, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i2, j3, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {fVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), list, jVar, jVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((f) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (List) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32136g = jVar;
            this.f32137h = jVar2;
        }

        @Override // b.i.b.a.d0.v.g.h
        public f a(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
                j jVar = this.f32136g;
                if (jVar != null) {
                    Format format = gVar.f32120a;
                    return new f(jVar.a(format.id, 0, format.bitrate, 0L), 0L, -1L);
                }
                return super.a(gVar);
            }
            return (f) invokeL.objValue;
        }

        @Override // b.i.b.a.d0.v.g.h.a
        public int d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                List<d> list = this.f32134f;
                if (list != null) {
                    return list.size();
                }
                if (j != -9223372036854775807L) {
                    return (int) v.g(j, (this.f32133e * 1000000) / this.f32130b);
                }
                return -1;
            }
            return invokeJ.intValue;
        }

        @Override // b.i.b.a.d0.v.g.h.a
        public f h(g gVar, int i2) {
            InterceptResult invokeLI;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gVar, i2)) == null) {
                List<d> list = this.f32134f;
                if (list != null) {
                    j = list.get(i2 - this.f32132d).f32138a;
                } else {
                    j = (i2 - this.f32132d) * this.f32133e;
                }
                long j2 = j;
                j jVar = this.f32137h;
                Format format = gVar.f32120a;
                return new f(jVar.a(format.id, i2, format.bitrate, j2), 0L, -1L);
            }
            return (f) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f32138a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32139b;

        public d(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32138a = j;
            this.f32139b = j2;
        }
    }

    public h(f fVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32129a = fVar;
        this.f32130b = j;
        this.f32131c = j2;
    }

    public f a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) ? this.f32129a : (f) invokeL.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? v.F(this.f32131c, 1000000L, this.f32130b) : invokeV.longValue;
    }

    /* loaded from: classes6.dex */
    public static class e extends h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final long f32140d;

        /* renamed from: e  reason: collision with root package name */
        public final long f32141e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {fVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((f) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f32140d = j3;
            this.f32141e = j4;
        }

        public f c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.f32141e;
                if (j <= 0) {
                    return null;
                }
                return new f(null, this.f32140d, j);
            }
            return (f) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e() {
            this(null, 1L, 0L, 0L, 0L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((f) objArr[0], ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue(), ((Long) objArr[4]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
