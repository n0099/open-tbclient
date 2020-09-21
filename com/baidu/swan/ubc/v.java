package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
class v {
    private boolean dMI = false;
    private JSONArray cMG = new JSONArray();
    private SparseArray<Integer> dME = new SparseArray<>();
    private ArrayList<String> dMF = new ArrayList<>();
    private long dMG = 0;
    private long dMH = 0;
    private String dLJ = "0";

    public final void cT(JSONObject jSONObject) {
        this.cMG.put(jSONObject);
    }

    public final SparseArray<Integer> aXb() {
        return this.dME;
    }

    public final void aF(int i, int i2) {
        this.dME.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aXc() {
        return this.dMF;
    }

    public final void xK(String str) {
        if (!this.dMF.contains(str)) {
            this.dMF.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.dMG || this.dMG == 0) && j != 0) {
            this.dMG = j;
        }
        if (j2 > this.dMH) {
            this.dMH = j2;
        }
    }

    public boolean mx(int i) {
        return this.cMG.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cMG.length() == 0;
    }

    public JSONArray aXd() {
        return this.cMG;
    }

    public void clearData() {
        this.dME.clear();
        this.dMF.clear();
        this.cMG = null;
    }

    public void xL(String str) {
        this.dLJ = str;
    }

    public String aXe() {
        return this.dLJ;
    }

    public long aXf() {
        return this.dMG;
    }

    public long getMaxTime() {
        return this.dMH;
    }

    public JSONArray aXg() {
        return this.cMG;
    }

    public boolean aXh() {
        return this.dMI;
    }

    public void hi(boolean z) {
        this.dMI = z;
    }
}
