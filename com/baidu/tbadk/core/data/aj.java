package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    public int bzA;
    public JSONArray bzB;
    public SparseArray<String> bzy = null;
    public SparseArray<String> bzz = null;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;

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

    public SparseArray<String> Xx() {
        return this.bzy;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bzy = sparseArray;
    }

    public void gf(int i) {
        this.bzA = i;
    }

    public int Xy() {
        return this.bzA;
    }

    public void w(JSONArray jSONArray) {
        this.bzB = jSONArray;
    }

    public JSONArray Xz() {
        return this.bzB;
    }
}
