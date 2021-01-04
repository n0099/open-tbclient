package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bi;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    private static volatile g bkY;
    private bi aRA;
    private SparseArray<String> bkZ = new SparseArray<>();
    private SparseArray<String> bla = new SparseArray<>();
    private SparseArray<String> blb = new SparseArray<>();
    private SparseArray<String> blc = new SparseArray<>();
    private JSONObject bld;

    public void O(JSONObject jSONObject) {
        this.bld = jSONObject;
    }

    private g() {
    }

    public static g Ly() {
        if (bkY == null) {
            synchronized (g.class) {
                if (bkY == null) {
                    bkY = new g();
                }
            }
        }
        return bkY;
    }

    public String Lz() {
        if (LB() || this.aRA.aQQ == null) {
            return null;
        }
        return this.aRA.aQQ;
    }

    public String eR(int i) {
        String str = this.bkZ.get(i);
        if (TextUtils.isEmpty(str)) {
            if (LB() || this.aRA.aQU == null) {
                return null;
            }
            String optString = this.aRA.aQU.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bkZ.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eS(int i) {
        String str = this.bla.get(i);
        if (TextUtils.isEmpty(str)) {
            if (LB() || this.aRA.aQS == null) {
                return null;
            }
            String optString = this.aRA.aQS.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bla.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eT(int i) {
        String str = this.blb.get(i);
        if (TextUtils.isEmpty(str)) {
            if (LB() || this.aRA.aQT == null) {
                return null;
            }
            String optString = this.aRA.aQT.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.blb.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eU(int i) {
        String str = this.blc.get(i);
        if (TextUtils.isEmpty(str)) {
            if (LB() || this.aRA.aQV == null) {
                return null;
            }
            String optString = this.aRA.aQV.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.blc.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bi LA() {
        if (LB()) {
            return null;
        }
        return this.aRA;
    }

    private boolean LB() {
        if (this.aRA == null) {
            this.aRA = com.baidu.live.af.a.SE().bCb.aRA;
            if (this.aRA == null) {
                return true;
            }
        }
        return false;
    }

    public int hF(String str) {
        if (this.bld == null) {
            return -1;
        }
        return this.bld.optInt(str);
    }
}
