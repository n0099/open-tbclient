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
    boolean BL;
    private ArrayList<BasicNameValuePair> BM;
    private StringBuilder BN;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.BL = false;
        this.mType = null;
        this.BN = new StringBuilder(100);
        this.mType = str;
        this.BL = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.BL = false;
        this.mType = null;
        this.BN = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.BM == null) {
                this.BM = new ArrayList<>();
            }
            this.BM.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.BN.length() > 0) {
            sb.append((CharSequence) this.BN);
        }
        if (this.BM != null) {
            Iterator<BasicNameValuePair> it = this.BM.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aI(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(aI(next.getValue()));
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

    public void append(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.BN.length() > 0) {
                this.BN.append('&');
            }
            this.BN.append(str);
            this.BN.append("=");
            try {
                this.BN.append(URLEncoder.encode(aI(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.BN.append(aI(str2));
            }
        }
    }

    public void iO() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long iP() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aI(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
