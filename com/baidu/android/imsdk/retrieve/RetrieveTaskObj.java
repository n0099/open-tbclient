package com.baidu.android.imsdk.retrieve;
/* loaded from: classes2.dex */
public class RetrieveTaskObj {
    public static final String TAG = "RetrieveTaskObj";
    public String mFileMeta;
    public String mFileid;
    public String mJobID;
    public String mOrigin;
    public String mStatus;
    public String mType;
    public String mValue;
    public String mVersion;

    public RetrieveTaskObj(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.mType = str;
        this.mValue = str2;
        this.mJobID = str3;
        this.mVersion = str4;
        this.mStatus = str5;
        this.mOrigin = str6;
        this.mFileMeta = str7;
        this.mFileid = str8;
    }

    public String getFileMeta() {
        return this.mFileMeta;
    }

    public String getFileid() {
        return this.mFileid;
    }

    public String getJobID() {
        return this.mJobID;
    }

    public String getOrigin() {
        return this.mOrigin;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getType() {
        return this.mType;
    }

    public String getValue() {
        return this.mValue;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setFileMeta(String str) {
        this.mFileMeta = str;
    }

    public void setFileid(String str) {
        this.mFileid = str;
    }

    public void setJobID(String str) {
        this.mJobID = str;
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "FetchTaskObj{mType='" + this.mType + "', mValue='" + this.mValue + "', mJobID='" + this.mJobID + "', mVersion='" + this.mVersion + "', mStatus='" + this.mStatus + "', mOrigin='" + this.mOrigin + "', mFileMeta='" + this.mFileMeta + "'}";
    }
}
