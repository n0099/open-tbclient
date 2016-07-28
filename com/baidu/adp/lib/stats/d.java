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
    public long nq;
    boolean nr;
    private ArrayList<BasicNameValuePair> ns;
    private StringBuilder nt;
    public long sequenceID;

    public d(String str) {
        this.nq = 1L;
        this.sequenceID = -1L;
        this.nr = false;
        this.mType = null;
        this.nt = new StringBuilder(100);
        this.mType = str;
        this.nr = false;
        this.nq = -1L;
        this.sequenceID = -1L;
    }

    public d() {
        this.nq = 1L;
        this.sequenceID = -1L;
        this.nr = false;
        this.mType = null;
        this.nt = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.ns == null) {
                this.ns = new ArrayList<>();
            }
            this.ns.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.nt.length() > 0) {
            sb.append((CharSequence) this.nt);
        }
        if (this.ns != null) {
            Iterator<BasicNameValuePair> it = this.ns.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(ao(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(ao(next.getValue()));
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

    public void q(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.nt.length() > 0) {
                this.nt.append('&');
            }
            this.nt.append(str);
            this.nt.append("=");
            try {
                this.nt.append(URLEncoder.encode(ao(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.nt.append(ao(str2));
            }
        }
    }

    public void ed() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long ee() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ao(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
