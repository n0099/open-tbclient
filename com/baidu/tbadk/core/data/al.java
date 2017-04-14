package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class al {
    private String WS;
    public SparseArray<String> WT = null;
    private String fid;

    public String getTid() {
        return this.WS;
    }

    public void cp(String str) {
        this.WS = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> rg() {
        return this.WT;
    }

    public void a(SparseArray<String> sparseArray) {
        this.WT = sparseArray;
    }
}
