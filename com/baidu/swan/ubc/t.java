package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean bqg = false;
    private JSONArray aFL = new JSONArray();
    private SparseArray<Integer> bqb = new SparseArray<>();
    private ArrayList<String> bqc = new ArrayList<>();
    private long bqd = 0;
    private long bqe = 0;
    private String bqf = "0";

    public final void aI(JSONObject jSONObject) {
        this.aFL.put(jSONObject);
    }

    public final SparseArray<Integer> Tv() {
        return this.bqb;
    }

    public final void P(int i, int i2) {
        this.bqb.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Tw() {
        return this.bqc;
    }

    public final void jU(String str) {
        if (!this.bqc.contains(str)) {
            this.bqc.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bqd || this.bqd == 0) && j != 0) {
            this.bqd = j;
        }
        if (j2 > this.bqe) {
            this.bqe = j2;
        }
    }

    public boolean fs(int i) {
        return this.aFL.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aFL.length() == 0;
    }

    public JSONArray Tx() {
        return this.aFL;
    }

    public void clearData() {
        this.bqb.clear();
        this.bqc.clear();
        this.aFL = null;
    }

    public void jV(String str) {
        this.bqf = str;
    }

    public String Ty() {
        return this.bqf;
    }

    public long Tz() {
        return this.bqd;
    }

    public long TA() {
        return this.bqe;
    }

    public JSONArray TB() {
        return this.aFL;
    }

    public boolean TC() {
        return this.bqg;
    }

    public void cW(boolean z) {
        this.bqg = z;
    }
}
