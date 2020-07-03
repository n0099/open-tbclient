package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ap {
    public String abTag;
    public int cardType;
    private long dJs;
    public int dJu;
    public JSONArray dJv;
    public int dJw;
    public String extra;
    private String fid;
    private String nid;
    public String source;
    public int threadType;
    private String tid;
    private String type;
    public String weight;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> dJt = null;

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

    public void kt(int i) {
        this.dJu = i;
    }

    public int aQM() {
        return this.dJu;
    }

    public void M(JSONArray jSONArray) {
        this.dJv = jSONArray;
    }

    public JSONArray aQN() {
        return this.dJv;
    }

    public long aQO() {
        return this.dJs;
    }

    public void bY(long j) {
        this.dJs = j;
    }

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }
}
