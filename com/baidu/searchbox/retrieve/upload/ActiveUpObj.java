package com.baidu.searchbox.retrieve.upload;

import java.util.List;
/* loaded from: classes4.dex */
public class ActiveUpObj {
    public String mDataId;
    public String mFileID;
    public String mFileMeta;
    public String mFileType = "1";
    public List<String> mSpace;
    public String mType;

    public ActiveUpObj(String str, String str2, List<String> list, String str3) {
        this.mType = str;
        this.mDataId = str2;
        this.mSpace = list;
        this.mFileMeta = str3;
    }

    public String getDataId() {
        return this.mDataId;
    }

    public String getFileID() {
        return this.mFileID;
    }

    public String getFileMeta() {
        return this.mFileMeta;
    }

    public String getFileType() {
        return this.mFileType;
    }

    public List<String> getSpace() {
        return this.mSpace;
    }

    public String getType() {
        return this.mType;
    }

    public void setDataId(String str) {
        this.mDataId = str;
    }

    public void setFileID(String str) {
        this.mFileID = str;
    }

    public void setFileMeta(String str) {
        this.mFileMeta = str;
    }

    public void setFileType(String str) {
        this.mFileType = str;
    }

    public void setSpace(List<String> list) {
        this.mSpace = list;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String toString() {
        return "ActiveUpObj{mType='" + this.mType + "', mDataId='" + this.mDataId + "', mSpace='" + this.mSpace.toString() + "', mFileId'" + this.mFileID + "', mFileType'" + this.mFileType + "', mFileMeta='" + this.mFileMeta + "'}";
    }
}
