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
    public long sequenceID;
    public long wN;
    boolean wO;
    private ArrayList<BasicNameValuePair> wP;
    private StringBuilder wQ;

    public d(String str) {
        this.wN = 1L;
        this.sequenceID = -1L;
        this.wO = false;
        this.mType = null;
        this.wQ = new StringBuilder(100);
        this.mType = str;
        this.wO = false;
        this.wN = -1L;
        this.sequenceID = -1L;
    }

    public d() {
        this.wN = 1L;
        this.sequenceID = -1L;
        this.wO = false;
        this.mType = null;
        this.wQ = new StringBuilder(100);
    }

    public void b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wP == null) {
                this.wP = new ArrayList<>();
            }
            this.wP.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.wQ.length() > 0) {
            sb.append((CharSequence) this.wQ);
        }
        if (this.wP != null) {
            Iterator<BasicNameValuePair> it = this.wP.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(at(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(at(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
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
            if (this.wQ.length() > 0) {
                this.wQ.append('&');
            }
            this.wQ.append(str);
            this.wQ.append("=");
            try {
                this.wQ.append(URLEncoder.encode(at(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wQ.append(at(str2));
            }
        }
    }

    public void hP() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long hQ() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String at(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
