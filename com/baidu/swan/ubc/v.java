package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class v {
    private boolean dYJ = false;
    private JSONArray cYJ = new JSONArray();
    private SparseArray<Integer> dYF = new SparseArray<>();
    private ArrayList<String> dYG = new ArrayList<>();
    private long dYH = 0;
    private long dYI = 0;
    private String dXK = "0";

    public final void da(JSONObject jSONObject) {
        this.cYJ.put(jSONObject);
    }

    public final SparseArray<Integer> aZJ() {
        return this.dYF;
    }

    public final void aE(int i, int i2) {
        this.dYF.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aZK() {
        return this.dYG;
    }

    public final void yw(String str) {
        if (!this.dYG.contains(str)) {
            this.dYG.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.dYH || this.dYH == 0) && j != 0) {
            this.dYH = j;
        }
        if (j2 > this.dYI) {
            this.dYI = j2;
        }
    }

    public boolean mU(int i) {
        return this.cYJ.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cYJ.length() == 0;
    }

    public JSONArray aZL() {
        return this.cYJ;
    }

    public void clearData() {
        this.dYF.clear();
        this.dYG.clear();
        this.cYJ = null;
    }

    public void yx(String str) {
        this.dXK = str;
    }

    public String aZM() {
        return this.dXK;
    }

    public long aZN() {
        return this.dYH;
    }

    public long getMaxTime() {
        return this.dYI;
    }

    public JSONArray aZO() {
        return this.cYJ;
    }

    public boolean aZP() {
        return this.dYJ;
    }

    public void hE(boolean z) {
        this.dYJ = z;
    }
}
