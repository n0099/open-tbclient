package com.baidu.searchbox.anr.impl;

import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ANRInfo {
    private String mAllStackTracePath;
    private String mCurrentPage;
    private String mLogId;
    private String mLogcatPath;
    private String mStackTrace;
    private String mTimeStamp;
    private String mTracesPath;
    private LinkedList<TrackUI> mTrackUIs;
    private String mType = "anr";

    public ANRInfo(String str, String str2, String str3, String str4, String str5) {
        this.mTimeStamp = str;
        this.mStackTrace = str2;
        this.mLogcatPath = str3;
        this.mTracesPath = str4;
        this.mAllStackTracePath = str5;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        return this.mTrackUIs;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }

    public String getCurrentPage() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(String str) {
        this.mCurrentPage = str;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(String str) {
        this.mTimeStamp = str;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public void setStackTrace(String str) {
        this.mStackTrace = str;
    }

    public String getLogcatPath() {
        return this.mLogcatPath;
    }

    public void setLogcatPath(String str) {
        this.mLogcatPath = str;
    }

    public String getTracesPath() {
        return this.mTracesPath;
    }

    public void setTracesPath(String str) {
        this.mTracesPath = str;
    }

    public String getAllStackTracePath() {
        return this.mAllStackTracePath;
    }

    public void setAllStackTracePath(String str) {
        this.mAllStackTracePath = str;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public void setLogId(String str) {
        this.mLogId = str;
    }
}
