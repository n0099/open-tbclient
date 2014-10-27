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
    private String mA;
    private StringBuilder mB;
    private long mStartTime;
    private ArrayList<BasicNameValuePair> mz;

    public q(String str) {
        this.mA = null;
        this.mB = new StringBuilder(100);
        this.mA = str;
    }

    public q() {
        this.mA = null;
        this.mB = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.mz == null) {
                this.mz = new ArrayList<>();
            }
            this.mz.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.mz != null) {
            Iterator<BasicNameValuePair> it = this.mz.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.mB.length() > 0) {
                        this.mB.append('&');
                    }
                    this.mB.append(next.getName());
                    this.mB.append('=');
                    try {
                        this.mB.append(URLEncoder.encode(al(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.mB.append(al(next.getValue()));
                    }
                }
            }
        }
        return this.mB.toString();
    }

    public void c(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    b(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void n(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.mB.length() > 0) {
                this.mB.append('&');
            }
            this.mB.append(str);
            this.mB.append("=");
            try {
                this.mB.append(URLEncoder.encode(al(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.mB.append(al(str2));
            }
        }
    }

    public void eL() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long eM() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    private String al(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", "").replace("&", "|");
    }
}
