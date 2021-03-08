package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    private static volatile g bkR;
    private bn aRl;
    private SparseArray<String> bkS = new SparseArray<>();
    private SparseArray<String> bkT = new SparseArray<>();
    private SparseArray<String> bkU = new SparseArray<>();
    private SparseArray<String> bkV = new SparseArray<>();
    private JSONObject bkW;

    public void Q(JSONObject jSONObject) {
        this.bkW = jSONObject;
    }

    private g() {
    }

    public static g IW() {
        if (bkR == null) {
            synchronized (g.class) {
                if (bkR == null) {
                    bkR = new g();
                }
            }
        }
        return bkR;
    }

    public String IX() {
        if (IZ() || this.aRl.aQB == null) {
            return null;
        }
        return this.aRl.aQB;
    }

    public String dr(int i) {
        String str = this.bkS.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IZ() || this.aRl.aQF == null) {
                return null;
            }
            String optString = this.aRl.aQF.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bkS.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ds(int i) {
        String str = this.bkT.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IZ() || this.aRl.aQD == null) {
                return null;
            }
            String optString = this.aRl.aQD.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bkT.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String dt(int i) {
        String str = this.bkU.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IZ() || this.aRl.aQE == null) {
                return null;
            }
            String optString = this.aRl.aQE.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bkU.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String du(int i) {
        String str = this.bkV.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IZ() || this.aRl.aQG == null) {
                return null;
            }
            String optString = this.aRl.aQG.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bkV.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bn IY() {
        if (IZ()) {
            return null;
        }
        return this.aRl;
    }

    private boolean IZ() {
        if (this.aRl == null) {
            this.aRl = com.baidu.live.ae.a.Qm().bCs.aRl;
            if (this.aRl == null) {
                return true;
            }
        }
        return false;
    }

    public int gX(String str) {
        if (this.bkW == null) {
            return -1;
        }
        return this.bkW.optInt(str);
    }
}
