package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ak {
    public String abTag;
    public int cardType;
    private long dCX;
    public int dCZ;
    public JSONArray dDa;
    public int dDb;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> dCY = null;

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

    public void kf(int i) {
        this.dCZ = i;
    }

    public int aPb() {
        return this.dCZ;
    }

    public void M(JSONArray jSONArray) {
        this.dDa = jSONArray;
    }

    public JSONArray aPc() {
        return this.dDa;
    }

    public long aPd() {
        return this.dCX;
    }

    public void bY(long j) {
        this.dCX = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
