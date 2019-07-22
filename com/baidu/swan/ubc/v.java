package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class v {
    private boolean bxq = false;
    private JSONArray aIq = new JSONArray();
    private SparseArray<Integer> bxm = new SparseArray<>();
    private ArrayList<String> bxn = new ArrayList<>();
    private long bxo = 0;
    private long bxp = 0;
    private String bwn = "0";

    public final void aU(JSONObject jSONObject) {
        this.aIq.put(jSONObject);
    }

    public final SparseArray<Integer> Yq() {
        return this.bxm;
    }

    public final void Q(int i, int i2) {
        this.bxm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Yr() {
        return this.bxn;
    }

    public final void lb(String str) {
        if (!this.bxn.contains(str)) {
            this.bxn.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bxo || this.bxo == 0) && j != 0) {
            this.bxo = j;
        }
        if (j2 > this.bxp) {
            this.bxp = j2;
        }
    }

    public boolean ge(int i) {
        return this.aIq.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aIq.length() == 0;
    }

    public JSONArray Ys() {
        return this.aIq;
    }

    public void clearData() {
        this.bxm.clear();
        this.bxn.clear();
        this.aIq = null;
    }

    public void lc(String str) {
        this.bwn = str;
    }

    public String Yt() {
        return this.bwn;
    }

    public long Yu() {
        return this.bxo;
    }

    public long Yv() {
        return this.bxp;
    }

    public JSONArray Yw() {
        return this.aIq;
    }

    public boolean Yx() {
        return this.bxq;
    }

    public void ds(boolean z) {
        this.bxq = z;
    }
}
