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
    public long wf;
    public long wg;
    boolean wh;
    private ArrayList<BasicNameValuePair> wi;
    private StringBuilder wj;

    public d(String str) {
        this.wf = 1L;
        this.wg = -1L;
        this.wh = false;
        this.mType = null;
        this.wj = new StringBuilder(100);
        this.mType = str;
        this.wh = false;
        this.wf = -1L;
        this.wg = -1L;
    }

    public d() {
        this.wf = 1L;
        this.wg = -1L;
        this.wh = false;
        this.mType = null;
        this.wj = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wi == null) {
                this.wi = new ArrayList<>();
            }
            this.wi.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wi != null) {
            Iterator<BasicNameValuePair> it = this.wi.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wj.length() > 0) {
                        this.wj.append('&');
                    }
                    this.wj.append(next.getName());
                    this.wj.append('=');
                    try {
                        this.wj.append(URLEncoder.encode(ao(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wj.append(ao(next.getValue()));
                    }
                }
            }
        }
        return this.wj.toString();
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
            if (this.wj.length() > 0) {
                this.wj.append('&');
            }
            this.wj.append(str);
            this.wj.append("=");
            try {
                this.wj.append(URLEncoder.encode(ao(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wj.append(ao(str2));
            }
        }
    }

    public String getValue(String str) {
        if (this.wi == null || this.wi.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.wi.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && next.getName() != null && next.getName().equals(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public void hz() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hA() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ao(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
