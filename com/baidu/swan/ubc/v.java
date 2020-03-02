package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean cFD = false;
    private JSONArray bKn = new JSONArray();
    private SparseArray<Integer> cFz = new SparseArray<>();
    private ArrayList<String> cFA = new ArrayList<>();
    private long cFB = 0;
    private long cFC = 0;
    private String cEH = "0";

    public final void cg(JSONObject jSONObject) {
        this.bKn.put(jSONObject);
    }

    public final SparseArray<Integer> avW() {
        return this.cFz;
    }

    public final void at(int i, int i2) {
        this.cFz.put(i, Integer.valueOf(i2));
    }

    public final ArrayList avX() {
        return this.cFA;
    }

    public final void rd(String str) {
        if (!this.cFA.contains(str)) {
            this.cFA.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.cFB || this.cFB == 0) && j != 0) {
            this.cFB = j;
        }
        if (j2 > this.cFC) {
            this.cFC = j2;
        }
    }

    public boolean ja(int i) {
        return this.bKn.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bKn.length() == 0;
    }

    public JSONArray avY() {
        return this.bKn;
    }

    public void clearData() {
        this.cFz.clear();
        this.cFA.clear();
        this.bKn = null;
    }

    public void re(String str) {
        this.cEH = str;
    }

    public String avZ() {
        return this.cEH;
    }

    public long awa() {
        return this.cFB;
    }

    public long getMaxTime() {
        return this.cFC;
    }

    public JSONArray awb() {
        return this.bKn;
    }

    public boolean awc() {
        return this.cFD;
    }

    public void fg(boolean z) {
        this.cFD = z;
    }
}
