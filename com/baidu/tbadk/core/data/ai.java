package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ai {
    public SparseArray<String> agZ = null;
    public SparseArray<String> aha = null;
    public int ahb;
    public JSONArray ahc;
    private String fid;
    private String tid;
    private String type;

    public String getTid() {
        return this.tid;
    }

    public void dk(String str) {
        this.tid = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
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

    public SparseArray<String> uv() {
        return this.agZ;
    }

    public void a(SparseArray<String> sparseArray) {
        this.agZ = sparseArray;
    }

    public void bF(int i) {
        this.ahb = i;
    }

    public int uw() {
        return this.ahb;
    }

    public void c(JSONArray jSONArray) {
        this.ahc = jSONArray;
    }

    public JSONArray ux() {
        return this.ahc;
    }
}
