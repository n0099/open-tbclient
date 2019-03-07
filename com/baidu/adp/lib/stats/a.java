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
    boolean DX;
    private ArrayList<BasicNameValuePair> DY;
    private StringBuilder DZ;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.DX = false;
        this.mType = null;
        this.DZ = new StringBuilder(100);
        this.mType = str;
        this.DX = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.DX = false;
        this.mType = null;
        this.DZ = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.DY == null) {
                this.DY = new ArrayList<>();
            }
            this.DY.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.DZ.length() > 0) {
            sb.append((CharSequence) this.DZ);
        }
        if (this.DY != null) {
            Iterator<BasicNameValuePair> it = this.DY.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aX(next.getValue()), "utf-8"));
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
            if (this.DZ.length() > 0) {
                this.DZ.append('&');
            }
            this.DZ.append(str);
            this.DZ.append("=");
            try {
                this.DZ.append(URLEncoder.encode(aX(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.DZ.append(aX(str2));
            }
        }
    }

    public void jL() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long jM() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aX(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
