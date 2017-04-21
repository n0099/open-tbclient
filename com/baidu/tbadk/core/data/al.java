package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class al {
    private String WT;
    public SparseArray<String> WU = null;
    private String fid;

    public String getTid() {
        return this.WT;
    }

    public void cp(String str) {
        this.WT = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> rg() {
        return this.WU;
    }

    public void a(SparseArray<String> sparseArray) {
        this.WU = sparseArray;
    }
}
