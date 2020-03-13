package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class al {
    private long cPB;
    public int cPD;
    public JSONArray cPE;
    public String cPF;
    public int cPG;
    public int cardType;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> cPC = null;

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

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public void setFeedBackReasonMap(SparseArray<String> sparseArray) {
        this.feedBackReasonMap = sparseArray;
    }

    public void jy(int i) {
        this.cPD = i;
    }

    public int aAS() {
        return this.cPD;
    }

    public void M(JSONArray jSONArray) {
        this.cPE = jSONArray;
    }

    public JSONArray aAT() {
        return this.cPE;
    }

    public long aAU() {
        return this.cPB;
    }

    public void bt(long j) {
        this.cPB = j;
    }
}
