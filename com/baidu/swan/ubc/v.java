package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class v {
    private boolean dKF = false;
    private JSONArray cKG = new JSONArray();
    private SparseArray<Integer> dKB = new SparseArray<>();
    private ArrayList<String> dKC = new ArrayList<>();
    private long dKD = 0;
    private long dKE = 0;
    private String dJF = "0";

    public final void cQ(JSONObject jSONObject) {
        this.cKG.put(jSONObject);
    }

    public final SparseArray<Integer> aWp() {
        return this.dKB;
    }

    public final void aF(int i, int i2) {
        this.dKB.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aWq() {
        return this.dKC;
    }

    public final void xr(String str) {
        if (!this.dKC.contains(str)) {
            this.dKC.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.dKD || this.dKD == 0) && j != 0) {
            this.dKD = j;
        }
        if (j2 > this.dKE) {
            this.dKE = j2;
        }
    }

    public boolean mm(int i) {
        return this.cKG.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cKG.length() == 0;
    }

    public JSONArray aWr() {
        return this.cKG;
    }

    public void clearData() {
        this.dKB.clear();
        this.dKC.clear();
        this.cKG = null;
    }

    public void xs(String str) {
        this.dJF = str;
    }

    public String aWs() {
        return this.dJF;
    }

    public long aWt() {
        return this.dKD;
    }

    public long getMaxTime() {
        return this.dKE;
    }

    public JSONArray aWu() {
        return this.cKG;
    }

    public boolean aWv() {
        return this.dKF;
    }

    public void hk(boolean z) {
        this.dKF = z;
    }
}
