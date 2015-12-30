package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private long mStartTime;
    public String mType;
    public long wn;
    public long wo;
    boolean wp;
    private ArrayList<BasicNameValuePair> wq;
    private StringBuilder wr;

    public d(String str) {
        this.wn = 1L;
        this.wo = -1L;
        this.wp = false;
        this.mType = null;
        this.wr = new StringBuilder(100);
        this.mType = str;
        this.wp = false;
        this.wn = -1L;
        this.wo = -1L;
    }

    public d() {
        this.wn = 1L;
        this.wo = -1L;
        this.wp = false;
        this.mType = null;
        this.wr = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wq == null) {
                this.wq = new ArrayList<>();
            }
            this.wq.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wq != null) {
            Iterator<BasicNameValuePair> it = this.wq.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wr.length() > 0) {
                        this.wr.append('&');
                    }
                    this.wr.append(next.getName());
                    this.wr.append('=');
                    try {
                        this.wr.append(URLEncoder.encode(as(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wr.append(as(next.getValue()));
                    }
                }
            }
        }
        return this.wr.toString();
    }

    public void e(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    b(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void q(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.wr.length() > 0) {
                this.wr.append('&');
            }
            this.wr.append(str);
            this.wr.append("=");
            try {
                this.wr.append(URLEncoder.encode(as(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wr.append(as(str2));
            }
        }
    }

    public String getValue(String str) {
        if (this.wq == null || this.wq.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.wq.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && next.getName() != null && next.getName().equals(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public void hB() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hC() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String as(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
