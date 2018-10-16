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
    boolean DU;
    private ArrayList<BasicNameValuePair> DV;
    private StringBuilder DW;
    public long logID;
    private long mStartTime;
    public String mType;
    public long sequenceID;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.DU = false;
        this.mType = null;
        this.DW = new StringBuilder(100);
        this.mType = str;
        this.DU = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.DU = false;
        this.mType = null;
        this.DW = new StringBuilder(100);
    }

    public void c(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.DV == null) {
                this.DV = new ArrayList<>();
            }
            this.DV.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.DW.length() > 0) {
            sb.append((CharSequence) this.DW);
        }
        if (this.DV != null) {
            Iterator<BasicNameValuePair> it = this.DV.iterator();
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
            if (this.DW.length() > 0) {
                this.DW.append('&');
            }
            this.DW.append(str);
            this.DW.append(ETAG.EQUAL);
            try {
                this.DW.append(URLEncoder.encode(aW(str2), IoUtils.UTF_8));
            } catch (Throwable th) {
                BdLog.e(th);
                this.DW.append(aW(str2));
            }
        }
    }

    public void startTimer() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long jM() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String aW(String str) {
        return str.replace(" ", BaseRequestAction.SPLITE).replace("[", "(").replace("]", ")").replace(ETAG.ITEM_SEPARATOR, "|");
    }
}
