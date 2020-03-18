package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean cFP = false;
    private JSONArray bKz = new JSONArray();
    private SparseArray<Integer> cFL = new SparseArray<>();
    private ArrayList<String> cFM = new ArrayList<>();
    private long cFN = 0;
    private long cFO = 0;
    private String cET = "0";

    public final void cg(JSONObject jSONObject) {
        this.bKz.put(jSONObject);
    }

    public final SparseArray<Integer> avZ() {
        return this.cFL;
    }

    public final void at(int i, int i2) {
        this.cFL.put(i, Integer.valueOf(i2));
    }

    public final ArrayList awa() {
        return this.cFM;
    }

    public final void rc(String str) {
        if (!this.cFM.contains(str)) {
            this.cFM.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.cFN || this.cFN == 0) && j != 0) {
            this.cFN = j;
        }
        if (j2 > this.cFO) {
            this.cFO = j2;
        }
    }

    public boolean ja(int i) {
        return this.bKz.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bKz.length() == 0;
    }

    public JSONArray awb() {
        return this.bKz;
    }

    public void clearData() {
        this.cFL.clear();
        this.cFM.clear();
        this.bKz = null;
    }

    public void rd(String str) {
        this.cET = str;
    }

    public String awc() {
        return this.cET;
    }

    public long awd() {
        return this.cFN;
    }

    public long getMaxTime() {
        return this.cFO;
    }

    public JSONArray awe() {
        return this.bKz;
    }

    public boolean awf() {
        return this.cFP;
    }

    public void fh(boolean z) {
        this.cFP = z;
    }
}
