package com.baidu.searchbox.looper.impl;

import com.baidu.searchbox.track.ui.TrackUI;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedList;
import java.util.UUID;
/* loaded from: classes6.dex */
public class LooperBlock {
    private String mCpuRateInfo;
    private String mCurrentPage;
    private String mDuration;
    private String mEndLagTime;
    private StringBuilder mStackSb;
    private String mStartLagTime;
    private LinkedList<TrackUI> mTrackUIs;
    private String mType = "looper";
    private String mLogID = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

    public LooperBlock(String str, String str2, String str3, String str4, StringBuilder sb) {
        this.mDuration = str;
        this.mCpuRateInfo = str2;
        this.mStartLagTime = str3;
        this.mEndLagTime = str4;
        this.mStackSb = sb;
    }

    public String getStartLagTime() {
        return this.mStartLagTime;
    }

    public String getEndLagTime() {
        return this.mEndLagTime;
    }

    public StringBuilder getStackSb() {
        return this.mStackSb;
    }

    public String getLogID() {
        return this.mLogID;
    }

    public String getDuration() {
        return this.mDuration;
    }

    public String getCpuRateInfo() {
        return this.mCpuRateInfo;
    }

    public String getCurrentPage() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(String str) {
        this.mCurrentPage = str;
    }

    public String getType() {
        return this.mType;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        return this.mTrackUIs;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }
}
