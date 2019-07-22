package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    private long bHK;
    public SparseArray<String> bHL = null;
    public SparseArray<String> bHM = null;
    public int bHN;
    public JSONArray bHO;
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

    public SparseArray<String> adg() {
        return this.bHL;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bHL = sparseArray;
    }

    public void gW(int i) {
        this.bHN = i;
    }

    public int adh() {
        return this.bHN;
    }

    public void x(JSONArray jSONArray) {
        this.bHO = jSONArray;
    }

    public JSONArray adi() {
        return this.bHO;
    }

    public long adj() {
        return this.bHK;
    }

    public void ap(long j) {
        this.bHK = j;
    }
}
