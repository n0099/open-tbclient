package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    private long bGK;
    public SparseArray<String> bGL = null;
    public SparseArray<String> bGM = null;
    public int bGN;
    public JSONArray bGO;
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

    public SparseArray<String> ace() {
        return this.bGL;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bGL = sparseArray;
    }

    public void gR(int i) {
        this.bGN = i;
    }

    public int acf() {
        return this.bGN;
    }

    public void x(JSONArray jSONArray) {
        this.bGO = jSONArray;
    }

    public JSONArray acg() {
        return this.bGO;
    }

    public long ach() {
        return this.bGK;
    }

    public void ao(long j) {
        this.bGK = j;
    }
}
