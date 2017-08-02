package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String ul = "_crashtime";
    public static String um = "_crashtype";
    private int uo;
    private int up;
    private b uq;

    public c(b bVar) {
        this.uo = 0;
        this.up = 0;
        this.uq = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.uq = bVar;
        if (this.uq.eQ() > 0 && this.uq.eT() != null) {
            this.uo = eV();
            if (this.uo == -1) {
                reset();
            }
        }
        this.up = eU();
        this.uq.d(this.up, true);
    }

    public String getName() {
        return this.uq.getName();
    }

    public int eO() {
        return this.uq.eO();
    }

    public int getType() {
        return this.up;
    }

    public boolean Y(int i) {
        if (this.uq.eQ() >= 0 && this.uo >= this.uq.eQ() + 2) {
            i = this.uq.eP();
        }
        if (i == this.up) {
            return false;
        }
        this.up = i;
        this.uq.d(this.up, false);
        Z(i);
        return true;
    }

    public boolean ae(String str) {
        String[] eR;
        String[] eT;
        if (str == null || this.uq.eQ() <= 0) {
            return false;
        }
        if (this.uq.eT() != null) {
            for (String str2 : this.uq.eT()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.uo++;
                    aa(this.uo);
                    if (this.uo >= this.uq.eQ()) {
                        Z(this.uq.eP());
                        this.up = this.uq.eP();
                        this.uq.d(this.uq.eP(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.uq.eR() != null) {
            for (String str3 : this.uq.eR()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.uo++;
                    aa(this.uo);
                    if (this.uo >= this.uq.eQ()) {
                        Z(this.uq.eP());
                        this.up = this.uq.eP();
                        this.uq.d(this.uq.eP(), false);
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
        edit.putInt(this.uq.getName() + um, i);
        edit.commit();
    }

    private int eU() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.uq.getName() + um, this.uq.eO());
    }

    private int eV() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.uq.getName() + ul, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.uq.getName() + ul, i);
        edit.commit();
    }

    public void reset() {
        this.uo = 0;
    }

    public void ab(int i) {
        this.uo = i;
    }
}
