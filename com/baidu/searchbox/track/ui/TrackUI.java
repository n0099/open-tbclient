package com.baidu.searchbox.track.ui;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class TrackUI {
    public static final String SEPERATOR = "\t";
    public static final String SEPERATOR_ARROR = "->";
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");
    public String mActivityPage;
    public String mActivityPageTag;
    public String mEvent;
    public String mFragmentPage;
    public String mFragmentPageTag;
    public String mPageName;
    public String mPageTag;
    public long mTimeStamp;
    public String mType;

    public String getActivityPage() {
        return this.mActivityPage;
    }

    public String getActivityPageTag() {
        return this.mActivityPageTag;
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getFragmentPage() {
        return this.mFragmentPage;
    }

    public String getFragmentPageTag() {
        return this.mFragmentPageTag;
    }

    public String getPageName() {
        return this.mPageName;
    }

    public String getPageTag() {
        return this.mPageTag;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getType() {
        return this.mType;
    }

    public TrackUI(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, long j, @NonNull String str5) {
        this.mActivityPage = str;
        this.mActivityPageTag = str2;
        this.mFragmentPage = str3;
        this.mFragmentPageTag = str4;
        this.mTimeStamp = j;
        this.mEvent = str5;
    }

    public TrackUI(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j, @NonNull String str8) {
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

    @Nullable
    public static String[] parse(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("\t")) == null || split.length != 4) {
            return null;
        }
        return split;
    }

    @NonNull
    @Deprecated
    public String toString() {
        StringBuilder sb = new StringBuilder(getTime(this.mTimeStamp));
        sb.append("\t");
        sb.append(this.mTimeStamp);
        sb.append("\t");
        sb.append(this.mActivityPage);
        sb.append(this.mActivityPageTag);
        if (!TextUtils.isEmpty(this.mFragmentPage)) {
            sb.append("->");
            sb.append(this.mFragmentPage);
            if (!TextUtils.isEmpty(this.mFragmentPageTag)) {
                sb.append(this.mFragmentPageTag);
            }
        }
        sb.append("\t");
        sb.append(this.mEvent);
        return sb.toString();
    }

    @Deprecated
    public String toStringPage() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mActivityPage)) {
            sb.append(this.mActivityPage);
            sb.append(this.mActivityPageTag);
        }
        if (!TextUtils.isEmpty(this.mFragmentPage)) {
            sb.append("->");
            sb.append(this.mFragmentPage);
            sb.append(this.mFragmentPageTag);
        }
        return sb.toString();
    }
}
