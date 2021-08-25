package c.a.w0.i;

import android.media.MediaFormat;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.w0.t.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.audioedit.AudioChangeConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class c implements j, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static AudioChangeConfig E;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public int B;
    public int C;
    public c.a.w0.l.d.j.c.a D;

    /* renamed from: e  reason: collision with root package name */
    public Object f30566e;

    /* renamed from: f  reason: collision with root package name */
    public Object f30567f;

    /* renamed from: g  reason: collision with root package name */
    public Object f30568g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f30569h;

    /* renamed from: i  reason: collision with root package name */
    public volatile a f30570i;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f30571j;
    public volatile long k;
    public volatile e l;
    public volatile c.a.w0.l.d.j.b m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public volatile boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public float v;
    public int w;
    public volatile boolean x;
    public byte[] y;
    public List<h> z;

    public c(int i2, String str, float f2, float f3, int[] iArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Float.valueOf(f2), Float.valueOf(f3), iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30571j = Long.MIN_VALUE;
        this.k = Long.MIN_VALUE;
        this.v = 1.0f;
        this.w = 0;
        this.x = false;
        this.y = null;
        this.r = i2;
        this.A = iArr;
        q(str);
        this.l = p();
        this.f30566e = new Object();
        this.f30567f = new Object();
        this.f30568g = new Object();
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, int[] iArr) throws Exception {
        this(i2, str, 1.0f, 1.0f, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), (int[]) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean o(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            if (iArr == null || iArr.length == 0) {
                return false;
            }
            boolean z = false;
            for (int i2 : iArr) {
                if (i2 > 700 || i2 > 300 || i2 > 200 || i2 > 100) {
                    z = true;
                    break;
                }
                if (i2 > 0) {
                    z = true;
                }
            }
            AudioChangeConfig audioChangeConfig = E;
            return audioChangeConfig != null ? audioChangeConfig.configEnabled(z) : z;
        }
        return invokeL.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || E == null) {
            return;
        }
        E = null;
    }

    public abstract void B(long j2);

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.m == null || this.o) {
            return;
        }
        long currentPosition = this.f30570i.getCurrentPosition();
        long duration = this.f30570i.getDuration();
        this.m.onProgressChanged(this.r, (currentPosition == 0 || duration == 0) ? 0.0d : currentPosition / duration, currentPosition);
    }

    public void D(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
            E(iArr, null, null);
        }
    }

    public void E(int[] iArr, int[] iArr2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, iArr, iArr2, dArr) == null) {
            this.A = iArr;
            c.a.w0.i.d.b f2 = f();
            if (iArr2 == null && dArr == null) {
                f2.b(this.A);
            } else {
                f2.c(this.A, iArr2, dArr);
            }
        }
    }

    public void F(c.a.w0.l.d.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void G(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            if (this.z == null) {
                this.z = new ArrayList();
            }
            c.a.w0.i.d.a aVar = null;
            Iterator<h> it = this.z.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof c.a.w0.i.d.a) {
                    aVar = (c.a.w0.i.d.a) next;
                    break;
                }
            }
            if (aVar == null) {
                aVar = new c.a.w0.i.d.a();
                aVar.a(this.r, this.s, this.t, this.u);
                this.z.add(0, aVar);
            }
            aVar.b(f2);
        }
    }

    public void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.v = f2;
            if (this.z == null) {
                this.z = new ArrayList();
            }
            c.a.w0.i.d.c cVar = null;
            Iterator<h> it = this.z.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof c.a.w0.i.d.c) {
                    cVar = (c.a.w0.i.d.c) next;
                    break;
                }
            }
            if (cVar == null) {
                cVar = new c.a.w0.i.d.c();
                cVar.a(this.r, this.s, this.t, this.u);
                List<h> list = this.z;
                list.add(list.size(), cVar);
            }
            cVar.b(this.v);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.f30566e) {
                u();
                this.n = false;
                this.q = false;
                this.o = false;
                this.p = false;
                this.f30566e.notifyAll();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.n) {
                synchronized (this.f30566e) {
                    this.n = false;
                    this.f30566e.notifyAll();
                }
            }
            v();
            this.o = true;
        }
    }

    @Override // c.a.w0.i.j
    public void a(MediaFormat mediaFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mediaFormat) == null) {
            try {
                this.s = this.f30570i.e();
                this.t = this.f30570i.b();
                r();
                if (this.l instanceof c.a.w0.i.g.b) {
                    ((c.a.w0.i.g.b) this.l).c(m(), i());
                }
            } catch (Exception e2) {
                c.a.w0.l.d.j.c.a aVar = this.D;
                if (aVar != null) {
                    aVar.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    public final byte[] b() throws IOException {
        InterceptResult invokeV;
        byte[] l;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.x) {
                return null;
            }
            this.x = true;
            if (l(Math.abs(this.w)).length > 0) {
                synchronized (this.f30567f) {
                    this.f30569h += this.l.write(l, 0, length);
                    c.a.w0.t.c.j("VideoMuxer: ", "bytesWritten ：" + this.f30569h + " ， empty bytesWritten time ：" + (((float) this.f30569h) / ((this.u * this.t) * this.s)) + 1000);
                }
                return null;
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || c.a.w0.t.h.e(this.z)) {
            return;
        }
        for (h hVar : this.z) {
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    public final byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bArr)) == null) {
            if (!this.x) {
                this.x = true;
                this.y = l(Math.abs(this.w));
            }
            byte[] bArr2 = this.y;
            if (bArr2 == null) {
                return bArr;
            }
            if (bArr.length < bArr2.length) {
                int length = bArr2.length - bArr.length;
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr2, bArr.length, bArr3, 0, length);
                this.y = bArr3;
                c.a.w0.t.c.j("VideoMuxer: ", "----discardAudioData-----,result.length : " + this.y.length);
                return null;
            }
            c.a.w0.t.c.j("VideoMuxer: ", "----discardAudioData-----, audioData.length >= result.length ， audioData.length : " + bArr.length + " ， result.length : " + this.y.length);
            int length2 = bArr.length;
            byte[] bArr4 = this.y;
            int length3 = length2 - bArr4.length;
            byte[] bArr5 = new byte[length3];
            System.arraycopy(bArr, bArr4.length, bArr5, 0, length3);
            this.y = null;
            c.a.w0.t.c.j("VideoMuxer: ", "----discardAudioData-----, audioData.length >= result.length ，new baffle length : " + length3);
            return bArr5;
        }
        return (byte[]) invokeL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || c.a.w0.t.h.e(this.z)) {
            return;
        }
        for (h hVar : this.z) {
            if (hVar != null) {
                hVar.c();
            }
        }
    }

    public final c.a.w0.i.d.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.z == null) {
                this.z = new ArrayList();
            }
            c.a.w0.i.d.b bVar = null;
            Iterator<h> it = this.z.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof c.a.w0.i.d.b) {
                    bVar = (c.a.w0.i.d.b) next;
                    break;
                }
            }
            if (bVar == null) {
                c.a.w0.i.d.b bVar2 = new c.a.w0.i.d.b();
                bVar2.a(this.r, this.s, this.t, this.u * 8);
                List<h> list = this.z;
                list.add(list.size(), bVar2);
                return bVar2;
            }
            return bVar;
        }
        return (c.a.w0.i.d.b) invokeV.objValue;
    }

    public int[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.A : (int[]) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.u : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.C = this.s;
            if (n()) {
                this.C = 1;
            }
            return this.C;
        }
        return invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.f30568g) {
                if (this.f30570i != null) {
                    return this.f30570i.getCurrentPosition();
                }
                return Long.MIN_VALUE;
            }
        }
        return invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f30570i != null) {
                return this.f30570i.getDuration();
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    public final byte[] l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            int m = (((this.u * m()) * i()) / 1000) * i2;
            c.a.w0.t.c.j("VideoMuxer: ", "byte size is : " + m);
            return new byte[m];
        }
        return (byte[]) invokeI.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.B = this.t;
            c.a.w0.t.c.b("SoundStreamRunnable: mTargetSampleRate=" + this.B);
            return this.B;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? o(this.A) : invokeV.booleanValue;
    }

    public abstract e p() throws IOException;

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this.f30566e) {
                t();
                this.n = true;
            }
        }
    }

    public final void q(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (this.m == null || this.p) {
                    return;
                }
                this.m.onExceptionThrown("Only API level >= 16 supported.");
                return;
            }
            this.f30570i = new i(str);
            ((i) this.f30570i).k(this);
            this.s = this.f30570i.e();
            this.t = this.f30570i.b();
            this.u = this.f30570i.a();
            c.a.w0.t.c.d("SoundStreamRunnable: channels=" + this.s + ";samplingRate=" + this.t + ";byteWidth=" + this.u);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || c.a.w0.t.h.e(this.z)) {
            return;
        }
        for (h hVar : this.z) {
            if (hVar != null) {
                hVar.a(this.r, this.s, this.t, this.u);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            while (!this.o) {
                try {
                    try {
                        if (!this.q) {
                            y();
                            synchronized (this.f30568g) {
                                this.f30570i.d();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.m != null && !this.p) {
                            this.m.onExceptionThrown(m.g(e2));
                        }
                        this.o = true;
                        z();
                        A();
                        synchronized (this.f30567f) {
                            try {
                                this.l.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            this.l = null;
                            synchronized (this.f30568g) {
                                if (this.f30570i != null) {
                                    this.f30570i.close();
                                }
                                this.f30570i = null;
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    this.o = true;
                    z();
                    A();
                    synchronized (this.f30567f) {
                        try {
                            this.l.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        this.l = null;
                        synchronized (this.f30568g) {
                            if (this.f30570i != null) {
                                this.f30570i.close();
                            }
                            this.f30570i = null;
                            throw th;
                        }
                    }
                }
            }
            this.o = true;
            z();
            A();
            synchronized (this.f30567f) {
                try {
                    this.l.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                this.l = null;
            }
            synchronized (this.f30568g) {
                if (this.f30570i != null) {
                    this.f30570i.close();
                }
                this.f30570i = null;
            }
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f30571j == Long.MIN_VALUE || this.k == Long.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }

    public abstract void t();

    public abstract void u();

    public abstract void v();

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this.f30566e) {
                while (this.n) {
                    try {
                        this.f30566e.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final int x(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bArr)) == null) {
            if (bArr == null) {
                return 0;
            }
            if (c.a.w0.t.h.e(this.z)) {
                length = bArr.length;
            } else {
                length = bArr.length;
                for (h hVar : this.z) {
                    if (!hVar.b()) {
                        hVar.a(this.r, this.s, this.t, this.u);
                    }
                    if (hVar.a() && bArr != null) {
                        int length2 = bArr.length;
                        hVar.a(bArr, length2);
                        bArr = hVar.a(length2);
                        length = bArr != null ? bArr.length : 0;
                    }
                }
            }
            if (length > 0) {
                synchronized (this.f30567f) {
                    this.f30569h += this.l.write(bArr, 0, length);
                }
            }
            return length;
        }
        return invokeL.intValue;
    }

    public final void y() throws IOException {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            while (true) {
                boolean z = false;
                if ((this.f30570i.f() || j() >= k() + this.w) && !s()) {
                    break;
                }
                w();
                if (this.o) {
                    break;
                }
                if (s() && this.f30570i.getCurrentPosition() >= this.k) {
                    B(this.f30571j);
                    this.x = false;
                }
                synchronized (this.f30568g) {
                    try {
                        z = this.f30570i.c();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.m != null && !this.p) {
                            this.m.onExceptionThrown(m.g(e2));
                        }
                    }
                }
                if (z) {
                    byte[] g2 = this.f30570i.g();
                    int i2 = this.w;
                    if (i2 != 0) {
                        if (i2 > 0) {
                            b();
                        } else {
                            g2 = d(g2);
                        }
                    }
                    C();
                    x(g2);
                }
            }
            c.a.w0.t.c.j("VideoMuxer: ", "----解码结束-----");
            if (this.p) {
                if (this.m != null) {
                    this.m.onCancel();
                    return;
                }
                return;
            }
            if (!c.a.w0.t.h.e(this.z)) {
                for (int i3 = 0; i3 < this.z.size(); i3++) {
                    if (this.z.get(i3).a()) {
                        this.z.get(i3).c();
                        do {
                            byte[] a2 = this.z.get(i3).a(4096);
                            if (a2 != null && a2.length != 0) {
                                length = a2.length;
                                int i4 = length;
                                for (int i5 = i3 + 1; i5 < this.z.size(); i5++) {
                                    if (this.z.get(i5).a()) {
                                        int length2 = a2.length;
                                        this.z.get(i5).a(a2, length2);
                                        a2 = this.z.get(i5).a(length2);
                                        i4 = a2 != null ? a2.length : 0;
                                    }
                                }
                                if (i4 > 0) {
                                    synchronized (this.f30567f) {
                                        c.a.w0.t.c.j("VideoMuxer: ", "----getLastBuffer-----");
                                        this.f30569h += this.l.write(a2, 0, i4);
                                    }
                                    continue;
                                }
                            }
                        } while (length > 0);
                    }
                }
            }
            e();
            if (this.m != null) {
                this.m.onTrackEnd(this.r);
                c.a.w0.t.c.j("VideoMuxer: ", "----所有数据输入编码器onTrackEnd-----,bytesWritten:" + this.f30569h);
            }
            this.q = true;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || c.a.w0.t.h.e(this.z)) {
            return;
        }
        for (h hVar : this.z) {
            if (hVar != null) {
                hVar.d();
            }
        }
    }
}
