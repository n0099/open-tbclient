package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ar {
    public String abTag;
    public int cardType;
    private long ebk;
    public int ebn;
    public JSONArray ebo;
    public int ebp;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> ebl = null;
    public SparseArray<String> ebm = null;

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

    public void ne(int i) {
        this.ebn = i;
    }

    public int bdV() {
        return this.ebn;
    }

    public void P(JSONArray jSONArray) {
        this.ebo = jSONArray;
    }

    public JSONArray bdW() {
        return this.ebo;
    }

    public long bdX() {
        return this.ebk;
    }

    public void cy(long j) {
        this.ebk = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
