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
    boolean akn;
    private ArrayList<BasicNameValuePair> ako;
    private StringBuilder akp;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.akn = false;
        this.mType = null;
        this.akp = new StringBuilder(100);
        this.mType = str;
        this.akn = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.akn = false;
        this.mType = null;
        this.akp = new StringBuilder(100);
    }

    public void l(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.ako == null) {
                this.ako = new ArrayList<>();
            }
            this.ako.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.akp.length() > 0) {
            sb.append((CharSequence) this.akp);
        }
        if (this.ako != null) {
            Iterator<BasicNameValuePair> it = this.ako.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(au(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(au(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
    }

    public void h(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    l(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void append(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.akp.length() > 0) {
                this.akp.append('&');
            }
            this.akp.append(str);
            this.akp.append("=");
            try {
                this.akp.append(URLEncoder.encode(au(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.akp.append(au(str2));
            }
        }
    }

    public void nw() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long nx() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String au(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
