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
    boolean BF;
    private ArrayList<BasicNameValuePair> BG;
    private StringBuilder BH;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.BF = false;
        this.mType = null;
        this.BH = new StringBuilder(100);
        this.mType = str;
        this.BF = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.BF = false;
        this.mType = null;
        this.BH = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.BG == null) {
                this.BG = new ArrayList<>();
            }
            this.BG.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.BH.length() > 0) {
            sb.append((CharSequence) this.BH);
        }
        if (this.BG != null) {
            Iterator<BasicNameValuePair> it = this.BG.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aH(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(aH(next.getValue()));
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
            if (this.BH.length() > 0) {
                this.BH.append('&');
            }
            this.BH.append(str);
            this.BH.append("=");
            try {
                this.BH.append(URLEncoder.encode(aH(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.BH.append(aH(str2));
            }
        }
    }

    public void iF() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long iG() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aH(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
