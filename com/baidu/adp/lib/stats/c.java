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
    boolean wK;
    private ArrayList<BasicNameValuePair> wL;
    private StringBuilder wM;

    public c(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wK = false;
        this.mType = null;
        this.wM = new StringBuilder(100);
        this.mType = str;
        this.wK = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public c() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.wK = false;
        this.mType = null;
        this.wM = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wL == null) {
                this.wL = new ArrayList<>();
            }
            this.wL.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.wM.length() > 0) {
            sb.append((CharSequence) this.wM);
        }
        if (this.wL != null) {
            Iterator<BasicNameValuePair> it = this.wL.iterator();
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
            if (this.wM.length() > 0) {
                this.wM.append('&');
            }
            this.wM.append(str);
            this.wM.append("=");
            try {
                this.wM.append(URLEncoder.encode(ae(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wM.append(ae(str2));
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
