package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String tF = "_crashtime";
    public static String tG = "_crashtype";
    private int tH;
    private int tI;
    private c tJ;

    public d(c cVar) {
        this.tH = 0;
        this.tI = 0;
        this.tJ = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tJ = cVar;
        if (this.tJ.getMaxCrashTimes() > 0 && this.tJ.gs() != null) {
            this.tH = gu();
            if (this.tH == -1) {
                reset();
            }
        }
        this.tI = gt();
        this.tJ.b(this.tI, true);
    }

    public String getName() {
        return this.tJ.getName();
    }

    public int getDefaultType() {
        return this.tJ.getDefaultType();
    }

    public int getType() {
        return this.tI;
    }

    public boolean J(int i) {
        if (this.tJ.getMaxCrashTimes() >= 0 && this.tH >= this.tJ.getMaxCrashTimes() + 2) {
            i = this.tJ.getOffType();
        }
        if (i == this.tI) {
            return false;
        }
        this.tI = i;
        this.tJ.b(this.tI, false);
        K(i);
        return true;
    }

    public boolean ag(String str) {
        if (str == null || this.tJ.getMaxCrashTimes() <= 0 || this.tJ.gs() == null) {
            return false;
        }
        for (String str2 : this.tJ.gs()) {
            if (str.indexOf(str2) != -1) {
                this.tH++;
                L(this.tH);
                if (this.tH >= this.tJ.getMaxCrashTimes()) {
                    K(this.tJ.getOffType());
                    this.tI = this.tJ.getOffType();
                    this.tJ.b(this.tJ.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void K(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tJ.getName()) + tG, i);
        edit.commit();
    }

    private int gt() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tJ.getName()) + tG, this.tJ.getDefaultType());
    }

    private int gu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tJ.getName()) + tF, -1);
    }

    private void L(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tJ.getName()) + tF, i);
        edit.commit();
    }

    public void reset() {
        this.tH = 0;
    }

    public void M(int i) {
        this.tH = i;
    }
}
