package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    public JSONArray bzA;
    public SparseArray<String> bzx = null;
    public SparseArray<String> bzy = null;
    public int bzz;
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
        return this.bzx;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bzx = sparseArray;
    }

    public void gf(int i) {
        this.bzz = i;
    }

    public int Xy() {
        return this.bzz;
    }

    public void w(JSONArray jSONArray) {
        this.bzA = jSONArray;
    }

    public JSONArray Xz() {
        return this.bzA;
    }
}
