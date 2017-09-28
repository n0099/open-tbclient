package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String tH = "_crashtime";
    public static String tI = "_crashtype";
    private int tJ;
    private int tK;
    private b tL;

    public c(b bVar) {
        this.tJ = 0;
        this.tK = 0;
        this.tL = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tL = bVar;
        if (this.tL.eP() > 0 && this.tL.eS() != null) {
            this.tJ = eU();
            if (this.tJ == -1) {
                reset();
            }
        }
        this.tK = eT();
        this.tL.c(this.tK, true);
    }

    public String getName() {
        return this.tL.getName();
    }

    public int eN() {
        return this.tL.eN();
    }

    public int getType() {
        return this.tK;
    }

    public boolean Y(int i) {
        if (this.tL.eP() >= 0 && this.tJ >= this.tL.eP() + 2) {
            i = this.tL.eO();
        }
        if (i == this.tK) {
            return false;
        }
        this.tK = i;
        this.tL.c(this.tK, false);
        Z(i);
        return true;
    }

    public boolean ae(String str) {
        String[] eQ;
        String[] eS;
        if (str == null || this.tL.eP() <= 0) {
            return false;
        }
        if (this.tL.eS() != null) {
            for (String str2 : this.tL.eS()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.tJ++;
                    aa(this.tJ);
                    if (this.tJ >= this.tL.eP()) {
                        Z(this.tL.eO());
                        this.tK = this.tL.eO();
                        this.tL.c(this.tL.eO(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.tL.eQ() != null) {
            for (String str3 : this.tL.eQ()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.tJ++;
                    aa(this.tJ);
                    if (this.tJ >= this.tL.eP()) {
                        Z(this.tL.eO());
                        this.tK = this.tL.eO();
                        this.tL.c(this.tL.eO(), false);
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
        edit.putInt(this.tL.getName() + tI, i);
        edit.commit();
    }

    private int eT() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tL.getName() + tI, this.tL.eN());
    }

    private int eU() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tL.getName() + tH, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tL.getName() + tH, i);
        edit.commit();
    }

    public void reset() {
        this.tJ = 0;
    }

    public void ab(int i) {
        this.tJ = i;
    }
}
