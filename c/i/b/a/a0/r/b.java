package c.i.b.a.a0.r;

import c.i.b.a.a0.l;
import c.i.b.a.a0.r.h;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes9.dex */
public final class b extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.i.b.a.i0.f n;
    public a o;

    /* loaded from: classes9.dex */
    public class a implements f, l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;

        /* renamed from: b  reason: collision with root package name */
        public long[] f29585b;

        /* renamed from: c  reason: collision with root package name */
        public long f29586c;

        /* renamed from: d  reason: collision with root package name */
        public long f29587d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29588e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29588e = bVar;
            this.f29586c = -1L;
            this.f29587d = -1L;
        }

        @Override // c.i.b.a.a0.r.f
        public long a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                long j2 = this.f29587d;
                if (j2 >= 0) {
                    long j3 = -(j2 + 2);
                    this.f29587d = -1L;
                    return j3;
                }
                return -1L;
            }
            return invokeL.longValue;
        }

        @Override // c.i.b.a.a0.l
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.i.b.a.a0.l
        public long c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? this.f29586c + this.f29585b[v.e(this.a, this.f29588e.b(j2), true, true)] : invokeJ.longValue;
        }

        @Override // c.i.b.a.a0.r.f
        public l d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (l) invokeV.objValue;
        }

        @Override // c.i.b.a.a0.r.f
        public long e(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                long b2 = this.f29588e.b(j2);
                this.f29587d = this.a[v.e(this.a, b2, true, true)];
                return b2;
            }
            return invokeJ.longValue;
        }

        public void f(c.i.b.a.i0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, lVar) == null) {
                lVar.K(1);
                int A = lVar.A() / 18;
                this.a = new long[A];
                this.f29585b = new long[A];
                for (int i2 = 0; i2 < A; i2++) {
                    this.a[i2] = lVar.q();
                    this.f29585b[i2] = lVar.q();
                    lVar.K(2);
                }
            }
        }

        @Override // c.i.b.a.a0.l
        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29588e.n.b() : invokeV.longValue;
        }

        public void i(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
                this.f29586c = j2;
            }
        }
    }

    public b() {
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

    public static boolean n(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? bArr[0] == -1 : invokeL.booleanValue;
    }

    public static boolean o(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) ? lVar.a() >= 5 && lVar.x() == 127 && lVar.z() == 1179402563 : invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.r.h
    public long e(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            if (n(lVar.a)) {
                return m(lVar);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    @Override // c.i.b.a.a0.r.h
    public boolean h(c.i.b.a.i0.l lVar, long j2, h.b bVar) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{lVar, Long.valueOf(j2), bVar})) == null) {
            byte[] bArr = lVar.a;
            if (this.n == null) {
                this.n = new c.i.b.a.i0.f(bArr, 17);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.d());
                copyOfRange[4] = ByteCompanionObject.MIN_VALUE;
                List singletonList = Collections.singletonList(copyOfRange);
                int a2 = this.n.a();
                c.i.b.a.i0.f fVar = this.n;
                bVar.a = Format.createAudioSampleFormat(null, "audio/flac", null, -1, a2, fVar.f30581b, fVar.a, singletonList, null, 0, null);
                return true;
            } else if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
                a aVar = new a(this);
                this.o = aVar;
                aVar.f(lVar);
                return true;
            } else if (n(bArr)) {
                a aVar2 = this.o;
                if (aVar2 != null) {
                    aVar2.i(j2);
                    bVar.f29613b = this.o;
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.a0.r.h
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.j(z);
            if (z) {
                this.n = null;
                this.o = null;
            }
        }
    }

    public final int m(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            int i4 = (lVar.a[2] & 255) >> 4;
            switch (i4) {
                case 1:
                    return 192;
                case 2:
                case 3:
                case 4:
                case 5:
                    i2 = 576;
                    i3 = i4 - 2;
                    break;
                case 6:
                case 7:
                    lVar.K(4);
                    lVar.E();
                    int x = i4 == 6 ? lVar.x() : lVar.D();
                    lVar.J(0);
                    return x + 1;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    i2 = 256;
                    i3 = i4 - 8;
                    break;
                default:
                    return -1;
            }
            return i2 << i3;
        }
        return invokeL.intValue;
    }
}
