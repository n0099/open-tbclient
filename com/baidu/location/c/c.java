package com.baidu.location.c;

import android.content.SharedPreferences;
import com.baidu.location.Jni;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class c {
    private static c LA = null;
    private static final String k = com.baidu.location.h.h.a + "/conlts.dat";
    private static int l = -1;
    private static int m = -1;
    private static int n = 0;
    private a LB = null;
    public boolean a = true;
    public boolean b = true;
    public boolean c = false;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.location.h.f {
        String a = null;
        boolean b = false;
        boolean c = false;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.h = com.baidu.location.h.i.c();
            this.i = 2;
            String encode = Jni.encode(this.a);
            this.a = null;
            if (this.b) {
                this.k.put("qt", "grid");
            } else {
                this.k.put("qt", "conf");
            }
            this.k.put("req", encode);
        }

        public void a(String str, boolean z) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a = str;
            this.b = z;
            if (z) {
                b(true);
            } else {
                e();
            }
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            if (!z || this.j == null) {
                c.this.c(null);
            } else if (this.b) {
                c.this.a(this.m);
            } else {
                c.this.c(this.j);
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.c = false;
        }
    }

    private c() {
    }

    private void a(int i) {
        this.a = (i & 1) == 1;
        this.b = (i & 2) == 2;
        this.c = (i & 4) == 4;
        this.d = (i & 8) == 8;
        this.f = (i & 65536) == 65536;
        this.g = (i & 131072) == 131072;
        if ((i & 16) == 16) {
            this.e = false;
        }
    }

    private void a(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject == null) {
            return;
        }
        try {
            if (!jSONObject.has("ipen") || jSONObject.getInt("ipen") != 0) {
                z = true;
            }
            int i = jSONObject.has("ipvt") ? jSONObject.getInt("ipvt") : 14400000;
            int i2 = jSONObject.has("ipvn") ? jSONObject.getInt("ipvn") : 10;
            SharedPreferences.Editor edit = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
            edit.putBoolean("ipLocInfoUpload", z);
            edit.putInt("ipValidTime", i);
            edit.putInt("ipLocInfoUploadTimesPerDay", i2);
            edit.commit();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            try {
                if (bArr.length < 640) {
                    com.baidu.location.h.i.u = false;
                    com.baidu.location.h.i.Li = com.baidu.location.h.i.Lg + 0.025d;
                    com.baidu.location.h.i.Lh = com.baidu.location.h.i.Lf - 0.025d;
                    i = 1;
                } else {
                    com.baidu.location.h.i.u = true;
                    com.baidu.location.h.i.Lh = Double.longBitsToDouble(((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255));
                    com.baidu.location.h.i.Li = Double.longBitsToDouble(((bArr[15] & 255) << 56) | ((bArr[14] & 255) << 48) | ((bArr[13] & 255) << 40) | ((bArr[12] & 255) << 32) | ((bArr[11] & 255) << 24) | ((bArr[10] & 255) << 16) | ((bArr[9] & 255) << 8) | (bArr[8] & 255));
                    com.baidu.location.h.i.t = new byte[625];
                    while (i < 625) {
                        com.baidu.location.h.i.t[i] = bArr[i + 16];
                        i++;
                    }
                    i = 1;
                }
            } catch (Exception e) {
                return;
            }
        }
        if (i != 0) {
            g();
        }
    }

    private void b(int i) {
        File file = new File(k);
        if (!file.exists()) {
            i();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((readInt * n) + 128);
            byte[] bytes = (com.baidu.location.h.c.c + (char) 0).getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == n) {
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private boolean b(String str) {
        boolean z = true;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ipconf")) {
                    try {
                        a(jSONObject.getJSONObject("ipconf"));
                    } catch (Exception e) {
                    }
                }
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > com.baidu.location.h.i.v) {
                    com.baidu.location.h.i.v = parseInt;
                    if (jSONObject.has("gps")) {
                        String[] split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (split[0] != null && !split[0].equals("")) {
                                com.baidu.location.h.i.w = Float.parseFloat(split[0]);
                            }
                            if (split[1] != null && !split[1].equals("")) {
                                com.baidu.location.h.i.x = Float.parseFloat(split[1]);
                            }
                            if (split[2] != null && !split[2].equals("")) {
                                com.baidu.location.h.i.y = Float.parseFloat(split[2]);
                            }
                            if (split[3] != null && !split[3].equals("")) {
                                com.baidu.location.h.i.z = Float.parseFloat(split[3]);
                            }
                            if (split[4] != null && !split[4].equals("")) {
                                com.baidu.location.h.i.A = Integer.parseInt(split[4]);
                            }
                            if (split[5] != null && !split[5].equals("")) {
                                com.baidu.location.h.i.B = Integer.parseInt(split[5]);
                            }
                            if (split[6] != null && !split[6].equals("")) {
                                com.baidu.location.h.i.C = Integer.parseInt(split[6]);
                            }
                            if (split[7] != null && !split[7].equals("")) {
                                com.baidu.location.h.i.LJ = Integer.parseInt(split[7]);
                            }
                            if (split[8] != null && !split[8].equals("")) {
                                com.baidu.location.h.i.E = Integer.parseInt(split[8]);
                            }
                            if (split[9] != null && !split[9].equals("")) {
                                com.baidu.location.h.i.F = Integer.parseInt(split[9]);
                            }
                            if (split[10] != null && !split[10].equals("")) {
                                com.baidu.location.h.i.Ob = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        String[] split2 = jSONObject.getString("up").split("\\|");
                        if (split2.length > 3) {
                            if (split2[0] != null && !split2[0].equals("")) {
                                com.baidu.location.h.i.H = Float.parseFloat(split2[0]);
                            }
                            if (split2[1] != null && !split2[1].equals("")) {
                                com.baidu.location.h.i.I = Float.parseFloat(split2[1]);
                            }
                            if (split2[2] != null && !split2[2].equals("")) {
                                com.baidu.location.h.i.J = Float.parseFloat(split2[2]);
                            }
                            if (split2[3] != null && !split2[3].equals("")) {
                                com.baidu.location.h.i.K = Float.parseFloat(split2[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        String[] split3 = jSONObject.getString("wf").split("\\|");
                        if (split3.length > 3) {
                            if (split3[0] != null && !split3[0].equals("")) {
                                com.baidu.location.h.i.L = Integer.parseInt(split3[0]);
                            }
                            if (split3[1] != null && !split3[1].equals("")) {
                                com.baidu.location.h.i.Oc = Float.parseFloat(split3[1]);
                            }
                            if (split3[2] != null && !split3[2].equals("")) {
                                com.baidu.location.h.i.N = Integer.parseInt(split3[2]);
                            }
                            if (split3[3] != null && !split3[3].equals("")) {
                                com.baidu.location.h.i.Od = Float.parseFloat(split3[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        String[] split4 = jSONObject.getString("ab").split("\\|");
                        if (split4.length > 3) {
                            if (split4[0] != null && !split4[0].equals("")) {
                                com.baidu.location.h.i.Oe = Float.parseFloat(split4[0]);
                            }
                            if (split4[1] != null && !split4[1].equals("")) {
                                com.baidu.location.h.i.Of = Float.parseFloat(split4[1]);
                            }
                            if (split4[2] != null && !split4[2].equals("")) {
                                com.baidu.location.h.i.R = Integer.parseInt(split4[2]);
                            }
                            if (split4[3] != null && !split4[3].equals("")) {
                                com.baidu.location.h.i.S = Integer.parseInt(split4[3]);
                            }
                        }
                    }
                    if (jSONObject.has("zxd")) {
                        String[] split5 = jSONObject.getString("zxd").split("\\|");
                        if (split5.length > 4) {
                            if (split5[0] != null && !split5[0].equals("")) {
                                com.baidu.location.h.i.Om = Float.parseFloat(split5[0]);
                            }
                            if (split5[1] != null && !split5[1].equals("")) {
                                com.baidu.location.h.i.On = Float.parseFloat(split5[1]);
                            }
                            if (split5[2] != null && !split5[2].equals("")) {
                                com.baidu.location.h.i.ap = Integer.parseInt(split5[2]);
                            }
                            if (split5[3] != null && !split5[3].equals("")) {
                                com.baidu.location.h.i.aq = Integer.parseInt(split5[3]);
                            }
                            if (split5[4] != null && !split5[4].equals("")) {
                                com.baidu.location.h.i.ar = Integer.parseInt(split5[4]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        String[] split6 = jSONObject.getString("gpc").split("\\|");
                        if (split6.length > 5) {
                            if (split6[0] != null && !split6[0].equals("")) {
                                if (Integer.parseInt(split6[0]) > 0) {
                                    com.baidu.location.h.i.X = true;
                                } else {
                                    com.baidu.location.h.i.X = false;
                                }
                            }
                            if (split6[1] != null && !split6[1].equals("")) {
                                if (Integer.parseInt(split6[1]) > 0) {
                                    com.baidu.location.h.i.Y = true;
                                } else {
                                    com.baidu.location.h.i.Y = false;
                                }
                            }
                            if (split6[2] != null && !split6[2].equals("")) {
                                com.baidu.location.h.i.Og = Integer.parseInt(split6[2]);
                            }
                            if (split6[3] != null && !split6[3].equals("")) {
                                com.baidu.location.h.i.ab = Integer.parseInt(split6[3]);
                            }
                            if (split6[4] != null && !split6[4].equals("")) {
                                int parseInt2 = Integer.parseInt(split6[4]);
                                if (parseInt2 > 0) {
                                    com.baidu.location.h.i.Ok = parseInt2;
                                    com.baidu.location.h.i.ac = com.baidu.location.h.i.Ok * 1000 * 60;
                                    com.baidu.location.h.i.Ol = com.baidu.location.h.i.ac >> 2;
                                } else {
                                    com.baidu.location.h.i.m = false;
                                }
                            }
                            if (split6[5] != null && !split6[5].equals("")) {
                                com.baidu.location.h.i.aj = Integer.parseInt(split6[5]);
                            }
                        }
                    }
                    if (jSONObject.has("shak")) {
                        String[] split7 = jSONObject.getString("shak").split("\\|");
                        if (split7.length > 2) {
                            if (split7[0] != null && !split7[0].equals("")) {
                                com.baidu.location.h.i.ak = Integer.parseInt(split7[0]);
                            }
                            if (split7[1] != null && !split7[1].equals("")) {
                                com.baidu.location.h.i.al = Integer.parseInt(split7[1]);
                            }
                            if (split7[2] != null && !split7[2].equals("")) {
                                com.baidu.location.h.i.am = Float.parseFloat(split7[2]);
                            }
                        }
                    }
                    if (jSONObject.has("dmx")) {
                        com.baidu.location.h.i.ai = jSONObject.getInt("dmx");
                    }
                    return z;
                }
            } catch (Exception e2) {
                return false;
            }
        }
        z = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        int i;
        m = -1;
        if (str != null) {
            try {
                if (b(str)) {
                    f();
                }
            } catch (Exception e) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    m = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception e2) {
            }
        }
        try {
            j();
            if (m != -1) {
                i = m;
                b(m);
            } else {
                i = l != -1 ? l : -1;
            }
            if (i != -1) {
                a(i);
            }
            if (com.baidu.location.f.isServing) {
            }
        } catch (Exception e3) {
        }
    }

    private void e() {
        String str = "&ver=" + com.baidu.location.h.i.v + "&usr=" + com.baidu.location.h.c.mU().b() + "&app=" + com.baidu.location.h.c.c + "&prod=" + com.baidu.location.h.c.d;
        if (this.LB == null) {
            this.LB = new a();
        }
        this.LB.a(str, false);
    }

    private void f() {
        String str = com.baidu.location.h.h.a + "/config.dat";
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", Integer.valueOf(com.baidu.location.h.i.v), Float.valueOf(com.baidu.location.h.i.w), Float.valueOf(com.baidu.location.h.i.x), Float.valueOf(com.baidu.location.h.i.y), Float.valueOf(com.baidu.location.h.i.z), Integer.valueOf(com.baidu.location.h.i.A), Integer.valueOf(com.baidu.location.h.i.B), Integer.valueOf(com.baidu.location.h.i.C), Integer.valueOf(com.baidu.location.h.i.LJ), Integer.valueOf(com.baidu.location.h.i.E), Integer.valueOf(com.baidu.location.h.i.F), Integer.valueOf(com.baidu.location.h.i.Ob), Float.valueOf(com.baidu.location.h.i.H), Float.valueOf(com.baidu.location.h.i.I), Float.valueOf(com.baidu.location.h.i.J), Float.valueOf(com.baidu.location.h.i.K), Integer.valueOf(com.baidu.location.h.i.L), Float.valueOf(com.baidu.location.h.i.Oc), Integer.valueOf(com.baidu.location.h.i.N), Float.valueOf(com.baidu.location.h.i.Od), Float.valueOf(com.baidu.location.h.i.Oe), Float.valueOf(com.baidu.location.h.i.Of), Integer.valueOf(com.baidu.location.h.i.R), Integer.valueOf(com.baidu.location.h.i.S), Integer.valueOf(com.baidu.location.h.i.X ? 1 : 0), Integer.valueOf(com.baidu.location.h.i.Y ? 1 : 0), Integer.valueOf(com.baidu.location.h.i.Og), Integer.valueOf(com.baidu.location.h.i.ab), Long.valueOf(com.baidu.location.h.i.Ok), Integer.valueOf(com.baidu.location.h.i.aj), Float.valueOf(com.baidu.location.h.i.Om), Float.valueOf(com.baidu.location.h.i.On), Integer.valueOf(com.baidu.location.h.i.ap), Integer.valueOf(com.baidu.location.h.i.aq), Integer.valueOf(com.baidu.location.h.i.ar), Integer.valueOf(com.baidu.location.h.i.ak), Integer.valueOf(com.baidu.location.h.i.al), Float.valueOf(com.baidu.location.h.i.am), Integer.valueOf(com.baidu.location.h.i.ai)).getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.h.a);
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

    private void g() {
        try {
            File file = new File(com.baidu.location.h.h.a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.h.a);
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
            randomAccessFile2.seek(IjkMediaMeta.AV_CH_SIDE_RIGHT);
            randomAccessFile2.writeDouble(com.baidu.location.h.i.Lh);
            randomAccessFile2.writeDouble(com.baidu.location.h.i.Li);
            randomAccessFile2.writeBoolean(com.baidu.location.h.i.u);
            if (com.baidu.location.h.i.u && com.baidu.location.h.i.t != null) {
                randomAccessFile2.write(com.baidu.location.h.i.t);
            }
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    private void h() {
        try {
            File file = new File(com.baidu.location.h.h.a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    b(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(IjkMediaMeta.AV_CH_SIDE_RIGHT);
                    com.baidu.location.h.i.Lh = randomAccessFile.readDouble();
                    com.baidu.location.h.i.Li = randomAccessFile.readDouble();
                    com.baidu.location.h.i.u = randomAccessFile.readBoolean();
                    if (com.baidu.location.h.i.u) {
                        com.baidu.location.h.i.t = new byte[625];
                        randomAccessFile.read(com.baidu.location.h.i.t, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        c(null);
    }

    private void i() {
        try {
            File file = new File(k);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.h.h.a);
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

    private void j() {
        int i = 0;
        try {
            File file = new File(k);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    n = 0;
                    i();
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
                            com.baidu.location.h.c.mU();
                            if (str.equals(com.baidu.location.h.c.c)) {
                                l = randomAccessFile.readInt();
                                n = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    n = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public static c ml() {
        if (LA == null) {
            LA = new c();
        }
        return LA;
    }

    public void a(String str) {
        if (this.LB == null) {
            this.LB = new a();
        }
        this.LB.a(str, true);
    }

    public void b() {
        h();
    }

    public void c() {
    }

    public void d() {
        if (System.currentTimeMillis() - com.baidu.location.h.d.mV().c() > 86400000) {
            com.baidu.location.h.d.mV().b(System.currentTimeMillis());
            e();
        }
    }
}
