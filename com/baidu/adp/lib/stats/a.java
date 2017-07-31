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
    boolean ym;
    private ArrayList<BasicNameValuePair> yn;
    private StringBuilder yo;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.ym = false;
        this.mType = null;
        this.yo = new StringBuilder(100);
        this.mType = str;
        this.ym = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.ym = false;
        this.mType = null;
        this.yo = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.yn == null) {
                this.yn = new ArrayList<>();
            }
            this.yn.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.yo.length() > 0) {
            sb.append((CharSequence) this.yo);
        }
        if (this.yn != null) {
            Iterator<BasicNameValuePair> it = this.yn.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(ar(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(ar(next.getValue()));
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
            if (this.yo.length() > 0) {
                this.yo.append('&');
            }
            this.yo.append(str);
            this.yo.append("=");
            try {
                this.yo.append(URLEncoder.encode(ar(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.yo.append(ar(str2));
            }
        }
    }

    public void startTimer() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long gf() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ar(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
