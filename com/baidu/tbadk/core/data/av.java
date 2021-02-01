package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class av {
    public String abTag;
    public int cardType;
    private long eOn;
    public int eOq;
    public JSONArray eOr;
    public int eOs;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eOo = null;
    public SparseArray<String> eOp = null;

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

    public void mX(int i) {
        this.eOq = i;
    }

    public int bml() {
        return this.eOq;
    }

    public void P(JSONArray jSONArray) {
        this.eOr = jSONArray;
    }

    public JSONArray bmm() {
        return this.eOr;
    }

    public long bmn() {
        return this.eOn;
    }

    public void dJ(long j) {
        this.eOn = j;
    }

    public String bmo() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
