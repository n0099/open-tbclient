package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean deV = false;
    private JSONArray cjp = new JSONArray();
    private SparseArray<Integer> deR = new SparseArray<>();
    private ArrayList<String> deS = new ArrayList<>();
    private long deT = 0;
    private long deU = 0;
    private String ddY = "0";

    public final void cr(JSONObject jSONObject) {
        this.cjp.put(jSONObject);
    }

    public final SparseArray<Integer> aEk() {
        return this.deR;
    }

    public final void aw(int i, int i2) {
        this.deR.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aEl() {
        return this.deS;
    }

    public final void sp(String str) {
        if (!this.deS.contains(str)) {
            this.deS.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.deT || this.deT == 0) && j != 0) {
            this.deT = j;
        }
        if (j2 > this.deU) {
            this.deU = j2;
        }
    }

    public boolean jh(int i) {
        return this.cjp.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cjp.length() == 0;
    }

    public JSONArray aEm() {
        return this.cjp;
    }

    public void clearData() {
        this.deR.clear();
        this.deS.clear();
        this.cjp = null;
    }

    public void sq(String str) {
        this.ddY = str;
    }

    public String aEn() {
        return this.ddY;
    }

    public long aEo() {
        return this.deT;
    }

    public long getMaxTime() {
        return this.deU;
    }

    public JSONArray aEp() {
        return this.cjp;
    }

    public boolean aEq() {
        return this.deV;
    }

    public void ge(boolean z) {
        this.deV = z;
    }
}
