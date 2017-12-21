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
    boolean wf;
    private ArrayList<BasicNameValuePair> wg;
    private StringBuilder wh;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wf = false;
        this.mType = null;
        this.wh = new StringBuilder(100);
        this.mType = str;
        this.wf = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wf = false;
        this.mType = null;
        this.wh = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wg == null) {
                this.wg = new ArrayList<>();
            }
            this.wg.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.wh.length() > 0) {
            sb.append((CharSequence) this.wh);
        }
        if (this.wg != null) {
            Iterator<BasicNameValuePair> it = this.wg.iterator();
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
            if (this.wh.length() > 0) {
                this.wh.append('&');
            }
            this.wh.append(str);
            this.wh.append("=");
            try {
                this.wh.append(URLEncoder.encode(am(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wh.append(am(str2));
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
