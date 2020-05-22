package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean dqO = false;
    private JSONArray cuT = new JSONArray();
    private SparseArray<Integer> dqK = new SparseArray<>();
    private ArrayList<String> dqL = new ArrayList<>();
    private long dqM = 0;
    private long dqN = 0;
    private String dpR = "0";

    public final void cx(JSONObject jSONObject) {
        this.cuT.put(jSONObject);
    }

    public final SparseArray<Integer> aIS() {
        return this.dqK;
    }

    public final void aw(int i, int i2) {
        this.dqK.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aIT() {
        return this.dqL;
    }

    public final void tU(String str) {
        if (!this.dqL.contains(str)) {
            this.dqL.add(str);
        }
    }

    public final void s(long j, long j2) {
        if ((j < this.dqM || this.dqM == 0) && j != 0) {
            this.dqM = j;
        }
        if (j2 > this.dqN) {
            this.dqN = j2;
        }
    }

    public boolean jA(int i) {
        return this.cuT.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cuT.length() == 0;
    }

    public JSONArray aIU() {
        return this.cuT;
    }

    public void clearData() {
        this.dqK.clear();
        this.dqL.clear();
        this.cuT = null;
    }

    public void tV(String str) {
        this.dpR = str;
    }

    public String aIV() {
        return this.dpR;
    }

    public long aIW() {
        return this.dqM;
    }

    public long getMaxTime() {
        return this.dqN;
    }

    public JSONArray aIX() {
        return this.cuT;
    }

    public boolean aIY() {
        return this.dqO;
    }

    public void gp(boolean z) {
        this.dqO = z;
    }
}
