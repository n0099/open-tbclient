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
    public long wg;
    public long wh;
    boolean wi;
    private ArrayList<BasicNameValuePair> wj;
    private StringBuilder wk;

    public d(String str) {
        this.wg = 1L;
        this.wh = -1L;
        this.wi = false;
        this.mType = null;
        this.wk = new StringBuilder(100);
        this.mType = str;
        this.wi = false;
        this.wg = -1L;
        this.wh = -1L;
    }

    public d() {
        this.wg = 1L;
        this.wh = -1L;
        this.wi = false;
        this.mType = null;
        this.wk = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wj == null) {
                this.wj = new ArrayList<>();
            }
            this.wj.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wj != null) {
            Iterator<BasicNameValuePair> it = this.wj.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wk.length() > 0) {
                        this.wk.append('&');
                    }
                    this.wk.append(next.getName());
                    this.wk.append('=');
                    try {
                        this.wk.append(URLEncoder.encode(aq(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wk.append(aq(next.getValue()));
                    }
                }
            }
        }
        return this.wk.toString();
    }

    public void e(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    b(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void q(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.wk.length() > 0) {
                this.wk.append('&');
            }
            this.wk.append(str);
            this.wk.append("=");
            try {
                this.wk.append(URLEncoder.encode(aq(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wk.append(aq(str2));
            }
        }
    }

    public String getValue(String str) {
        if (this.wj == null || this.wj.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.wj.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && next.getName() != null && next.getName().equals(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public void hA() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hB() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aq(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
