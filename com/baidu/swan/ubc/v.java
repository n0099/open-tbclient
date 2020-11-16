package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes16.dex */
class v {
    private boolean elq = false;
    private JSONArray dly = new JSONArray();
    private SparseArray<Integer> elm = new SparseArray<>();
    private ArrayList<String> eln = new ArrayList<>();
    private long elo = 0;
    private long elp = 0;
    private String ekr = "0";

    public final void dd(JSONObject jSONObject) {
        this.dly.put(jSONObject);
    }

    public final SparseArray<Integer> bdv() {
        return this.elm;
    }

    public final void aF(int i, int i2) {
        this.elm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bdw() {
        return this.eln;
    }

    public final void yY(String str) {
        if (!this.eln.contains(str)) {
            this.eln.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.elo || this.elo == 0) && j != 0) {
            this.elo = j;
        }
        if (j2 > this.elp) {
            this.elp = j2;
        }
    }

    public boolean nl(int i) {
        return this.dly.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dly.length() == 0;
    }

    public JSONArray bdx() {
        return this.dly;
    }

    public void clearData() {
        this.elm.clear();
        this.eln.clear();
        this.dly = null;
    }

    public void yZ(String str) {
        this.ekr = str;
    }

    public String bdy() {
        return this.ekr;
    }

    public long bdz() {
        return this.elo;
    }

    public long getMaxTime() {
        return this.elp;
    }

    public JSONArray bdA() {
        return this.dly;
    }

    public boolean bdB() {
        return this.elq;
    }

    public void id(boolean z) {
        this.elq = z;
    }
}
