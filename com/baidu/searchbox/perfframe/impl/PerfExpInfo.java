package com.baidu.searchbox.perfframe.impl;

import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class PerfExpInfo {
    public String mBusiness;
    public String mException;
    public boolean mIsNeedDynamicperf;
    public boolean mIsNeedMainStackTrace;
    public boolean mIsNeedPageTrace;
    public boolean mIsNeedStaticperf;
    public long mLaunchTime;
    public String mLogId;
    public String mPage;
    public long mTime;
    public LinkedList<TrackUI> mTrackUIs;
    public String mType;
    public String mUbcId;

    public PerfExpInfo(String str, String str2, long j, long j2, String str3, String str4, String str5) {
        this.mUbcId = str;
        this.mType = str2;
        this.mTime = j;
        this.mLaunchTime = j2;
        this.mException = str3;
        this.mPage = str4;
        this.mBusiness = str5;
    }

    public String getBusiness() {
        return this.mBusiness;
    }

    public String getException() {
        return this.mException;
    }

    public long getLaunchTime() {
        return this.mLaunchTime;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getProcessDuration() {
        return String.valueOf(getTime() - getLaunchTime());
    }

    public long getTime() {
        return this.mTime;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        return this.mTrackUIs;
    }

    public String getType() {
        return this.mType;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    public boolean isNeedDynamicperf() {
        return this.mIsNeedDynamicperf;
    }

    public boolean isNeedMainStackTrace() {
        return this.mIsNeedMainStackTrace;
    }

    public boolean isNeedPageTrace() {
        return this.mIsNeedPageTrace;
    }

    public boolean isNeedStaticperf() {
        return this.mIsNeedStaticperf;
    }

    public void setBusiness(String str) {
        this.mBusiness = str;
    }

    public void setException(String str) {
        this.mException = str;
    }

    public void setLaunchTime(long j) {
        this.mLaunchTime = j;
    }

    public void setLogId(String str) {
        this.mLogId = str;
    }

    public void setNeedDynamicperf(boolean z) {
        this.mIsNeedDynamicperf = z;
    }

    public void setNeedMainStackTrace(boolean z) {
        this.mIsNeedMainStackTrace = z;
    }

    public void setNeedPageTrace(boolean z) {
        this.mIsNeedPageTrace = z;
    }

    public void setNeedStaticperf(boolean z) {
        this.mIsNeedStaticperf = z;
    }

    public void setPage(String str) {
        this.mPage = str;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setUbcId(String str) {
        this.mUbcId = str;
    }

    public String toString() {
        return "PerfExpInfo{mUbcId='" + this.mUbcId + "', mType='" + this.mType + "', mLogId='" + this.mLogId + "', mTime=" + this.mTime + ", mException='" + this.mException + "', mPage='" + this.mPage + "', mLaunchTime=" + this.mLaunchTime + ", mBusiness='" + this.mBusiness + "', mTrackUIs=" + this.mTrackUIs + ", mIsNeedPageTrace=" + this.mIsNeedPageTrace + ", mIsNeedDynamicperf=" + this.mIsNeedDynamicperf + ", mIsNeedStaticperf=" + this.mIsNeedStaticperf + ", mIsNeedMainStackTrace=" + this.mIsNeedMainStackTrace + '}';
    }
}
