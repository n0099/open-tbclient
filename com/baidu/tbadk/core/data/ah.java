package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> aiT = null;
    public SparseArray<String> aiU = null;
    public int aiV;
    public JSONArray aiW;
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

    public SparseArray<String> vk() {
        return this.aiT;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aiT = sparseArray;
    }

    public void bQ(int i) {
        this.aiV = i;
    }

    public int vl() {
        return this.aiV;
    }

    public void g(JSONArray jSONArray) {
        this.aiW = jSONArray;
    }

    public JSONArray vm() {
        return this.aiW;
    }
}
