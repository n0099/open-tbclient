package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class an {
    private String XS;
    public SparseArray<String> XT = null;
    private String fid;

    public String getTid() {
        return this.XS;
    }

    public void cF(String str) {
        this.XS = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qw() {
        return this.XT;
    }

    public void a(SparseArray<String> sparseArray) {
        this.XT = sparseArray;
    }
}
