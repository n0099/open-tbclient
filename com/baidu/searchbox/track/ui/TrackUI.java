package com.baidu.searchbox.track.ui;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class TrackUI {
    private static final String SEPERATOR = "\t";
    private static final String SEPERATOR_ARROR = "->";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");
    private String mActivityPage;
    private String mActivityPageTag;
    private String mEvent;
    private String mFragmentPage;
    private String mFragmentPageTag;
    private String mPageName;
    private String mPageTag;
    private long mTimeStamp;
    private String mType;

    public TrackUI(String str, String str2, String str3, String str4, long j, String str5) {
        this.mActivityPage = str;
        this.mActivityPageTag = str2;
        this.mFragmentPage = str3;
        this.mFragmentPageTag = str4;
        this.mTimeStamp = j;
        this.mEvent = str5;
    }

    public TrackUI(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8) {
        this.mActivityPage = str;
        this.mActivityPageTag = str2;
        this.mFragmentPage = str3;
        this.mFragmentPageTag = str4;
        this.mPageName = str5;
        this.mPageTag = str6;
        this.mType = str7;
        this.mTimeStamp = j;
        this.mEvent = str8;
    }

    public static String getTime(long j) {
        return simpleDateFormat.format(new Date(j));
    }

    public static String[] parse(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(SEPERATOR)) == null || split.length != 4) {
            return null;
        }
        return split;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getFragmentPage() {
        return this.mFragmentPage;
    }

    public String getFragmentPageTag() {
        return this.mFragmentPageTag;
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getActivityPage() {
        return this.mActivityPage;
    }

    public String getActivityPageTag() {
        return this.mActivityPageTag;
    }

    public String getPageName() {
        return this.mPageName;
    }

    public String getPageTag() {
        return this.mPageTag;
    }

    public String getType() {
        return this.mType;
    }

    @Deprecated
    public String toString() {
        StringBuilder append = new StringBuilder(getTime(this.mTimeStamp)).append(SEPERATOR).append(this.mTimeStamp).append(SEPERATOR).append(this.mActivityPage).append(this.mActivityPageTag);
        if (!TextUtils.isEmpty(this.mFragmentPage)) {
            append.append("->").append(this.mFragmentPage);
            if (!TextUtils.isEmpty(this.mFragmentPageTag)) {
                append.append(this.mFragmentPageTag);
            }
        }
        append.append(SEPERATOR).append(this.mEvent);
        return append.toString();
    }

    @Deprecated
    public String toStringPage() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mActivityPage)) {
            sb.append(this.mActivityPage).append(this.mActivityPageTag);
        }
        if (!TextUtils.isEmpty(this.mFragmentPage)) {
            sb.append("->");
            sb.append(this.mFragmentPage).append(this.mFragmentPageTag);
        }
        return sb.toString();
    }
}
