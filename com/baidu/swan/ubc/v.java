package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class v {
    private boolean ehg = false;
    private JSONArray dhk = new JSONArray();
    private SparseArray<Integer> ehc = new SparseArray<>();
    private ArrayList<String> ehd = new ArrayList<>();
    private long ehe = 0;
    private long ehf = 0;
    private String egg = "0";

    public final void dd(JSONObject jSONObject) {
        this.dhk.put(jSONObject);
    }

    public final SparseArray<Integer> bbC() {
        return this.ehc;
    }

    public final void aF(int i, int i2) {
        this.ehc.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bbD() {
        return this.ehd;
    }

    public final void yP(String str) {
        if (!this.ehd.contains(str)) {
            this.ehd.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.ehe || this.ehe == 0) && j != 0) {
            this.ehe = j;
        }
        if (j2 > this.ehf) {
            this.ehf = j2;
        }
    }

    public boolean nf(int i) {
        return this.dhk.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dhk.length() == 0;
    }

    public JSONArray bbE() {
        return this.dhk;
    }

    public void clearData() {
        this.ehc.clear();
        this.ehd.clear();
        this.dhk = null;
    }

    public void yQ(String str) {
        this.egg = str;
    }

    public String bbF() {
        return this.egg;
    }

    public long bbG() {
        return this.ehe;
    }

    public long getMaxTime() {
        return this.ehf;
    }

    public JSONArray bbH() {
        return this.dhk;
    }

    public boolean bbI() {
        return this.ehg;
    }

    public void hR(boolean z) {
        this.ehg = z;
    }
}
