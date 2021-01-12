package com.baidu.android.imsdk.retrieve;
/* loaded from: classes3.dex */
public class RetrieveTaskObj {
    private static final String TAG = "RetrieveTaskObj";
    private String mFileMeta;
    private String mFileid;
    private String mJobID;
    private String mOrigin;
    private String mStatus;
    private String mType;
    private String mValue;
    private String mVersion;

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

    public String getFileid() {
        return this.mFileid;
    }

    public void setFileid(String str) {
        this.mFileid = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String getJobID() {
        return this.mJobID;
    }

    public void setJobID(String str) {
        this.mJobID = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getOrigin() {
        return this.mOrigin;
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
    }

    public String getFileMeta() {
        return this.mFileMeta;
    }

    public void setFileMeta(String str) {
        this.mFileMeta = str;
    }

    public String toString() {
        return "FetchTaskObj{mType='" + this.mType + "', mValue='" + this.mValue + "', mJobID='" + this.mJobID + "', mVersion='" + this.mVersion + "', mStatus='" + this.mStatus + "', mOrigin='" + this.mOrigin + "', mFileMeta='" + this.mFileMeta + "'}";
    }
}
