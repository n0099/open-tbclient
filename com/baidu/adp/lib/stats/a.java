package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;
    boolean wg;
    private ArrayList<BasicNameValuePair> wh;
    private StringBuilder wi;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wg = false;
        this.mType = null;
        this.wi = new StringBuilder(100);
        this.mType = str;
        this.wg = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wg = false;
        this.mType = null;
        this.wi = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wh == null) {
                this.wh = new ArrayList<>();
            }
            this.wh.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.wi.length() > 0) {
            sb.append((CharSequence) this.wi);
        }
        if (this.wh != null) {
            Iterator<BasicNameValuePair> it = this.wh.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(am(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(am(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
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

    public void p(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.wi.length() > 0) {
                this.wi.append('&');
            }
            this.wi.append(str);
            this.wi.append("=");
            try {
                this.wi.append(URLEncoder.encode(am(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wi.append(am(str2));
            }
        }
    }

    public void fT() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long fU() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String am(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
