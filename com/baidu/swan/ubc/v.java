package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes17.dex */
class v {
    private boolean ess = false;
    private JSONArray dsz = new JSONArray();
    private SparseArray<Integer> eso = new SparseArray<>();
    private ArrayList<String> esp = new ArrayList<>();
    private long esq = 0;
    private long esr = 0;
    private String eru = "0";

    public final void df(JSONObject jSONObject) {
        this.dsz.put(jSONObject);
    }

    public final SparseArray<Integer> bgA() {
        return this.eso;
    }

    public final void aH(int i, int i2) {
        this.eso.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bgB() {
        return this.esp;
    }

    public final void zF(String str) {
        if (!this.esp.contains(str)) {
            this.esp.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.esq || this.esq == 0) && j != 0) {
            this.esq = j;
        }
        if (j2 > this.esr) {
            this.esr = j2;
        }
    }

    public boolean nJ(int i) {
        return this.dsz.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dsz.length() == 0;
    }

    public JSONArray bgC() {
        return this.dsz;
    }

    public void clearData() {
        this.eso.clear();
        this.esp.clear();
        this.dsz = null;
    }

    public void zG(String str) {
        this.eru = str;
    }

    public String bgD() {
        return this.eru;
    }

    public long bgE() {
        return this.esq;
    }

    public long getMaxTime() {
        return this.esr;
    }

    public JSONArray bgF() {
        return this.dsz;
    }

    public boolean bgG() {
        return this.ess;
    }

    public void is(boolean z) {
        this.ess = z;
    }
}
