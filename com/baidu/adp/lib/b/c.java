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
        if (this.tJ.eP() > 0 && this.tJ.eS() != null) {
            this.tH = eU();
            if (this.tH == -1) {
                reset();
            }
        }
        this.tI = eT();
        this.tJ.c(this.tI, true);
    }

    public String getName() {
        return this.tJ.getName();
    }

    public int eN() {
        return this.tJ.eN();
    }

    public int getType() {
        return this.tI;
    }

    public boolean X(int i) {
        if (this.tJ.eP() >= 0 && this.tH >= this.tJ.eP() + 2) {
            i = this.tJ.eO();
        }
        if (i == this.tI) {
            return false;
        }
        this.tI = i;
        this.tJ.c(this.tI, false);
        Y(i);
        return true;
    }

    public boolean ae(String str) {
        String[] eQ;
        String[] eS;
        if (str == null || this.tJ.eP() <= 0) {
            return false;
        }
        if (this.tJ.eS() != null) {
            for (String str2 : this.tJ.eS()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.tH++;
                    Z(this.tH);
                    if (this.tH >= this.tJ.eP()) {
                        Y(this.tJ.eO());
                        this.tI = this.tJ.eO();
                        this.tJ.c(this.tJ.eO(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.tJ.eQ() != null) {
            for (String str3 : this.tJ.eQ()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.tH++;
                    Z(this.tH);
                    if (this.tH >= this.tJ.eP()) {
                        Y(this.tJ.eO());
                        this.tI = this.tJ.eO();
                        this.tJ.c(this.tJ.eO(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void Y(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tJ.getName() + tG, i);
        edit.commit();
    }

    private int eT() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tJ.getName() + tG, this.tJ.eN());
    }

    private int eU() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tJ.getName() + tF, -1);
    }

    private void Z(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tJ.getName() + tF, i);
        edit.commit();
    }

    public void reset() {
        this.tH = 0;
    }

    public void aa(int i) {
        this.tH = i;
    }
}
