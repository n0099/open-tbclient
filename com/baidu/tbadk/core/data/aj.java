package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    public SparseArray<String> bzu = null;
    public SparseArray<String> bzv = null;
    public int bzw;
    public JSONArray bzx;
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
        return this.bzu;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bzu = sparseArray;
    }

    public void gg(int i) {
        this.bzw = i;
    }

    public int XB() {
        return this.bzw;
    }

    public void w(JSONArray jSONArray) {
        this.bzx = jSONArray;
    }

    public JSONArray XC() {
        return this.bzx;
    }
}
