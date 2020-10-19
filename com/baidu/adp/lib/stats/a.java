package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private g Np;
    public long logID;
    private ArrayList<BasicNameValuePair> mKvLists;
    private long mStartTime;
    private StringBuilder mStringBuilder;
    public String mType;
    public long sequenceID;
    boolean usedSequenceId;

    public a(String str) {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.usedSequenceId = false;
        this.mType = null;
        this.mStringBuilder = new StringBuilder(100);
        this.mType = str;
        this.usedSequenceId = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public a() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.usedSequenceId = false;
        this.mType = null;
        this.mStringBuilder = new StringBuilder(100);
    }

    public void addValue(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.mKvLists == null) {
                this.mKvLists = new ArrayList<>();
            }
            this.mKvLists.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.mStringBuilder.length() > 0) {
            sb.append((CharSequence) this.mStringBuilder);
        }
        if (this.mKvLists != null) {
            Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(valueEscapeSpace(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                        sb.append(valueEscapeSpace(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
    }

    public void append(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    addValue(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public void append(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (this.mStringBuilder.length() > 0) {
                this.mStringBuilder.append('&');
            }
            this.mStringBuilder.append(str);
            this.mStringBuilder.append(ETAG.EQUAL);
            try {
                this.mStringBuilder.append(URLEncoder.encode(valueEscapeSpace(str2), "utf-8"));
            } catch (Throwable th) {
                BdLog.e(th);
                this.mStringBuilder.append(valueEscapeSpace(str2));
            }
        }
    }

    public void startTimer() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long getTimeCost() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static String valueEscapeSpace(String str) {
        return str.replace(" ", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).replace("[", "(").replace("]", ")").replace(ETAG.ITEM_SEPARATOR, "|");
    }

    public void a(c cVar) {
        if (this.Np == null) {
            this.Np = new g();
        }
        this.Np.b(cVar);
        if (this.mKvLists != null && this.mKvLists.size() > 0) {
            Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (BdStatsConstant.StatsKey.TYPE.equals(next.getName())) {
                    this.Np.ca(next.getValue());
                } else if ("st".equals(next.getName())) {
                    this.Np.setAction(next.getValue());
                } else if ("errNo".equals(next.getName())) {
                    this.Np.setErrorCode(next.getValue());
                } else if ("errMsg".equals(next.getName())) {
                    this.Np.setErrorMessage(next.getValue());
                } else {
                    this.Np.y(next.getName(), next.getValue());
                }
            }
        }
    }

    public g nb() {
        return this.Np;
    }
}
