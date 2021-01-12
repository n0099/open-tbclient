package com.baidu.searchbox.perfframe.impl;

import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
/* loaded from: classes14.dex */
public class PerfExpInfo {
    private String mBusiness;
    private String mException;
    private boolean mIsNeedDynamicperf;
    private boolean mIsNeedMainStackTrace;
    private boolean mIsNeedPageTrace;
    private boolean mIsNeedStaticperf;
    private long mLaunchTime;
    private String mLogId;
    private String mPage;
    private long mTime;
    private LinkedList<TrackUI> mTrackUIs;
    private String mType;
    private String mUbcId;

    public PerfExpInfo(String str, String str2, long j, long j2, String str3, String str4, String str5) {
        this.mUbcId = str;
        this.mType = str2;
        this.mTime = j;
        this.mLaunchTime = j2;
        this.mException = str3;
        this.mPage = str4;
        this.mBusiness = str5;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public void setLogId(String str) {
        this.mLogId = str;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    public void setUbcId(String str) {
        this.mUbcId = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public String getException() {
        return this.mException;
    }

    public void setException(String str) {
        this.mException = str;
    }

    public String getPage() {
        return this.mPage;
    }

    public void setPage(String str) {
        this.mPage = str;
    }

    public String getBusiness() {
        return this.mBusiness;
    }

    public void setBusiness(String str) {
        this.mBusiness = str;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        return this.mTrackUIs;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }

    public boolean isNeedPageTrace() {
        return this.mIsNeedPageTrace;
    }

    public void setNeedPageTrace(boolean z) {
        this.mIsNeedPageTrace = z;
    }

    public boolean isNeedDynamicperf() {
        return this.mIsNeedDynamicperf;
    }

    public void setNeedDynamicperf(boolean z) {
        this.mIsNeedDynamicperf = z;
    }

    public boolean isNeedStaticperf() {
        return this.mIsNeedStaticperf;
    }

    public void setNeedStaticperf(boolean z) {
        this.mIsNeedStaticperf = z;
    }

    public boolean isNeedMainStackTrace() {
        return this.mIsNeedMainStackTrace;
    }

    public void setNeedMainStackTrace(boolean z) {
        this.mIsNeedMainStackTrace = z;
    }

    public long getLaunchTime() {
        return this.mLaunchTime;
    }

    public void setLaunchTime(long j) {
        this.mLaunchTime = j;
    }

    public String getProcessDuration() {
        return String.valueOf(getTime() - getLaunchTime());
    }

    public String toString() {
        return "PerfExpInfo{mUbcId='" + this.mUbcId + "', mType='" + this.mType + "', mLogId='" + this.mLogId + "', mTime=" + this.mTime + ", mException='" + this.mException + "', mPage='" + this.mPage + "', mLaunchTime=" + this.mLaunchTime + ", mBusiness='" + this.mBusiness + "', mTrackUIs=" + this.mTrackUIs + ", mIsNeedPageTrace=" + this.mIsNeedPageTrace + ", mIsNeedDynamicperf=" + this.mIsNeedDynamicperf + ", mIsNeedStaticperf=" + this.mIsNeedStaticperf + ", mIsNeedMainStackTrace=" + this.mIsNeedMainStackTrace + '}';
    }
}
