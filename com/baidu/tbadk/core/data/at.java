package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class at {
    public String abTag;
    public int cardType;
    private long eGV;
    public int eGY;
    public JSONArray eGZ;
    public int eHa;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eGW = null;
    public SparseArray<String> eGX = null;

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

    public void oq(int i) {
        this.eGY = i;
    }

    public int bnm() {
        return this.eGY;
    }

    public void Q(JSONArray jSONArray) {
        this.eGZ = jSONArray;
    }

    public JSONArray bnn() {
        return this.eGZ;
    }

    public long bno() {
        return this.eGV;
    }

    public void dD(long j) {
        this.eGV = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
