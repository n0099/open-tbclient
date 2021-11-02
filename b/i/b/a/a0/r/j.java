package b.i.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import b.i.b.a.a0.r.h;
import b.i.b.a.a0.r.k;
import b.i.b.a.i0.l;
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
/* loaded from: classes6.dex */
public final class j extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a n;
    public int o;
    public boolean p;
    public k.d q;
    public k.b r;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final k.d f31619a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f31620b;

        /* renamed from: c  reason: collision with root package name */
        public final k.c[] f31621c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31622d;

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
            this.f31619a = dVar;
            this.f31620b = bArr;
            this.f31621c = cVarArr;
            this.f31622d = i2;
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

    public static void l(l lVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, lVar, j) == null) {
            lVar.I(lVar.d() + 4);
            lVar.f32635a[lVar.d() - 4] = (byte) (j & 255);
            lVar.f32635a[lVar.d() - 3] = (byte) ((j >>> 8) & 255);
            lVar.f32635a[lVar.d() - 2] = (byte) ((j >>> 16) & 255);
            lVar.f32635a[lVar.d() - 1] = (byte) ((j >>> 24) & 255);
        }
    }

    public static int m(byte b2, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), aVar})) == null) {
            if (!aVar.f31621c[n(b2, aVar.f31622d, 1)].f31623a) {
                return aVar.f31619a.f31627d;
            }
            return aVar.f31619a.f31628e;
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

    @Override // b.i.b.a.a0.r.h
    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            super.d(j);
            this.p = j != 0;
            k.d dVar = this.q;
            this.o = dVar != null ? dVar.f31627d : 0;
        }
    }

    @Override // b.i.b.a.a0.r.h
    public long e(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar)) == null) {
            byte[] bArr = lVar.f32635a;
            if ((bArr[0] & 1) == 1) {
                return -1L;
            }
            int m = m(bArr[0], this.n);
            long j = this.p ? (this.o + m) / 4 : 0;
            l(lVar, j);
            this.p = true;
            this.o = m;
            return j;
        }
        return invokeL.longValue;
    }

    @Override // b.i.b.a.a0.r.h
    public boolean h(l lVar, long j, h.b bVar) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{lVar, Long.valueOf(j), bVar})) == null) {
            if (this.n != null) {
                return false;
            }
            a o = o(lVar);
            this.n = o;
            if (o == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.n.f31619a.f31629f);
            arrayList.add(this.n.f31620b);
            k.d dVar = this.n.f31619a;
            bVar.f31613a = Format.createAudioSampleFormat(null, "audio/vorbis", null, dVar.f31626c, -1, dVar.f31624a, (int) dVar.f31625b, arrayList, null, 0, null);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // b.i.b.a.a0.r.h
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
                System.arraycopy(lVar.f32635a, 0, bArr, 0, lVar.d());
                k.c[] j = k.j(lVar, this.q.f31624a);
                return new a(this.q, this.r, bArr, j, k.a(j.length - 1));
            }
        }
        return (a) invokeL.objValue;
    }
}
