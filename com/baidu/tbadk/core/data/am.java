package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class am {
    private String Wl;
    public SparseArray<String> Wm = null;
    private String fid;

    public String getTid() {
        return this.Wl;
    }

    public void cp(String str) {
        this.Wl = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public SparseArray<String> qq() {
        return this.Wm;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Wm = sparseArray;
    }
}
