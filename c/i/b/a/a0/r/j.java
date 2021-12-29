package c.i.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.r.h;
import c.i.b.a.a0.r.k;
import c.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class j extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a n;
    public int o;
    public boolean p;
    public k.d q;
    public k.b r;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final k.d a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f29695b;

        /* renamed from: c  reason: collision with root package name */
        public final k.c[] f29696c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29697d;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, bArr, cVarArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f29695b = bArr;
            this.f29696c = cVarArr;
            this.f29697d = i2;
        }
    }

    public j() {
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

    public static void l(l lVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, lVar, j2) == null) {
            lVar.I(lVar.d() + 4);
            lVar.a[lVar.d() - 4] = (byte) (j2 & 255);
            lVar.a[lVar.d() - 3] = (byte) ((j2 >>> 8) & 255);
            lVar.a[lVar.d() - 2] = (byte) ((j2 >>> 16) & 255);
            lVar.a[lVar.d() - 1] = (byte) ((j2 >>> 24) & 255);
        }
    }

    public static int m(byte b2, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), aVar})) == null) {
            if (!aVar.f29696c[n(b2, aVar.f29697d, 1)].a) {
                return aVar.a.f29700d;
            }
            return aVar.a.f29701e;
        }
        return invokeCommon.intValue;
    }

    public static int n(byte b2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? (b2 >> i3) & (255 >>> (8 - i2)) : invokeCommon.intValue;
    }

    public static boolean p(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar)) == null) {
            try {
                return k.k(1, lVar, true);
            } catch (ParserException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.r.h
    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.d(j2);
            this.p = j2 != 0;
            k.d dVar = this.q;
            this.o = dVar != null ? dVar.f29700d : 0;
        }
    }

    @Override // c.i.b.a.a0.r.h
    public long e(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar)) == null) {
            byte[] bArr = lVar.a;
            if ((bArr[0] & 1) == 1) {
                return -1L;
            }
            int m = m(bArr[0], this.n);
            long j2 = this.p ? (this.o + m) / 4 : 0;
            l(lVar, j2);
            this.p = true;
            this.o = m;
            return j2;
        }
        return invokeL.longValue;
    }

    @Override // c.i.b.a.a0.r.h
    public boolean h(l lVar, long j2, h.b bVar) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{lVar, Long.valueOf(j2), bVar})) == null) {
            if (this.n != null) {
                return false;
            }
            a o = o(lVar);
            this.n = o;
            if (o == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.n.a.f29702f);
            arrayList.add(this.n.f29695b);
            k.d dVar = this.n.a;
            bVar.a = Format.createAudioSampleFormat(null, "audio/vorbis", null, dVar.f29699c, -1, dVar.a, (int) dVar.f29698b, arrayList, null, 0, null);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.a0.r.h
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.j(z);
            if (z) {
                this.n = null;
                this.q = null;
                this.r = null;
            }
            this.o = 0;
            this.p = false;
        }
    }

    public a o(l lVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lVar)) == null) {
            if (this.q == null) {
                this.q = k.i(lVar);
                return null;
            } else if (this.r == null) {
                this.r = k.h(lVar);
                return null;
            } else {
                byte[] bArr = new byte[lVar.d()];
                System.arraycopy(lVar.a, 0, bArr, 0, lVar.d());
                k.c[] j2 = k.j(lVar, this.q.a);
                return new a(this.q, this.r, bArr, j2, k.a(j2.length - 1));
            }
        }
        return (a) invokeL.objValue;
    }
}
