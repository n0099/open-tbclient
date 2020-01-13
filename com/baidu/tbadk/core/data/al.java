package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class al {
    public String cLA;
    public int cLB;
    private long cLw;
    public int cLy;
    public JSONArray cLz;
    public int cardType;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> cLx = null;

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

    public void jg(int i) {
        this.cLy = i;
    }

    public int ayC() {
        return this.cLy;
    }

    public void M(JSONArray jSONArray) {
        this.cLz = jSONArray;
    }

    public JSONArray ayD() {
        return this.cLz;
    }

    public long ayE() {
        return this.cLw;
    }

    public void bp(long j) {
        this.cLw = j;
    }
}
