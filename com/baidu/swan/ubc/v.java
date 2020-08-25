package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class v {
    private boolean dKB = false;
    private JSONArray cKC = new JSONArray();
    private SparseArray<Integer> dKx = new SparseArray<>();
    private ArrayList<String> dKy = new ArrayList<>();
    private long dKz = 0;
    private long dKA = 0;
    private String dJB = "0";

    public final void cQ(JSONObject jSONObject) {
        this.cKC.put(jSONObject);
    }

    public final SparseArray<Integer> aWp() {
        return this.dKx;
    }

    public final void aF(int i, int i2) {
        this.dKx.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aWq() {
        return this.dKy;
    }

    public final void xq(String str) {
        if (!this.dKy.contains(str)) {
            this.dKy.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.dKz || this.dKz == 0) && j != 0) {
            this.dKz = j;
        }
        if (j2 > this.dKA) {
            this.dKA = j2;
        }
    }

    public boolean mm(int i) {
        return this.cKC.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cKC.length() == 0;
    }

    public JSONArray aWr() {
        return this.cKC;
    }

    public void clearData() {
        this.dKx.clear();
        this.dKy.clear();
        this.cKC = null;
    }

    public void xr(String str) {
        this.dJB = str;
    }

    public String aWs() {
        return this.dJB;
    }

    public long aWt() {
        return this.dKz;
    }

    public long getMaxTime() {
        return this.dKA;
    }

    public JSONArray aWu() {
        return this.cKC;
    }

    public boolean aWv() {
        return this.dKB;
    }

    public void hj(boolean z) {
        this.dKB = z;
    }
}
