package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class al {
    public int cardType;
    private long doY;
    public int dpa;
    public JSONArray dpb;
    public String dpc;
    public int dpd;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> doZ = null;

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

    public void jF(int i) {
        this.dpa = i;
    }

    public int aJg() {
        return this.dpa;
    }

    public void N(JSONArray jSONArray) {
        this.dpb = jSONArray;
    }

    public JSONArray aJh() {
        return this.dpb;
    }

    public long aJi() {
        return this.doY;
    }

    public void bY(long j) {
        this.doY = j;
    }
}
