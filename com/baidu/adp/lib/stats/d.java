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
    public long wl;
    public long wm;
    boolean wn;
    private ArrayList<BasicNameValuePair> wo;
    private StringBuilder wp;

    public d(String str) {
        this.wl = 1L;
        this.wm = -1L;
        this.wn = false;
        this.mType = null;
        this.wp = new StringBuilder(100);
        this.mType = str;
        this.wn = false;
        this.wl = -1L;
        this.wm = -1L;
    }

    public d() {
        this.wl = 1L;
        this.wm = -1L;
        this.wn = false;
        this.mType = null;
        this.wp = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wo == null) {
                this.wo = new ArrayList<>();
            }
            this.wo.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wo != null) {
            Iterator<BasicNameValuePair> it = this.wo.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wp.length() > 0) {
                        this.wp.append('&');
                    }
                    this.wp.append(next.getName());
                    this.wp.append('=');
                    try {
                        this.wp.append(URLEncoder.encode(as(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wp.append(as(next.getValue()));
                    }
                }
            }
        }
        return this.wp.toString();
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
            if (this.wp.length() > 0) {
                this.wp.append('&');
            }
            this.wp.append(str);
            this.wp.append("=");
            try {
                this.wp.append(URLEncoder.encode(as(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wp.append(as(str2));
            }
        }
    }

    public String getValue(String str) {
        if (this.wo == null || this.wo.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.wo.iterator();
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
