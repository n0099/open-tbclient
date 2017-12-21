package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> XB = null;
    private String fid;
    private String tid;

    public String getTid() {
        return this.tid;
    }

    public void cD(String str) {
        this.tid = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> ql() {
        return this.XB;
    }

    public void a(SparseArray<String> sparseArray) {
        this.XB = sparseArray;
    }
}
