package com.baidu.live.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class BdStatsItem {
    public String childType;
    public long logID;
    private ArrayList<BasicNameValuePair> mKvLists;
    private long mStartTime;
    private StringBuilder mStringBuilder;
    public String mType;
    public String parentType;
    public long sequenceID;
    boolean usedSequenceId;

    public BdStatsItem(String str) {
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

    public BdStatsItem() {
        this.logID = 1L;
        this.sequenceID = -1L;
        this.usedSequenceId = false;
        this.mType = null;
        this.mStringBuilder = new StringBuilder(100);
    }

    public String getType() {
        return this.mType;
    }

    public ArrayList<BasicNameValuePair> getKvList() {
        return this.mKvLists;
    }

    public void parse(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str)) {
            if (this.mKvLists == null) {
                this.mKvLists = new ArrayList<>();
            }
            this.mKvLists.clear();
            String[] split2 = str.split(ETAG.ITEM_SEPARATOR);
            if (split2 != null && split2.length != 0) {
                for (String str2 : split2) {
                    if (!TextUtils.isEmpty(str2) && (split = str2.split(ETAG.EQUAL)) != null && split.length == 2) {
                        try {
                            this.mKvLists.add(new BasicNameValuePair(split[0], URLDecoder.decode(split[1], "utf-8")));
                        } catch (UnsupportedEncodingException e) {
                            BdLog.e(e);
                        }
                    }
                }
            }
        }
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

    public void setMStringBuilder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mStringBuilder.append(str);
        }
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

    public String getValue(String str) {
        if (this.mKvLists == null || this.mKvLists.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && next.getName() != null && next.getName().equals(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public void setValue(String str, int i) {
        if (this.mKvLists != null && this.mKvLists.size() != 0 && !TextUtils.isEmpty(str)) {
            Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null && next.getName() != null && next.getName().equals(str)) {
                    this.mKvLists.remove(next);
                    this.mKvLists.add(new BasicNameValuePair(str, String.valueOf(i)));
                    return;
                }
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
        return str.replace(HanziToPinyin.Token.SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).replace("[", "(").replace("]", ")").replace(ETAG.ITEM_SEPARATOR, "|");
    }
}
