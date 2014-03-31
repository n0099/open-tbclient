package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import protobuf.Im;
/* loaded from: classes.dex */
public final class b extends Thread {
    private Bitmap A;
    private int J;
    private short[] K;
    private byte[] L;
    private byte[] M;
    private byte[] N;
    private c O;
    private int P;
    private a Q;
    public int a;
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
    private final byte[] D = new byte[256];
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

    public final void a(byte[] bArr) {
        this.R = bArr;
    }

    public final void a(InputStream inputStream) {
        this.c = inputStream;
    }

    private void a(String str, boolean z) {
        try {
            a(str);
            new File(str.toString()).delete();
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

    private void a(Bitmap bitmap) {
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(String.valueOf(this.S) + File.separator + e() + ".png"));
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (this.c != null) {
            f();
        } else if (this.R != null) {
            this.c = new ByteArrayInputStream(this.R);
            this.R = null;
            f();
        }
    }

    public final void a() {
        c cVar = this.O;
        if (!this.T) {
            while (cVar != null) {
                if (cVar.a != null && !cVar.a.isRecycled()) {
                    cVar.a.recycle();
                }
                cVar.a = null;
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

    public final int b() {
        return this.P;
    }

    public final Bitmap c() {
        return a(0);
    }

    private Bitmap a(int i) {
        c cVar = this.O;
        int i2 = 0;
        while (true) {
            if (cVar != null) {
                if (i2 == i) {
                    break;
                }
                i2++;
                cVar = cVar.d;
            } else {
                cVar = null;
                break;
            }
        }
        if (cVar == null) {
            return null;
        }
        return cVar.a;
    }

    public final c d() {
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

    private int f() {
        this.d = 0;
        this.P = 0;
        this.O = null;
        this.h = null;
        this.i = null;
        if (this.c != null) {
            String str = "";
            for (int i = 0; i < 6; i++) {
                str = String.valueOf(str) + ((char) h());
            }
            if (str.startsWith("GIF")) {
                this.a = l();
                this.b = l();
                int h = h();
                this.e = (h & 128) != 0;
                this.f = 2 << (h & 7);
                this.k = h();
                this.n = h();
                if (this.e && !g()) {
                    this.h = b(this.f);
                    this.l = this.h[this.k];
                }
            } else {
                this.d = 1;
            }
            if (!g()) {
                j();
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

    private boolean g() {
        return this.d != 0;
    }

    private int h() {
        try {
            return this.c.read();
        } catch (Exception e) {
            this.d = 1;
            return 0;
        }
    }

    private int i() {
        this.E = h();
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

    private int[] b(int i) {
        int i2;
        int i3 = 0;
        int i4 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i4];
        try {
            i2 = this.c.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i4) {
            this.d = 1;
        } else {
            iArr = new int[256];
            int i5 = 0;
            while (i5 < i) {
                int i6 = i3 + 1;
                int i7 = bArr[i3] & 255;
                int i8 = i6 + 1;
                iArr[i5] = (i7 << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i8] & 255);
                i5++;
                i3 = i8 + 1;
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:222:0x02fe */
    /* JADX DEBUG: Multi-variable search result rejected for r6v28, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x037d A[LOOP:4: B:48:0x0111->B:119:0x037d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x011e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0003 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        short s;
        boolean z = false;
        while (!z && !g()) {
            switch (h()) {
                case 0:
                    break;
                case Im.GroupInfo.ISRECENTLYREPLY_FIELD_NUMBER /* 33 */:
                    switch (h()) {
                        case 249:
                            h();
                            int h = h();
                            this.F = (h & 28) >> 2;
                            if (this.F == 0) {
                                this.F = 1;
                            }
                            this.H = (h & 1) != 0;
                            this.I = l() * 10;
                            this.J = h();
                            h();
                            continue;
                        case MotionEventCompat.ACTION_MASK /* 255 */:
                            i();
                            String str = "";
                            for (int i12 = 0; i12 < 11; i12++) {
                                str = String.valueOf(str) + ((char) this.D[i12]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                k();
                                break;
                            } else {
                                m();
                                continue;
                            }
                        default:
                            m();
                            continue;
                    }
                case 44:
                    this.r = l();
                    this.s = l();
                    this.t = l();
                    this.u = l();
                    int h2 = h();
                    this.o = (h2 & 128) != 0;
                    this.p = (h2 & 64) != 0;
                    this.q = 2 << (h2 & 7);
                    if (this.o) {
                        this.i = b(this.q);
                        this.j = this.i;
                    } else {
                        this.j = this.h;
                        if (this.k == this.J) {
                            this.l = 0;
                        }
                    }
                    int i13 = 0;
                    if (this.H) {
                        i13 = this.j[this.J];
                        this.j[this.J] = 0;
                    }
                    int i14 = i13;
                    if (this.j == null) {
                        this.d = 1;
                    }
                    if (g()) {
                        break;
                    } else {
                        int i15 = this.t * this.u;
                        if (this.N == null || this.N.length < i15) {
                            this.N = new byte[i15];
                        }
                        if (this.K == null) {
                            this.K = new short[4096];
                        }
                        if (this.L == null) {
                            this.L = new byte[4096];
                        }
                        if (this.M == null) {
                            this.M = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
                        }
                        int h3 = h();
                        int i16 = 1 << h3;
                        int i17 = i16 + 1;
                        int i18 = i16 + 2;
                        int i19 = -1;
                        int i20 = h3 + 1;
                        int i21 = (1 << i20) - 1;
                        for (int i22 = 0; i22 < i16; i22++) {
                            this.K[i22] = 0;
                            this.L[i22] = (byte) i22;
                        }
                        int i23 = 0;
                        int i24 = 0;
                        int i25 = 0;
                        int i26 = 0;
                        int i27 = 0;
                        int i28 = 0;
                        int i29 = 0;
                        int i30 = 0;
                        while (i29 < i15) {
                            if (i24 != 0) {
                                i3 = i21;
                                i4 = i25;
                                i5 = i28;
                                i6 = i20;
                                i7 = i24;
                                i8 = i26;
                                i9 = i19;
                                i10 = i18;
                            } else if (i28 < i20) {
                                if (i27 == 0) {
                                    i27 = i();
                                    if (i27 <= 0) {
                                        for (i = i23; i < i15; i++) {
                                            this.N[i] = 0;
                                        }
                                        m();
                                        if (g()) {
                                            break;
                                        } else {
                                            this.P++;
                                            this.z = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_4444);
                                            int[] iArr = new int[this.a * this.b];
                                            if (this.G > 0) {
                                                if (this.G == 3) {
                                                    int i31 = this.P - 2;
                                                    if (i31 > 0) {
                                                        this.A = a(i31 - 1);
                                                    } else {
                                                        this.A = null;
                                                    }
                                                }
                                                if (this.A != null) {
                                                    this.A.getPixels(iArr, 0, this.a, 0, 0, this.a, this.b);
                                                    if (this.G == 2) {
                                                        int i32 = this.H ? 0 : this.m;
                                                        for (int i33 = 0; i33 < this.y; i33++) {
                                                            int i34 = ((this.w + i33) * this.a) + this.v;
                                                            int i35 = this.x + i34;
                                                            while (i34 < i35) {
                                                                iArr[i34] = i32;
                                                                i34++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            int i36 = 1;
                                            int i37 = 8;
                                            int i38 = 0;
                                            for (int i39 = 0; i39 < this.u; i39++) {
                                                if (this.p) {
                                                    if (i38 >= this.u) {
                                                        i36++;
                                                        switch (i36) {
                                                            case 2:
                                                                i38 = 4;
                                                                break;
                                                            case 3:
                                                                i38 = 2;
                                                                i37 = 4;
                                                                break;
                                                            case 4:
                                                                i38 = 1;
                                                                i37 = 2;
                                                                break;
                                                        }
                                                    }
                                                    int i40 = i38;
                                                    i38 += i37;
                                                    i2 = i40;
                                                } else {
                                                    i2 = i39;
                                                }
                                                int i41 = i2 + this.s;
                                                if (i41 < this.b) {
                                                    int i42 = this.a * i41;
                                                    int i43 = i42 + this.r;
                                                    int i44 = this.t + i43;
                                                    if (this.a + i42 < i44) {
                                                        i44 = this.a + i42;
                                                    }
                                                    int i45 = this.t * i39;
                                                    int i46 = i43;
                                                    while (i46 < i44) {
                                                        int i47 = i45 + 1;
                                                        int i48 = this.j[this.N[i45] & 255];
                                                        if (i48 != 0) {
                                                            iArr[i46] = i48;
                                                        }
                                                        i46++;
                                                        i45 = i47;
                                                    }
                                                }
                                            }
                                            this.z = Bitmap.createBitmap(iArr, this.a, this.b, Bitmap.Config.ARGB_4444);
                                            if (this.O == null) {
                                                if (this.T) {
                                                    this.O = new c(String.valueOf(this.S) + File.separator + e() + ".png", this.I);
                                                    a(this.z);
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
                                                    cVar.d = new c(String.valueOf(this.S) + File.separator + e() + ".png", this.I);
                                                    a(this.z);
                                                } else {
                                                    cVar.d = new c(this.z, this.I);
                                                }
                                            }
                                            if (this.H) {
                                                this.j[this.J] = i14;
                                            }
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
                                            this.Q.a(true, this.P);
                                            break;
                                        }
                                    } else {
                                        i30 = 0;
                                    }
                                }
                                i26 += (this.D[i30] & 255) << i28;
                                i28 += 8;
                                i30++;
                                i27--;
                            } else {
                                int i49 = i26 & i21;
                                i26 >>= i20;
                                i28 -= i20;
                                if (i49 <= i18 && i49 != i17) {
                                    if (i49 == i16) {
                                        i20 = h3 + 1;
                                        i21 = (1 << i20) - 1;
                                        i18 = i16 + 2;
                                        i19 = -1;
                                    } else if (i19 == -1) {
                                        this.M[i24] = this.L[i49];
                                        i24++;
                                        i19 = i49;
                                        i25 = i49;
                                    } else {
                                        if (i49 == i18) {
                                            i11 = i24 + 1;
                                            this.M[i24] = (byte) i25;
                                            s = i19;
                                        } else {
                                            i11 = i24;
                                            s = i49;
                                        }
                                        while (s > i16) {
                                            this.M[i11] = this.L[s];
                                            s = this.K[s];
                                            i11++;
                                        }
                                        int i50 = this.L[s] & 255;
                                        if (i18 < 4096) {
                                            int i51 = i11 + 1;
                                            this.M[i11] = (byte) i50;
                                            this.K[i18] = (short) i19;
                                            this.L[i18] = (byte) i50;
                                            i10 = i18 + 1;
                                            if ((i10 & i21) == 0 && i10 < 4096) {
                                                i20++;
                                                i21 += i10;
                                            }
                                            i8 = i26;
                                            i9 = i49;
                                            i3 = i21;
                                            i4 = i50;
                                            i5 = i28;
                                            i6 = i20;
                                            i7 = i51;
                                        }
                                    }
                                }
                                while (i < i15) {
                                }
                                m();
                                if (g()) {
                                }
                            }
                            int i52 = i7 - 1;
                            this.N[i23] = this.M[i52];
                            i29++;
                            i23++;
                            i20 = i6;
                            i28 = i5;
                            i25 = i4;
                            i21 = i3;
                            int i53 = i8;
                            i24 = i52;
                            i18 = i10;
                            i19 = i9;
                            i26 = i53;
                        }
                        while (i < i15) {
                        }
                        m();
                        if (g()) {
                        }
                    }
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

    private void k() {
        do {
            i();
            if (this.D[0] == 1) {
                this.g = (this.D[1] & 255) | ((this.D[2] & 255) << 8);
            }
            if (this.E <= 0) {
                return;
            }
        } while (!g());
    }

    private int l() {
        return h() | (h() << 8);
    }

    private void m() {
        do {
            i();
            if (this.E <= 0) {
                return;
            }
        } while (!g());
    }
}
