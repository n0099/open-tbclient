package com.baidu.searchbox.cloudcommand.dao;
/* loaded from: classes3.dex */
public class CloudCommandBean {
    public int mDispatched;
    public String mMsgId;
    public long mTimeStamp;
    public String mType;
    public String mVersion;

    public int getDispatched() {
        return this.mDispatched;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getType() {
        return this.mType;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setDispatched(int i) {
        this.mDispatched = i;
    }

    public void setMsgId(String str) {
        this.mMsgId = str;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }
}
