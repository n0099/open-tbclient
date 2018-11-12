package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> aoB = null;
    public SparseArray<String> aoC = null;
    public int aoD;
    public JSONArray aoE;
    private String fid;
    private String tid;
    private String type;

    public String getTid() {
        return this.tid;
    }

    public void setTid(String str) {
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

    public SparseArray<String> xB() {
        return this.aoB;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aoB = sparseArray;
    }

    public void cq(int i) {
        this.aoD = i;
    }

    public int xC() {
        return this.aoD;
    }

    public void h(JSONArray jSONArray) {
        this.aoE = jSONArray;
    }

    public JSONArray xD() {
        return this.aoE;
    }
}
