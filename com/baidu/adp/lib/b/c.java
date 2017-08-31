package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String tF = "_crashtime";
    public static String tG = "_crashtype";
    private int tH;
    private int tI;
    private b tJ;

    public c(b bVar) {
        this.tH = 0;
        this.tI = 0;
        this.tJ = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tJ = bVar;
        if (this.tJ.eQ() > 0 && this.tJ.eT() != null) {
            this.tH = eV();
            if (this.tH == -1) {
                reset();
            }
        }
        this.tI = eU();
        this.tJ.c(this.tI, true);
    }

    public String getName() {
        return this.tJ.getName();
    }

    public int eO() {
        return this.tJ.eO();
    }

    public int getType() {
        return this.tI;
    }

    public boolean Y(int i) {
        if (this.tJ.eQ() >= 0 && this.tH >= this.tJ.eQ() + 2) {
            i = this.tJ.eP();
        }
        if (i == this.tI) {
            return false;
        }
        this.tI = i;
        this.tJ.c(this.tI, false);
        Z(i);
        return true;
    }

    public boolean ae(String str) {
        String[] eR;
        String[] eT;
        if (str == null || this.tJ.eQ() <= 0) {
            return false;
        }
        if (this.tJ.eT() != null) {
            for (String str2 : this.tJ.eT()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.tH++;
                    aa(this.tH);
                    if (this.tH >= this.tJ.eQ()) {
                        Z(this.tJ.eP());
                        this.tI = this.tJ.eP();
                        this.tJ.c(this.tJ.eP(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.tJ.eR() != null) {
            for (String str3 : this.tJ.eR()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.tH++;
                    aa(this.tH);
                    if (this.tH >= this.tJ.eQ()) {
                        Z(this.tJ.eP());
                        this.tI = this.tJ.eP();
                        this.tJ.c(this.tJ.eP(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void Z(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tJ.getName() + tG, i);
        edit.commit();
    }

    private int eU() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tJ.getName() + tG, this.tJ.eO());
    }

    private int eV() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tJ.getName() + tF, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tJ.getName() + tF, i);
        edit.commit();
    }

    public void reset() {
        this.tH = 0;
    }

    public void ab(int i) {
        this.tH = i;
    }
}
