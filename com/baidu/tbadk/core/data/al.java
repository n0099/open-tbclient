package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class al {
    private String Xl;
    public SparseArray<String> Xm = null;
    private String fid;

    public String getTid() {
        return this.Xl;
    }

    public void cD(String str) {
        this.Xl = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qk() {
        return this.Xm;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Xm = sparseArray;
    }
}
