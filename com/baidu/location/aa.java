package com.baidu.location;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a0, n {
    private static final int gp = 128;
    private a gl;
    private long gt = 0;
    private static aa gr = null;
    public static boolean go = true;
    public static boolean gq = true;
    public static boolean gu = false;
    public static boolean gi = true;
    public static boolean gw = true;
    public static boolean gj = true;
    public static boolean gn = true;
    static boolean gs = false;
    private static final String gk = I + "/conlts.dat";
    public static int gv = -1;
    public static int gm = -1;
    public static int gx = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t {
        String dD = null;
        boolean dC = false;
        boolean dE = false;

        public a() {
            this.cZ = new ArrayList();
        }

        @Override // com.baidu.location.t
        void X() {
            this.cX = c.m265for();
            this.c8 = 2;
            String j = Jni.j(this.dD);
            this.dD = null;
            if (this.dC) {
                this.cZ.add(new BasicNameValuePair("qt", "grid"));
            } else {
                this.cZ.add(new BasicNameValuePair("qt", "conf"));
            }
            this.cZ.add(new BasicNameValuePair("req", j));
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            if (!z || this.cY == null) {
                aa.this.m115do(null);
            } else if (this.dC) {
                aa.this.m117if(this.cY);
            } else {
                aa.this.m115do(this.cY);
            }
            if (this.cZ != null) {
                this.cZ.clear();
            }
            this.dE = false;
        }

        /* renamed from: if  reason: not valid java name */
        public void m120if(String str, boolean z) {
            if (this.dE) {
                return;
            }
            this.dE = true;
            this.dD = str;
            this.dC = z;
            R();
        }
    }

    private aa() {
        this.gl = null;
        this.gl = new a();
    }

    public static void bd() {
        String str = I + "/config.dat";
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", Integer.valueOf(c.ap), Float.valueOf(c.bg), Float.valueOf(c.am), Float.valueOf(c.aJ), Float.valueOf(c.aY), Integer.valueOf(c.ax), Integer.valueOf(c.aP), Integer.valueOf(c.a1), Integer.valueOf(c.ab), Integer.valueOf(c.Z), Integer.valueOf(c.a7), Integer.valueOf(c.ai), Float.valueOf(c.aH), Float.valueOf(c.aG), Float.valueOf(c.bd), Float.valueOf(c.aW), Integer.valueOf(c.a2), Float.valueOf(c.ad), Integer.valueOf(c.aX), Float.valueOf(c.X), Float.valueOf(c.aB), Float.valueOf(c.aA), Integer.valueOf(c.az), Integer.valueOf(c.ay), Integer.valueOf(c.aj ? 1 : 0), Integer.valueOf(c.ac ? 1 : 0), Integer.valueOf(c.aZ), Integer.valueOf(c.aQ), Long.valueOf(c.a6), Integer.valueOf(c.ba), Float.valueOf(c.aD), Float.valueOf(c.a0), Integer.valueOf(c.aC), Integer.valueOf(c.a9), Integer.valueOf(c.ah), Integer.valueOf(c.aa), Integer.valueOf(c.ae), Float.valueOf(c.aM), Integer.valueOf(c.ak)).getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(I);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(0L);
            randomAccessFile2.writeBoolean(true);
            randomAccessFile2.seek(2L);
            randomAccessFile2.writeInt(bytes.length);
            randomAccessFile2.write(bytes);
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    public static void be() {
        try {
            File file = new File(gk);
            if (file.exists()) {
                return;
            }
            File file2 = new File(I);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(128);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    public static aa bf() {
        if (gr == null) {
            gr = new aa();
        }
        return gr;
    }

    private void bi() {
        this.gl.m120if("&ver=" + c.ap + "&usr=" + a2.cC().cA() + "&app=" + a2.jc + "&prod=" + a2.jg, false);
    }

    public static void bj() {
        try {
            File file = new File(I + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(I);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(1L);
            randomAccessFile2.writeBoolean(true);
            randomAccessFile2.seek(1024L);
            randomAccessFile2.writeDouble(c.Y);
            randomAccessFile2.writeDouble(c.au);
            randomAccessFile2.writeBoolean(c.bb);
            if (c.bb && c.ar != null) {
                randomAccessFile2.write(c.ar);
            }
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    public static void bk() {
        int i = 0;
        try {
            File file = new File(gk);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    gx = 0;
                    be();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128L);
                byte[] bArr = new byte[readInt];
                while (true) {
                    if (i >= readInt2) {
                        break;
                    }
                    randomAccessFile.seek((readInt * i) + 128);
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        if (bArr[readInt3 - 1] == 0) {
                            String str = new String(bArr, 0, readInt3 - 1);
                            a2.cC();
                            if (str.equals(a2.jc)) {
                                gv = randomAccessFile.readInt();
                                gx = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    gx = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m115do(HttpEntity httpEntity) {
        int i;
        String str = null;
        gm = -1;
        if (httpEntity != null) {
            try {
                str = EntityUtils.toString(httpEntity, "utf-8");
                if (p(str)) {
                    bd();
                }
            } catch (Exception e) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    gm = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception e2) {
            }
        }
        try {
            bk();
            if (gm != -1) {
                i = gm;
                m118new(gm);
            } else {
                i = gv != -1 ? gv : -1;
            }
            if (i != -1) {
                m119try(i);
            }
            r.I().J().obtainMessage(92).sendToTarget();
        } catch (Exception e3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m117if(HttpEntity httpEntity) {
        int i = 0;
        try {
            byte[] byteArray = EntityUtils.toByteArray(httpEntity);
            if (byteArray != null) {
                if (byteArray.length < 640) {
                    c.bb = false;
                    c.au = c.a3 + 0.025d;
                    c.Y = c.aO - 0.025d;
                    i = 1;
                } else {
                    c.bb = true;
                    c.Y = Double.longBitsToDouble(Long.valueOf(((byteArray[7] & 255) << 56) | ((byteArray[6] & 255) << 48) | ((byteArray[5] & 255) << 40) | ((byteArray[4] & 255) << 32) | ((byteArray[3] & 255) << 24) | ((byteArray[2] & 255) << 16) | ((byteArray[1] & 255) << 8) | (byteArray[0] & 255)).longValue());
                    c.au = Double.longBitsToDouble(Long.valueOf(((byteArray[15] & 255) << 56) | ((byteArray[14] & 255) << 48) | ((byteArray[13] & 255) << 40) | ((byteArray[12] & 255) << 32) | ((byteArray[11] & 255) << 24) | ((byteArray[10] & 255) << 16) | ((byteArray[9] & 255) << 8) | (byteArray[8] & 255)).longValue());
                    c.ar = new byte[625];
                    while (i < 625) {
                        c.ar[i] = byteArray[i + 16];
                        i++;
                    }
                    i = 1;
                }
            }
            if (i != 0) {
                bj();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: new  reason: not valid java name */
    public static void m118new(int i) {
        File file = new File(gk);
        if (!file.exists()) {
            be();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((readInt * gx) + 128);
            byte[] bytes = (a2.jc + (char) 0).getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == gx) {
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: try  reason: not valid java name */
    public static void m119try(int i) {
        go = (i & 1) == 1;
        gq = (i & 2) == 2;
        gu = (i & 4) == 4;
        gi = (i & 8) == 8;
        gj = (i & 65536) == 65536;
        gn = (i & 131072) == 131072;
        if ((i & 16) == 16) {
            gw = false;
        }
    }

    public void bg() {
        try {
            File file = new File(I + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    p(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024L);
                    c.Y = randomAccessFile.readDouble();
                    c.au = randomAccessFile.readDouble();
                    c.bb = randomAccessFile.readBoolean();
                    if (c.bb) {
                        c.ar = new byte[625];
                        randomAccessFile.read(c.ar, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        m115do(null);
    }

    public void bh() {
        if (System.currentTimeMillis() - e.m284if().m287for() > 86400000) {
            e.m284if().a(System.currentTimeMillis());
            bi();
        }
    }

    public void o(String str) {
        this.gl.m120if(str, true);
    }

    public boolean p(String str) {
        boolean z = true;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > c.ap) {
                    c.ap = parseInt;
                    if (jSONObject.has("gps")) {
                        String[] split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (split[0] != null && !split[0].equals("")) {
                                c.bg = Float.parseFloat(split[0]);
                            }
                            if (split[1] != null && !split[1].equals("")) {
                                c.am = Float.parseFloat(split[1]);
                            }
                            if (split[2] != null && !split[2].equals("")) {
                                c.aJ = Float.parseFloat(split[2]);
                            }
                            if (split[3] != null && !split[3].equals("")) {
                                c.aY = Float.parseFloat(split[3]);
                            }
                            if (split[4] != null && !split[4].equals("")) {
                                c.ax = Integer.parseInt(split[4]);
                            }
                            if (split[5] != null && !split[5].equals("")) {
                                c.aP = Integer.parseInt(split[5]);
                            }
                            if (split[6] != null && !split[6].equals("")) {
                                c.a1 = Integer.parseInt(split[6]);
                            }
                            if (split[7] != null && !split[7].equals("")) {
                                c.ab = Integer.parseInt(split[7]);
                            }
                            if (split[8] != null && !split[8].equals("")) {
                                c.Z = Integer.parseInt(split[8]);
                            }
                            if (split[9] != null && !split[9].equals("")) {
                                c.a7 = Integer.parseInt(split[9]);
                            }
                            if (split[10] != null && !split[10].equals("")) {
                                c.ai = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        String[] split2 = jSONObject.getString("up").split("\\|");
                        if (split2.length > 3) {
                            if (split2[0] != null && !split2[0].equals("")) {
                                c.aH = Float.parseFloat(split2[0]);
                            }
                            if (split2[1] != null && !split2[1].equals("")) {
                                c.aG = Float.parseFloat(split2[1]);
                            }
                            if (split2[2] != null && !split2[2].equals("")) {
                                c.bd = Float.parseFloat(split2[2]);
                            }
                            if (split2[3] != null && !split2[3].equals("")) {
                                c.aW = Float.parseFloat(split2[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        String[] split3 = jSONObject.getString("wf").split("\\|");
                        if (split3.length > 3) {
                            if (split3[0] != null && !split3[0].equals("")) {
                                c.a2 = Integer.parseInt(split3[0]);
                            }
                            if (split3[1] != null && !split3[1].equals("")) {
                                c.ad = Float.parseFloat(split3[1]);
                            }
                            if (split3[2] != null && !split3[2].equals("")) {
                                c.aX = Integer.parseInt(split3[2]);
                            }
                            if (split3[3] != null && !split3[3].equals("")) {
                                c.X = Float.parseFloat(split3[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        String[] split4 = jSONObject.getString("ab").split("\\|");
                        if (split4.length > 3) {
                            if (split4[0] != null && !split4[0].equals("")) {
                                c.aB = Float.parseFloat(split4[0]);
                            }
                            if (split4[1] != null && !split4[1].equals("")) {
                                c.aA = Float.parseFloat(split4[1]);
                            }
                            if (split4[2] != null && !split4[2].equals("")) {
                                c.az = Integer.parseInt(split4[2]);
                            }
                            if (split4[3] != null && !split4[3].equals("")) {
                                c.ay = Integer.parseInt(split4[3]);
                            }
                        }
                    }
                    if (jSONObject.has("zxd")) {
                        String[] split5 = jSONObject.getString("zxd").split("\\|");
                        if (split5.length > 4) {
                            if (split5[0] != null && !split5[0].equals("")) {
                                c.aD = Float.parseFloat(split5[0]);
                            }
                            if (split5[1] != null && !split5[1].equals("")) {
                                c.a0 = Float.parseFloat(split5[1]);
                            }
                            if (split5[2] != null && !split5[2].equals("")) {
                                c.aC = Integer.parseInt(split5[2]);
                            }
                            if (split5[3] != null && !split5[3].equals("")) {
                                c.a9 = Integer.parseInt(split5[3]);
                            }
                            if (split5[4] != null && !split5[4].equals("")) {
                                c.ah = Integer.parseInt(split5[4]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        String[] split6 = jSONObject.getString("gpc").split("\\|");
                        if (split6.length > 5) {
                            if (split6[0] != null && !split6[0].equals("")) {
                                if (Integer.parseInt(split6[0]) > 0) {
                                    c.aj = true;
                                } else {
                                    c.aj = false;
                                }
                            }
                            if (split6[1] != null && !split6[1].equals("")) {
                                if (Integer.parseInt(split6[1]) > 0) {
                                    c.ac = true;
                                } else {
                                    c.ac = false;
                                }
                            }
                            if (split6[2] != null && !split6[2].equals("")) {
                                c.aZ = Integer.parseInt(split6[2]);
                            }
                            if (split6[3] != null && !split6[3].equals("")) {
                                c.aQ = Integer.parseInt(split6[3]);
                            }
                            if (split6[4] != null && !split6[4].equals("")) {
                                int parseInt2 = Integer.parseInt(split6[4]);
                                if (parseInt2 > 0) {
                                    c.a6 = parseInt2;
                                    c.aR = c.a6 * 1000 * 60;
                                    c.bf = c.aR >> 2;
                                } else {
                                    c.aK = false;
                                }
                            }
                            if (split6[5] != null && !split6[5].equals("")) {
                                c.ba = Integer.parseInt(split6[5]);
                            }
                        }
                    }
                    if (jSONObject.has("shak")) {
                        String[] split7 = jSONObject.getString("shak").split("\\|");
                        if (split7.length > 2) {
                            if (split7[0] != null && !split7[0].equals("")) {
                                c.aa = Integer.parseInt(split7[0]);
                            }
                            if (split7[1] != null && !split7[1].equals("")) {
                                c.ae = Integer.parseInt(split7[1]);
                            }
                            if (split7[2] != null && !split7[2].equals("")) {
                                c.aM = Float.parseFloat(split7[2]);
                            }
                        }
                    }
                    if (jSONObject.has("dmx")) {
                        c.ak = jSONObject.getInt("dmx");
                    }
                    return z;
                }
            } catch (Exception e) {
                return false;
            }
        }
        z = false;
        return z;
    }
}
