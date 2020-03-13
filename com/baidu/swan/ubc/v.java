package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean cFE = false;
    private JSONArray bKo = new JSONArray();
    private SparseArray<Integer> cFA = new SparseArray<>();
    private ArrayList<String> cFB = new ArrayList<>();
    private long cFC = 0;
    private long cFD = 0;
    private String cEI = "0";

    public final void cg(JSONObject jSONObject) {
        this.bKo.put(jSONObject);
    }

    public final SparseArray<Integer> avW() {
        return this.cFA;
    }

    public final void at(int i, int i2) {
        this.cFA.put(i, Integer.valueOf(i2));
    }

    public final ArrayList avX() {
        return this.cFB;
    }

    public final void rd(String str) {
        if (!this.cFB.contains(str)) {
            this.cFB.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.cFC || this.cFC == 0) && j != 0) {
            this.cFC = j;
        }
        if (j2 > this.cFD) {
            this.cFD = j2;
        }
    }

    public boolean ja(int i) {
        return this.bKo.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bKo.length() == 0;
    }

    public JSONArray avY() {
        return this.bKo;
    }

    public void clearData() {
        this.cFA.clear();
        this.cFB.clear();
        this.bKo = null;
    }

    public void re(String str) {
        this.cEI = str;
    }

    public String avZ() {
        return this.cEI;
    }

    public long awa() {
        return this.cFC;
    }

    public long getMaxTime() {
        return this.cFD;
    }

    public JSONArray awb() {
        return this.bKo;
    }

    public boolean awc() {
        return this.cFE;
    }

    public void fg(boolean z) {
        this.cFE = z;
    }
}
