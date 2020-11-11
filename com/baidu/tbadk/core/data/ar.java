package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ar {
    public String abTag;
    public int cardType;
    private long eBF;
    public int eBI;
    public JSONArray eBJ;
    public int eBK;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eBG = null;
    public SparseArray<String> eBH = null;

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

    public void nW(int i) {
        this.eBI = i;
    }

    public int bkX() {
        return this.eBI;
    }

    public void P(JSONArray jSONArray) {
        this.eBJ = jSONArray;
    }

    public JSONArray bkY() {
        return this.eBJ;
    }

    public long bkZ() {
        return this.eBF;
    }

    public void de(long j) {
        this.eBF = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
