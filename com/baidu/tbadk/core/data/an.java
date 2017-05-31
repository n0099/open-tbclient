package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class an {
    private String Wg;
    public SparseArray<String> Wh = null;
    private String fid;

    public String getTid() {
        return this.Wg;
    }

    public void co(String str) {
        this.Wg = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qm() {
        return this.Wh;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Wh = sparseArray;
    }
}
