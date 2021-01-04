package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class at {
    public String abTag;
    public int cardType;
    private long eQM;
    public int eQP;
    public JSONArray eQQ;
    public int eQR;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eQN = null;
    public SparseArray<String> eQO = null;

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

    public void oA(int i) {
        this.eQP = i;
    }

    public int bpL() {
        return this.eQP;
    }

    public void Q(JSONArray jSONArray) {
        this.eQQ = jSONArray;
    }

    public JSONArray bpM() {
        return this.eQQ;
    }

    public long bpN() {
        return this.eQM;
    }

    public void dD(long j) {
        this.eQM = j;
    }

    public String bpO() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
