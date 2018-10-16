package com.baidu.searchbox.ng.ai.apps.storage;
/* loaded from: classes2.dex */
public class FileInfo {
    private String mDigest;
    private long mFileSavedTime;
    private String mPath;
    private long mSize;

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public String getDigest() {
        return this.mDigest;
    }

    public void setDigest(String str) {
        this.mDigest = str;
    }

    public long getCreatedTime() {
        return this.mFileSavedTime;
    }

    public void setCreatedTime(long j) {
        this.mFileSavedTime = j;
    }
}
