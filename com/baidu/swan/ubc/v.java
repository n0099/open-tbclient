package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class v {
    private boolean bwz = false;
    private JSONArray aHI = new JSONArray();
    private SparseArray<Integer> bwv = new SparseArray<>();
    private ArrayList<String> bww = new ArrayList<>();
    private long bwx = 0;
    private long bwy = 0;
    private String bvx = "0";

    public final void aU(JSONObject jSONObject) {
        this.aHI.put(jSONObject);
    }

    public final SparseArray<Integer> Xu() {
        return this.bwv;
    }

    public final void N(int i, int i2) {
        this.bwv.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Xv() {
        return this.bww;
    }

    public final void kT(String str) {
        if (!this.bww.contains(str)) {
            this.bww.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bwx || this.bwx == 0) && j != 0) {
            this.bwx = j;
        }
        if (j2 > this.bwy) {
            this.bwy = j2;
        }
    }

    public boolean ga(int i) {
        return this.aHI.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aHI.length() == 0;
    }

    public JSONArray Xw() {
        return this.aHI;
    }

    public void clearData() {
        this.bwv.clear();
        this.bww.clear();
        this.aHI = null;
    }

    public void kU(String str) {
        this.bvx = str;
    }

    public String Xx() {
        return this.bvx;
    }

    public long Xy() {
        return this.bwx;
    }

    public long Xz() {
        return this.bwy;
    }

    public JSONArray XA() {
        return this.aHI;
    }

    public boolean XB() {
        return this.bwz;
    }

    public void dn(boolean z) {
        this.bwz = z;
    }
}
