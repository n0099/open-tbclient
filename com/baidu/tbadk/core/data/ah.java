package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> asE = null;
    public SparseArray<String> asF = null;
    public int asG;
    public JSONArray asH;
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

    public SparseArray<String> yS() {
        return this.asE;
    }

    public void a(SparseArray<String> sparseArray) {
        this.asE = sparseArray;
    }

    public void cE(int i) {
        this.asG = i;
    }

    public int yT() {
        return this.asG;
    }

    public void h(JSONArray jSONArray) {
        this.asH = jSONArray;
    }

    public JSONArray yU() {
        return this.asH;
    }
}
