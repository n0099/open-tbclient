package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class al {
    private String Xf;
    public SparseArray<String> Xg = null;
    private String fid;

    public String getTid() {
        return this.Xf;
    }

    public void cy(String str) {
        this.Xf = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qm() {
        return this.Xg;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Xg = sparseArray;
    }
}
