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
    private StringBuilder wA;
    public long ww;
    public long wx;
    boolean wy;
    private ArrayList<BasicNameValuePair> wz;

    public d(String str) {
        this.ww = 1L;
        this.wx = -1L;
        this.wy = false;
        this.mType = null;
        this.wA = new StringBuilder(100);
        this.mType = str;
        this.wy = false;
        this.ww = -1L;
        this.wx = -1L;
    }

    public d() {
        this.ww = 1L;
        this.wx = -1L;
        this.wy = false;
        this.mType = null;
        this.wA = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wz == null) {
                this.wz = new ArrayList<>();
            }
            this.wz.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wz != null) {
            Iterator<BasicNameValuePair> it = this.wz.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wA.length() > 0) {
                        this.wA.append('&');
                    }
                    this.wA.append(next.getName());
                    this.wA.append('=');
                    try {
                        this.wA.append(URLEncoder.encode(ar(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wA.append(ar(next.getValue()));
                    }
                }
            }
        }
        return this.wA.toString();
    }

    public void b(Object... objArr) {
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
            if (this.wA.length() > 0) {
                this.wA.append('&');
            }
            this.wA.append(str);
            this.wA.append("=");
            try {
                this.wA.append(URLEncoder.encode(ar(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wA.append(ar(str2));
            }
        }
    }

    public void hJ() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hK() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ar(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
