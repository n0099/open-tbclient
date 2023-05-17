package com.baidu.searchbox.retrieve.upload;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public class FetchTaskObj {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchTaskObj";
    public String mFileID;
    public String mFileMeta;
    public String mJobID;
    public String mOrigin;
    public String mStatus;
    public String mType;
    public String mValue;
    public String mVersion;

    public String getFileID() {
        return this.mFileID;
    }

    public String getFileMeta() {
        return this.mFileMeta;
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

    public FetchTaskObj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mType = str;
        this.mValue = str2;
        this.mJobID = str3;
        this.mVersion = str4;
        this.mStatus = str5;
        this.mOrigin = str6;
        this.mFileMeta = str7;
    }

    public void setFileID(String str) {
        this.mFileID = str;
    }

    public void setFileMeta(String str) {
        this.mFileMeta = str;
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
