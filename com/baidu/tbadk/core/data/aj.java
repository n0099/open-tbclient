package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    private long bHL;
    public SparseArray<String> bHM = null;
    public SparseArray<String> bHN = null;
    public int bHO;
    public JSONArray bHP;
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

    public SparseArray<String> adh() {
        return this.bHM;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bHM = sparseArray;
    }

    public void gW(int i) {
        this.bHO = i;
    }

    public int adi() {
        return this.bHO;
    }

    public void x(JSONArray jSONArray) {
        this.bHP = jSONArray;
    }

    public JSONArray adj() {
        return this.bHP;
    }

    public long adk() {
        return this.bHL;
    }

    public void ap(long j) {
        this.bHL = j;
    }
}
