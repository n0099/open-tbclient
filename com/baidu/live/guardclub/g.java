package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bn;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    private static volatile g bjr;
    private bn aPL;
    private SparseArray<String> bjs = new SparseArray<>();
    private SparseArray<String> bjt = new SparseArray<>();
    private SparseArray<String> bju = new SparseArray<>();
    private SparseArray<String> bjv = new SparseArray<>();
    private JSONObject bjw;

    public void O(JSONObject jSONObject) {
        this.bjw = jSONObject;
    }

    private g() {
    }

    public static g IT() {
        if (bjr == null) {
            synchronized (g.class) {
                if (bjr == null) {
                    bjr = new g();
                }
            }
        }
        return bjr;
    }

    public String IU() {
        if (IW() || this.aPL.aPb == null) {
            return null;
        }
        return this.aPL.aPb;
    }

    public String dq(int i) {
        String str = this.bjs.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IW() || this.aPL.aPf == null) {
                return null;
            }
            String optString = this.aPL.aPf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjs.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String dr(int i) {
        String str = this.bjt.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IW() || this.aPL.aPd == null) {
                return null;
            }
            String optString = this.aPL.aPd.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjt.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ds(int i) {
        String str = this.bju.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IW() || this.aPL.aPe == null) {
                return null;
            }
            String optString = this.aPL.aPe.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bju.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String dt(int i) {
        String str = this.bjv.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IW() || this.aPL.aPg == null) {
                return null;
            }
            String optString = this.aPL.aPg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjv.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bn IV() {
        if (IW()) {
            return null;
        }
        return this.aPL;
    }

    private boolean IW() {
        if (this.aPL == null) {
            this.aPL = com.baidu.live.ae.a.Qj().bAS.aPL;
            if (this.aPL == null) {
                return true;
            }
        }
        return false;
    }

    public int gR(String str) {
        if (this.bjw == null) {
            return -1;
        }
        return this.bjw.optInt(str);
    }
}
