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
    private ArrayList<BasicNameValuePair> xO;
    private String xP;
    private StringBuilder xQ;

    public q(String str) {
        this.xP = null;
        this.xQ = new StringBuilder(100);
        this.xP = str;
    }

    public q() {
        this.xP = null;
        this.xQ = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.xO == null) {
                this.xO = new ArrayList<>();
            }
            this.xO.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.xO != null) {
            Iterator<BasicNameValuePair> it = this.xO.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.xQ.length() > 0) {
                        this.xQ.append('&');
                    }
                    this.xQ.append(next.getName());
                    this.xQ.append('=');
                    try {
                        this.xQ.append(URLEncoder.encode(aw(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.xQ.append(aw(next.getValue()));
                    }
                }
            }
        }
        return this.xQ.toString();
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
            if (this.xQ.length() > 0) {
                this.xQ.append('&');
            }
            this.xQ.append(str);
            this.xQ.append("=");
            try {
                this.xQ.append(URLEncoder.encode(aw(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.xQ.append(aw(str2));
            }
        }
    }

    public void il() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long im() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    private String aw(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
