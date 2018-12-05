package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ah {
    public SparseArray<String> asc = null;
    public SparseArray<String> asd = null;
    public int ase;
    public JSONArray asf;
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

    public SparseArray<String> yF() {
        return this.asc;
    }

    public void a(SparseArray<String> sparseArray) {
        this.asc = sparseArray;
    }

    public void cE(int i) {
        this.ase = i;
    }

    public int yG() {
        return this.ase;
    }

    public void h(JSONArray jSONArray) {
        this.asf = jSONArray;
    }

    public JSONArray yH() {
        return this.asf;
    }
}
