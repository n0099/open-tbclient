package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aq {
    public String abTag;
    public int cardType;
    private long dPD;
    public int dPG;
    public JSONArray dPH;
    public int dPI;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> dPE = null;
    public SparseArray<String> dPF = null;

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

    public void kN(int i) {
        this.dPG = i;
    }

    public int aUI() {
        return this.dPG;
    }

    public void N(JSONArray jSONArray) {
        this.dPH = jSONArray;
    }

    public JSONArray aUJ() {
        return this.dPH;
    }

    public long aUK() {
        return this.dPD;
    }

    public void cn(long j) {
        this.dPD = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
