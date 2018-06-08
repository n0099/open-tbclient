package com.baidu.tbadk.core.data;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ai {
    public SparseArray<String> agK = null;
    private String fid;
    private String tid;
    private String type;

    public String getTid() {
        return this.tid;
    }

    public void dh(String str) {
        this.tid = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = String.valueOf(j);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public SparseArray<String> up() {
        return this.agK;
    }

    public void a(SparseArray<String> sparseArray) {
        this.agK = sparseArray;
    }
}
