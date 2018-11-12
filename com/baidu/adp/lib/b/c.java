package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Bw = "_crashtime";
    public static String Bx = "_crashtype";
    private b BA;
    private int By;
    private int Bz;

    public c(b bVar) {
        this.By = 0;
        this.Bz = 0;
        this.BA = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.BA = bVar;
        if (this.BA.iJ() > 0 && this.BA.iN() != null) {
            this.By = iP();
            if (this.By == -1) {
                reset();
            }
        }
        if (!bVar.iM()) {
            this.Bz = iO();
        }
        this.BA.f(this.Bz, true);
    }

    public String getName() {
        return this.BA.getName();
    }

    public int iH() {
        return this.BA.iH();
    }

    public int getType() {
        return this.Bz;
    }

    public boolean ar(int i) {
        if (this.BA.iJ() >= 0 && this.By >= this.BA.iJ() + 2) {
            i = this.BA.iI();
        }
        if (i == this.Bz) {
            return false;
        }
        this.Bz = i;
        this.BA.f(this.Bz, false);
        as(i);
        return true;
    }

    public boolean aN(String str) {
        String[] iK;
        String[] iN;
        if (str == null || this.BA.iJ() <= 0) {
            return false;
        }
        if (this.BA.iN() != null) {
            for (String str2 : this.BA.iN()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.By++;
                    at(this.By);
                    if (this.By >= this.BA.iJ()) {
                        as(this.BA.iI());
                        this.Bz = this.BA.iI();
                        this.BA.f(this.BA.iI(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.BA.iK() != null) {
            for (String str3 : this.BA.iK()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.By++;
                    at(this.By);
                    if (this.By >= this.BA.iJ()) {
                        as(this.BA.iI());
                        this.Bz = this.BA.iI();
                        this.BA.f(this.BA.iI(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void as(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.BA.getName() + Bx, i);
        edit.commit();
    }

    private int iO() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.BA.getName() + Bx, this.BA.iH());
    }

    private int iP() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.BA.getName() + Bw, -1);
    }

    private void at(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.BA.getName() + Bw, i);
        edit.commit();
    }

    public void reset() {
        this.By = 0;
    }

    public void au(int i) {
        this.By = i;
    }
}
