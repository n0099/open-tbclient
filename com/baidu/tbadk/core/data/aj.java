package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    private long bIj;
    public SparseArray<String> bIk = null;
    public SparseArray<String> bIl = null;
    public int bIm;
    public JSONArray bIn;
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

    public SparseArray<String> adl() {
        return this.bIk;
    }

    public void b(SparseArray<String> sparseArray) {
        this.bIk = sparseArray;
    }

    public void gX(int i) {
        this.bIm = i;
    }

    public int adm() {
        return this.bIm;
    }

    public void x(JSONArray jSONArray) {
        this.bIn = jSONArray;
    }

    public JSONArray adn() {
        return this.bIn;
    }

    public long ado() {
        return this.bIj;
    }

    public void ap(long j) {
        this.bIj = j;
    }
}
