package com.baidu.swan.apps.storage;
/* loaded from: classes2.dex */
public class a {
    private long aSN;
    private long aSO;
    private String mPath;

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public long getSize() {
        return this.aSN;
    }

    public void setSize(long j) {
        this.aSN = j;
    }

    public long KB() {
        return this.aSO;
    }

    public void I(long j) {
        this.aSO = j;
    }
}
