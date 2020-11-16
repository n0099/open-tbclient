package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class as {
    public String abTag;
    public int cardType;
    public JSONArray eAa;
    public int eAb;
    public String extra;
    private long ezW;
    public int ezZ;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> ezX = null;
    public SparseArray<String> ezY = null;

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

    public void nS(int i) {
        this.ezZ = i;
    }

    public int bjZ() {
        return this.ezZ;
    }

    public void P(JSONArray jSONArray) {
        this.eAa = jSONArray;
    }

    public JSONArray bka() {
        return this.eAa;
    }

    public long bkb() {
        return this.ezW;
    }

    public void de(long j) {
        this.ezW = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
