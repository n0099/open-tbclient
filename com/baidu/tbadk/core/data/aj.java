package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    public SparseArray<String> bzs = null;
    public SparseArray<String> bzt = null;
    public int bzu;
    public JSONArray bzv;
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

    public SparseArray<String> XA() {
        return this.bzs;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bzs = sparseArray;
    }

    public void gg(int i) {
        this.bzu = i;
    }

    public int XB() {
        return this.bzu;
    }

    public void w(JSONArray jSONArray) {
        this.bzv = jSONArray;
    }

    public JSONArray XC() {
        return this.bzv;
    }
}
