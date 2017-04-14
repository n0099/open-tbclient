package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private long mStartTime;
    public String mType;
    public long sequenceID;
    public long wF;
    boolean wG;
    private ArrayList<BasicNameValuePair> wH;
    private StringBuilder wI;

    public c(String str) {
        this.wF = 1L;
        this.sequenceID = -1L;
        this.wG = false;
        this.mType = null;
        this.wI = new StringBuilder(100);
        this.mType = str;
        this.wG = false;
        this.wF = -1L;
        this.sequenceID = -1L;
    }

    public c() {
        this.wF = 1L;
        this.sequenceID = -1L;
        this.wG = false;
        this.mType = null;
        this.wI = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.wH == null) {
                this.wH = new ArrayList<>();
            }
            this.wH.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.wI.length() > 0) {
            sb.append((CharSequence) this.wI);
        }
        if (this.wH != null) {
            Iterator<BasicNameValuePair> it = this.wH.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(ae(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(ae(next.getValue()));
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

    public void p(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.wI.length() > 0) {
                this.wI.append('&');
            }
            this.wI.append(str);
            this.wI.append("=");
            try {
                this.wI.append(URLEncoder.encode(ae(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.wI.append(ae(str2));
            }
        }
    }

    public void fV() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long fW() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String ae(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", ")").replace("&", "|");
    }
}
