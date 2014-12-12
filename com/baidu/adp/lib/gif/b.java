package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends Thread {
    private int bgColor;
    public int height;
    private int iA;
    private int iB;
    private int iC;
    private int iD;
    private int iE;
    private int iF;
    private Bitmap iG;
    private Bitmap iH;
    private int iO;
    private short[] iP;
    private byte[] iQ;
    private byte[] iR;
    private byte[] iS;
    private c iT;
    private int iU;
    private a iV;
    private boolean ih;
    private int ii;
    private int[] ik;
    private int[] il;
    private int[] im;
    private InputStream in;
    private int io;
    private int iq;
    private int ir;
    private boolean iu;
    private boolean iw;
    private int ix;
    private int iy;
    private int iz;
    private int status;
    public int width;
    private int ij = 1;
    private c iI = null;
    private boolean isShow = false;
    private final byte[] iJ = new byte[256];
    private int iK = 0;
    private int iL = 0;
    private int iM = 0;
    private boolean iN = false;
    private int delay = 0;
    private byte[] iW = null;
    private String iX = null;
    private boolean iY = false;

    public b(a aVar) {
        this.iV = null;
        this.iV = aVar;
    }

    public void setGifImage(byte[] bArr) {
        this.iW = bArr;
    }

    public void setGifImage(InputStream inputStream) {
        this.in = inputStream;
    }

    private void d(String str, boolean z) {
        try {
            aa(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean aa(String str) {
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
                aa(String.valueOf(str) + File.separator + list[i]);
                d(String.valueOf(str) + File.separator + list[i], true);
                z = true;
            } else {
                z = z2;
            }
            i++;
        }
    }

    private synchronized String dd() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void b(Bitmap bitmap, String str) {
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(String.valueOf(this.iX) + File.separator + dd() + ".png"));
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.in != null) {
            dh();
        } else if (this.iW != null) {
            dg();
        }
    }

    public void free() {
        c cVar = this.iT;
        if (!this.iY) {
            while (cVar != null) {
                if (cVar.iG != null && !cVar.iG.isRecycled()) {
                    cVar.iG.recycle();
                }
                cVar.iG = null;
                this.iT = this.iT.ja;
                cVar = this.iT;
            }
        } else {
            d(this.iX, true);
        }
        if (this.in != null) {
            try {
                this.in.close();
            } catch (Exception e) {
            }
            this.in = null;
        }
        this.iW = null;
        this.status = 0;
        this.iI = null;
    }

    public int bK() {
        return this.iU;
    }

    public Bitmap getImage() {
        return E(0);
    }

    private void de() {
        int i;
        int[] iArr = new int[this.width * this.height];
        if (this.iM > 0) {
            if (this.iM == 3) {
                int i2 = this.iU - 2;
                if (i2 > 0) {
                    this.iH = E(i2 - 1);
                } else {
                    this.iH = null;
                }
            }
            if (this.iH != null) {
                this.iH.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.iM == 2) {
                    int i3 = !this.iN ? this.iq : 0;
                    for (int i4 = 0; i4 < this.iF; i4++) {
                        int i5 = ((this.iD + i4) * this.width) + this.iC;
                        int i6 = this.iE + i5;
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
        for (int i10 = 0; i10 < this.iB; i10++) {
            if (this.iw) {
                if (i9 >= this.iB) {
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
            int i12 = i + this.iz;
            if (i12 < this.height) {
                int i13 = this.width * i12;
                int i14 = i13 + this.iy;
                int i15 = this.iA + i14;
                if (this.width + i13 < i15) {
                    i15 = this.width + i13;
                }
                int i16 = this.iA * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.im[this.iS[i16] & 255];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.iG = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    public Bitmap E(int i) {
        c F = F(i);
        if (F == null) {
            return null;
        }
        return F.iG;
    }

    public c F(int i) {
        int i2 = 0;
        for (c cVar = this.iT; cVar != null; cVar = cVar.ja) {
            if (i2 == i) {
                return cVar;
            }
            i2++;
        }
        return null;
    }

    public c df() {
        if (!this.isShow) {
            this.isShow = true;
            return this.iT;
        } else if (this.iI == null) {
            return null;
        } else {
            if (this.status == 0) {
                if (this.iI.ja != null) {
                    this.iI = this.iI.ja;
                }
            } else {
                this.iI = this.iI.ja;
                if (this.iI == null) {
                    this.iI = this.iT;
                }
            }
            return this.iI;
        }
    }

    private int dg() {
        this.in = new ByteArrayInputStream(this.iW);
        this.iW = null;
        return dh();
    }

    private int dh() {
        init();
        if (this.in != null) {
            dn();
            if (!dj()) {
                dl();
                if (this.iU < 0) {
                    this.status = 1;
                    this.iV.a(false, -1);
                } else {
                    this.status = -1;
                    this.iV.a(true, -1);
                }
            }
            try {
                this.in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.status = 2;
            this.iV.a(false, -1);
        }
        return this.status;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void di() {
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
        int i10 = this.iA * this.iB;
        if (this.iS == null || this.iS.length < i10) {
            this.iS = new byte[i10];
        }
        if (this.iP == null) {
            this.iP = new short[4096];
        }
        if (this.iQ == null) {
            this.iQ = new byte[4096];
        }
        if (this.iR == null) {
            this.iR = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i11 = 1 << read;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = read + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.iP[i16] = 0;
            this.iQ[i16] = (byte) i16;
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
                    i22 = dk();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.iJ[i25] & 255) << i23;
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
                    i14 = read + 1;
                    i15 = (1 << i14) - 1;
                    i13 = i11 + 2;
                    i24 = -1;
                } else if (i24 == -1) {
                    this.iR[i18] = this.iQ[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.iR[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.iR[i9] = this.iQ[s];
                        s = this.iP[s];
                        i9++;
                    }
                    int i27 = this.iQ[s] & 255;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.iR[i9] = (byte) i27;
                    this.iP[i13] = (short) i24;
                    this.iQ[i13] = (byte) i27;
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
            this.iS[i17] = this.iR[i29];
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
            this.iS[i31] = 0;
        }
    }

    private boolean dj() {
        return this.status != 0;
    }

    private void init() {
        this.status = 0;
        this.iU = 0;
        this.iT = null;
        this.ik = null;
        this.il = null;
    }

    private int read() {
        try {
            return this.in.read();
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    private int dk() {
        this.iK = read();
        int i = 0;
        if (this.iK > 0) {
            while (i < this.iK) {
                try {
                    int read = this.in.read(this.iJ, i, this.iK - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.iK) {
                this.status = 1;
            }
        }
        return i;
    }

    private int[] G(int i) {
        int i2;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.in.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.status = 1;
        } else {
            iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                i4 = i7 + 1;
                iArr[i5] = ((bArr[i4] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            }
        }
        return iArr;
    }

    private void dl() {
        boolean z = false;
        while (!z && !dj()) {
            switch (read()) {
                case 0:
                    break;
                case 33:
                    switch (read()) {
                        case 249:
                            dm();
                            continue;
                        case MotionEventCompat.ACTION_MASK /* 255 */:
                            dk();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = String.valueOf(str) + ((char) this.iJ[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                dr();
                                break;
                            } else {
                                du();
                                continue;
                            }
                        default:
                            du();
                            continue;
                    }
                case 44:
                    dp();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.status = 1;
                    break;
            }
        }
    }

    private void dm() {
        read();
        int read = read();
        this.iL = (read & 28) >> 2;
        if (this.iL == 0) {
            this.iL = 1;
        }
        this.iN = (read & 1) != 0;
        this.delay = ds() * 10;
        this.iO = read();
        read();
    }

    private void dn() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        dq();
        if (this.ih && !dj()) {
            this.ik = G(this.ii);
            this.bgColor = this.ik[this.io];
        }
    }

    private void dp() {
        int i = 0;
        this.iy = ds();
        this.iz = ds();
        this.iA = ds();
        this.iB = ds();
        int read = read();
        this.iu = (read & 128) != 0;
        this.iw = (read & 64) != 0;
        this.ix = 2 << (read & 7);
        if (this.iu) {
            this.il = G(this.ix);
            this.im = this.il;
        } else {
            this.im = this.ik;
            if (this.io == this.iO) {
                this.bgColor = 0;
            }
        }
        if (this.iN) {
            int i2 = this.im[this.iO];
            this.im[this.iO] = 0;
            i = i2;
        }
        if (this.im == null) {
            this.status = 1;
        }
        if (!dj()) {
            di();
            du();
            if (!dj()) {
                this.iU++;
                this.iG = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                de();
                if (this.iT == null) {
                    if (this.iY) {
                        String dd = dd();
                        this.iT = new c(String.valueOf(this.iX) + File.separator + dd + ".png", this.delay);
                        b(this.iG, dd);
                    } else {
                        this.iT = new c(this.iG, this.delay);
                    }
                    this.iI = this.iT;
                } else {
                    c cVar = this.iT;
                    while (cVar.ja != null) {
                        cVar = cVar.ja;
                    }
                    if (this.iY) {
                        String dd2 = dd();
                        cVar.ja = new c(String.valueOf(this.iX) + File.separator + dd2 + ".png", this.delay);
                        b(this.iG, dd2);
                    } else {
                        cVar.ja = new c(this.iG, this.delay);
                    }
                }
                if (this.iN) {
                    this.im[this.iO] = i;
                }
                dt();
                this.iV.a(true, this.iU);
            }
        }
    }

    private void dq() {
        this.width = ds();
        this.height = ds();
        int read = read();
        this.ih = (read & 128) != 0;
        this.ii = 2 << (read & 7);
        this.io = read();
        this.ir = read();
    }

    private void dr() {
        do {
            dk();
            if (this.iJ[0] == 1) {
                this.ij = (this.iJ[1] & 255) | ((this.iJ[2] & 255) << 8);
            }
            if (this.iK <= 0) {
                return;
            }
        } while (!dj());
    }

    private int ds() {
        return read() | (read() << 8);
    }

    private void dt() {
        this.iM = this.iL;
        this.iC = this.iy;
        this.iD = this.iz;
        this.iE = this.iA;
        this.iF = this.iB;
        this.iH = this.iG;
        this.iq = this.bgColor;
        this.iL = 0;
        this.iN = false;
        this.delay = 0;
        this.il = null;
    }

    private void du() {
        do {
            dk();
            if (this.iK <= 0) {
                return;
            }
        } while (!dj());
    }
}
