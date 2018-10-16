package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Bt = "_crashtime";
    public static String Bu = "_crashtype";
    private int Bv;
    private int Bw;
    private b Bx;

    public c(b bVar) {
        this.Bv = 0;
        this.Bw = 0;
        this.Bx = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Bx = bVar;
        if (this.Bx.iK() > 0 && this.Bx.iO() != null) {
            this.Bv = iQ();
            if (this.Bv == -1) {
                reset();
            }
        }
        if (!bVar.iN()) {
            this.Bw = iP();
        }
        this.Bx.f(this.Bw, true);
    }

    public String getName() {
        return this.Bx.getName();
    }

    public int iI() {
        return this.Bx.iI();
    }

    public int getType() {
        return this.Bw;
    }

    public boolean aa(int i) {
        if (this.Bx.iK() >= 0 && this.Bv >= this.Bx.iK() + 2) {
            i = this.Bx.iJ();
        }
        if (i == this.Bw) {
            return false;
        }
        this.Bw = i;
        this.Bx.f(this.Bw, false);
        ab(i);
        return true;
    }

    public boolean aN(String str) {
        String[] iL;
        String[] iO;
        if (str == null || this.Bx.iK() <= 0) {
            return false;
        }
        if (this.Bx.iO() != null) {
            for (String str2 : this.Bx.iO()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Bv++;
                    ac(this.Bv);
                    if (this.Bv >= this.Bx.iK()) {
                        ab(this.Bx.iJ());
                        this.Bw = this.Bx.iJ();
                        this.Bx.f(this.Bx.iJ(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Bx.iL() != null) {
            for (String str3 : this.Bx.iL()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Bv++;
                    ac(this.Bv);
                    if (this.Bv >= this.Bx.iK()) {
                        ab(this.Bx.iJ());
                        this.Bw = this.Bx.iJ();
                        this.Bx.f(this.Bx.iJ(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void ab(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Bx.getName() + Bu, i);
        edit.commit();
    }

    private int iP() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Bx.getName() + Bu, this.Bx.iI());
    }

    private int iQ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Bx.getName() + Bt, -1);
    }

    private void ac(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Bx.getName() + Bt, i);
        edit.commit();
    }

    public void reset() {
        this.Bv = 0;
    }

    public void ad(int i) {
        this.Bv = i;
    }
}
