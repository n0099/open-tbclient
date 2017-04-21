package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String uk = "_crashtime";
    public static String ul = "_crashtype";
    private int um;
    private int uo;
    private c up;

    public d(c cVar) {
        this.um = 0;
        this.uo = 0;
        this.up = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.up = cVar;
        if (this.up.eT() > 0 && this.up.eW() != null) {
            this.um = eY();
            if (this.um == -1) {
                reset();
            }
        }
        this.uo = eX();
        this.up.d(this.uo, true);
    }

    public String getName() {
        return this.up.getName();
    }

    public int eR() {
        return this.up.eR();
    }

    public int getType() {
        return this.uo;
    }

    public boolean Y(int i) {
        if (this.up.eT() >= 0 && this.um >= this.up.eT() + 2) {
            i = this.up.eS();
        }
        if (i == this.uo) {
            return false;
        }
        this.uo = i;
        this.up.d(this.uo, false);
        Z(i);
        return true;
    }

    public boolean X(String str) {
        String[] eU;
        String[] eW;
        if (str == null || this.up.eT() <= 0) {
            return false;
        }
        if (this.up.eW() != null) {
            for (String str2 : this.up.eW()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.um++;
                    aa(this.um);
                    if (this.um >= this.up.eT()) {
                        Z(this.up.eS());
                        this.uo = this.up.eS();
                        this.up.d(this.up.eS(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.up.eU() != null) {
            for (String str3 : this.up.eU()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.um++;
                    aa(this.um);
                    if (this.um >= this.up.eT()) {
                        Z(this.up.eS());
                        this.uo = this.up.eS();
                        this.up.d(this.up.eS(), false);
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
        edit.putInt(String.valueOf(this.up.getName()) + ul, i);
        edit.commit();
    }

    private int eX() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.up.getName()) + ul, this.up.eR());
    }

    private int eY() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.up.getName()) + uk, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.up.getName()) + uk, i);
        edit.commit();
    }

    public void reset() {
        this.um = 0;
    }

    public void ab(int i) {
        this.um = i;
    }
}
