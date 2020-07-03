package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class v {
    private boolean dvA = false;
    private JSONArray czE = new JSONArray();
    private SparseArray<Integer> dvw = new SparseArray<>();
    private ArrayList<String> dvx = new ArrayList<>();
    private long dvy = 0;
    private long dvz = 0;
    private String duD = "0";

    public final void cE(JSONObject jSONObject) {
        this.czE.put(jSONObject);
    }

    public final SparseArray<Integer> aJY() {
        return this.dvw;
    }

    public final void ay(int i, int i2) {
        this.dvw.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aJZ() {
        return this.dvx;
    }

    public final void uc(String str) {
        if (!this.dvx.contains(str)) {
            this.dvx.add(str);
        }
    }

    public final void s(long j, long j2) {
        if ((j < this.dvy || this.dvy == 0) && j != 0) {
            this.dvy = j;
        }
        if (j2 > this.dvz) {
            this.dvz = j2;
        }
    }

    public boolean jN(int i) {
        return this.czE.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.czE.length() == 0;
    }

    public JSONArray aKa() {
        return this.czE;
    }

    public void clearData() {
        this.dvw.clear();
        this.dvx.clear();
        this.czE = null;
    }

    public void ud(String str) {
        this.duD = str;
    }

    public String aKb() {
        return this.duD;
    }

    public long aKc() {
        return this.dvy;
    }

    public long getMaxTime() {
        return this.dvz;
    }

    public JSONArray aKd() {
        return this.czE;
    }

    public boolean aKe() {
        return this.dvA;
    }

    public void gu(boolean z) {
        this.dvA = z;
    }
}
