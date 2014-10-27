package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import com.baidu.tbadk.BaseActivity;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends Thread {
    private int bgColor;
    private boolean hY;
    private int hZ;
    public int height;
    private Bitmap iA;
    private int iI;
    private short[] iJ;
    private byte[] iK;
    private byte[] iL;
    private byte[] iM;
    private c iN;
    private int iO;
    private a iP;
    private int[] ib;
    private int[] ic;
    private int[] ie;
    private int ig;
    private int ih;
    private int ii;
    private boolean ij;
    private boolean ik;
    private int il;
    private int im;
    private InputStream in;
    private int iq;
    private int ir;
    private int is;
    private int iu;
    private int iw;
    private int ix;
    private int iy;
    private Bitmap iz;
    private int status;
    public int width;
    private int ia = 1;
    private c iB = null;
    private boolean iC = false;
    private final byte[] iD = new byte[256];
    private int iE = 0;
    private int iF = 0;
    private int iG = 0;
    private boolean iH = false;
    private int delay = 0;
    private byte[] iQ = null;
    private String iR = null;
    private boolean iS = false;

    public b(a aVar) {
        this.iP = null;
        this.iP = aVar;
    }

    public void setGifImage(byte[] bArr) {
        this.iQ = bArr;
    }

    public void setGifImage(InputStream inputStream) {
        this.in = inputStream;
    }

    private void d(String str, boolean z) {
        try {
            V(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean V(String str) {
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
                V(String.valueOf(str) + File.separator + list[i]);
                d(String.valueOf(str) + File.separator + list[i], true);
                z = true;
            } else {
                z = z2;
            }
            i++;
        }
    }

    private synchronized String dc() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, String str) {
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(String.valueOf(this.iR) + File.separator + dc() + ".png"));
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.in != null) {
            di();
        } else if (this.iQ != null) {
            dh();
        }
    }

    public void dd() {
        c cVar = this.iN;
        if (!this.iS) {
            while (cVar != null) {
                if (cVar.iz != null && !cVar.iz.isRecycled()) {
                    cVar.iz.recycle();
                }
                cVar.iz = null;
                this.iN = this.iN.iU;
                cVar = this.iN;
            }
        } else {
            d(this.iR, true);
        }
        if (this.in != null) {
            try {
                this.in.close();
            } catch (Exception e) {
            }
            this.in = null;
        }
        this.iQ = null;
        this.status = 0;
        this.iB = null;
    }

    public int bj() {
        return this.iO;
    }

    public Bitmap de() {
        return w(0);
    }

    private void df() {
        int i;
        int[] iArr = new int[this.width * this.height];
        if (this.iG > 0) {
            if (this.iG == 3) {
                int i2 = this.iO - 2;
                if (i2 > 0) {
                    this.iA = w(i2 - 1);
                } else {
                    this.iA = null;
                }
            }
            if (this.iA != null) {
                this.iA.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.iG == 2) {
                    int i3 = !this.iH ? this.ih : 0;
                    for (int i4 = 0; i4 < this.iy; i4++) {
                        int i5 = ((this.iw + i4) * this.width) + this.iu;
                        int i6 = this.ix + i5;
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
        for (int i10 = 0; i10 < this.is; i10++) {
            if (this.ik) {
                if (i9 >= this.is) {
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
            int i12 = i + this.iq;
            if (i12 < this.height) {
                int i13 = this.width * i12;
                int i14 = i13 + this.im;
                int i15 = this.ir + i14;
                if (this.width + i13 < i15) {
                    i15 = this.width + i13;
                }
                int i16 = this.ir * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.ie[this.iM[i16] & BaseActivity.KEYBOARD_STATE_INIT];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.iz = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    public Bitmap w(int i) {
        c x = x(i);
        if (x == null) {
            return null;
        }
        return x.iz;
    }

    public c x(int i) {
        int i2 = 0;
        for (c cVar = this.iN; cVar != null; cVar = cVar.iU) {
            if (i2 == i) {
                return cVar;
            }
            i2++;
        }
        return null;
    }

    public c dg() {
        if (!this.iC) {
            this.iC = true;
            return this.iN;
        } else if (this.iB == null) {
            return null;
        } else {
            if (this.status == 0) {
                if (this.iB.iU != null) {
                    this.iB = this.iB.iU;
                }
            } else {
                this.iB = this.iB.iU;
                if (this.iB == null) {
                    this.iB = this.iN;
                }
            }
            return this.iB;
        }
    }

    private int dh() {
        this.in = new ByteArrayInputStream(this.iQ);
        this.iQ = null;
        return di();
    }

    private int di() {
        init();
        if (this.in != null) {
            dp();
            if (!dk()) {
                dm();
                if (this.iO < 0) {
                    this.status = 1;
                    this.iP.a(false, -1);
                } else {
                    this.status = -1;
                    this.iP.a(true, -1);
                }
            }
            try {
                this.in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.status = 2;
            this.iP.a(false, -1);
        }
        return this.status;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void dj() {
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
        int i10 = this.ir * this.is;
        if (this.iM == null || this.iM.length < i10) {
            this.iM = new byte[i10];
        }
        if (this.iJ == null) {
            this.iJ = new short[4096];
        }
        if (this.iK == null) {
            this.iK = new byte[4096];
        }
        if (this.iL == null) {
            this.iL = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i11 = 1 << read;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = read + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.iJ[i16] = 0;
            this.iK[i16] = (byte) i16;
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
                    i22 = dl();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.iD[i25] & BaseActivity.KEYBOARD_STATE_INIT) << i23;
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
                    this.iL[i18] = this.iK[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.iL[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.iL[i9] = this.iK[s];
                        s = this.iJ[s];
                        i9++;
                    }
                    int i27 = this.iK[s] & BaseActivity.KEYBOARD_STATE_INIT;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.iL[i9] = (byte) i27;
                    this.iJ[i13] = (short) i24;
                    this.iK[i13] = (byte) i27;
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
            this.iM[i17] = this.iL[i29];
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
            this.iM[i31] = 0;
        }
    }

    private boolean dk() {
        return this.status != 0;
    }

    private void init() {
        this.status = 0;
        this.iO = 0;
        this.iN = null;
        this.ib = null;
        this.ic = null;
    }

    private int read() {
        try {
            return this.in.read();
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    private int dl() {
        this.iE = read();
        int i = 0;
        if (this.iE > 0) {
            while (i < this.iE) {
                try {
                    int read = this.in.read(this.iD, i, this.iE - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.iE) {
                this.status = 1;
            }
        }
        return i;
    }

    private int[] y(int i) {
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
                iArr[i5] = ((bArr[i4] & BaseActivity.KEYBOARD_STATE_INIT) << 16) | (-16777216) | ((bArr[i6] & BaseActivity.KEYBOARD_STATE_INIT) << 8) | (bArr[i7] & BaseActivity.KEYBOARD_STATE_INIT);
            }
        }
        return iArr;
    }

    private void dm() {
        boolean z = false;
        while (!z && !dk()) {
            switch (read()) {
                case 0:
                    break;
                case 33:
                    switch (read()) {
                        case 249:
                            dn();
                            continue;
                        case MotionEventCompat.ACTION_MASK /* 255 */:
                            dl();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = String.valueOf(str) + ((char) this.iD[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                ds();
                                break;
                            } else {
                                dv();
                                continue;
                            }
                        default:
                            dv();
                            continue;
                    }
                case 44:
                    dq();
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

    private void dn() {
        read();
        int read = read();
        this.iF = (read & 28) >> 2;
        if (this.iF == 0) {
            this.iF = 1;
        }
        this.iH = (read & 1) != 0;
        this.delay = dt() * 10;
        this.iI = read();
        read();
    }

    private void dp() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        dr();
        if (this.hY && !dk()) {
            this.ib = y(this.hZ);
            this.bgColor = this.ib[this.ig];
        }
    }

    private void dq() {
        int i = 0;
        this.im = dt();
        this.iq = dt();
        this.ir = dt();
        this.is = dt();
        int read = read();
        this.ij = (read & 128) != 0;
        this.ik = (read & 64) != 0;
        this.il = 2 << (read & 7);
        if (this.ij) {
            this.ic = y(this.il);
            this.ie = this.ic;
        } else {
            this.ie = this.ib;
            if (this.ig == this.iI) {
                this.bgColor = 0;
            }
        }
        if (this.iH) {
            int i2 = this.ie[this.iI];
            this.ie[this.iI] = 0;
            i = i2;
        }
        if (this.ie == null) {
            this.status = 1;
        }
        if (!dk()) {
            dj();
            dv();
            if (!dk()) {
                this.iO++;
                this.iz = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                df();
                if (this.iN == null) {
                    if (this.iS) {
                        String dc = dc();
                        this.iN = new c(String.valueOf(this.iR) + File.separator + dc + ".png", this.delay);
                        a(this.iz, dc);
                    } else {
                        this.iN = new c(this.iz, this.delay);
                    }
                    this.iB = this.iN;
                } else {
                    c cVar = this.iN;
                    while (cVar.iU != null) {
                        cVar = cVar.iU;
                    }
                    if (this.iS) {
                        String dc2 = dc();
                        cVar.iU = new c(String.valueOf(this.iR) + File.separator + dc2 + ".png", this.delay);
                        a(this.iz, dc2);
                    } else {
                        cVar.iU = new c(this.iz, this.delay);
                    }
                }
                if (this.iH) {
                    this.ie[this.iI] = i;
                }
                du();
                this.iP.a(true, this.iO);
            }
        }
    }

    private void dr() {
        this.width = dt();
        this.height = dt();
        int read = read();
        this.hY = (read & 128) != 0;
        this.hZ = 2 << (read & 7);
        this.ig = read();
        this.ii = read();
    }

    private void ds() {
        do {
            dl();
            if (this.iD[0] == 1) {
                this.ia = (this.iD[1] & BaseActivity.KEYBOARD_STATE_INIT) | ((this.iD[2] & BaseActivity.KEYBOARD_STATE_INIT) << 8);
            }
            if (this.iE <= 0) {
                return;
            }
        } while (!dk());
    }

    private int dt() {
        return read() | (read() << 8);
    }

    private void du() {
        this.iG = this.iF;
        this.iu = this.im;
        this.iw = this.iq;
        this.ix = this.ir;
        this.iy = this.is;
        this.iA = this.iz;
        this.ih = this.bgColor;
        this.iF = 0;
        this.iH = false;
        this.delay = 0;
        this.ic = null;
    }

    private void dv() {
        do {
            dl();
            if (this.iE <= 0) {
                return;
            }
        } while (!dk());
    }
}
