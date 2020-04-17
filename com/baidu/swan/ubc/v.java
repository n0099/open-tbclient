package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean deQ = false;
    private JSONArray cjj = new JSONArray();
    private SparseArray<Integer> deM = new SparseArray<>();
    private ArrayList<String> deN = new ArrayList<>();
    private long deO = 0;
    private long deP = 0;
    private String ddT = "0";

    public final void cr(JSONObject jSONObject) {
        this.cjj.put(jSONObject);
    }

    public final SparseArray<Integer> aEk() {
        return this.deM;
    }

    public final void aw(int i, int i2) {
        this.deM.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aEl() {
        return this.deN;
    }

    public final void sp(String str) {
        if (!this.deN.contains(str)) {
            this.deN.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.deO || this.deO == 0) && j != 0) {
            this.deO = j;
        }
        if (j2 > this.deP) {
            this.deP = j2;
        }
    }

    public boolean jh(int i) {
        return this.cjj.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cjj.length() == 0;
    }

    public JSONArray aEm() {
        return this.cjj;
    }

    public void clearData() {
        this.deM.clear();
        this.deN.clear();
        this.cjj = null;
    }

    public void sq(String str) {
        this.ddT = str;
    }

    public String aEn() {
        return this.ddT;
    }

    public long aEo() {
        return this.deO;
    }

    public long getMaxTime() {
        return this.deP;
    }

    public JSONArray aEp() {
        return this.cjj;
    }

    public boolean aEq() {
        return this.deQ;
    }

    public void ge(boolean z) {
        this.deQ = z;
    }
}
