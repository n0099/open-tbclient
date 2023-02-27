package com.baidu.searchbox.block.impl;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class BlockInfo {
    public String mCurrentPage;
    public String mLogId;
    public String mStackTrace;
    public String mTimeStamp;
    public LinkedList<TrackUI> mTrackUIs;
    public String mType = BreakpointSQLiteHelper.BLOCK_TABLE_NAME;

    public BlockInfo(String str, String str2) {
        this.mTimeStamp = str;
        this.mStackTrace = str2;
    }

    public String getCurrentPage() {
        return this.mCurrentPage;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
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

    public void setLogId(String str) {
        this.mLogId = str;
    }

    public void setStackTrace(String str) {
        this.mStackTrace = str;
    }

    public void setTimeStamp(String str) {
        this.mTimeStamp = str;
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        this.mTrackUIs = linkedList;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
