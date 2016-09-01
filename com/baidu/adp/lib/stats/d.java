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
    public long pL;
    boolean pM;
    private ArrayList<BasicNameValuePair> pN;
    private StringBuilder pO;
    public long sequenceID;

    public d(String str) {
        this.pL = 1L;
        this.sequenceID = -1L;
        this.pM = false;
        this.mType = null;
        this.pO = new StringBuilder(100);
        this.mType = str;
        this.pM = false;
        this.pL = -1L;
        this.sequenceID = -1L;
    }

    public d() {
        this.pL = 1L;
        this.sequenceID = -1L;
        this.pM = false;
        this.mType = null;
        this.pO = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.pN == null) {
                this.pN = new ArrayList<>();
            }
            this.pN.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.pO.length() > 0) {
            sb.append((CharSequence) this.pO);
        }
        if (this.pN != null) {
            Iterator<BasicNameValuePair> it = this.pN.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(ap(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(ap(next.getValue()));
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
            if (this.pO.length() > 0) {
                this.pO.append('&');
            }
            this.pO.append(str);
            this.pO.append("=");
            try {
                this.pO.append(URLEncoder.encode(ap(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.pO.append(ap(str2));
            }
        }
    }

    public void eY() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long eZ() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ap(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
