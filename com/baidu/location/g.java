package com.baidu.location;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {

    /* renamed from: byte  reason: not valid java name */
    private static final int f156byte = 1;

    /* renamed from: case  reason: not valid java name */
    private static final int f157case = 2;
    private static String d = null;

    /* renamed from: do  reason: not valid java name */
    private static String f159do = null;

    /* renamed from: for  reason: not valid java name */
    private static String f161for = null;
    private static final int h = 4;
    private static String k = null;
    public static final int m = 3;

    /* renamed from: new  reason: not valid java name */
    private static String f166new = f.v;
    private static int c = 2048;

    /* renamed from: void  reason: not valid java name */
    private static int f168void = 3;

    /* renamed from: long  reason: not valid java name */
    private static String f165long = null;
    private static boolean i = false;

    /* renamed from: else  reason: not valid java name */
    private static boolean f160else = false;
    private static boolean b = false;

    /* renamed from: char  reason: not valid java name */
    private static boolean f158char = false;
    private static boolean g = false;
    private static ArrayList e = null;
    private static int a = LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_12;

    /* renamed from: if  reason: not valid java name */
    private static Uri f163if = null;

    /* renamed from: try  reason: not valid java name */
    private static int f167try = 4;
    private static String j = "10.0.0.172";
    private static int f = 80;

    /* renamed from: goto  reason: not valid java name */
    private static int f162goto = 0;

    /* renamed from: int  reason: not valid java name */
    private static Handler f164int = null;
    private static Handler l = null;

    g() {
    }

    private static int a(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                String defaultHost = Proxy.getDefaultHost();
                j = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                return 1;
            } else if (lowerCase.startsWith("ctwap")) {
                String defaultHost2 = Proxy.getDefaultHost();
                j = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.200" : "10.0.0.200";
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
            j = "10.0.0.172";
            return 1;
        } else if ("10.0.0.200".equals(defaultHost3.trim())) {
            j = "10.0.0.200";
            return 1;
        } else {
            return 2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.location.g$4] */
    public static void a(String str, boolean z) {
        if (f158char || str == null) {
            return;
        }
        f165long = Jni.m6if(str);
        g = z;
        f158char = true;
        new Thread() { // from class: com.baidu.location.g.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Long valueOf;
                boolean z2 = true;
                try {
                    HttpPost httpPost = new HttpPost(j.m239do());
                    ArrayList arrayList = new ArrayList();
                    if (g.g) {
                        arrayList.add(new BasicNameValuePair("qt", "grid"));
                    } else {
                        arrayList.add(new BasicNameValuePair("qt", "conf"));
                    }
                    arrayList.add(new BasicNameValuePair("req", g.f165long));
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                    defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                    j.a(g.f166new, "req config...");
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        if (g.g) {
                            j.a(g.f166new, "req config response...");
                            byte[] byteArray = EntityUtils.toByteArray(execute.getEntity());
                            if (byteArray == null) {
                                z2 = false;
                            } else if (byteArray.length < 640) {
                                j.a(g.f166new, "req config response.<640.");
                                j.e = false;
                                j.f194byte = j.c + 0.025d;
                                j.s = j.O - 0.025d;
                            } else {
                                j.e = true;
                                Long valueOf2 = Long.valueOf(((byteArray[7] & 255) << 56) | ((byteArray[6] & 255) << 48) | ((byteArray[5] & 255) << 40) | ((byteArray[4] & 255) << 32) | ((byteArray[3] & 255) << 24) | ((byteArray[2] & 255) << 16) | ((byteArray[1] & 255) << 8) | (byteArray[0] & 255));
                                j.a(g.f166new, "req config 1...");
                                j.s = Double.longBitsToDouble(valueOf2.longValue());
                                j.a(g.f166new, "req config response:" + Double.longBitsToDouble(valueOf2.longValue()));
                                j.f194byte = Double.longBitsToDouble(Long.valueOf(((byteArray[15] & 255) << 56) | ((byteArray[14] & 255) << 48) | ((byteArray[13] & 255) << 40) | ((byteArray[12] & 255) << 32) | ((byteArray[11] & 255) << 24) | ((byteArray[10] & 255) << 16) | ((byteArray[9] & 255) << 8) | (byteArray[8] & 255)).longValue());
                                j.o = new byte[625];
                                j.a(g.f166new, "req config response:" + Double.longBitsToDouble(valueOf.longValue()));
                                for (int i2 = 0; i2 < 625; i2++) {
                                    j.o[i2] = byteArray[i2 + 16];
                                    j.a(g.f166new, "req config value:" + ((int) j.o[i2]));
                                }
                            }
                            if (z2) {
                                g.m206for();
                            }
                        } else {
                            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
                            j.a(g.f166new, "req config value:" + entityUtils);
                            if (g.m213if(entityUtils)) {
                                j.a(g.f166new, "Save to config");
                                g.c();
                            }
                        }
                    }
                } catch (Exception e2) {
                    j.a(g.f166new, "Exception!!!");
                } finally {
                    String unused = g.f165long = null;
                    boolean unused2 = g.f158char = false;
                    boolean unused3 = g.g = false;
                }
            }
        }.start();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        m201do(context);
        return f167try == 3;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.baidu.location.g$1] */
    public static boolean a(String str, Handler handler) {
        if (i || str == null) {
            return false;
        }
        i = true;
        j.a(f166new, "bloc : " + k);
        k = Jni.m6if(str);
        j.a(f166new, "NUMBER_e : " + k.length());
        f164int = handler;
        if (f159do == null) {
            f159do = k.a();
        }
        new Thread() { // from class: com.baidu.location.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpPost httpPost;
                HttpResponse execute;
                int statusCode;
                int i2 = g.f168void;
                while (i2 > 0) {
                    try {
                        httpPost = new HttpPost(j.m239do());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("bloc", g.k));
                        if (g.f159do != null) {
                            arrayList.add(new BasicNameValuePair("up", g.f159do));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                        HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                        j.a(g.f166new, "apn type : " + g.f167try);
                        if ((g.f167try == 1 || g.f167try == 4) && (g.f168void - i2) % 2 == 0) {
                            j.a(g.f166new, "apn type : ADD PROXY" + g.j + g.f);
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(g.j, g.f, "http"));
                        }
                        execute = defaultHttpClient.execute(httpPost);
                        statusCode = execute.getStatusLine().getStatusCode();
                        j.a(g.f166new, "===status error : " + statusCode);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (statusCode == 200) {
                        String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
                        j.a(g.f166new, "status error : " + execute.getEntity().getContentType());
                        Message obtainMessage = g.f164int.obtainMessage(21);
                        obtainMessage.obj = entityUtils;
                        obtainMessage.sendToTarget();
                        String unused = g.f159do = null;
                        break;
                    }
                    httpPost.abort();
                    Message obtainMessage2 = g.f164int.obtainMessage(63);
                    obtainMessage2.obj = "HttpStatus error";
                    obtainMessage2.sendToTarget();
                    i2--;
                }
                if (i2 <= 0 && g.f164int != null) {
                    j.a(g.f166new, "have tried 3 times...");
                    g.f164int.obtainMessage(62).sendToTarget();
                }
                Handler unused2 = g.f164int = null;
                boolean unused3 = g.i = false;
            }
        }.start();
        return true;
    }

    /* renamed from: byte  reason: not valid java name */
    public static void m198byte() {
        try {
            File file = new File(f.aa + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    m213if(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024L);
                    j.s = randomAccessFile.readDouble();
                    j.f194byte = randomAccessFile.readDouble();
                    j.e = randomAccessFile.readBoolean();
                    if (j.e) {
                        j.o = new byte[625];
                        randomAccessFile.read(j.o, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
            String str = "&ver=" + j.f200goto + "&usr=" + j.f;
            j.a(f166new, str);
            a(str, false);
        } catch (Exception e2) {
        }
    }

    public static void c() {
        String str = f.aa + "/config.dat";
        String format = String.format("{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\"}", Integer.valueOf(j.f200goto), Float.valueOf(j.f195case), Float.valueOf(j.A), Float.valueOf(j.f196char), Float.valueOf(j.C), Integer.valueOf(j.t), Integer.valueOf(j.a), Integer.valueOf(j.u), Integer.valueOf(j.f201if), Integer.valueOf(j.f202int), Integer.valueOf(j.k), Integer.valueOf(j.K), Float.valueOf(j.T), Float.valueOf(j.Q), Float.valueOf(j.d), Float.valueOf(j.H), Integer.valueOf(j.F), Float.valueOf(j.f204new), Integer.valueOf(j.h), Float.valueOf(j.D), Float.valueOf(j.S), Float.valueOf(j.P), Integer.valueOf(j.N), Integer.valueOf(j.L), Integer.valueOf(j.m ? 1 : 0), Integer.valueOf(j.G ? 1 : 0), Integer.valueOf(j.i), Integer.valueOf(j.l), Long.valueOf(j.B), Integer.valueOf(j.E));
        j.a(f166new, "save2Config : " + format);
        byte[] bytes = format.getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(f.aa);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                j.a(f166new, "upload manager create file success");
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

    /* renamed from: do  reason: not valid java name */
    public static int m201do(Context context) {
        f167try = m210if(context);
        return f167try;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.location.g$3] */
    public static void f() {
        if (b) {
            return;
        }
        b = true;
        if (e == null) {
            f162goto = 0;
            e = new ArrayList();
            int i2 = 0;
            do {
                String a2 = f162goto < 2 ? k.a() : null;
                if (a2 != null || f162goto == 1) {
                    f162goto = 1;
                } else {
                    f162goto = 2;
                    try {
                        if (j.E == 0) {
                            a2 = f.m180new();
                            if (a2 == null) {
                                a2 = b.e();
                            }
                        } else if (j.E == 1 && (a2 = b.e()) == null) {
                            a2 = f.m180new();
                        }
                    } catch (Exception e2) {
                        a2 = null;
                    }
                }
                if (a2 == null) {
                    break;
                }
                e.add(a2);
                i2 += a2.length();
                j.a(f166new, "upload data size:" + i2);
            } while (i2 < c);
        }
        if (e != null && e.size() >= 1) {
            j.a(f166new, "Beging upload data...");
            new Thread() { // from class: com.baidu.location.g.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        HttpPost httpPost = new HttpPost(j.m239do());
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < g.e.size(); i3++) {
                            if (g.f162goto == 1) {
                                arrayList.add(new BasicNameValuePair("cldc[" + i3 + "]", (String) g.e.get(i3)));
                            } else {
                                arrayList.add(new BasicNameValuePair("cltr[" + i3 + "]", (String) g.e.get(i3)));
                            }
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                        if (defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200) {
                            j.a(g.f166new, "Status ok1...");
                            g.e.clear();
                            ArrayList unused = g.e = null;
                        } else {
                            j.a(g.f166new, "Status err1...");
                        }
                    } catch (Exception e3) {
                    } finally {
                        boolean unused2 = g.b = false;
                    }
                }
            }.start();
            return;
        }
        e = null;
        b = false;
        j.a(f166new, "No upload data...");
    }

    /* renamed from: for  reason: not valid java name */
    public static void m206for() {
        try {
            File file = new File(f.aa + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(f.aa);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                j.a(f166new, "upload manager create file success");
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
            randomAccessFile2.writeDouble(j.s);
            randomAccessFile2.writeDouble(j.f194byte);
            randomAccessFile2.writeBoolean(j.e);
            if (j.e && j.o != null) {
                randomAccessFile2.write(j.o);
            }
            randomAccessFile2.close();
        } catch (Exception e2) {
        }
    }

    /* renamed from: for  reason: not valid java name */
    public static boolean m207for(Context context) {
        if (context == null) {
            return false;
        }
        m201do(context);
        return f167try == 1;
    }

    /* renamed from: if  reason: not valid java name */
    private static int m210if(Context context) {
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
                            f163if = Uri.parse("content://telephony/carriers/preferapn");
                            Cursor query = context.getContentResolver().query(f163if, null, null, null, null);
                            if (query != null && query.moveToFirst()) {
                                String string = query.getString(query.getColumnIndex("apn"));
                                if (string != null && string.toLowerCase().contains("ctwap")) {
                                    String defaultHost = Proxy.getDefaultHost();
                                    j = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.200" : "10.0.0.200";
                                    f = 80;
                                    if (query != null) {
                                        query.close();
                                    }
                                    return 1;
                                } else if (string != null && string.toLowerCase().contains("wap")) {
                                    String defaultHost2 = Proxy.getDefaultHost();
                                    j = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                                    f = 80;
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
                            j.a(f166new, "APN security...");
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

    /* renamed from: if  reason: not valid java name */
    public static boolean m213if(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > j.f200goto) {
                    j.f200goto = parseInt;
                    if (jSONObject.has("gps")) {
                        j.a(f166new, "has gps...");
                        String[] split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (split[0] != null && !split[0].equals("")) {
                                j.f195case = Float.parseFloat(split[0]);
                            }
                            if (split[1] != null && !split[1].equals("")) {
                                j.A = Float.parseFloat(split[1]);
                            }
                            if (split[2] != null && !split[2].equals("")) {
                                j.f196char = Float.parseFloat(split[2]);
                            }
                            if (split[3] != null && !split[3].equals("")) {
                                j.C = Float.parseFloat(split[3]);
                            }
                            if (split[4] != null && !split[4].equals("")) {
                                j.t = Integer.parseInt(split[4]);
                            }
                            if (split[5] != null && !split[5].equals("")) {
                                j.a = Integer.parseInt(split[5]);
                            }
                            if (split[6] != null && !split[6].equals("")) {
                                j.u = Integer.parseInt(split[6]);
                            }
                            if (split[7] != null && !split[7].equals("")) {
                                j.f201if = Integer.parseInt(split[7]);
                            }
                            if (split[8] != null && !split[8].equals("")) {
                                j.f202int = Integer.parseInt(split[8]);
                            }
                            if (split[9] != null && !split[9].equals("")) {
                                j.k = Integer.parseInt(split[9]);
                            }
                            if (split[10] != null && !split[10].equals("")) {
                                j.K = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        j.a(f166new, "has up...");
                        String[] split2 = jSONObject.getString("up").split("\\|");
                        if (split2.length > 3) {
                            if (split2[0] != null && !split2[0].equals("")) {
                                j.T = Float.parseFloat(split2[0]);
                            }
                            if (split2[1] != null && !split2[1].equals("")) {
                                j.Q = Float.parseFloat(split2[1]);
                            }
                            if (split2[2] != null && !split2[2].equals("")) {
                                j.d = Float.parseFloat(split2[2]);
                            }
                            if (split2[3] != null && !split2[3].equals("")) {
                                j.H = Float.parseFloat(split2[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        j.a(f166new, "has wf...");
                        String[] split3 = jSONObject.getString("wf").split("\\|");
                        if (split3.length > 3) {
                            if (split3[0] != null && !split3[0].equals("")) {
                                j.F = Integer.parseInt(split3[0]);
                            }
                            if (split3[1] != null && !split3[1].equals("")) {
                                j.f204new = Float.parseFloat(split3[1]);
                            }
                            if (split3[2] != null && !split3[2].equals("")) {
                                j.h = Integer.parseInt(split3[2]);
                            }
                            if (split3[3] != null && !split3[3].equals("")) {
                                j.D = Float.parseFloat(split3[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        j.a(f166new, "has ab...");
                        String[] split4 = jSONObject.getString("ab").split("\\|");
                        if (split4.length > 3) {
                            if (split4[0] != null && !split4[0].equals("")) {
                                j.S = Float.parseFloat(split4[0]);
                            }
                            if (split4[1] != null && !split4[1].equals("")) {
                                j.P = Float.parseFloat(split4[1]);
                            }
                            if (split4[2] != null && !split4[2].equals("")) {
                                j.N = Integer.parseInt(split4[2]);
                            }
                            if (split4[3] != null && !split4[3].equals("")) {
                                j.L = Integer.parseInt(split4[3]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        j.a(f166new, "has gpc...");
                        String[] split5 = jSONObject.getString("gpc").split("\\|");
                        if (split5.length > 5) {
                            if (split5[0] != null && !split5[0].equals("")) {
                                if (Integer.parseInt(split5[0]) > 0) {
                                    j.m = true;
                                } else {
                                    j.m = false;
                                }
                            }
                            if (split5[1] != null && !split5[1].equals("")) {
                                if (Integer.parseInt(split5[1]) > 0) {
                                    j.G = true;
                                } else {
                                    j.G = false;
                                }
                            }
                            if (split5[2] != null && !split5[2].equals("")) {
                                j.i = Integer.parseInt(split5[2]);
                            }
                            if (split5[3] != null && !split5[3].equals("")) {
                                j.l = Integer.parseInt(split5[3]);
                            }
                            if (split5[4] != null && !split5[4].equals("")) {
                                int parseInt2 = Integer.parseInt(split5[4]);
                                if (parseInt2 > 0) {
                                    j.B = parseInt2;
                                    j.z = j.B * 1000 * 60;
                                    j.q = j.z >> 2;
                                } else {
                                    j.M = false;
                                }
                            }
                            if (split5[5] != null && !split5[5].equals("")) {
                                j.E = Integer.parseInt(split5[5]);
                            }
                        }
                    }
                    try {
                        j.a(f166new, "config change true...");
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

    /* JADX WARN: Type inference failed for: r1v4, types: [com.baidu.location.g$2] */
    /* renamed from: if  reason: not valid java name */
    public static boolean m214if(String str, Handler handler) {
        if (f160else || str == null) {
            return false;
        }
        f160else = true;
        d = Jni.m6if(str);
        j.a(f166new, "bloc : " + d);
        l = handler;
        if (f161for == null) {
            f161for = k.a();
        }
        new Thread() { // from class: com.baidu.location.g.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpPost httpPost;
                HttpResponse execute;
                int statusCode;
                int i2 = g.f168void;
                while (i2 > 0) {
                    try {
                        httpPost = new HttpPost(j.m239do());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("bloc", g.d));
                        if (g.f161for != null) {
                            arrayList.add(new BasicNameValuePair("up", g.f161for));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                        HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                        if (g.f167try == 1) {
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(g.j, g.f, "http"));
                        }
                        execute = defaultHttpClient.execute(httpPost);
                        statusCode = execute.getStatusLine().getStatusCode();
                        j.a(g.f166new, "===status error : " + statusCode);
                    } catch (Exception e2) {
                    }
                    if (statusCode == 200) {
                        String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
                        Message obtainMessage = g.l.obtainMessage(26);
                        obtainMessage.obj = entityUtils;
                        obtainMessage.sendToTarget();
                        String unused = g.f159do = null;
                        break;
                    }
                    httpPost.abort();
                    Message obtainMessage2 = g.l.obtainMessage(65);
                    obtainMessage2.obj = "HttpStatus error";
                    obtainMessage2.sendToTarget();
                    i2--;
                }
                if (i2 <= 0 && g.l != null) {
                    j.a(g.f166new, "have tried 3 times...");
                    g.l.obtainMessage(64).sendToTarget();
                }
                Handler unused2 = g.l = null;
                boolean unused3 = g.f160else = false;
            }
        }.start();
        return true;
    }
}
