package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends Thread {
    private Bitmap A;
    private int J;
    private short[] K;
    private byte[] L;
    private byte[] M;
    private byte[] N;
    private c O;
    private int P;
    private a Q;

    /* renamed from: a  reason: collision with root package name */
    public int f171a;
    public int b;
    private InputStream c;
    private int d;
    private boolean e;
    private int f;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Bitmap z;
    private int g = 1;
    private c B = null;
    private boolean C = false;
    private byte[] D = new byte[256];
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private boolean H = false;
    private int I = 0;
    private byte[] R = null;
    private String S = null;
    private boolean T = false;

    public b(a aVar) {
        this.Q = null;
        this.Q = aVar;
    }

    public void a(byte[] bArr) {
        this.R = bArr;
    }

    public void a(InputStream inputStream) {
        this.c = inputStream;
    }

    private void a(String str, boolean z) {
        try {
            a(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean a(String str) {
        File file;
        boolean z = false;
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory()) {
            return false;
        }
        String[] list = file2.list();
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i >= list.length) {
                return z2;
            }
            if (str.endsWith(File.separator)) {
                file = new File(String.valueOf(str) + list[i]);
            } else {
                file = new File(String.valueOf(str) + File.separator + list[i]);
            }
            if (file.isFile()) {
                file.delete();
                z = z2;
            } else if (file.isDirectory()) {
                a(String.valueOf(str) + File.separator + list[i]);
                a(String.valueOf(str) + File.separator + list[i], true);
                z = true;
            } else {
                z = z2;
            }
            i++;
        }
    }

    private synchronized String e() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, String str) {
        try {
            new File(String.valueOf(this.S) + File.separator + str + ".png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(String.valueOf(this.S) + File.separator + e() + ".png"));
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.c != null) {
            h();
        } else if (this.R != null) {
            g();
        }
    }

    public void a() {
        c cVar = this.O;
        if (!this.T) {
            while (cVar != null) {
                if (cVar.f172a != null && !cVar.f172a.isRecycled()) {
                    cVar.f172a.recycle();
                }
                cVar.f172a = null;
                this.O = this.O.d;
                cVar = this.O;
            }
        } else {
            a(this.S, true);
        }
        if (this.c != null) {
            try {
                this.c.close();
            } catch (Exception e) {
            }
            this.c = null;
        }
        this.R = null;
        this.d = 0;
        this.B = null;
    }

    public int b() {
        return this.P;
    }

    public Bitmap c() {
        return a(0);
    }

    private void f() {
        int i;
        int[] iArr = new int[this.f171a * this.b];
        if (this.G > 0) {
            if (this.G == 3) {
                int i2 = this.P - 2;
                if (i2 > 0) {
                    this.A = a(i2 - 1);
                } else {
                    this.A = null;
                }
            }
            if (this.A != null) {
                this.A.getPixels(iArr, 0, this.f171a, 0, 0, this.f171a, this.b);
                if (this.G == 2) {
                    int i3 = !this.H ? this.m : 0;
                    for (int i4 = 0; i4 < this.y; i4++) {
                        int i5 = ((this.w + i4) * this.f171a) + this.v;
                        int i6 = this.x + i5;
                        while (i5 < i6) {
                            iArr[i5] = i3;
                            i5++;
                        }
                    }
                }
            }
        }
        int i7 = 8;
        int i8 = 1;
        int i9 = 0;
        for (int i10 = 0; i10 < this.u; i10++) {
            if (this.p) {
                if (i9 >= this.u) {
                    i8++;
                    switch (i8) {
                        case 2:
                            i9 = 4;
                            break;
                        case 3:
                            i9 = 2;
                            i7 = 4;
                            break;
                        case 4:
                            i9 = 1;
                            i7 = 2;
                            break;
                    }
                }
                int i11 = i9;
                i9 += i7;
                i = i11;
            } else {
                i = i10;
            }
            int i12 = i + this.s;
            if (i12 < this.b) {
                int i13 = this.f171a * i12;
                int i14 = i13 + this.r;
                int i15 = this.t + i14;
                if (this.f171a + i13 < i15) {
                    i15 = this.f171a + i13;
                }
                int i16 = this.t * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.j[this.N[i16] & 255];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.z = Bitmap.createBitmap(iArr, this.f171a, this.b, Bitmap.Config.ARGB_4444);
    }

    public Bitmap a(int i) {
        c b = b(i);
        if (b == null) {
            return null;
        }
        return b.f172a;
    }

    public c b(int i) {
        int i2 = 0;
        for (c cVar = this.O; cVar != null; cVar = cVar.d) {
            if (i2 == i) {
                return cVar;
            }
            i2++;
        }
        return null;
    }

    public c d() {
        if (!this.C) {
            this.C = true;
            return this.O;
        } else if (this.B == null) {
            return null;
        } else {
            if (this.d == 0) {
                if (this.B.d != null) {
                    this.B = this.B.d;
                }
            } else {
                this.B = this.B.d;
                if (this.B == null) {
                    this.B = this.O;
                }
            }
            return this.B;
        }
    }

    private int g() {
        this.c = new ByteArrayInputStream(this.R);
        this.R = null;
        return h();
    }

    private int h() {
        k();
        if (this.c != null) {
            p();
            if (!j()) {
                n();
                if (this.P < 0) {
                    this.d = 1;
                    this.Q.a(false, -1);
                } else {
                    this.d = -1;
                    this.Q.a(true, -1);
                }
            }
            try {
                this.c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.d = 2;
            this.Q.a(false, -1);
        }
        return this.d;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        short s;
        int i10 = this.t * this.u;
        if (this.N == null || this.N.length < i10) {
            this.N = new byte[i10];
        }
        if (this.K == null) {
            this.K = new short[4096];
        }
        if (this.L == null) {
            this.L = new byte[4096];
        }
        if (this.M == null) {
            this.M = new byte[4097];
        }
        int l = l();
        int i11 = 1 << l;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = l + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.K[i16] = 0;
            this.L[i16] = (byte) i16;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 0;
        while (i21 < i10) {
            if (i18 != 0) {
                i = i15;
                i2 = i19;
                i3 = i23;
                i4 = i14;
                i5 = i18;
                i6 = i20;
                i7 = i24;
                i8 = i13;
            } else if (i23 < i14) {
                if (i22 == 0) {
                    i22 = m();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.D[i25] & 255) << i23;
                i23 += 8;
                i25++;
                i22--;
            } else {
                int i26 = i20 & i15;
                i20 >>= i14;
                i23 -= i14;
                if (i26 > i13 || i26 == i12) {
                    break;
                } else if (i26 == i11) {
                    i14 = l + 1;
                    i15 = (1 << i14) - 1;
                    i13 = i11 + 2;
                    i24 = -1;
                } else if (i24 == -1) {
                    this.M[i18] = this.L[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.M[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.M[i9] = this.L[s];
                        s = this.K[s];
                        i9++;
                    }
                    int i27 = this.L[s] & 255;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.M[i9] = (byte) i27;
                    this.K[i13] = (short) i24;
                    this.L[i13] = (byte) i27;
                    i8 = i13 + 1;
                    if ((i8 & i15) == 0 && i8 < 4096) {
                        i14++;
                        i15 += i8;
                    }
                    i6 = i20;
                    i7 = i26;
                    i = i15;
                    i2 = i27;
                    i3 = i23;
                    i4 = i14;
                    i5 = i28;
                }
            }
            int i29 = i5 - 1;
            this.N[i17] = this.M[i29];
            i21++;
            i17++;
            i14 = i4;
            i23 = i3;
            i19 = i2;
            i15 = i;
            int i30 = i7;
            i20 = i6;
            i18 = i29;
            i13 = i8;
            i24 = i30;
        }
        for (int i31 = i17; i31 < i10; i31++) {
            this.N[i31] = 0;
        }
    }

    private boolean j() {
        return this.d != 0;
    }

    private void k() {
        this.d = 0;
        this.P = 0;
        this.O = null;
        this.h = null;
        this.i = null;
    }

    private int l() {
        try {
            return this.c.read();
        } catch (Exception e) {
            this.d = 1;
            return 0;
        }
    }

    private int m() {
        this.E = l();
        int i = 0;
        if (this.E > 0) {
            while (i < this.E) {
                try {
                    int read = this.c.read(this.D, i, this.E - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.E) {
                this.d = 1;
            }
        }
        return i;
    }

    private int[] c(int i) {
        int i2;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.c.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.d = 1;
        } else {
            iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                i4 = i7 + 1;
                iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            }
        }
        return iArr;
    }

    private void n() {
        boolean z = false;
        while (!z && !j()) {
            switch (l()) {
                case 0:
                    break;
                case 33:
                    switch (l()) {
                        case 249:
                            o();
                            continue;
                        case 255:
                            m();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = String.valueOf(str) + ((char) this.D[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                s();
                                break;
                            } else {
                                v();
                                continue;
                            }
                        default:
                            v();
                            continue;
                    }
                case 44:
                    q();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.d = 1;
                    break;
            }
        }
    }

    private void o() {
        l();
        int l = l();
        this.F = (l & 28) >> 2;
        if (this.F == 0) {
            this.F = 1;
        }
        this.H = (l & 1) != 0;
        this.I = t() * 10;
        this.J = l();
        l();
    }

    private void p() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) l());
        }
        if (!str.startsWith("GIF")) {
            this.d = 1;
            return;
        }
        r();
        if (this.e && !j()) {
            this.h = c(this.f);
            this.l = this.h[this.k];
        }
    }

    private void q() {
        int i = 0;
        this.r = t();
        this.s = t();
        this.t = t();
        this.u = t();
        int l = l();
        this.o = (l & DERTags.TAGGED) != 0;
        this.p = (l & 64) != 0;
        this.q = 2 << (l & 7);
        if (this.o) {
            this.i = c(this.q);
            this.j = this.i;
        } else {
            this.j = this.h;
            if (this.k == this.J) {
                this.l = 0;
            }
        }
        if (this.H) {
            int i2 = this.j[this.J];
            this.j[this.J] = 0;
            i = i2;
        }
        if (this.j == null) {
            this.d = 1;
        }
        if (!j()) {
            i();
            v();
            if (!j()) {
                this.P++;
                this.z = Bitmap.createBitmap(this.f171a, this.b, Bitmap.Config.ARGB_4444);
                f();
                if (this.O == null) {
                    if (this.T) {
                        String e = e();
                        this.O = new c(String.valueOf(this.S) + File.separator + e + ".png", this.I);
                        a(this.z, e);
                    } else {
                        this.O = new c(this.z, this.I);
                    }
                    this.B = this.O;
                } else {
                    c cVar = this.O;
                    while (cVar.d != null) {
                        cVar = cVar.d;
                    }
                    if (this.T) {
                        String e2 = e();
                        cVar.d = new c(String.valueOf(this.S) + File.separator + e2 + ".png", this.I);
                        a(this.z, e2);
                    } else {
                        cVar.d = new c(this.z, this.I);
                    }
                }
                if (this.H) {
                    this.j[this.J] = i;
                }
                u();
                this.Q.a(true, this.P);
            }
        }
    }

    private void r() {
        this.f171a = t();
        this.b = t();
        int l = l();
        this.e = (l & DERTags.TAGGED) != 0;
        this.f = 2 << (l & 7);
        this.k = l();
        this.n = l();
    }

    private void s() {
        do {
            m();
            if (this.D[0] == 1) {
                this.g = (this.D[1] & 255) | ((this.D[2] & 255) << 8);
            }
            if (this.E <= 0) {
                return;
            }
        } while (!j());
    }

    private int t() {
        return l() | (l() << 8);
    }

    private void u() {
        this.G = this.F;
        this.v = this.r;
        this.w = this.s;
        this.x = this.t;
        this.y = this.u;
        this.A = this.z;
        this.m = this.l;
        this.F = 0;
        this.H = false;
        this.I = 0;
        this.i = null;
    }

    private void v() {
        do {
            m();
            if (this.E <= 0) {
                return;
            }
        } while (!j());
    }
}
