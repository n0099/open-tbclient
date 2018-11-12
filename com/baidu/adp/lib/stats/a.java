package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.IoUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    boolean DY;
    private ArrayList<BasicNameValuePair> DZ;
    private StringBuilder Ea;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.DY = false;
        this.mType = null;
        this.Ea = new StringBuilder(100);
        this.mType = str;
        this.DY = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.DY = false;
        this.mType = null;
        this.Ea = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.DZ == null) {
                this.DZ = new ArrayList<>();
            }
            this.DZ.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.Ea.length() > 0) {
            sb.append((CharSequence) this.Ea);
        }
        if (this.DZ != null) {
            Iterator<BasicNameValuePair> it = this.DZ.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(aW(next.getValue()), IoUtils.UTF_8));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(aW(next.getValue()));
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
            if (this.Ea.length() > 0) {
                this.Ea.append('&');
            }
            this.Ea.append(str);
            this.Ea.append(ETAG.EQUAL);
            try {
                this.Ea.append(URLEncoder.encode(aW(str2), IoUtils.UTF_8));
            } catch (Throwable th) {
                BdLog.e(th);
                this.Ea.append(aW(str2));
            }
        }
    }

    public void startTimer() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long jK() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aW(String str) {
        return str.replace(" ", BaseRequestAction.SPLITE).replace("[", "(").replace("]", ")").replace(ETAG.ITEM_SEPARATOR, "|");
    }
}
