package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class v {
    private boolean cBE = false;
    private JSONArray bGh = new JSONArray();
    private SparseArray<Integer> cBA = new SparseArray<>();
    private ArrayList<String> cBB = new ArrayList<>();
    private long cBC = 0;
    private long cBD = 0;
    private String cAI = "0";

    public final void cg(JSONObject jSONObject) {
        this.bGh.put(jSONObject);
    }

    public final SparseArray<Integer> atG() {
        return this.cBA;
    }

    public final void at(int i, int i2) {
        this.cBA.put(i, Integer.valueOf(i2));
    }

    public final ArrayList atH() {
        return this.cBB;
    }

    public final void qO(String str) {
        if (!this.cBB.contains(str)) {
            this.cBB.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.cBC || this.cBC == 0) && j != 0) {
            this.cBC = j;
        }
        if (j2 > this.cBD) {
            this.cBD = j2;
        }
    }

    public boolean iJ(int i) {
        return this.bGh.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bGh.length() == 0;
    }

    public JSONArray atI() {
        return this.bGh;
    }

    public void clearData() {
        this.cBA.clear();
        this.cBB.clear();
        this.bGh = null;
    }

    public void qP(String str) {
        this.cAI = str;
    }

    public String atJ() {
        return this.cAI;
    }

    public long atK() {
        return this.cBC;
    }

    public long getMaxTime() {
        return this.cBD;
    }

    public JSONArray atL() {
        return this.bGh;
    }

    public boolean atM() {
        return this.cBE;
    }

    public void eZ(boolean z) {
        this.cBE = z;
    }
}
