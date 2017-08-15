package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class an {
    private String XU;
    public SparseArray<String> XV = null;
    private String fid;

    public String getTid() {
        return this.XU;
    }

    public void cF(String str) {
        this.XU = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qw() {
        return this.XV;
    }

    public void a(SparseArray<String> sparseArray) {
        this.XV = sparseArray;
    }
}
