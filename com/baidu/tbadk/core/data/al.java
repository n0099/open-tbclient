package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class al {
    public int cardType;
    private long doU;
    public int doW;
    public JSONArray doX;
    public String doY;
    public int doZ;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> doV = null;

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
        this.doW = i;
    }

    public int aJi() {
        return this.doW;
    }

    public void N(JSONArray jSONArray) {
        this.doX = jSONArray;
    }

    public JSONArray aJj() {
        return this.doX;
    }

    public long aJk() {
        return this.doU;
    }

    public void bY(long j) {
        this.doU = j;
    }
}
