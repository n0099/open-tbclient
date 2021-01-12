package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class at {
    public String abTag;
    public int cardType;
    private long eMb;
    public int eMe;
    public JSONArray eMf;
    public int eMg;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eMc = null;
    public SparseArray<String> eMd = null;

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

    public void mU(int i) {
        this.eMe = i;
    }

    public int blS() {
        return this.eMe;
    }

    public void Q(JSONArray jSONArray) {
        this.eMf = jSONArray;
    }

    public JSONArray blT() {
        return this.eMf;
    }

    public long blU() {
        return this.eMb;
    }

    public void dD(long j) {
        this.eMb = j;
    }

    public String blV() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
