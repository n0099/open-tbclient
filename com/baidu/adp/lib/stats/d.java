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
    public long pM;
    boolean pN;
    private ArrayList<BasicNameValuePair> pO;
    private StringBuilder pP;
    public long sequenceID;

    public d(String str) {
        this.pM = 1L;
        this.sequenceID = -1L;
        this.pN = false;
        this.mType = null;
        this.pP = new StringBuilder(100);
        this.mType = str;
        this.pN = false;
        this.pM = -1L;
        this.sequenceID = -1L;
    }

    public d() {
        this.pM = 1L;
        this.sequenceID = -1L;
        this.pN = false;
        this.mType = null;
        this.pP = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.pO == null) {
                this.pO = new ArrayList<>();
            }
            this.pO.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.pP.length() > 0) {
            sb.append((CharSequence) this.pP);
        }
        if (this.pO != null) {
            Iterator<BasicNameValuePair> it = this.pO.iterator();
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
            if (this.pP.length() > 0) {
                this.pP.append('&');
            }
            this.pP.append(str);
            this.pP.append("=");
            try {
                this.pP.append(URLEncoder.encode(ap(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.pP.append(ap(str2));
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
