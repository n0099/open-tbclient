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
    boolean yo;
    private ArrayList<BasicNameValuePair> yp;
    private StringBuilder yq;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.yo = false;
        this.mType = null;
        this.yq = new StringBuilder(100);
        this.mType = str;
        this.yo = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.yo = false;
        this.mType = null;
        this.yq = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.yp == null) {
                this.yp = new ArrayList<>();
            }
            this.yp.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.yq.length() > 0) {
            sb.append((CharSequence) this.yq);
        }
        if (this.yp != null) {
            Iterator<BasicNameValuePair> it = this.yp.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(as(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(as(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
    }

    public void d(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    c(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void p(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.yq.length() > 0) {
                this.yq.append('&');
            }
            this.yq.append(str);
            this.yq.append("=");
            try {
                this.yq.append(URLEncoder.encode(as(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.yq.append(as(str2));
            }
        }
    }

    public void startTimer() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long gf() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String as(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
