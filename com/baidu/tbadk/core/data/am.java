package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class am {
    private String WD;
    public SparseArray<String> WE = null;
    private String fid;

    public String getTid() {
        return this.WD;
    }

    public void ci(String str) {
        this.WD = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qJ() {
        return this.WE;
    }

    public void a(SparseArray<String> sparseArray) {
        this.WE = sparseArray;
    }
}
