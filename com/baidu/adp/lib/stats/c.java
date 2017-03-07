package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private long mStartTime;
    public String mType;
    public long sequenceID;
    public long xc;
    boolean xd;
    private ArrayList<BasicNameValuePair> xe;
    private StringBuilder xf;

    public c(String str) {
        this.xc = 1L;
        this.sequenceID = -1L;
        this.xd = false;
        this.mType = null;
        this.xf = new StringBuilder(100);
        this.mType = str;
        this.xd = false;
        this.xc = -1L;
        this.sequenceID = -1L;
    }

    public c() {
        this.xc = 1L;
        this.sequenceID = -1L;
        this.xd = false;
        this.mType = null;
        this.xf = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.xe == null) {
                this.xe = new ArrayList<>();
            }
            this.xe.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.xf.length() > 0) {
            sb.append((CharSequence) this.xf);
        }
        if (this.xe != null) {
            Iterator<BasicNameValuePair> it = this.xe.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(ai(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(ai(next.getValue()));
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
            if (this.xf.length() > 0) {
                this.xf.append('&');
            }
            this.xf.append(str);
            this.xf.append("=");
            try {
                this.xf.append(URLEncoder.encode(ai(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.xf.append(ai(str2));
            }
        }
    }

    public void fQ() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long fR() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ai(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
