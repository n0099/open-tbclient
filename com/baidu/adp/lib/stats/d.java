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
    public long mJ;
    boolean mK;
    private ArrayList<BasicNameValuePair> mL;
    private StringBuilder mM;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public d(String str) {
        this.mJ = 1L;
        this.sequenceID = -1L;
        this.mK = false;
        this.mType = null;
        this.mM = new StringBuilder(100);
        this.mType = str;
        this.mK = false;
        this.mJ = -1L;
        this.sequenceID = -1L;
    }

    public d() {
        this.mJ = 1L;
        this.sequenceID = -1L;
        this.mK = false;
        this.mType = null;
        this.mM = new StringBuilder(100);
    }

    public void a(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.mL == null) {
                this.mL = new ArrayList<>();
            }
            this.mL.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.mM.length() > 0) {
            sb.append((CharSequence) this.mM);
        }
        if (this.mL != null) {
            Iterator<BasicNameValuePair> it = this.mL.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(am(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(am(next.getValue()));
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
                    a(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void q(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.mM.length() > 0) {
                this.mM.append('&');
            }
            this.mM.append(str);
            this.mM.append("=");
            try {
                this.mM.append(URLEncoder.encode(am(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.mM.append(am(str2));
            }
        }
    }

    public void ee() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long ef() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String am(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
