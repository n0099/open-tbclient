package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class q {
    private long mStartTime;
    public long wR;
    public long wS;
    boolean wT;
    private ArrayList<BasicNameValuePair> wU;
    public String wV;
    private StringBuilder wW;

    public q(String str) {
        this.wR = 1L;
        this.wS = -1L;
        this.wT = false;
        this.wV = null;
        this.wW = new StringBuilder(100);
        this.wV = str;
        this.wT = false;
        this.wR = -1L;
        this.wS = -1L;
    }

    public q() {
        this.wR = 1L;
        this.wS = -1L;
        this.wT = false;
        this.wV = null;
        this.wW = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wU == null) {
                this.wU = new ArrayList<>();
            }
            this.wU.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wU != null) {
            Iterator<BasicNameValuePair> it = this.wU.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wW.length() > 0) {
                        this.wW.append('&');
                    }
                    this.wW.append(next.getName());
                    this.wW.append('=');
                    try {
                        this.wW.append(URLEncoder.encode(ay(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wW.append(ay(next.getValue()));
                    }
                }
            }
        }
        return this.wW.toString();
    }

    public void ax(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wW.append(str);
        }
    }

    public void f(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    b(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void r(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.wW.length() > 0) {
                this.wW.append('&');
            }
            this.wW.append(str);
            this.wW.append("=");
            try {
                this.wW.append(URLEncoder.encode(ay(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wW.append(ay(str2));
            }
        }
    }

    public void hU() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hV() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ay(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
