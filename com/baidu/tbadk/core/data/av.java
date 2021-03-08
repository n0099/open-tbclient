package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class av {
    public String abTag;
    public int cardType;
    private long ePO;
    public int ePR;
    public JSONArray ePS;
    public int ePT;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> ePP = null;
    public SparseArray<String> ePQ = null;

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

    public void mY(int i) {
        this.ePR = i;
    }

    public int bmn() {
        return this.ePR;
    }

    public void P(JSONArray jSONArray) {
        this.ePS = jSONArray;
    }

    public JSONArray bmo() {
        return this.ePS;
    }

    public long bmp() {
        return this.ePO;
    }

    public void dJ(long j) {
        this.ePO = j;
    }

    public String bmq() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
