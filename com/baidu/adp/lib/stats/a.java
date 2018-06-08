package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.IoUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    boolean AV;
    private ArrayList<BasicNameValuePair> AW;
    private StringBuilder AX;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.AV = false;
        this.mType = null;
        this.AX = new StringBuilder(100);
        this.mType = str;
        this.AV = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.AV = false;
        this.mType = null;
        this.AX = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.AW == null) {
                this.AW = new ArrayList<>();
            }
            this.AW.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.AX.length() > 0) {
            sb.append((CharSequence) this.AX);
        }
        if (this.AW != null) {
            Iterator<BasicNameValuePair> it = this.AW.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aD(next.getValue()), IoUtils.UTF_8));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(aD(next.getValue()));
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
            if (this.AX.length() > 0) {
                this.AX.append('&');
            }
            this.AX.append(str);
            this.AX.append("=");
            try {
                this.AX.append(URLEncoder.encode(aD(str2), IoUtils.UTF_8));
            } catch (Throwable th) {
                BdLog.e(th);
                this.AX.append(aD(str2));
            }
        }
    }

    public void iq() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long ir() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aD(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
