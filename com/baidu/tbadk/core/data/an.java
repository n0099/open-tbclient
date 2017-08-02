package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class an {
    private String Ww;
    public SparseArray<String> Wx = null;
    private String fid;

    public String getTid() {
        return this.Ww;
    }

    public void cz(String str) {
        this.Ww = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qm() {
        return this.Wx;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Wx = sparseArray;
    }
}
