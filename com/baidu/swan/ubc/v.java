package com.baidu.swan.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class v {
    private boolean bQu = false;
    private JSONArray bcc = new JSONArray();
    private SparseArray<Integer> bQq = new SparseArray<>();
    private ArrayList<String> bQr = new ArrayList<>();
    private long bQs = 0;
    private long bQt = 0;
    private String bPs = "0";

    public final void bs(JSONObject jSONObject) {
        this.bcc.put(jSONObject);
    }

    public final SparseArray<Integer> adk() {
        return this.bQq;
    }

    public final void W(int i, int i2) {
        this.bQq.put(i, Integer.valueOf(i2));
    }

    public final ArrayList adl() {
        return this.bQr;
    }

    public final void lF(String str) {
        if (!this.bQr.contains(str)) {
            this.bQr.add(str);
        }
    }

    public final void m(long j, long j2) {
        if ((j < this.bQs || this.bQs == 0) && j != 0) {
            this.bQs = j;
        }
        if (j2 > this.bQt) {
            this.bQt = j2;
        }
    }

    public boolean ha(int i) {
        return this.bcc.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bcc.length() == 0;
    }

    public JSONArray adm() {
        return this.bcc;
    }

    public void clearData() {
        this.bQq.clear();
        this.bQr.clear();
        this.bcc = null;
    }

    public void lG(String str) {
        this.bPs = str;
    }

    public String adn() {
        return this.bPs;
    }

    public long ado() {
        return this.bQs;
    }

    public long getMaxTime() {
        return this.bQt;
    }

    public JSONArray adp() {
        return this.bcc;
    }

    public boolean adq() {
        return this.bQu;
    }

    public void dJ(boolean z) {
        this.bQu = z;
    }
}
