package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> anO = null;
    public SparseArray<String> anP = null;
    public int anQ;
    public JSONArray anR;
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

    public SparseArray<String> xt() {
        return this.anO;
    }

    public void a(SparseArray<String> sparseArray) {
        this.anO = sparseArray;
    }

    public void cb(int i) {
        this.anQ = i;
    }

    public int xu() {
        return this.anQ;
    }

    public void h(JSONArray jSONArray) {
        this.anR = jSONArray;
    }

    public JSONArray xv() {
        return this.anR;
    }
}
