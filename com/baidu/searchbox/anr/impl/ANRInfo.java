package com.baidu.searchbox.anr.impl;

import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ANRInfo {
    public String mAllStackTracePath;
    public String mCurrentPage;
    public String mLogId;
    public String mLogcatPath;
    public String mStackTrace;
    public String mTimeStamp;
    public String mTracesPath;
    public LinkedList<TrackUI> mTrackUIs;
    public String mType = "anr";

    public ANRInfo(String str, String str2, String str3, String str4, String str5) {
        this.mTimeStamp = str;
        this.mStackTrace = str2;
        this.mLogcatPath = str3;
        this.mTracesPath = str4;
        this.mAllStackTracePath = str5;
    }

    public String getAllStackTracePath() {
        return this.mAllStackTracePath;
    }

    public String getCurrentPage() {
        return this.mCurrentPage;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public String getLogcatPath() {
        return this.mLogcatPath;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getTracesPath() {
        return this.mTracesPath;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        return this.mTrackUIs;
    }

    public String getType() {
        return this.mType;
    }

    public void setAllStackTracePath(String str) {
        this.mAllStackTracePath = str;
    }

    public void setCurrentPage(String str) {
        this.mCurrentPage = str;
    }

    public void setLogId(String str) {
        this.mLogId = str;
    }

    public void setLogcatPath(String str) {
        this.mLogcatPath = str;
    }

    public void setStackTrace(String str) {
        this.mStackTrace = str;
    }

    public void setTimeStamp(String str) {
        this.mTimeStamp = str;
    }

    public void setTracesPath(String str) {
        this.mTracesPath = str;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
