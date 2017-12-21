package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String tG = "_crashtime";
    public static String tH = "_crashtype";
    private int tI;
    private int tJ;
    private b tK;

    public c(b bVar) {
        this.tI = 0;
        this.tJ = 0;
        this.tK = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tK = bVar;
        if (this.tK.eP() > 0 && this.tK.eS() != null) {
            this.tI = eU();
            if (this.tI == -1) {
                reset();
            }
        }
        this.tJ = eT();
        this.tK.c(this.tJ, true);
    }

    public String getName() {
        return this.tK.getName();
    }

    public int eN() {
        return this.tK.eN();
    }

    public int getType() {
        return this.tJ;
    }

    public boolean X(int i) {
        if (this.tK.eP() >= 0 && this.tI >= this.tK.eP() + 2) {
            i = this.tK.eO();
        }
        if (i == this.tJ) {
            return false;
        }
        this.tJ = i;
        this.tK.c(this.tJ, false);
        Y(i);
        return true;
    }

    public boolean ae(String str) {
        String[] eQ;
        String[] eS;
        if (str == null || this.tK.eP() <= 0) {
            return false;
        }
        if (this.tK.eS() != null) {
            for (String str2 : this.tK.eS()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.tI++;
                    Z(this.tI);
                    if (this.tI >= this.tK.eP()) {
                        Y(this.tK.eO());
                        this.tJ = this.tK.eO();
                        this.tK.c(this.tK.eO(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.tK.eQ() != null) {
            for (String str3 : this.tK.eQ()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.tI++;
                    Z(this.tI);
                    if (this.tI >= this.tK.eP()) {
                        Y(this.tK.eO());
                        this.tJ = this.tK.eO();
                        this.tK.c(this.tK.eO(), false);
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
        edit.putInt(this.tK.getName() + tH, i);
        edit.commit();
    }

    private int eT() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tK.getName() + tH, this.tK.eN());
    }

    private int eU() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tK.getName() + tG, -1);
    }

    private void Z(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tK.getName() + tG, i);
        edit.commit();
    }

    public void reset() {
        this.tI = 0;
    }

    public void aa(int i) {
        this.tI = i;
    }
}
