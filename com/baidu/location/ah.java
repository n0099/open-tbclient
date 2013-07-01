package com.baidu.location;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Handler;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah {
    private static String d;
    private static String e;
    private static String f;
    private static String g;

    /* renamed from: a  reason: collision with root package name */
    private static String f460a = "baidu_location_service";
    private static int b = 2048;
    private static int c = 3;
    private static String h = null;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static ArrayList n = null;
    private static int o = 12000;
    private static Uri p = null;
    private static int q = 4;
    private static String r = "10.0.0.172";
    private static int s = 80;
    private static int t = 0;
    private static Handler u = null;
    private static Handler v = null;

    private static int a(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                String defaultHost = Proxy.getDefaultHost();
                r = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                return 1;
            } else if (lowerCase.startsWith("ctwap")) {
                String defaultHost2 = Proxy.getDefaultHost();
                if (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) {
                    defaultHost2 = HttpUtils.IP_CTWAP;
                }
                r = defaultHost2;
                return 1;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                return 2;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 == null || defaultHost3.length() <= 0) {
            return 2;
        }
        if ("10.0.0.172".equals(defaultHost3.trim())) {
            r = "10.0.0.172";
            return 1;
        } else if (HttpUtils.IP_CTWAP.equals(defaultHost3.trim())) {
            r = HttpUtils.IP_CTWAP;
            return 1;
        } else {
            return 2;
        }
    }

    public static void a() {
        if (k) {
            return;
        }
        k = true;
        if (n == null) {
            t = 0;
            n = new ArrayList();
            int i2 = 0;
            do {
                String a2 = t < 2 ? as.a() : null;
                if (a2 != null || t == 1) {
                    t = 1;
                } else {
                    t = 2;
                    try {
                        if (ap.Z == 0) {
                            a2 = f.b();
                            if (a2 == null) {
                                a2 = m.h();
                            }
                        } else if (ap.Z == 1 && (a2 = m.h()) == null) {
                            a2 = f.b();
                        }
                    } catch (Exception e2) {
                        a2 = null;
                    }
                }
                if (a2 == null) {
                    break;
                }
                n.add(a2);
                i2 += a2.length();
                ap.a(f460a, "upload data size:" + i2);
            } while (i2 < b);
        }
        if (n != null && n.size() >= 1) {
            ap.a(f460a, "Beging upload data...");
            new ak().start();
            return;
        }
        n = null;
        k = false;
        ap.a(f460a, "No upload data...");
    }

    public static void a(String str, boolean z) {
        if (l || str == null) {
            return;
        }
        h = Jni.a(str);
        m = z;
        l = true;
        new al().start();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        b(context);
        return q == 3;
    }

    public static boolean a(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > ap.t) {
                    ap.t = parseInt;
                    if (jSONObject.has("gps")) {
                        ap.a(f460a, "has gps...");
                        String[] split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (split[0] != null && !split[0].equals("")) {
                                ap.u = Float.parseFloat(split[0]);
                            }
                            if (split[1] != null && !split[1].equals("")) {
                                ap.v = Float.parseFloat(split[1]);
                            }
                            if (split[2] != null && !split[2].equals("")) {
                                ap.w = Float.parseFloat(split[2]);
                            }
                            if (split[3] != null && !split[3].equals("")) {
                                ap.x = Float.parseFloat(split[3]);
                            }
                            if (split[4] != null && !split[4].equals("")) {
                                ap.y = Integer.parseInt(split[4]);
                            }
                            if (split[5] != null && !split[5].equals("")) {
                                ap.z = Integer.parseInt(split[5]);
                            }
                            if (split[6] != null && !split[6].equals("")) {
                                ap.A = Integer.parseInt(split[6]);
                            }
                            if (split[7] != null && !split[7].equals("")) {
                                ap.B = Integer.parseInt(split[7]);
                            }
                            if (split[8] != null && !split[8].equals("")) {
                                ap.C = Integer.parseInt(split[8]);
                            }
                            if (split[9] != null && !split[9].equals("")) {
                                ap.D = Integer.parseInt(split[9]);
                            }
                            if (split[10] != null && !split[10].equals("")) {
                                ap.E = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        ap.a(f460a, "has up...");
                        String[] split2 = jSONObject.getString("up").split("\\|");
                        if (split2.length > 3) {
                            if (split2[0] != null && !split2[0].equals("")) {
                                ap.F = Float.parseFloat(split2[0]);
                            }
                            if (split2[1] != null && !split2[1].equals("")) {
                                ap.G = Float.parseFloat(split2[1]);
                            }
                            if (split2[2] != null && !split2[2].equals("")) {
                                ap.H = Float.parseFloat(split2[2]);
                            }
                            if (split2[3] != null && !split2[3].equals("")) {
                                ap.I = Float.parseFloat(split2[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        ap.a(f460a, "has wf...");
                        String[] split3 = jSONObject.getString("wf").split("\\|");
                        if (split3.length > 3) {
                            if (split3[0] != null && !split3[0].equals("")) {
                                ap.J = Integer.parseInt(split3[0]);
                            }
                            if (split3[1] != null && !split3[1].equals("")) {
                                ap.K = Float.parseFloat(split3[1]);
                            }
                            if (split3[2] != null && !split3[2].equals("")) {
                                ap.L = Integer.parseInt(split3[2]);
                            }
                            if (split3[3] != null && !split3[3].equals("")) {
                                ap.M = Float.parseFloat(split3[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        ap.a(f460a, "has ab...");
                        String[] split4 = jSONObject.getString("ab").split("\\|");
                        if (split4.length > 3) {
                            if (split4[0] != null && !split4[0].equals("")) {
                                ap.N = Float.parseFloat(split4[0]);
                            }
                            if (split4[1] != null && !split4[1].equals("")) {
                                ap.O = Float.parseFloat(split4[1]);
                            }
                            if (split4[2] != null && !split4[2].equals("")) {
                                ap.P = Integer.parseInt(split4[2]);
                            }
                            if (split4[3] != null && !split4[3].equals("")) {
                                ap.Q = Integer.parseInt(split4[3]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        ap.a(f460a, "has gpc...");
                        String[] split5 = jSONObject.getString("gpc").split("\\|");
                        if (split5.length > 5) {
                            if (split5[0] != null && !split5[0].equals("")) {
                                if (Integer.parseInt(split5[0]) > 0) {
                                    ap.R = true;
                                } else {
                                    ap.R = false;
                                }
                            }
                            if (split5[1] != null && !split5[1].equals("")) {
                                if (Integer.parseInt(split5[1]) > 0) {
                                    ap.S = true;
                                } else {
                                    ap.S = false;
                                }
                            }
                            if (split5[2] != null && !split5[2].equals("")) {
                                ap.T = Integer.parseInt(split5[2]);
                            }
                            if (split5[3] != null && !split5[3].equals("")) {
                                ap.V = Integer.parseInt(split5[3]);
                            }
                            if (split5[4] != null && !split5[4].equals("")) {
                                int parseInt2 = Integer.parseInt(split5[4]);
                                if (parseInt2 > 0) {
                                    ap.X = parseInt2;
                                    ap.W = ap.X * 1000 * 60;
                                    ap.Y = ap.W >> 2;
                                } else {
                                    ap.l = false;
                                }
                            }
                            if (split5[5] != null && !split5[5].equals("")) {
                                ap.Z = Integer.parseInt(split5[5]);
                            }
                        }
                    }
                    try {
                        ap.a(f460a, "config change true...");
                        return true;
                    } catch (Exception e2) {
                        return true;
                    }
                }
            } catch (Exception e3) {
                return false;
            }
        }
        return false;
    }

    public static boolean a(String str, Handler handler) {
        if (i || str == null) {
            return false;
        }
        i = true;
        ap.a(f460a, "bloc : " + d);
        d = Jni.a(str);
        ap.a(f460a, "NUMBER_e : " + d.length());
        u = handler;
        if (f == null) {
            f = as.a();
        }
        new ai().start();
        return true;
    }

    public static int b(Context context) {
        q = c(context);
        return q;
    }

    public static void b() {
        String str = f.f470a + "/config.dat";
        String format = String.format("{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\"}", Integer.valueOf(ap.t), Float.valueOf(ap.u), Float.valueOf(ap.v), Float.valueOf(ap.w), Float.valueOf(ap.x), Integer.valueOf(ap.y), Integer.valueOf(ap.z), Integer.valueOf(ap.A), Integer.valueOf(ap.B), Integer.valueOf(ap.C), Integer.valueOf(ap.D), Integer.valueOf(ap.E), Float.valueOf(ap.F), Float.valueOf(ap.G), Float.valueOf(ap.H), Float.valueOf(ap.I), Integer.valueOf(ap.J), Float.valueOf(ap.K), Integer.valueOf(ap.L), Float.valueOf(ap.M), Float.valueOf(ap.N), Float.valueOf(ap.O), Integer.valueOf(ap.P), Integer.valueOf(ap.Q), Integer.valueOf(ap.R ? 1 : 0), Integer.valueOf(ap.S ? 1 : 0), Integer.valueOf(ap.T), Integer.valueOf(ap.V), Long.valueOf(ap.X), Integer.valueOf(ap.Z));
        ap.a(f460a, "save2Config : " + format);
        byte[] bytes = format.getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(f.f470a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                ap.a(f460a, "upload manager create file success");
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
        } catch (Exception e2) {
        }
    }

    public static boolean b(String str, Handler handler) {
        if (j || str == null) {
            return false;
        }
        j = true;
        e = Jni.a(str);
        ap.a(f460a, "bloc : " + e);
        v = handler;
        if (g == null) {
            g = as.a();
        }
        new aj().start();
        return true;
    }

    private static int c(Context context) {
        NetworkInfo networkInfo;
        try {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return 4;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    try {
                        if (activeNetworkInfo.isAvailable()) {
                            if (activeNetworkInfo.getType() == 1) {
                                return 3;
                            }
                            p = Uri.parse("content://telephony/carriers/preferapn");
                            Cursor query = context.getContentResolver().query(p, null, null, null, null);
                            if (query != null && query.moveToFirst()) {
                                String string = query.getString(query.getColumnIndex("apn"));
                                if (string != null && string.toLowerCase().contains("ctwap")) {
                                    String defaultHost = Proxy.getDefaultHost();
                                    if (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) {
                                        defaultHost = HttpUtils.IP_CTWAP;
                                    }
                                    r = defaultHost;
                                    s = 80;
                                    if (query != null) {
                                        query.close();
                                    }
                                    return 1;
                                } else if (string != null && string.toLowerCase().contains(com.baidu.loginshare.e.d)) {
                                    String defaultHost2 = Proxy.getDefaultHost();
                                    r = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                                    s = 80;
                                    if (query != null) {
                                        query.close();
                                    }
                                    return 1;
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                            return 2;
                        }
                    } catch (SecurityException e2) {
                        networkInfo = activeNetworkInfo;
                        try {
                            ap.a(f460a, "APN security...");
                            return a(context, networkInfo);
                        } catch (Exception e3) {
                            return 4;
                        }
                    }
                }
                return 4;
            } catch (SecurityException e4) {
                networkInfo = null;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            return 4;
        }
    }

    public static void c() {
        try {
            File file = new File(f.f470a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(f.f470a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                ap.a(f460a, "upload manager create file success");
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
            randomAccessFile2.writeDouble(ap.o);
            randomAccessFile2.writeDouble(ap.p);
            randomAccessFile2.writeBoolean(ap.s);
            if (ap.s && ap.r != null) {
                randomAccessFile2.write(ap.r);
            }
            randomAccessFile2.close();
        } catch (Exception e2) {
        }
    }

    public static void d() {
        try {
            File file = new File(f.f470a + "/config.dat");
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
                    ap.o = randomAccessFile.readDouble();
                    ap.p = randomAccessFile.readDouble();
                    ap.s = randomAccessFile.readBoolean();
                    if (ap.s) {
                        ap.r = new byte[625];
                        randomAccessFile.read(ap.r, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
            String str = "&ver=" + ap.t + "&usr=" + ap.h;
            ap.a(f460a, str);
            a(str, false);
        } catch (Exception e2) {
        }
    }
}
