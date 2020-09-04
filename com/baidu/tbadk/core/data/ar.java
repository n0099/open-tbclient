package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ar {
    public String abTag;
    public int cardType;
    private long dZa;
    public int dZd;
    public JSONArray dZe;
    public int dZf;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> dZb = null;
    public SparseArray<String> dZc = null;

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

    public void mT(int i) {
        this.dZd = i;
    }

    public int bdb() {
        return this.dZd;
    }

    public void P(JSONArray jSONArray) {
        this.dZe = jSONArray;
    }

    public JSONArray bdc() {
        return this.dZe;
    }

    public long bdd() {
        return this.dZa;
    }

    public void cx(long j) {
        this.dZa = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
