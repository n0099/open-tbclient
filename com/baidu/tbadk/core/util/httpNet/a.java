package com.baidu.tbadk.core.util.httpNet;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import java.net.URL;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public class a {
    private static a h;
    private b c;
    private String a = null;
    private long b = 0;
    private boolean d = false;
    private long e = 0;
    private final long f = 120000;
    private final long g = 600000;

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    public a() {
        this.c = null;
        try {
            this.c = new b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkApplication.m252getInst().getApp().registerReceiver(this.c, intentFilter);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public HttpGet a(String str) {
        String str2 = this.a;
        if (str2 != null) {
            if (System.currentTimeMillis() - this.b < 600000) {
                int indexOf = str.indexOf("hiphotos");
                if (indexOf > 0 && indexOf < 20) {
                    try {
                        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                        URL url = new URL(str);
                        String host = url.getHost();
                        HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                        httpGet.addHeader("Host", host);
                        a(true);
                        return httpGet;
                    } catch (Exception e) {
                    }
                }
            } else {
                b();
            }
        }
        a(false);
        return new HttpGet(str);
    }

    public void a(boolean z) {
        if (this.d != z) {
            ae.a(z, this.e);
        }
        this.d = z;
    }

    public void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b > 120000) {
            this.b = currentTimeMillis;
            String d = d(str);
            if (!TextUtils.isEmpty(d)) {
                this.a = d;
            }
            this.e = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    public void c(String str) {
        if (this.a != null && str != null && this.a.equals(str)) {
            b();
        }
    }

    public void b() {
        this.a = null;
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            b(str);
        } else {
            c(str2);
        }
    }

    public String c() {
        if (this.a == null || System.currentTimeMillis() - this.b >= 600000) {
            return null;
        }
        return this.a;
    }

    private String d(String str) {
        int indexOf = str.indexOf("hiphotos.baidu.com");
        return indexOf > 0 ? UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com") : "";
    }
}
