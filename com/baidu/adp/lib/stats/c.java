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
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;
    boolean wJ;
    private ArrayList<BasicNameValuePair> wK;
    private StringBuilder wL;

    public c(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wJ = false;
        this.mType = null;
        this.wL = new StringBuilder(100);
        this.mType = str;
        this.wJ = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public c() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wJ = false;
        this.mType = null;
        this.wL = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wK == null) {
                this.wK = new ArrayList<>();
            }
            this.wK.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.wL.length() > 0) {
            sb.append((CharSequence) this.wL);
        }
        if (this.wK != null) {
            Iterator<BasicNameValuePair> it = this.wK.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(ae(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(ae(next.getValue()));
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
            if (this.wL.length() > 0) {
                this.wL.append('&');
            }
            this.wL.append(str);
            this.wL.append("=");
            try {
                this.wL.append(URLEncoder.encode(ae(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wL.append(ae(str2));
            }
        }
    }

    public void fW() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long fX() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ae(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
