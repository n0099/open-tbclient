package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class v {
    private boolean dBq = false;
    private JSONArray cCo = new JSONArray();
    private SparseArray<Integer> dBm = new SparseArray<>();
    private ArrayList<String> dBn = new ArrayList<>();
    private long dBo = 0;
    private long dBp = 0;
    private String dAs = "0";

    public final void cK(JSONObject jSONObject) {
        this.cCo.put(jSONObject);
    }

    public final SparseArray<Integer> aNP() {
        return this.dBm;
    }

    public final void ay(int i, int i2) {
        this.dBm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aNQ() {
        return this.dBn;
    }

    public final void vf(String str) {
        if (!this.dBn.contains(str)) {
            this.dBn.add(str);
        }
    }

    public final void t(long j, long j2) {
        if ((j < this.dBo || this.dBo == 0) && j != 0) {
            this.dBo = j;
        }
        if (j2 > this.dBp) {
            this.dBp = j2;
        }
    }

    public boolean kg(int i) {
        return this.cCo.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cCo.length() == 0;
    }

    public JSONArray aNR() {
        return this.cCo;
    }

    public void clearData() {
        this.dBm.clear();
        this.dBn.clear();
        this.cCo = null;
    }

    public void vg(String str) {
        this.dAs = str;
    }

    public String aNS() {
        return this.dAs;
    }

    public long aNT() {
        return this.dBo;
    }

    public long getMaxTime() {
        return this.dBp;
    }

    public JSONArray aNU() {
        return this.cCo;
    }

    public boolean aNV() {
        return this.dBq;
    }

    public void gP(boolean z) {
        this.dBq = z;
    }
}
