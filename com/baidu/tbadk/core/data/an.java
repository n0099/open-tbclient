package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class an {
    private String XV;
    public SparseArray<String> XW = null;
    private String fid;

    public String getTid() {
        return this.XV;
    }

    public void cI(String str) {
        this.XV = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qx() {
        return this.XW;
    }

    public void a(SparseArray<String> sparseArray) {
        this.XW = sparseArray;
    }
}
