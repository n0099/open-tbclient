package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Bv = "_crashtime";
    public static String Bw = "_crashtype";
    private int Bx;
    private int By;
    private b Bz;

    public c(b bVar) {
        this.Bx = 0;
        this.By = 0;
        this.Bz = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Bz = bVar;
        if (this.Bz.iJ() > 0 && this.Bz.iN() != null) {
            this.Bx = iP();
            if (this.Bx == -1) {
                reset();
            }
        }
        if (!bVar.iM()) {
            this.By = iO();
        }
        this.Bz.f(this.By, true);
    }

    public String getName() {
        return this.Bz.getName();
    }

    public int iH() {
        return this.Bz.iH();
    }

    public int getType() {
        return this.By;
    }

    public boolean aa(int i) {
        if (this.Bz.iJ() >= 0 && this.Bx >= this.Bz.iJ() + 2) {
            i = this.Bz.iI();
        }
        if (i == this.By) {
            return false;
        }
        this.By = i;
        this.Bz.f(this.By, false);
        ab(i);
        return true;
    }

    public boolean aN(String str) {
        String[] iK;
        String[] iN;
        if (str == null || this.Bz.iJ() <= 0) {
            return false;
        }
        if (this.Bz.iN() != null) {
            for (String str2 : this.Bz.iN()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Bx++;
                    ac(this.Bx);
                    if (this.Bx >= this.Bz.iJ()) {
                        ab(this.Bz.iI());
                        this.By = this.Bz.iI();
                        this.Bz.f(this.Bz.iI(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Bz.iK() != null) {
            for (String str3 : this.Bz.iK()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Bx++;
                    ac(this.Bx);
                    if (this.Bx >= this.Bz.iJ()) {
                        ab(this.Bz.iI());
                        this.By = this.Bz.iI();
                        this.Bz.f(this.Bz.iI(), false);
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
        edit.putInt(this.Bz.getName() + Bw, i);
        edit.commit();
    }

    private int iO() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Bz.getName() + Bw, this.Bz.iH());
    }

    private int iP() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Bz.getName() + Bv, -1);
    }

    private void ac(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Bz.getName() + Bv, i);
        edit.commit();
    }

    public void reset() {
        this.Bx = 0;
    }

    public void ad(int i) {
        this.Bx = i;
    }
}
