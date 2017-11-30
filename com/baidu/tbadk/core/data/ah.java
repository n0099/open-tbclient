package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> XE = null;
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

    public SparseArray<String> qn() {
        return this.XE;
    }

    public void a(SparseArray<String> sparseArray) {
        this.XE = sparseArray;
    }
}
