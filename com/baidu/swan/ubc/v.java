package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean cFC = false;
    private JSONArray bKm = new JSONArray();
    private SparseArray<Integer> cFy = new SparseArray<>();
    private ArrayList<String> cFz = new ArrayList<>();
    private long cFA = 0;
    private long cFB = 0;
    private String cEG = "0";

    public final void cg(JSONObject jSONObject) {
        this.bKm.put(jSONObject);
    }

    public final SparseArray<Integer> avU() {
        return this.cFy;
    }

    public final void at(int i, int i2) {
        this.cFy.put(i, Integer.valueOf(i2));
    }

    public final ArrayList avV() {
        return this.cFz;
    }

    public final void rd(String str) {
        if (!this.cFz.contains(str)) {
            this.cFz.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.cFA || this.cFA == 0) && j != 0) {
            this.cFA = j;
        }
        if (j2 > this.cFB) {
            this.cFB = j2;
        }
    }

    public boolean ja(int i) {
        return this.bKm.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bKm.length() == 0;
    }

    public JSONArray avW() {
        return this.bKm;
    }

    public void clearData() {
        this.cFy.clear();
        this.cFz.clear();
        this.bKm = null;
    }

    public void re(String str) {
        this.cEG = str;
    }

    public String avX() {
        return this.cEG;
    }

    public long avY() {
        return this.cFA;
    }

    public long getMaxTime() {
        return this.cFB;
    }

    public JSONArray avZ() {
        return this.bKm;
    }

    public boolean awa() {
        return this.cFC;
    }

    public void fg(boolean z) {
        this.cFC = z;
    }
}
