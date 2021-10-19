package c.i.b.a.d0.v.g;

import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f33300a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33301b;

    /* renamed from: c  reason: collision with root package name */
    public final long f33302c;

    /* loaded from: classes4.dex */
    public static abstract class a extends h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final int f33303d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33304e;

        /* renamed from: f  reason: collision with root package name */
        public final List<d> f33305f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, long j2, long j3, int i2, long j4, List<d> list) {
            super(fVar, j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {fVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list};
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
            this.f33303d = i2;
            this.f33304e = j4;
            this.f33305f = list;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33303d : invokeV.intValue;
        }

        public abstract int d(long j2);

        public final long e(int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                List<d> list = this.f33305f;
                if (list != null) {
                    return (list.get(i2 - this.f33303d).f33310b * 1000000) / this.f33301b;
                }
                int d2 = d(j2);
                return (d2 == -1 || i2 != (c() + d2) + (-1)) ? (this.f33304e * 1000000) / this.f33301b : j2 - g(i2);
            }
            return invokeCommon.longValue;
        }

        public int f(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                int c2 = c();
                int d2 = d(j3);
                if (d2 == 0) {
                    return c2;
                }
                if (this.f33305f == null) {
                    int i2 = this.f33303d + ((int) (j2 / ((this.f33304e * 1000000) / this.f33301b)));
                    return i2 < c2 ? c2 : d2 == -1 ? i2 : Math.min(i2, (c2 + d2) - 1);
                }
                int i3 = (d2 + c2) - 1;
                int i4 = c2;
                while (i4 <= i3) {
                    int i5 = ((i3 - i4) / 2) + i4;
                    int i6 = (g(i5) > j2 ? 1 : (g(i5) == j2 ? 0 : -1));
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
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                List<d> list = this.f33305f;
                if (list != null) {
                    j2 = list.get(i2 - this.f33303d).f33309a - this.f33302c;
                } else {
                    j2 = (i2 - this.f33303d) * this.f33304e;
                }
                return v.F(j2, 1000000L, this.f33301b);
            }
            return invokeI.longValue;
        }

        public abstract f h(g gVar, int i2);

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33305f != null : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final List<f> f33306g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, long j2, long j3, int i2, long j4, List<d> list, List<f> list2) {
            super(fVar, j2, j3, i2, j4, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {fVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list, list2};
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
            this.f33306g = list2;
        }

        @Override // c.i.b.a.d0.v.g.h.a
        public int d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f33306g.size() : invokeJ.intValue;
        }

        @Override // c.i.b.a.d0.v.g.h.a
        public f h(g gVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i2)) == null) ? this.f33306g.get(i2 - this.f33303d) : (f) invokeLI.objValue;
        }

        @Override // c.i.b.a.d0.v.g.h.a
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final j f33307g;

        /* renamed from: h  reason: collision with root package name */
        public final j f33308h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, long j2, long j3, int i2, long j4, List<d> list, j jVar, j jVar2) {
            super(fVar, j2, j3, i2, j4, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {fVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list, jVar, jVar2};
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
            this.f33307g = jVar;
            this.f33308h = jVar2;
        }

        @Override // c.i.b.a.d0.v.g.h
        public f a(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
                j jVar = this.f33307g;
                if (jVar != null) {
                    Format format = gVar.f33291a;
                    return new f(jVar.a(format.id, 0, format.bitrate, 0L), 0L, -1L);
                }
                return super.a(gVar);
            }
            return (f) invokeL.objValue;
        }

        @Override // c.i.b.a.d0.v.g.h.a
        public int d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                List<d> list = this.f33305f;
                if (list != null) {
                    return list.size();
                }
                if (j2 != -9223372036854775807L) {
                    return (int) v.g(j2, (this.f33304e * 1000000) / this.f33301b);
                }
                return -1;
            }
            return invokeJ.intValue;
        }

        @Override // c.i.b.a.d0.v.g.h.a
        public f h(g gVar, int i2) {
            InterceptResult invokeLI;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gVar, i2)) == null) {
                List<d> list = this.f33305f;
                if (list != null) {
                    j2 = list.get(i2 - this.f33303d).f33309a;
                } else {
                    j2 = (i2 - this.f33303d) * this.f33304e;
                }
                long j3 = j2;
                j jVar = this.f33308h;
                Format format = gVar.f33291a;
                return new f(jVar.a(format.id, i2, format.bitrate, j3), 0L, -1L);
            }
            return (f) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f33309a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33310b;

        public d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33309a = j2;
            this.f33310b = j3;
        }
    }

    public h(f fVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33300a = fVar;
        this.f33301b = j2;
        this.f33302c = j3;
    }

    public f a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) ? this.f33300a : (f) invokeL.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? v.F(this.f33302c, 1000000L, this.f33301b) : invokeV.longValue;
    }

    /* loaded from: classes4.dex */
    public static class e extends h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final long f33311d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33312e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f fVar, long j2, long j3, long j4, long j5) {
            super(fVar, j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {fVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
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
            this.f33311d = j4;
            this.f33312e = j5;
        }

        public f c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.f33312e;
                if (j2 <= 0) {
                    return null;
                }
                return new f(null, this.f33311d, j2);
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
