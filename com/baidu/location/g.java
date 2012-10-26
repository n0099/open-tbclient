package com.baidu.location;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {

    /* renamed from: byte  reason: not valid java name */
    private static final int f140byte = 1;

    /* renamed from: case  reason: not valid java name */
    private static final int f141case = 2;
    private static final int d = 4;

    /* renamed from: do  reason: not valid java name */
    private static String f143do = null;

    /* renamed from: for  reason: not valid java name */
    private static String f145for = null;
    private static String g = null;
    public static final int i = 3;

    /* renamed from: void  reason: not valid java name */
    private static String f152void;

    /* renamed from: new  reason: not valid java name */
    private static String f150new = f.g;

    /* renamed from: long  reason: not valid java name */
    private static int f149long = AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED;

    /* renamed from: else  reason: not valid java name */
    private static int f144else = 3;
    private static boolean e = false;

    /* renamed from: char  reason: not valid java name */
    private static boolean f142char = false;

    /* renamed from: goto  reason: not valid java name */
    private static boolean f146goto = false;
    private static ArrayList b = null;
    private static int a = 12000;

    /* renamed from: if  reason: not valid java name */
    private static Uri f147if = null;

    /* renamed from: try  reason: not valid java name */
    private static int f151try = 4;
    private static String f = "10.0.0.172";
    private static int c = 80;

    /* renamed from: int  reason: not valid java name */
    private static Handler f148int = null;
    private static Handler h = null;

    g() {
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        m150do(context);
        return f151try == 1;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.baidu.location.g$1] */
    public static boolean a(String str, Handler handler) {
        if (e || str == null) {
            return false;
        }
        e = true;
        j.a(f150new, "bloc : " + g);
        g = Jni.m0if(str);
        j.a(f150new, "NUMBER_e : " + g.length());
        f148int = handler;
        if (f143do == null) {
            f143do = k.a();
        }
        new Thread() { // from class: com.baidu.location.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpPost httpPost;
                HttpResponse execute;
                int statusCode;
                int i2 = g.f144else;
                while (i2 > 0) {
                    try {
                        httpPost = new HttpPost(j.m183do());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("bloc", g.g));
                        if (g.f143do != null) {
                            arrayList.add(new BasicNameValuePair("up", g.f143do));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                        HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                        if (g.f151try == 1) {
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(g.f, g.c, "http"));
                        }
                        execute = defaultHttpClient.execute(httpPost);
                        statusCode = execute.getStatusLine().getStatusCode();
                        j.a(g.f150new, "===status error : " + statusCode);
                    } catch (Exception e2) {
                    }
                    if (statusCode == 200) {
                        String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
                        Message obtainMessage = g.f148int.obtainMessage(21);
                        obtainMessage.obj = entityUtils;
                        obtainMessage.sendToTarget();
                        String unused = g.f143do = null;
                        break;
                    }
                    httpPost.abort();
                    Message obtainMessage2 = g.f148int.obtainMessage(63);
                    obtainMessage2.obj = "HttpStatus error";
                    obtainMessage2.sendToTarget();
                    i2--;
                }
                if (i2 <= 0 && g.f148int != null) {
                    j.a(g.f150new, "have tried 3 times...");
                    g.f148int.obtainMessage(62).sendToTarget();
                }
                Handler unused2 = g.f148int = null;
                boolean unused3 = g.e = false;
            }
        }.start();
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m150do(Context context) {
        f151try = m154for(context);
        return f151try;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.location.g$3] */
    /* renamed from: else  reason: not valid java name */
    public static void m152else() {
        if (f146goto) {
            return;
        }
        f146goto = true;
        if (b == null) {
            b = new ArrayList();
            int i2 = 0;
            do {
                String a2 = k.a();
                if (a2 == null) {
                    break;
                }
                b.add(a2);
                i2 += a2.length();
                j.a(f150new, "upload data size:" + i2);
            } while (i2 < f149long);
        }
        if (b != null && b.size() >= 1) {
            j.a(f150new, "Beging upload data...");
            new Thread() { // from class: com.baidu.location.g.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        HttpPost httpPost = new HttpPost(j.m183do());
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < g.b.size(); i3++) {
                            arrayList.add(new BasicNameValuePair("cldc[" + i3 + "]", (String) g.b.get(i3)));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                        if (defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200) {
                            g.b.clear();
                            ArrayList unused = g.b = null;
                        }
                    } catch (Exception e2) {
                    } finally {
                        boolean unused2 = g.f146goto = false;
                    }
                }
            }.start();
            return;
        }
        b = null;
        f146goto = false;
        j.a(f150new, "No upload data...");
    }

    /* renamed from: for  reason: not valid java name */
    private static int m154for(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 4;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return 4;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 3;
            }
            f147if = Uri.parse("content://telephony/carriers/preferapn");
            Cursor query = context.getContentResolver().query(f147if, null, null, null, null);
            if (query != null && query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("apn"));
                if (string != null && string.toLowerCase().contains("ctwap")) {
                    String defaultHost = Proxy.getDefaultHost();
                    f = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.200" : "10.0.0.200";
                    c = 80;
                    return 1;
                } else if (string != null && string.toLowerCase().contains("wap")) {
                    String defaultHost2 = Proxy.getDefaultHost();
                    f = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                    c = 80;
                    return 1;
                }
            }
            if (query != null) {
                query.close();
            }
            return 2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 4;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m158if(Context context) {
        if (context == null) {
            return false;
        }
        m150do(context);
        return f151try == 3;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.baidu.location.g$2] */
    /* renamed from: if  reason: not valid java name */
    public static boolean m159if(String str, Handler handler) {
        if (f142char || str == null) {
            return false;
        }
        f142char = true;
        f152void = Jni.m0if(str);
        j.a(f150new, "bloc : " + f152void);
        h = handler;
        if (f145for == null) {
            f145for = k.a();
        }
        new Thread() { // from class: com.baidu.location.g.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpPost httpPost;
                HttpResponse execute;
                int statusCode;
                int i2 = g.f144else;
                while (i2 > 0) {
                    try {
                        httpPost = new HttpPost(j.m183do());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("bloc", g.f152void));
                        if (g.f145for != null) {
                            arrayList.add(new BasicNameValuePair("up", g.f145for));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.a));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.a));
                        HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                        if (g.f151try == 1) {
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(g.f, g.c, "http"));
                        }
                        execute = defaultHttpClient.execute(httpPost);
                        statusCode = execute.getStatusLine().getStatusCode();
                        j.a(g.f150new, "===status error : " + statusCode);
                    } catch (Exception e2) {
                    }
                    if (statusCode == 200) {
                        String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
                        Message obtainMessage = g.h.obtainMessage(26);
                        obtainMessage.obj = entityUtils;
                        obtainMessage.sendToTarget();
                        String unused = g.f143do = null;
                        break;
                    }
                    httpPost.abort();
                    Message obtainMessage2 = g.h.obtainMessage(65);
                    obtainMessage2.obj = "HttpStatus error";
                    obtainMessage2.sendToTarget();
                    i2--;
                }
                if (i2 <= 0 && g.h != null) {
                    j.a(g.f150new, "have tried 3 times...");
                    g.h.obtainMessage(64).sendToTarget();
                }
                Handler unused2 = g.h = null;
                boolean unused3 = g.f142char = false;
            }
        }.start();
        return true;
    }
}
