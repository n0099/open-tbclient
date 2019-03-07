package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class u {
    private static final boolean DEBUG = g.DEBUG;
    private boolean bqf = false;
    private JSONArray aFK = new JSONArray();
    private SparseArray<Integer> bqa = new SparseArray<>();
    private ArrayList<String> bqb = new ArrayList<>();
    private long bqc = 0;
    private long bqd = 0;
    private String bqe = "0";

    public final void aI(JSONObject jSONObject) {
        this.aFK.put(jSONObject);
    }

    public final SparseArray<Integer> Tv() {
        return this.bqa;
    }

    public final void P(int i, int i2) {
        this.bqa.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Tw() {
        return this.bqb;
    }

    public final void jU(String str) {
        if (!this.bqb.contains(str)) {
            this.bqb.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bqc || this.bqc == 0) && j != 0) {
            this.bqc = j;
        }
        if (j2 > this.bqd) {
            this.bqd = j2;
        }
    }

    public boolean fs(int i) {
        return this.aFK.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aFK.length() == 0;
    }

    public JSONArray Tx() {
        return this.aFK;
    }

    public void clearData() {
        this.bqa.clear();
        this.bqb.clear();
        this.aFK = null;
    }

    public void jV(String str) {
        this.bqe = str;
    }

    public String Ty() {
        return this.bqe;
    }

    public long Tz() {
        return this.bqc;
    }

    public long TA() {
        return this.bqd;
    }

    public JSONArray TB() {
        return this.aFK;
    }

    public boolean TC() {
        return this.bqf;
    }

    public void cW(boolean z) {
        this.bqf = z;
    }
}
