package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String tH = "_crashtime";
    public static String tI = "_crashtype";
    private int tJ;
    private int tK;
    private c tL;

    public d(c cVar) {
        this.tJ = 0;
        this.tK = 0;
        this.tL = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tL = cVar;
        if (this.tL.getMaxCrashTimes() > 0 && this.tL.gv() != null) {
            this.tJ = gx();
            if (this.tJ == -1) {
                reset();
            }
        }
        this.tK = gw();
        this.tL.b(this.tK, true);
    }

    public String getName() {
        return this.tL.getName();
    }

    public int getDefaultType() {
        return this.tL.getDefaultType();
    }

    public int getType() {
        return this.tK;
    }

    public boolean J(int i) {
        if (this.tL.getMaxCrashTimes() >= 0 && this.tJ >= this.tL.getMaxCrashTimes() + 2) {
            i = this.tL.getOffType();
        }
        if (i == this.tK) {
            return false;
        }
        this.tK = i;
        this.tL.b(this.tK, false);
        K(i);
        return true;
    }

    public boolean ag(String str) {
        if (str == null || this.tL.getMaxCrashTimes() <= 0 || this.tL.gv() == null) {
            return false;
        }
        for (String str2 : this.tL.gv()) {
            if (str.indexOf(str2) != -1) {
                this.tJ++;
                L(this.tJ);
                if (this.tJ >= this.tL.getMaxCrashTimes()) {
                    K(this.tL.getOffType());
                    this.tK = this.tL.getOffType();
                    this.tL.b(this.tL.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void K(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tL.getName()) + tI, i);
        edit.commit();
    }

    private int gw() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tL.getName()) + tI, this.tL.getDefaultType());
    }

    private int gx() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tL.getName()) + tH, -1);
    }

    private void L(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tL.getName()) + tH, i);
        edit.commit();
    }

    public void reset() {
        this.tJ = 0;
    }

    public void M(int i) {
        this.tJ = i;
    }
}
