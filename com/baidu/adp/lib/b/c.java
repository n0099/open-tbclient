package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Bu = "_crashtime";
    public static String Bv = "_crashtype";
    private int Bw;
    private int Bx;
    private b By;

    public c(b bVar) {
        this.Bw = 0;
        this.Bx = 0;
        this.By = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.By = bVar;
        if (this.By.iJ() > 0 && this.By.iN() != null) {
            this.Bw = iP();
            if (this.Bw == -1) {
                reset();
            }
        }
        if (!bVar.iM()) {
            this.Bx = iO();
        }
        this.By.f(this.Bx, true);
    }

    public String getName() {
        return this.By.getName();
    }

    public int iH() {
        return this.By.iH();
    }

    public int getType() {
        return this.Bx;
    }

    public boolean Z(int i) {
        if (this.By.iJ() >= 0 && this.Bw >= this.By.iJ() + 2) {
            i = this.By.iI();
        }
        if (i == this.Bx) {
            return false;
        }
        this.Bx = i;
        this.By.f(this.Bx, false);
        aa(i);
        return true;
    }

    public boolean aN(String str) {
        String[] iK;
        String[] iN;
        if (str == null || this.By.iJ() <= 0) {
            return false;
        }
        if (this.By.iN() != null) {
            for (String str2 : this.By.iN()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Bw++;
                    ab(this.Bw);
                    if (this.Bw >= this.By.iJ()) {
                        aa(this.By.iI());
                        this.Bx = this.By.iI();
                        this.By.f(this.By.iI(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.By.iK() != null) {
            for (String str3 : this.By.iK()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Bw++;
                    ab(this.Bw);
                    if (this.Bw >= this.By.iJ()) {
                        aa(this.By.iI());
                        this.Bx = this.By.iI();
                        this.By.f(this.By.iI(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.By.getName() + Bv, i);
        edit.commit();
    }

    private int iO() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.By.getName() + Bv, this.By.iH());
    }

    private int iP() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.By.getName() + Bu, -1);
    }

    private void ab(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.By.getName() + Bu, i);
        edit.commit();
    }

    public void reset() {
        this.Bw = 0;
    }

    public void ac(int i) {
        this.Bw = i;
    }
}
