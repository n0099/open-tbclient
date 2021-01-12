package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bi;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    private static volatile g bgi;
    private bi aMN;
    private SparseArray<String> bgj = new SparseArray<>();
    private SparseArray<String> bgk = new SparseArray<>();
    private SparseArray<String> bgl = new SparseArray<>();
    private SparseArray<String> bgm = new SparseArray<>();
    private JSONObject bgn;

    public void O(JSONObject jSONObject) {
        this.bgn = jSONObject;
    }

    private g() {
    }

    public static g HD() {
        if (bgi == null) {
            synchronized (g.class) {
                if (bgi == null) {
                    bgi = new g();
                }
            }
        }
        return bgi;
    }

    public String HE() {
        if (HG() || this.aMN.aMd == null) {
            return null;
        }
        return this.aMN.aMd;
    }

    public String dl(int i) {
        String str = this.bgj.get(i);
        if (TextUtils.isEmpty(str)) {
            if (HG() || this.aMN.aMh == null) {
                return null;
            }
            String optString = this.aMN.aMh.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgj.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String dm(int i) {
        String str = this.bgk.get(i);
        if (TextUtils.isEmpty(str)) {
            if (HG() || this.aMN.aMf == null) {
                return null;
            }
            String optString = this.aMN.aMf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgk.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String dn(int i) {
        String str = this.bgl.get(i);
        if (TextUtils.isEmpty(str)) {
            if (HG() || this.aMN.aMg == null) {
                return null;
            }
            String optString = this.aMN.aMg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgl.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    /* renamed from: do  reason: not valid java name */
    public String m19do(int i) {
        String str = this.bgm.get(i);
        if (TextUtils.isEmpty(str)) {
            if (HG() || this.aMN.aMi == null) {
                return null;
            }
            String optString = this.aMN.aMi.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgm.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bi HF() {
        if (HG()) {
            return null;
        }
        return this.aMN;
    }

    private boolean HG() {
        if (this.aMN == null) {
            this.aMN = com.baidu.live.af.a.OJ().bxp.aMN;
            if (this.aMN == null) {
                return true;
            }
        }
        return false;
    }

    public int gu(String str) {
        if (this.bgn == null) {
            return -1;
        }
        return this.bgn.optInt(str);
    }
}
