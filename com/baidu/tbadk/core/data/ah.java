package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> asF = null;
    public SparseArray<String> asG = null;
    public int asH;
    public JSONArray asI;
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
        return this.asF;
    }

    public void a(SparseArray<String> sparseArray) {
        this.asF = sparseArray;
    }

    public void cE(int i) {
        this.asH = i;
    }

    public int yT() {
        return this.asH;
    }

    public void h(JSONArray jSONArray) {
        this.asI = jSONArray;
    }

    public JSONArray yU() {
        return this.asI;
    }
}
