package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class v {
    private boolean eCc = false;
    private JSONArray dxx = new JSONArray();
    private SparseArray<Integer> eBY = new SparseArray<>();
    private ArrayList<String> eBZ = new ArrayList<>();
    private long eCa = 0;
    private long eCb = 0;
    private String eBe = "0";

    public final void dn(JSONObject jSONObject) {
        this.dxx.put(jSONObject);
    }

    public final SparseArray<Integer> biY() {
        return this.eBY;
    }

    public final void aE(int i, int i2) {
        this.eBY.put(i, Integer.valueOf(i2));
    }

    public final ArrayList biZ() {
        return this.eBZ;
    }

    public final void zE(String str) {
        if (!this.eBZ.contains(str)) {
            this.eBZ.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.eCa || this.eCa == 0) && j != 0) {
            this.eCa = j;
        }
        if (j2 > this.eCb) {
            this.eCb = j2;
        }
    }

    public boolean nS(int i) {
        return this.dxx.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dxx.length() == 0;
    }

    public JSONArray bja() {
        return this.dxx;
    }

    public void clearData() {
        this.eBY.clear();
        this.eBZ.clear();
        this.dxx = null;
    }

    public void zF(String str) {
        this.eBe = str;
    }

    public String bjb() {
        return this.eBe;
    }

    public long bjc() {
        return this.eCa;
    }

    public long getMaxTime() {
        return this.eCb;
    }

    public JSONArray bjd() {
        return this.dxx;
    }

    public boolean bje() {
        return this.eCc;
    }

    public void iN(boolean z) {
        this.eCc = z;
    }
}
