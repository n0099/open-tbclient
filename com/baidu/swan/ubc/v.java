package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class v {
    private boolean exn = false;
    private JSONArray dsK = new JSONArray();
    private SparseArray<Integer> exj = new SparseArray<>();
    private ArrayList<String> exk = new ArrayList<>();
    private long exl = 0;
    private long exm = 0;
    private String ewp = "0";

    public final void dn(JSONObject jSONObject) {
        this.dsK.put(jSONObject);
    }

    public final SparseArray<Integer> bfe() {
        return this.exj;
    }

    public final void aE(int i, int i2) {
        this.exj.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bff() {
        return this.exk;
    }

    public final void yt(String str) {
        if (!this.exk.contains(str)) {
            this.exk.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.exl || this.exl == 0) && j != 0) {
            this.exl = j;
        }
        if (j2 > this.exm) {
            this.exm = j2;
        }
    }

    public boolean mm(int i) {
        return this.dsK.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dsK.length() == 0;
    }

    public JSONArray bfg() {
        return this.dsK;
    }

    public void clearData() {
        this.exj.clear();
        this.exk.clear();
        this.dsK = null;
    }

    public void yu(String str) {
        this.ewp = str;
    }

    public String bfh() {
        return this.ewp;
    }

    public long bfi() {
        return this.exl;
    }

    public long getMaxTime() {
        return this.exm;
    }

    public JSONArray bfj() {
        return this.dsK;
    }

    public boolean bfk() {
        return this.exn;
    }

    public void iJ(boolean z) {
        this.exn = z;
    }
}
