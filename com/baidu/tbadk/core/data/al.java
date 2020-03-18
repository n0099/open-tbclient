package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class al {
    private long cPO;
    public int cPQ;
    public JSONArray cPR;
    public String cPS;
    public int cPT;
    public int cardType;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> cPP = null;

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
        this.cPQ = i;
    }

    public int aAV() {
        return this.cPQ;
    }

    public void M(JSONArray jSONArray) {
        this.cPR = jSONArray;
    }

    public JSONArray aAW() {
        return this.cPR;
    }

    public long aAX() {
        return this.cPO;
    }

    public void bt(long j) {
        this.cPO = j;
    }
}
