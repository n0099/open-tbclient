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
    private int iG;
    private int iH;
    private Bitmap iI;
    private Bitmap iJ;
    private int iQ;
    private short[] iR;
    private byte[] iS;
    private byte[] iT;
    private byte[] iU;
    private c iV;
    private int iW;
    private a iX;
    private boolean ij;
    private int ik;
    private int[] im;
    private InputStream in;
    private int[] io;
    private int[] iq;
    private int ir;
    private int iu;
    private int iw;
    private boolean ix;
    private boolean iy;
    private int iz;
    private int status;
    public int width;
    private int il = 1;
    private c iK = null;
    private boolean isShow = false;
    private final byte[] iL = new byte[256];
    private int iM = 0;
    private int iN = 0;
    private int iO = 0;
    private boolean iP = false;
    private int delay = 0;
    private byte[] iY = null;
    private String iZ = null;
    private boolean ja = false;

    public b(a aVar) {
        this.iX = null;
        this.iX = aVar;
    }

    public void setGifImage(byte[] bArr) {
        this.iY = bArr;
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

    private synchronized String db() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void b(Bitmap bitmap, String str) {
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(String.valueOf(this.iZ) + File.separator + db() + ".png"));
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.in != null) {
            df();
        } else if (this.iY != null) {
            de();
        }
    }

    public void free() {
        c cVar = this.iV;
        if (!this.ja) {
            while (cVar != null) {
                if (cVar.iI != null && !cVar.iI.isRecycled()) {
                    cVar.iI.recycle();
                }
                cVar.iI = null;
                this.iV = this.iV.jc;
                cVar = this.iV;
            }
        } else {
            d(this.iZ, true);
        }
        if (this.in != null) {
            try {
                this.in.close();
            } catch (Exception e) {
            }
            this.in = null;
        }
        this.iY = null;
        this.status = 0;
        this.iK = null;
    }

    public int bI() {
        return this.iW;
    }

    public Bitmap getImage() {
        return J(0);
    }

    private void dc() {
        int i;
        int[] iArr = new int[this.width * this.height];
        if (this.iO > 0) {
            if (this.iO == 3) {
                int i2 = this.iW - 2;
                if (i2 > 0) {
                    this.iJ = J(i2 - 1);
                } else {
                    this.iJ = null;
                }
            }
            if (this.iJ != null) {
                this.iJ.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.iO == 2) {
                    int i3 = !this.iP ? this.iu : 0;
                    for (int i4 = 0; i4 < this.iH; i4++) {
                        int i5 = ((this.iF + i4) * this.width) + this.iE;
                        int i6 = this.iG + i5;
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
        for (int i10 = 0; i10 < this.iD; i10++) {
            if (this.iy) {
                if (i9 >= this.iD) {
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
            int i12 = i + this.iB;
            if (i12 < this.height) {
                int i13 = this.width * i12;
                int i14 = i13 + this.iA;
                int i15 = this.iC + i14;
                if (this.width + i13 < i15) {
                    i15 = this.width + i13;
                }
                int i16 = this.iC * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.iq[this.iU[i16] & 255];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.iI = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    public Bitmap J(int i) {
        c K = K(i);
        if (K == null) {
            return null;
        }
        return K.iI;
    }

    public c K(int i) {
        int i2 = 0;
        for (c cVar = this.iV; cVar != null; cVar = cVar.jc) {
            if (i2 == i) {
                return cVar;
            }
            i2++;
        }
        return null;
    }

    public c dd() {
        if (!this.isShow) {
            this.isShow = true;
            return this.iV;
        } else if (this.iK == null) {
            return null;
        } else {
            if (this.status == 0) {
                if (this.iK.jc != null) {
                    this.iK = this.iK.jc;
                }
            } else {
                this.iK = this.iK.jc;
                if (this.iK == null) {
                    this.iK = this.iV;
                }
            }
            return this.iK;
        }
    }

    private int de() {
        this.in = new ByteArrayInputStream(this.iY);
        this.iY = null;
        return df();
    }

    private int df() {
        init();
        if (this.in != null) {
            dl();
            if (!dh()) {
                dj();
                if (this.iW < 0) {
                    this.status = 1;
                    this.iX.a(false, -1);
                } else {
                    this.status = -1;
                    this.iX.a(true, -1);
                }
            }
            try {
                this.in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.status = 2;
            this.iX.a(false, -1);
        }
        return this.status;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void dg() {
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
        int i10 = this.iC * this.iD;
        if (this.iU == null || this.iU.length < i10) {
            this.iU = new byte[i10];
        }
        if (this.iR == null) {
            this.iR = new short[4096];
        }
        if (this.iS == null) {
            this.iS = new byte[4096];
        }
        if (this.iT == null) {
            this.iT = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i11 = 1 << read;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = read + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.iR[i16] = 0;
            this.iS[i16] = (byte) i16;
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
                    i22 = di();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.iL[i25] & 255) << i23;
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
                    this.iT[i18] = this.iS[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.iT[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.iT[i9] = this.iS[s];
                        s = this.iR[s];
                        i9++;
                    }
                    int i27 = this.iS[s] & 255;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.iT[i9] = (byte) i27;
                    this.iR[i13] = (short) i24;
                    this.iS[i13] = (byte) i27;
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
            this.iU[i17] = this.iT[i29];
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
            this.iU[i31] = 0;
        }
    }

    private boolean dh() {
        return this.status != 0;
    }

    private void init() {
        this.status = 0;
        this.iW = 0;
        this.iV = null;
        this.im = null;
        this.io = null;
    }

    private int read() {
        try {
            return this.in.read();
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    private int di() {
        this.iM = read();
        int i = 0;
        if (this.iM > 0) {
            while (i < this.iM) {
                try {
                    int read = this.in.read(this.iL, i, this.iM - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.iM) {
                this.status = 1;
            }
        }
        return i;
    }

    private int[] L(int i) {
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

    private void dj() {
        boolean z = false;
        while (!z && !dh()) {
            switch (read()) {
                case 0:
                    break;
                case 33:
                    switch (read()) {
                        case 249:
                            dk();
                            continue;
                        case MotionEventCompat.ACTION_MASK /* 255 */:
                            di();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = String.valueOf(str) + ((char) this.iL[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                dp();
                                break;
                            } else {
                                ds();
                                continue;
                            }
                        default:
                            ds();
                            continue;
                    }
                case 44:
                    dm();
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

    private void dk() {
        read();
        int read = read();
        this.iN = (read & 28) >> 2;
        if (this.iN == 0) {
            this.iN = 1;
        }
        this.iP = (read & 1) != 0;
        this.delay = dq() * 10;
        this.iQ = read();
        read();
    }

    private void dl() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        dn();
        if (this.ij && !dh()) {
            this.im = L(this.ik);
            this.bgColor = this.im[this.ir];
        }
    }

    private void dm() {
        int i = 0;
        this.iA = dq();
        this.iB = dq();
        this.iC = dq();
        this.iD = dq();
        int read = read();
        this.ix = (read & 128) != 0;
        this.iy = (read & 64) != 0;
        this.iz = 2 << (read & 7);
        if (this.ix) {
            this.io = L(this.iz);
            this.iq = this.io;
        } else {
            this.iq = this.im;
            if (this.ir == this.iQ) {
                this.bgColor = 0;
            }
        }
        if (this.iP) {
            int i2 = this.iq[this.iQ];
            this.iq[this.iQ] = 0;
            i = i2;
        }
        if (this.iq == null) {
            this.status = 1;
        }
        if (!dh()) {
            dg();
            ds();
            if (!dh()) {
                this.iW++;
                this.iI = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                dc();
                if (this.iV == null) {
                    if (this.ja) {
                        String db = db();
                        this.iV = new c(String.valueOf(this.iZ) + File.separator + db + ".png", this.delay);
                        b(this.iI, db);
                    } else {
                        this.iV = new c(this.iI, this.delay);
                    }
                    this.iK = this.iV;
                } else {
                    c cVar = this.iV;
                    while (cVar.jc != null) {
                        cVar = cVar.jc;
                    }
                    if (this.ja) {
                        String db2 = db();
                        cVar.jc = new c(String.valueOf(this.iZ) + File.separator + db2 + ".png", this.delay);
                        b(this.iI, db2);
                    } else {
                        cVar.jc = new c(this.iI, this.delay);
                    }
                }
                if (this.iP) {
                    this.iq[this.iQ] = i;
                }
                dr();
                this.iX.a(true, this.iW);
            }
        }
    }

    private void dn() {
        this.width = dq();
        this.height = dq();
        int read = read();
        this.ij = (read & 128) != 0;
        this.ik = 2 << (read & 7);
        this.ir = read();
        this.iw = read();
    }

    private void dp() {
        do {
            di();
            if (this.iL[0] == 1) {
                this.il = (this.iL[1] & 255) | ((this.iL[2] & 255) << 8);
            }
            if (this.iM <= 0) {
                return;
            }
        } while (!dh());
    }

    private int dq() {
        return read() | (read() << 8);
    }

    private void dr() {
        this.iO = this.iN;
        this.iE = this.iA;
        this.iF = this.iB;
        this.iG = this.iC;
        this.iH = this.iD;
        this.iJ = this.iI;
        this.iu = this.bgColor;
        this.iN = 0;
        this.iP = false;
        this.delay = 0;
        this.io = null;
    }

    private void ds() {
        do {
            di();
            if (this.iM <= 0) {
                return;
            }
        } while (!dh());
    }
}
