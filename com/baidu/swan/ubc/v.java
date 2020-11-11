package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class v {
    private boolean emX = false;
    private JSONArray dnf = new JSONArray();
    private SparseArray<Integer> emT = new SparseArray<>();
    private ArrayList<String> emU = new ArrayList<>();
    private long emV = 0;
    private long emW = 0;
    private String elY = "0";

    public final void dj(JSONObject jSONObject) {
        this.dnf.put(jSONObject);
    }

    public final SparseArray<Integer> bec() {
        return this.emT;
    }

    public final void aF(int i, int i2) {
        this.emT.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bed() {
        return this.emU;
    }

    public final void zd(String str) {
        if (!this.emU.contains(str)) {
            this.emU.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.emV || this.emV == 0) && j != 0) {
            this.emV = j;
        }
        if (j2 > this.emW) {
            this.emW = j2;
        }
    }

    public boolean np(int i) {
        return this.dnf.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dnf.length() == 0;
    }

    public JSONArray bee() {
        return this.dnf;
    }

    public void clearData() {
        this.emT.clear();
        this.emU.clear();
        this.dnf = null;
    }

    public void ze(String str) {
        this.elY = str;
    }

    public String bef() {
        return this.elY;
    }

    public long beg() {
        return this.emV;
    }

    public long getMaxTime() {
        return this.emW;
    }

    public JSONArray beh() {
        return this.dnf;
    }

    public boolean bei() {
        return this.emX;
    }

    public void ia(boolean z) {
        this.emX = z;
    }
}
