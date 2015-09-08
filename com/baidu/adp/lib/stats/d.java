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
    public long we;
    public long wf;
    boolean wg;
    private ArrayList<BasicNameValuePair> wh;
    private StringBuilder wi;

    public d(String str) {
        this.we = 1L;
        this.wf = -1L;
        this.wg = false;
        this.mType = null;
        this.wi = new StringBuilder(100);
        this.mType = str;
        this.wg = false;
        this.we = -1L;
        this.wf = -1L;
    }

    public d() {
        this.we = 1L;
        this.wf = -1L;
        this.wg = false;
        this.mType = null;
        this.wi = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wh == null) {
                this.wh = new ArrayList<>();
            }
            this.wh.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        if (this.wh != null) {
            Iterator<BasicNameValuePair> it = this.wh.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (this.wi.length() > 0) {
                        this.wi.append('&');
                    }
                    this.wi.append(next.getName());
                    this.wi.append('=');
                    try {
                        this.wi.append(URLEncoder.encode(aq(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        this.wi.append(aq(next.getValue()));
                    }
                }
            }
        }
        return this.wi.toString();
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
            if (this.wi.length() > 0) {
                this.wi.append('&');
            }
            this.wi.append(str);
            this.wi.append("=");
            try {
                this.wi.append(URLEncoder.encode(aq(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wi.append(aq(str2));
            }
        }
    }

    public String getValue(String str) {
        if (this.wh == null || this.wh.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.wh.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && next.getName() != null && next.getName().equals(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public void hx() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hy() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aq(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
