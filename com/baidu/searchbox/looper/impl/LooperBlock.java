package com.baidu.searchbox.looper.impl;

import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
import java.util.UUID;
/* loaded from: classes3.dex */
public class LooperBlock {
    public String mCpuRateInfo;
    public String mCurrentPage;
    public String mDuration;
    public String mEndLagTime;
    public StringBuilder mStackSb;
    public String mStartLagTime;
    public LinkedList<TrackUI> mTrackUIs;
    public String mType = "looper";
    public String mLogID = UUID.randomUUID().toString().replace("-", "");

    public LooperBlock(String str, String str2, String str3, String str4, StringBuilder sb) {
        this.mDuration = str;
        this.mCpuRateInfo = str2;
        this.mStartLagTime = str3;
        this.mEndLagTime = str4;
        this.mStackSb = sb;
    }

    public String getCpuRateInfo() {
        return this.mCpuRateInfo;
    }

    public String getCurrentPage() {
        return this.mCurrentPage;
    }

    public String getDuration() {
        return this.mDuration;
    }

    public String getEndLagTime() {
        return this.mEndLagTime;
    }

    public String getLogID() {
        return this.mLogID;
    }

    public StringBuilder getStackSb() {
        return this.mStackSb;
    }

    public String getStartLagTime() {
        return this.mStartLagTime;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        return this.mTrackUIs;
    }

    public String getType() {
        return this.mType;
    }

    public void setCurrentPage(String str) {
        this.mCurrentPage = str;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }
}
