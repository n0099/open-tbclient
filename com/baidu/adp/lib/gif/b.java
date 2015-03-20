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
    private InputStream in;
    private int status;
    private boolean tE;
    private int tF;
    private int[] tH;
    private int[] tI;
    private int[] tJ;
    private int tK;
    private int tL;
    private int tM;
    private boolean tN;
    private boolean tO;
    private int tP;
    private int tQ;
    private int tR;
    private int tS;
    private int tT;
    private int tU;
    private int tV;
    private int tW;
    private int tX;
    private Bitmap tY;
    private Bitmap tZ;
    private int ug;
    private short[] uh;
    private byte[] ui;
    private byte[] uj;
    private byte[] uk;
    private c ul;
    private int um;
    private a uo;
    public int width;
    private int tG = 1;
    private c ua = null;
    private boolean isShow = false;
    private final byte[] ub = new byte[256];
    private int uc = 0;
    private int ud = 0;
    private int ue = 0;
    private boolean uf = false;
    private int delay = 0;
    private byte[] up = null;
    private String uq = null;
    private boolean ur = false;

    public b(a aVar) {
        this.uo = null;
        this.uo = aVar;
    }

    public void setGifImage(byte[] bArr) {
        this.up = bArr;
    }

    public void setGifImage(InputStream inputStream) {
        this.in = inputStream;
    }

    private void d(String str, boolean z) {
        try {
            ah(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean ah(String str) {
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
                ah(String.valueOf(str) + File.separator + list[i]);
                d(String.valueOf(str) + File.separator + list[i], true);
                z = true;
            } else {
                z = z2;
            }
            i++;
        }
    }

    private synchronized String gA() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void b(Bitmap bitmap, String str) {
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(String.valueOf(this.uq) + File.separator + gA() + ".png"));
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.in != null) {
            gE();
        } else if (this.up != null) {
            gD();
        }
    }

    public void free() {
        c cVar = this.ul;
        if (!this.ur) {
            while (cVar != null) {
                if (cVar.tY != null && !cVar.tY.isRecycled()) {
                    cVar.tY.recycle();
                }
                cVar.tY = null;
                this.ul = this.ul.ut;
                cVar = this.ul;
            }
        } else {
            d(this.uq, true);
        }
        if (this.in != null) {
            try {
                this.in.close();
            } catch (Exception e) {
            }
            this.in = null;
        }
        this.up = null;
        this.status = 0;
        this.ua = null;
    }

    public int fg() {
        return this.um;
    }

    public Bitmap getImage() {
        return K(0);
    }

    private void gB() {
        int i;
        int[] iArr = new int[this.width * this.height];
        if (this.ue > 0) {
            if (this.ue == 3) {
                int i2 = this.um - 2;
                if (i2 > 0) {
                    this.tZ = K(i2 - 1);
                } else {
                    this.tZ = null;
                }
            }
            if (this.tZ != null) {
                this.tZ.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.ue == 2) {
                    int i3 = !this.uf ? this.tL : 0;
                    for (int i4 = 0; i4 < this.tX; i4++) {
                        int i5 = ((this.tV + i4) * this.width) + this.tU;
                        int i6 = this.tW + i5;
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
        for (int i10 = 0; i10 < this.tT; i10++) {
            if (this.tO) {
                if (i9 >= this.tT) {
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
            int i12 = i + this.tR;
            if (i12 < this.height) {
                int i13 = this.width * i12;
                int i14 = i13 + this.tQ;
                int i15 = this.tS + i14;
                if (this.width + i13 < i15) {
                    i15 = this.width + i13;
                }
                int i16 = this.tS * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.tJ[this.uk[i16] & 255];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.tY = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    public Bitmap K(int i) {
        c L = L(i);
        if (L == null) {
            return null;
        }
        return L.tY;
    }

    public c L(int i) {
        int i2 = 0;
        for (c cVar = this.ul; cVar != null; cVar = cVar.ut) {
            if (i2 == i) {
                return cVar;
            }
            i2++;
        }
        return null;
    }

    public c gC() {
        if (!this.isShow) {
            this.isShow = true;
            return this.ul;
        } else if (this.ua == null) {
            return null;
        } else {
            if (this.status == 0) {
                if (this.ua.ut != null) {
                    this.ua = this.ua.ut;
                }
            } else {
                this.ua = this.ua.ut;
                if (this.ua == null) {
                    this.ua = this.ul;
                }
            }
            return this.ua;
        }
    }

    private int gD() {
        this.in = new ByteArrayInputStream(this.up);
        this.up = null;
        return gE();
    }

    private int gE() {
        init();
        if (this.in != null) {
            gK();
            if (!gG()) {
                gI();
                if (this.um < 0) {
                    this.status = 1;
                    this.uo.a(false, -1);
                } else {
                    this.status = -1;
                    this.uo.a(true, -1);
                }
            }
            try {
                this.in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.status = 2;
            this.uo.a(false, -1);
        }
        return this.status;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void gF() {
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
        int i10 = this.tS * this.tT;
        if (this.uk == null || this.uk.length < i10) {
            this.uk = new byte[i10];
        }
        if (this.uh == null) {
            this.uh = new short[4096];
        }
        if (this.ui == null) {
            this.ui = new byte[4096];
        }
        if (this.uj == null) {
            this.uj = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i11 = 1 << read;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = read + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.uh[i16] = 0;
            this.ui[i16] = (byte) i16;
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
                    i22 = gH();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.ub[i25] & 255) << i23;
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
                    this.uj[i18] = this.ui[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.uj[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.uj[i9] = this.ui[s];
                        s = this.uh[s];
                        i9++;
                    }
                    int i27 = this.ui[s] & 255;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.uj[i9] = (byte) i27;
                    this.uh[i13] = (short) i24;
                    this.ui[i13] = (byte) i27;
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
            this.uk[i17] = this.uj[i29];
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
            this.uk[i31] = 0;
        }
    }

    private boolean gG() {
        return this.status != 0;
    }

    private void init() {
        this.status = 0;
        this.um = 0;
        this.ul = null;
        this.tH = null;
        this.tI = null;
    }

    private int read() {
        try {
            return this.in.read();
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    private int gH() {
        this.uc = read();
        int i = 0;
        if (this.uc > 0) {
            while (i < this.uc) {
                try {
                    int read = this.in.read(this.ub, i, this.uc - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.uc) {
                this.status = 1;
            }
        }
        return i;
    }

    private int[] M(int i) {
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

    private void gI() {
        boolean z = false;
        while (!z && !gG()) {
            switch (read()) {
                case 0:
                    break;
                case 33:
                    switch (read()) {
                        case 249:
                            gJ();
                            continue;
                        case MotionEventCompat.ACTION_MASK /* 255 */:
                            gH();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = String.valueOf(str) + ((char) this.ub[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                gN();
                                break;
                            } else {
                                gQ();
                                continue;
                            }
                        default:
                            gQ();
                            continue;
                    }
                case 44:
                    gL();
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

    private void gJ() {
        read();
        int read = read();
        this.ud = (read & 28) >> 2;
        if (this.ud == 0) {
            this.ud = 1;
        }
        this.uf = (read & 1) != 0;
        this.delay = gO() * 10;
        this.ug = read();
        read();
    }

    private void gK() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        gM();
        if (this.tE && !gG()) {
            this.tH = M(this.tF);
            this.bgColor = this.tH[this.tK];
        }
    }

    private void gL() {
        int i = 0;
        this.tQ = gO();
        this.tR = gO();
        this.tS = gO();
        this.tT = gO();
        int read = read();
        this.tN = (read & 128) != 0;
        this.tO = (read & 64) != 0;
        this.tP = 2 << (read & 7);
        if (this.tN) {
            this.tI = M(this.tP);
            this.tJ = this.tI;
        } else {
            this.tJ = this.tH;
            if (this.tK == this.ug) {
                this.bgColor = 0;
            }
        }
        if (this.uf) {
            int i2 = this.tJ[this.ug];
            this.tJ[this.ug] = 0;
            i = i2;
        }
        if (this.tJ == null) {
            this.status = 1;
        }
        if (!gG()) {
            gF();
            gQ();
            if (!gG()) {
                this.um++;
                this.tY = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                gB();
                if (this.ul == null) {
                    if (this.ur) {
                        String gA = gA();
                        this.ul = new c(String.valueOf(this.uq) + File.separator + gA + ".png", this.delay);
                        b(this.tY, gA);
                    } else {
                        this.ul = new c(this.tY, this.delay);
                    }
                    this.ua = this.ul;
                } else {
                    c cVar = this.ul;
                    while (cVar.ut != null) {
                        cVar = cVar.ut;
                    }
                    if (this.ur) {
                        String gA2 = gA();
                        cVar.ut = new c(String.valueOf(this.uq) + File.separator + gA2 + ".png", this.delay);
                        b(this.tY, gA2);
                    } else {
                        cVar.ut = new c(this.tY, this.delay);
                    }
                }
                if (this.uf) {
                    this.tJ[this.ug] = i;
                }
                gP();
                this.uo.a(true, this.um);
            }
        }
    }

    private void gM() {
        this.width = gO();
        this.height = gO();
        int read = read();
        this.tE = (read & 128) != 0;
        this.tF = 2 << (read & 7);
        this.tK = read();
        this.tM = read();
    }

    private void gN() {
        do {
            gH();
            if (this.ub[0] == 1) {
                this.tG = (this.ub[1] & 255) | ((this.ub[2] & 255) << 8);
            }
            if (this.uc <= 0) {
                return;
            }
        } while (!gG());
    }

    private int gO() {
        return read() | (read() << 8);
    }

    private void gP() {
        this.ue = this.ud;
        this.tU = this.tQ;
        this.tV = this.tR;
        this.tW = this.tS;
        this.tX = this.tT;
        this.tZ = this.tY;
        this.tL = this.bgColor;
        this.ud = 0;
        this.uf = false;
        this.delay = 0;
        this.tI = null;
    }

    private void gQ() {
        do {
            gH();
            if (this.uc <= 0) {
                return;
            }
        } while (!gG());
    }
}
