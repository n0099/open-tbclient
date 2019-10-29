package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {
    private long bZT;
    public int bZV;
    public JSONArray bZW;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> bZU = null;

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

    public void hw(int i) {
        this.bZV = i;
    }

    public int ahr() {
        return this.bZV;
    }

    public void F(JSONArray jSONArray) {
        this.bZW = jSONArray;
    }

    public JSONArray ahs() {
        return this.bZW;
    }

    public long aht() {
        return this.bZT;
    }

    public void aI(long j) {
        this.bZT = j;
    }
}
