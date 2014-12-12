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
    private long mStartTime;
    private ArrayList<BasicNameValuePair> mx;
    private String my;
    private StringBuilder mz;

    public q(String str) {
        this.my = null;
        this.mz = new StringBuilder(100);
        this.my = str;
    }

    public q() {
        this.my = null;
        this.mz = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.mx == null) {
                this.mx = new ArrayList<>();
            }
            this.mx.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.mx != null) {
            Iterator<BasicNameValuePair> it = this.mx.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.mz.length() > 0) {
                        this.mz.append('&');
                    }
                    this.mz.append(next.getName());
                    this.mz.append('=');
                    try {
                        this.mz.append(URLEncoder.encode(ap(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.mz.append(ap(next.getValue()));
                    }
                }
            }
        }
        return this.mz.toString();
    }

    public void f(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    b(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void r(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.mz.length() > 0) {
                this.mz.append('&');
            }
            this.mz.append(str);
            this.mz.append("=");
            try {
                this.mz.append(URLEncoder.encode(ap(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.mz.append(ap(str2));
            }
        }
    }

    public void startTimer() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long eM() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    private String ap(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", "").replace("&", "|");
    }
}
