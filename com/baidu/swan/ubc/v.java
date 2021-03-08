package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
class v {
    private boolean eAX = false;
    private JSONArray dww = new JSONArray();
    private SparseArray<Integer> eAT = new SparseArray<>();
    private ArrayList<String> eAU = new ArrayList<>();
    private long eAV = 0;
    private long eAW = 0;
    private String ezZ = "0";

    public final void dm(JSONObject jSONObject) {
        this.dww.put(jSONObject);
    }

    public final SparseArray<Integer> bft() {
        return this.eAT;
    }

    public final void aB(int i, int i2) {
        this.eAT.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bfu() {
        return this.eAU;
    }

    public final void yT(String str) {
        if (!this.eAU.contains(str)) {
            this.eAU.add(str);
        }
    }

    public final void y(long j, long j2) {
        if ((j < this.eAV || this.eAV == 0) && j != 0) {
            this.eAV = j;
        }
        if (j2 > this.eAW) {
            this.eAW = j2;
        }
    }

    public boolean mq(int i) {
        return this.dww.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dww.length() == 0;
    }

    public JSONArray bfv() {
        return this.dww;
    }

    public void clearData() {
        this.eAT.clear();
        this.eAU.clear();
        this.dww = null;
    }

    public void yU(String str) {
        this.ezZ = str;
    }

    public String bfw() {
        return this.ezZ;
    }

    public long bfx() {
        return this.eAV;
    }

    public long getMaxTime() {
        return this.eAW;
    }

    public JSONArray bfy() {
        return this.dww;
    }

    public boolean bfz() {
        return this.eAX;
    }

    public void iL(boolean z) {
        this.eAX = z;
    }
}
