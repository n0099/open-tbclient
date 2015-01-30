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
    private ArrayList<BasicNameValuePair> mA;
    private String mB;
    private StringBuilder mC;
    private long mStartTime;

    public q(String str) {
        this.mB = null;
        this.mC = new StringBuilder(100);
        this.mB = str;
    }

    public q() {
        this.mB = null;
        this.mC = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.mA == null) {
                this.mA = new ArrayList<>();
            }
            this.mA.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.mA != null) {
            Iterator<BasicNameValuePair> it = this.mA.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.mC.length() > 0) {
                        this.mC.append('&');
                    }
                    this.mC.append(next.getName());
                    this.mC.append('=');
                    try {
                        this.mC.append(URLEncoder.encode(ap(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.mC.append(ap(next.getValue()));
                    }
                }
            }
        }
        return this.mC.toString();
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
            if (this.mC.length() > 0) {
                this.mC.append('&');
            }
            this.mC.append(str);
            this.mC.append("=");
            try {
                this.mC.append(URLEncoder.encode(ap(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.mC.append(ap(str2));
            }
        }
    }

    public void eK() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long eL() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    private String ap(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", "").replace("&", "|");
    }
}
