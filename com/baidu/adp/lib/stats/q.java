package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class q {
    private ArrayList<BasicNameValuePair> a;
    private String b;
    private StringBuilder c;
    private long d;

    public q(String str) {
        this.b = null;
        this.c = new StringBuilder(100);
        this.b = str;
    }

    public q() {
        this.b = null;
        this.c = new StringBuilder(100);
    }

    public void a(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.a != null) {
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.c.length() > 0) {
                        this.c.append('&');
                    }
                    this.c.append(next.getName());
                    this.c.append('=');
                    try {
                        this.c.append(URLEncoder.encode(a(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.c.append(a(next.getValue()));
                    }
                }
            }
        }
        return this.c.toString();
    }

    public void a(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    a(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.c.length() > 0) {
                this.c.append('&');
            }
            this.c.append(str);
            this.c.append("=");
            try {
                this.c.append(URLEncoder.encode(a(str2), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
                this.c.append(a(str2));
            }
        }
    }

    public void a() {
        this.d = System.currentTimeMillis();
    }

    public long b() {
        return System.currentTimeMillis() - this.d;
    }

    private String a(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", "").replace("&", "|");
    }
}
