package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String uf = "_crashtime";
    public static String ug = "_crashtype";
    private int uh;
    private int ui;
    private c uj;

    public d(c cVar) {
        this.uh = 0;
        this.ui = 0;
        this.uj = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.uj = cVar;
        if (this.uj.eS() > 0 && this.uj.eV() != null) {
            this.uh = eX();
            if (this.uh == -1) {
                reset();
            }
        }
        this.ui = eW();
        this.uj.d(this.ui, true);
    }

    public String getName() {
        return this.uj.getName();
    }

    public int eQ() {
        return this.uj.eQ();
    }

    public int getType() {
        return this.ui;
    }

    public boolean Y(int i) {
        if (this.uj.eS() >= 0 && this.uh >= this.uj.eS() + 2) {
            i = this.uj.eR();
        }
        if (i == this.ui) {
            return false;
        }
        this.ui = i;
        this.uj.d(this.ui, false);
        Z(i);
        return true;
    }

    public boolean X(String str) {
        String[] eT;
        String[] eV;
        if (str == null || this.uj.eS() <= 0) {
            return false;
        }
        if (this.uj.eV() != null) {
            for (String str2 : this.uj.eV()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.uh++;
                    aa(this.uh);
                    if (this.uh >= this.uj.eS()) {
                        Z(this.uj.eR());
                        this.ui = this.uj.eR();
                        this.uj.d(this.uj.eR(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.uj.eT() != null) {
            for (String str3 : this.uj.eT()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.uh++;
                    aa(this.uh);
                    if (this.uh >= this.uj.eS()) {
                        Z(this.uj.eR());
                        this.ui = this.uj.eR();
                        this.uj.d(this.uj.eR(), false);
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
        edit.putInt(String.valueOf(this.uj.getName()) + ug, i);
        edit.commit();
    }

    private int eW() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uj.getName()) + ug, this.uj.eQ());
    }

    private int eX() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uj.getName()) + uf, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.uj.getName()) + uf, i);
        edit.commit();
    }

    public void reset() {
        this.uh = 0;
    }

    public void ab(int i) {
        this.uh = i;
    }
}
