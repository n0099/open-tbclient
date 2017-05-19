package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String ul = "_crashtime";
    public static String um = "_crashtype";
    private int uo;
    private int up;
    private c uq;

    public d(c cVar) {
        this.uo = 0;
        this.up = 0;
        this.uq = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.uq = cVar;
        if (this.uq.eT() > 0 && this.uq.eW() != null) {
            this.uo = eY();
            if (this.uo == -1) {
                reset();
            }
        }
        this.up = eX();
        this.uq.d(this.up, true);
    }

    public String getName() {
        return this.uq.getName();
    }

    public int eR() {
        return this.uq.eR();
    }

    public int getType() {
        return this.up;
    }

    public boolean Y(int i) {
        if (this.uq.eT() >= 0 && this.uo >= this.uq.eT() + 2) {
            i = this.uq.eS();
        }
        if (i == this.up) {
            return false;
        }
        this.up = i;
        this.uq.d(this.up, false);
        Z(i);
        return true;
    }

    public boolean X(String str) {
        String[] eU;
        String[] eW;
        if (str == null || this.uq.eT() <= 0) {
            return false;
        }
        if (this.uq.eW() != null) {
            for (String str2 : this.uq.eW()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.uo++;
                    aa(this.uo);
                    if (this.uo >= this.uq.eT()) {
                        Z(this.uq.eS());
                        this.up = this.uq.eS();
                        this.uq.d(this.uq.eS(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.uq.eU() != null) {
            for (String str3 : this.uq.eU()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.uo++;
                    aa(this.uo);
                    if (this.uo >= this.uq.eT()) {
                        Z(this.uq.eS());
                        this.up = this.uq.eS();
                        this.uq.d(this.uq.eS(), false);
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
        edit.putInt(String.valueOf(this.uq.getName()) + um, i);
        edit.commit();
    }

    private int eX() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uq.getName()) + um, this.uq.eR());
    }

    private int eY() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uq.getName()) + ul, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.uq.getName()) + ul, i);
        edit.commit();
    }

    public void reset() {
        this.uo = 0;
    }

    public void ab(int i) {
        this.uo = i;
    }
}
