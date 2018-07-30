package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> agt = null;
    public SparseArray<String> agu = null;
    public int agv;
    public JSONArray agw;
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

    public SparseArray<String> ui() {
        return this.agt;
    }

    public void a(SparseArray<String> sparseArray) {
        this.agt = sparseArray;
    }

    public void bH(int i) {
        this.agv = i;
    }

    public int uj() {
        return this.agv;
    }

    public void c(JSONArray jSONArray) {
        this.agw = jSONArray;
    }

    public JSONArray uk() {
        return this.agw;
    }
}
