package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean bqj = false;
    private JSONArray aFO = new JSONArray();
    private SparseArray<Integer> bqe = new SparseArray<>();
    private ArrayList<String> bqf = new ArrayList<>();
    private long bqg = 0;
    private long bqh = 0;
    private String bqi = "0";

    public final void aI(JSONObject jSONObject) {
        this.aFO.put(jSONObject);
    }

    public final SparseArray<Integer> Tt() {
        return this.bqe;
    }

    public final void P(int i, int i2) {
        this.bqe.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Tu() {
        return this.bqf;
    }

    public final void jV(String str) {
        if (!this.bqf.contains(str)) {
            this.bqf.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bqg || this.bqg == 0) && j != 0) {
            this.bqg = j;
        }
        if (j2 > this.bqh) {
            this.bqh = j2;
        }
    }

    public boolean fr(int i) {
        return this.aFO.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aFO.length() == 0;
    }

    public JSONArray Tv() {
        return this.aFO;
    }

    public void clearData() {
        this.bqe.clear();
        this.bqf.clear();
        this.aFO = null;
    }

    public void jW(String str) {
        this.bqi = str;
    }

    public String Tw() {
        return this.bqi;
    }

    public long Tx() {
        return this.bqg;
    }

    public long Ty() {
        return this.bqh;
    }

    public JSONArray Tz() {
        return this.aFO;
    }

    public boolean TA() {
        return this.bqj;
    }

    public void cW(boolean z) {
        this.bqj = z;
    }
}
