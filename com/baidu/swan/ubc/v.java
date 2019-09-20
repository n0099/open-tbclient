package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class v {
    private boolean bxO = false;
    private JSONArray aIO = new JSONArray();
    private SparseArray<Integer> bxK = new SparseArray<>();
    private ArrayList<String> bxL = new ArrayList<>();
    private long bxM = 0;
    private long bxN = 0;
    private String bwL = "0";

    public final void aU(JSONObject jSONObject) {
        this.aIO.put(jSONObject);
    }

    public final SparseArray<Integer> Yu() {
        return this.bxK;
    }

    public final void Q(int i, int i2) {
        this.bxK.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Yv() {
        return this.bxL;
    }

    public final void ld(String str) {
        if (!this.bxL.contains(str)) {
            this.bxL.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bxM || this.bxM == 0) && j != 0) {
            this.bxM = j;
        }
        if (j2 > this.bxN) {
            this.bxN = j2;
        }
    }

    public boolean gf(int i) {
        return this.aIO.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aIO.length() == 0;
    }

    public JSONArray Yw() {
        return this.aIO;
    }

    public void clearData() {
        this.bxK.clear();
        this.bxL.clear();
        this.aIO = null;
    }

    public void le(String str) {
        this.bwL = str;
    }

    public String Yx() {
        return this.bwL;
    }

    public long Yy() {
        return this.bxM;
    }

    public long Yz() {
        return this.bxN;
    }

    public JSONArray YA() {
        return this.aIO;
    }

    public boolean YB() {
        return this.bxO;
    }

    public void ds(boolean z) {
        this.bxO = z;
    }
}
