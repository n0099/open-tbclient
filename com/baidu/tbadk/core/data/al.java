package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class al {
    private long cLm;
    public int cLo;
    public JSONArray cLp;
    public String cLq;
    public int cLr;
    public int cardType;
    public String extra;
    private String fid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> cLn = null;

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
        this.cLo = i;
    }

    public int ayj() {
        return this.cLo;
    }

    public void L(JSONArray jSONArray) {
        this.cLp = jSONArray;
    }

    public JSONArray ayk() {
        return this.cLp;
    }

    public long ayl() {
        return this.cLm;
    }

    public void bm(long j) {
        this.cLm = j;
    }
}
