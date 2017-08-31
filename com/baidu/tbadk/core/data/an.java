package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class an {
    private String Xe;
    public SparseArray<String> Xf = null;
    private String fid;

    public String getTid() {
        return this.Xe;
    }

    public void cy(String str) {
        this.Xe = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qs() {
        return this.Xf;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Xf = sparseArray;
    }
}
