package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class v {
    private boolean bPD = false;
    private JSONArray bbK = new JSONArray();
    private SparseArray<Integer> bPz = new SparseArray<>();
    private ArrayList<String> bPA = new ArrayList<>();
    private long bPB = 0;
    private long bPC = 0;
    private String bOB = "0";

    public final void bt(JSONObject jSONObject) {
        this.bbK.put(jSONObject);
    }

    public final SparseArray<Integer> adi() {
        return this.bPz;
    }

    public final void U(int i, int i2) {
        this.bPz.put(i, Integer.valueOf(i2));
    }

    public final ArrayList adj() {
        return this.bPA;
    }

    public final void lF(String str) {
        if (!this.bPA.contains(str)) {
            this.bPA.add(str);
        }
    }

    public final void m(long j, long j2) {
        if ((j < this.bPB || this.bPB == 0) && j != 0) {
            this.bPB = j;
        }
        if (j2 > this.bPC) {
            this.bPC = j2;
        }
    }

    public boolean gZ(int i) {
        return this.bbK.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bbK.length() == 0;
    }

    public JSONArray adk() {
        return this.bbK;
    }

    public void clearData() {
        this.bPz.clear();
        this.bPA.clear();
        this.bbK = null;
    }

    public void lG(String str) {
        this.bOB = str;
    }

    public String adl() {
        return this.bOB;
    }

    public long adm() {
        return this.bPB;
    }

    public long getMaxTime() {
        return this.bPC;
    }

    public JSONArray adn() {
        return this.bbK;
    }

    public boolean ado() {
        return this.bPD;
    }

    public void dJ(boolean z) {
        this.bPD = z;
    }
}
