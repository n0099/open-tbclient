package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String tI = "_crashtime";
    public static String tJ = "_crashtype";
    private int tK;
    private int tL;
    private b tM;

    public c(b bVar) {
        this.tK = 0;
        this.tL = 0;
        this.tM = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tM = bVar;
        if (this.tM.eP() > 0 && this.tM.eS() != null) {
            this.tK = eU();
            if (this.tK == -1) {
                reset();
            }
        }
        this.tL = eT();
        this.tM.c(this.tL, true);
    }

    public String getName() {
        return this.tM.getName();
    }

    public int eN() {
        return this.tM.eN();
    }

    public int getType() {
        return this.tL;
    }

    public boolean Y(int i) {
        if (this.tM.eP() >= 0 && this.tK >= this.tM.eP() + 2) {
            i = this.tM.eO();
        }
        if (i == this.tL) {
            return false;
        }
        this.tL = i;
        this.tM.c(this.tL, false);
        Z(i);
        return true;
    }

    public boolean ae(String str) {
        String[] eQ;
        String[] eS;
        if (str == null || this.tM.eP() <= 0) {
            return false;
        }
        if (this.tM.eS() != null) {
            for (String str2 : this.tM.eS()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.tK++;
                    aa(this.tK);
                    if (this.tK >= this.tM.eP()) {
                        Z(this.tM.eO());
                        this.tL = this.tM.eO();
                        this.tM.c(this.tM.eO(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.tM.eQ() != null) {
            for (String str3 : this.tM.eQ()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.tK++;
                    aa(this.tK);
                    if (this.tK >= this.tM.eP()) {
                        Z(this.tM.eO());
                        this.tL = this.tM.eO();
                        this.tM.c(this.tM.eO(), false);
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
        edit.putInt(this.tM.getName() + tJ, i);
        edit.commit();
    }

    private int eT() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tM.getName() + tJ, this.tM.eN());
    }

    private int eU() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.tM.getName() + tI, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.tM.getName() + tI, i);
        edit.commit();
    }

    public void reset() {
        this.tK = 0;
    }

    public void ab(int i) {
        this.tK = i;
    }
}
