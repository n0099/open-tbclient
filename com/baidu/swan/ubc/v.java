package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class v {
    private boolean ezw = false;
    private JSONArray duV = new JSONArray();
    private SparseArray<Integer> ezs = new SparseArray<>();
    private ArrayList<String> ezt = new ArrayList<>();
    private long ezu = 0;
    private long ezv = 0;
    private String eyy = "0";

    public final void dk(JSONObject jSONObject) {
        this.duV.put(jSONObject);
    }

    public final SparseArray<Integer> bfr() {
        return this.ezs;
    }

    public final void aB(int i, int i2) {
        this.ezs.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bfs() {
        return this.ezt;
    }

    public final void yM(String str) {
        if (!this.ezt.contains(str)) {
            this.ezt.add(str);
        }
    }

    public final void y(long j, long j2) {
        if ((j < this.ezu || this.ezu == 0) && j != 0) {
            this.ezu = j;
        }
        if (j2 > this.ezv) {
            this.ezv = j2;
        }
    }

    public boolean mp(int i) {
        return this.duV.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.duV.length() == 0;
    }

    public JSONArray bft() {
        return this.duV;
    }

    public void clearData() {
        this.ezs.clear();
        this.ezt.clear();
        this.duV = null;
    }

    public void yN(String str) {
        this.eyy = str;
    }

    public String bfu() {
        return this.eyy;
    }

    public long bfv() {
        return this.ezu;
    }

    public long getMaxTime() {
        return this.ezv;
    }

    public JSONArray bfw() {
        return this.duV;
    }

    public boolean bfx() {
        return this.ezw;
    }

    public void iL(boolean z) {
        this.ezw = z;
    }
}
