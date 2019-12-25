package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class v {
    private boolean cBt = false;
    private JSONArray bFw = new JSONArray();
    private SparseArray<Integer> cBp = new SparseArray<>();
    private ArrayList<String> cBq = new ArrayList<>();
    private long cBr = 0;
    private long cBs = 0;
    private String cAx = "0";

    public final void cg(JSONObject jSONObject) {
        this.bFw.put(jSONObject);
    }

    public final SparseArray<Integer> atn() {
        return this.cBp;
    }

    public final void ap(int i, int i2) {
        this.cBp.put(i, Integer.valueOf(i2));
    }

    public final ArrayList ato() {
        return this.cBq;
    }

    public final void qL(String str) {
        if (!this.cBq.contains(str)) {
            this.cBq.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.cBr || this.cBr == 0) && j != 0) {
            this.cBr = j;
        }
        if (j2 > this.cBs) {
            this.cBs = j2;
        }
    }

    public boolean iJ(int i) {
        return this.bFw.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bFw.length() == 0;
    }

    public JSONArray atp() {
        return this.bFw;
    }

    public void clearData() {
        this.cBp.clear();
        this.cBq.clear();
        this.bFw = null;
    }

    public void qM(String str) {
        this.cAx = str;
    }

    public String atq() {
        return this.cAx;
    }

    public long atr() {
        return this.cBr;
    }

    public long getMaxTime() {
        return this.cBs;
    }

    public JSONArray ats() {
        return this.bFw;
    }

    public boolean att() {
        return this.cBt;
    }

    public void eU(boolean z) {
        this.cBt = z;
    }
}
