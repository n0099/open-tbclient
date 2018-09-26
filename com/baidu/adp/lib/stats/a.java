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
    boolean Dl;
    private ArrayList<BasicNameValuePair> Dm;
    private StringBuilder Dn;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.Dl = false;
        this.mType = null;
        this.Dn = new StringBuilder(100);
        this.mType = str;
        this.Dl = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.Dl = false;
        this.mType = null;
        this.Dn = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.Dm == null) {
                this.Dm = new ArrayList<>();
            }
            this.Dm.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.Dn.length() > 0) {
            sb.append((CharSequence) this.Dn);
        }
        if (this.Dm != null) {
            Iterator<BasicNameValuePair> it = this.Dm.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aX(next.getValue()), IoUtils.UTF_8));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(aX(next.getValue()));
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
            if (this.Dn.length() > 0) {
                this.Dn.append('&');
            }
            this.Dn.append(str);
            this.Dn.append("=");
            try {
                this.Dn.append(URLEncoder.encode(aX(str2), IoUtils.UTF_8));
            } catch (Throwable th) {
                BdLog.e(th);
                this.Dn.append(aX(str2));
            }
        }
    }

    public void jx() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long jy() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aX(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
