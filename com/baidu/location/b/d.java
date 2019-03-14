package com.baidu.location.b;

import android.content.SharedPreferences;
import com.baidu.location.Jni;
import com.baidu.location.g.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static d i = null;
    private static final String k = com.baidu.location.g.f.a + "/conlts.dat";
    private static int l = -1;
    private static int m = -1;
    private static int n = 0;
    private a j = null;
    public boolean a = true;
    public boolean b = true;
    public boolean c = false;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends com.baidu.location.g.e {
        String a = null;
        boolean b = false;
        boolean c = false;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.g.e
        public void a() {
            this.h = g.c();
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
                a(true, "loc.map.baidu.com");
            } else {
                b(g.f);
            }
        }

        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            if (!z || this.j == null) {
                d.this.b((String) null);
            } else if (this.b) {
                d.this.a(this.m);
            } else {
                d.this.b(this.j);
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.c = false;
        }
    }

    private d() {
    }

    public static d a() {
        if (i == null) {
            i = new d();
        }
        return i;
    }

    private void a(int i2) {
        this.a = (i2 & 1) == 1;
        this.b = (i2 & 2) == 2;
        this.c = (i2 & 4) == 4;
        this.d = (i2 & 8) == 8;
        this.f = (i2 & 65536) == 65536;
        this.g = (i2 & 131072) == 131072;
        if ((i2 & 16) == 16) {
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
            int i2 = jSONObject.has("ipvt") ? jSONObject.getInt("ipvt") : 14400000;
            int i3 = jSONObject.has("ipvn") ? jSONObject.getInt("ipvn") : 10;
            SharedPreferences.Editor edit = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
            edit.putBoolean("ipLocInfoUpload", z);
            edit.putInt("ipValidTime", i2);
            edit.putInt("ipLocInfoUploadTimesPerDay", i3);
            edit.commit();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        int i2 = 0;
        if (bArr != null) {
            try {
                if (bArr.length < 640) {
                    g.x = false;
                    g.u = g.s + 0.025d;
                    g.t = g.r - 0.025d;
                    i2 = 1;
                } else {
                    g.x = true;
                    g.t = Double.longBitsToDouble(((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255));
                    g.u = Double.longBitsToDouble(((bArr[15] & 255) << 56) | ((bArr[14] & 255) << 48) | ((bArr[13] & 255) << 40) | ((bArr[12] & 255) << 32) | ((bArr[11] & 255) << 24) | ((bArr[10] & 255) << 16) | ((bArr[9] & 255) << 8) | (bArr[8] & 255));
                    g.w = new byte[625];
                    while (i2 < 625) {
                        g.w[i2] = bArr[i2 + 16];
                        i2++;
                    }
                    i2 = 1;
                }
            } catch (Exception e) {
                return;
            }
        }
        if (i2 != 0) {
            g();
        }
    }

    private boolean a(String str) {
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
                if (parseInt > g.y) {
                    g.y = parseInt;
                    if (jSONObject.has("gps")) {
                        String[] split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (split[0] != null && !split[0].equals("")) {
                                g.z = Float.parseFloat(split[0]);
                            }
                            if (split[1] != null && !split[1].equals("")) {
                                g.A = Float.parseFloat(split[1]);
                            }
                            if (split[2] != null && !split[2].equals("")) {
                                g.B = Float.parseFloat(split[2]);
                            }
                            if (split[3] != null && !split[3].equals("")) {
                                g.C = Float.parseFloat(split[3]);
                            }
                            if (split[4] != null && !split[4].equals("")) {
                                g.D = Integer.parseInt(split[4]);
                            }
                            if (split[5] != null && !split[5].equals("")) {
                                g.E = Integer.parseInt(split[5]);
                            }
                            if (split[6] != null && !split[6].equals("")) {
                                g.F = Integer.parseInt(split[6]);
                            }
                            if (split[7] != null && !split[7].equals("")) {
                                g.G = Integer.parseInt(split[7]);
                            }
                            if (split[8] != null && !split[8].equals("")) {
                                g.H = Integer.parseInt(split[8]);
                            }
                            if (split[9] != null && !split[9].equals("")) {
                                g.I = Integer.parseInt(split[9]);
                            }
                            if (split[10] != null && !split[10].equals("")) {
                                g.J = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        String[] split2 = jSONObject.getString("up").split("\\|");
                        if (split2.length > 3) {
                            if (split2[0] != null && !split2[0].equals("")) {
                                g.K = Float.parseFloat(split2[0]);
                            }
                            if (split2[1] != null && !split2[1].equals("")) {
                                g.L = Float.parseFloat(split2[1]);
                            }
                            if (split2[2] != null && !split2[2].equals("")) {
                                g.M = Float.parseFloat(split2[2]);
                            }
                            if (split2[3] != null && !split2[3].equals("")) {
                                g.N = Float.parseFloat(split2[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        String[] split3 = jSONObject.getString("wf").split("\\|");
                        if (split3.length > 3) {
                            if (split3[0] != null && !split3[0].equals("")) {
                                g.O = Integer.parseInt(split3[0]);
                            }
                            if (split3[1] != null && !split3[1].equals("")) {
                                g.P = Float.parseFloat(split3[1]);
                            }
                            if (split3[2] != null && !split3[2].equals("")) {
                                g.Q = Integer.parseInt(split3[2]);
                            }
                            if (split3[3] != null && !split3[3].equals("")) {
                                g.R = Float.parseFloat(split3[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        String[] split4 = jSONObject.getString("ab").split("\\|");
                        if (split4.length > 3) {
                            if (split4[0] != null && !split4[0].equals("")) {
                                g.S = Float.parseFloat(split4[0]);
                            }
                            if (split4[1] != null && !split4[1].equals("")) {
                                g.T = Float.parseFloat(split4[1]);
                            }
                            if (split4[2] != null && !split4[2].equals("")) {
                                g.U = Integer.parseInt(split4[2]);
                            }
                            if (split4[3] != null && !split4[3].equals("")) {
                                g.V = Integer.parseInt(split4[3]);
                            }
                        }
                    }
                    if (jSONObject.has("zxd")) {
                        String[] split5 = jSONObject.getString("zxd").split("\\|");
                        if (split5.length > 4) {
                            if (split5[0] != null && !split5[0].equals("")) {
                                g.ar = Float.parseFloat(split5[0]);
                            }
                            if (split5[1] != null && !split5[1].equals("")) {
                                g.as = Float.parseFloat(split5[1]);
                            }
                            if (split5[2] != null && !split5[2].equals("")) {
                                g.at = Integer.parseInt(split5[2]);
                            }
                            if (split5[3] != null && !split5[3].equals("")) {
                                g.au = Integer.parseInt(split5[3]);
                            }
                            if (split5[4] != null && !split5[4].equals("")) {
                                g.av = Integer.parseInt(split5[4]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        String[] split6 = jSONObject.getString("gpc").split("\\|");
                        if (split6.length > 5) {
                            if (split6[0] != null && !split6[0].equals("")) {
                                if (Integer.parseInt(split6[0]) > 0) {
                                    g.aa = true;
                                } else {
                                    g.aa = false;
                                }
                            }
                            if (split6[1] != null && !split6[1].equals("")) {
                                if (Integer.parseInt(split6[1]) > 0) {
                                    g.ab = true;
                                } else {
                                    g.ab = false;
                                }
                            }
                            if (split6[2] != null && !split6[2].equals("")) {
                                g.ac = Integer.parseInt(split6[2]);
                            }
                            if (split6[3] != null && !split6[3].equals("")) {
                                g.ae = Integer.parseInt(split6[3]);
                            }
                            if (split6[4] != null && !split6[4].equals("")) {
                                int parseInt2 = Integer.parseInt(split6[4]);
                                if (parseInt2 > 0) {
                                    g.ak = parseInt2;
                                    g.ag = g.ak * 1000 * 60;
                                    g.al = g.ag >> 2;
                                } else {
                                    g.p = false;
                                }
                            }
                            if (split6[5] != null && !split6[5].equals("")) {
                                g.an = Integer.parseInt(split6[5]);
                            }
                        }
                    }
                    if (jSONObject.has("shak")) {
                        String[] split7 = jSONObject.getString("shak").split("\\|");
                        if (split7.length > 2) {
                            if (split7[0] != null && !split7[0].equals("")) {
                                g.ao = Integer.parseInt(split7[0]);
                            }
                            if (split7[1] != null && !split7[1].equals("")) {
                                g.ap = Integer.parseInt(split7[1]);
                            }
                            if (split7[2] != null && !split7[2].equals("")) {
                                g.aq = Float.parseFloat(split7[2]);
                            }
                        }
                    }
                    if (jSONObject.has("dmx")) {
                        g.am = jSONObject.getInt("dmx");
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

    private void b(int i2) {
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
            byte[] bytes = (com.baidu.location.g.b.d + (char) 0).getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i2);
            if (readInt2 == n) {
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        int i2;
        m = -1;
        if (str != null) {
            try {
                if (a(str)) {
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
            try {
                j();
                if (m != -1) {
                    i2 = m;
                    b(m);
                } else {
                    i2 = l != -1 ? l : -1;
                }
                if (i2 != -1) {
                    a(i2);
                }
            } catch (Exception e3) {
            }
        }
    }

    private void e() {
        String str = "&ver=" + g.y + "&usr=" + com.baidu.location.g.b.a().b() + "&app=" + com.baidu.location.g.b.d + "&prod=" + com.baidu.location.g.b.e;
        if (this.j == null) {
            this.j = new a();
        }
        this.j.a(str, false);
    }

    private void f() {
        String str = com.baidu.location.g.f.a + "/config.dat";
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", Integer.valueOf(g.y), Float.valueOf(g.z), Float.valueOf(g.A), Float.valueOf(g.B), Float.valueOf(g.C), Integer.valueOf(g.D), Integer.valueOf(g.E), Integer.valueOf(g.F), Integer.valueOf(g.G), Integer.valueOf(g.H), Integer.valueOf(g.I), Integer.valueOf(g.J), Float.valueOf(g.K), Float.valueOf(g.L), Float.valueOf(g.M), Float.valueOf(g.N), Integer.valueOf(g.O), Float.valueOf(g.P), Integer.valueOf(g.Q), Float.valueOf(g.R), Float.valueOf(g.S), Float.valueOf(g.T), Integer.valueOf(g.U), Integer.valueOf(g.V), Integer.valueOf(g.aa ? 1 : 0), Integer.valueOf(g.ab ? 1 : 0), Integer.valueOf(g.ac), Integer.valueOf(g.ae), Long.valueOf(g.ak), Integer.valueOf(g.an), Float.valueOf(g.ar), Float.valueOf(g.as), Integer.valueOf(g.at), Integer.valueOf(g.au), Integer.valueOf(g.av), Integer.valueOf(g.ao), Integer.valueOf(g.ap), Float.valueOf(g.aq), Integer.valueOf(g.am)).getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.g.f.a);
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
            File file = new File(com.baidu.location.g.f.a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.g.f.a);
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
            randomAccessFile2.writeDouble(g.t);
            randomAccessFile2.writeDouble(g.u);
            randomAccessFile2.writeBoolean(g.x);
            if (g.x && g.w != null) {
                randomAccessFile2.write(g.w);
            }
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    private void h() {
        try {
            File file = new File(com.baidu.location.g.f.a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    a(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024L);
                    g.t = randomAccessFile.readDouble();
                    g.u = randomAccessFile.readDouble();
                    g.x = randomAccessFile.readBoolean();
                    if (g.x) {
                        g.w = new byte[625];
                        randomAccessFile.read(g.w, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        if (!g.p || com.baidu.location.f.isServing) {
        }
    }

    private void i() {
        try {
            File file = new File(k);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.g.f.a);
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
        int i2 = 0;
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
                    if (i2 >= readInt2) {
                        break;
                    }
                    randomAccessFile.seek((readInt * i2) + 128);
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        if (bArr[readInt3 - 1] == 0) {
                            String str = new String(bArr, 0, readInt3 - 1);
                            com.baidu.location.g.b.a();
                            if (str.equals(com.baidu.location.g.b.d)) {
                                l = randomAccessFile.readInt();
                                n = i2;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i2++;
                }
                if (i2 == readInt2) {
                    n = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public void b() {
        h();
    }

    public void c() {
    }

    public void d() {
        if (System.currentTimeMillis() - com.baidu.location.g.c.a().d() > 604800000) {
            com.baidu.location.g.c.a().c(System.currentTimeMillis());
            e();
        }
    }
}
