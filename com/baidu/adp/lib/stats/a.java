package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.IoUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    boolean AQ;
    private ArrayList<BasicNameValuePair> AR;
    private StringBuilder AT;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.AQ = false;
        this.mType = null;
        this.AT = new StringBuilder(100);
        this.mType = str;
        this.AQ = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.AQ = false;
        this.mType = null;
        this.AT = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.AR == null) {
                this.AR = new ArrayList<>();
            }
            this.AR.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.AT.length() > 0) {
            sb.append((CharSequence) this.AT);
        }
        if (this.AR != null) {
            Iterator<BasicNameValuePair> it = this.AR.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aG(next.getValue()), IoUtils.UTF_8));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(aG(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
    }

    public void f(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    c(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void append(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.AT.length() > 0) {
                this.AT.append('&');
            }
            this.AT.append(str);
            this.AT.append("=");
            try {
                this.AT.append(URLEncoder.encode(aG(str2), IoUtils.UTF_8));
            } catch (Throwable th) {
                BdLog.e(th);
                this.AT.append(aG(str2));
            }
        }
    }

    public void ir() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long is() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aG(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
