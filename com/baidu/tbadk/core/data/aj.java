package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    private long bGJ;
    public SparseArray<String> bGK = null;
    public SparseArray<String> bGL = null;
    public int bGM;
    public JSONArray bGN;
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
        return this.bGK;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bGK = sparseArray;
    }

    public void gR(int i) {
        this.bGM = i;
    }

    public int acf() {
        return this.bGM;
    }

    public void x(JSONArray jSONArray) {
        this.bGN = jSONArray;
    }

    public JSONArray acg() {
        return this.bGN;
    }

    public long ach() {
        return this.bGJ;
    }

    public void ao(long j) {
        this.bGJ = j;
    }
}
