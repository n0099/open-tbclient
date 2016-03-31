package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
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
        if (this.uj.getMaxCrashTimes() > 0 && this.uj.gB() != null) {
            this.uh = gD();
            if (this.uh == -1) {
                reset();
            }
        }
        this.ui = gC();
        this.uj.b(this.ui, true);
    }

    public String getName() {
        return this.uj.getName();
    }

    public int getDefaultType() {
        return this.uj.getDefaultType();
    }

    public int getType() {
        return this.ui;
    }

    public boolean U(int i) {
        if (this.uj.getMaxCrashTimes() >= 0 && this.uh >= this.uj.getMaxCrashTimes() + 2) {
            i = this.uj.getOffType();
        }
        if (i == this.ui) {
            return false;
        }
        this.ui = i;
        this.uj.b(this.ui, false);
        V(i);
        return true;
    }

    public boolean ah(String str) {
        if (str == null || this.uj.getMaxCrashTimes() <= 0 || this.uj.gB() == null) {
            return false;
        }
        for (String str2 : this.uj.gB()) {
            if (str.indexOf(str2) != -1) {
                this.uh++;
                W(this.uh);
                if (this.uh >= this.uj.getMaxCrashTimes()) {
                    V(this.uj.getOffType());
                    this.ui = this.uj.getOffType();
                    this.uj.b(this.uj.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void V(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.uj.getName()) + ug, i);
        edit.commit();
    }

    private int gC() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uj.getName()) + ug, this.uj.getDefaultType());
    }

    private int gD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uj.getName()) + uf, -1);
    }

    private void W(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.uj.getName()) + uf, i);
        edit.commit();
    }

    public void reset() {
        this.uh = 0;
    }

    public void X(int i) {
        this.uh = i;
    }
}
