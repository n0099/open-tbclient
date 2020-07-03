package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String JX = "_crashtime";
    public static String JY = "_crashtype";
    private int JZ;
    private int Ka;
    private b Kb;

    public c(b bVar) {
        this.JZ = 0;
        this.Ka = 0;
        this.Kb = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Kb = bVar;
        if (this.Kb.getMaxCrashTimes() > 0 && this.Kb.kA() != null) {
            this.JZ = kD();
            if (this.JZ == -1) {
                reset();
            }
        }
        if (!bVar.kz()) {
            this.Ka = kC();
        }
        this.Kb.j(this.Ka, true);
    }

    public b kB() {
        return this.Kb;
    }

    public String getName() {
        return this.Kb.getName();
    }

    public int getDefaultType() {
        return this.Kb.getDefaultType();
    }

    public int getType() {
        return this.Ka;
    }

    public boolean aa(int i) {
        if (this.Kb.getMaxCrashTimes() >= 0 && this.JZ >= this.Kb.getMaxCrashTimes() + 2) {
            i = this.Kb.getOffType();
        }
        if (i == this.Ka) {
            return false;
        }
        this.Ka = i;
        this.Kb.j(this.Ka, false);
        ab(i);
        return true;
    }

    public boolean bA(String str) {
        String[] switchLibs;
        String[] kA;
        if (str == null || this.Kb.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Kb.kA() != null) {
            for (String str2 : this.Kb.kA()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.JZ++;
                    ac(this.JZ);
                    if (this.JZ >= this.Kb.getMaxCrashTimes()) {
                        ab(this.Kb.getOffType());
                        this.Ka = this.Kb.getOffType();
                        this.Kb.j(this.Kb.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Kb.getSwitchLibs() != null) {
            for (String str3 : this.Kb.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.JZ++;
                    ac(this.JZ);
                    if (this.JZ >= this.Kb.getMaxCrashTimes()) {
                        ab(this.Kb.getOffType());
                        this.Ka = this.Kb.getOffType();
                        this.Kb.j(this.Kb.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void ab(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Kb.getName() + JY, i);
        edit.commit();
    }

    private int kC() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Kb.getName() + JY, this.Kb.getDefaultType());
    }

    private int kD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Kb.getName() + JX, -1);
    }

    private void ac(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Kb.getName() + JX, i);
        edit.commit();
    }

    public void reset() {
        this.JZ = 0;
    }

    public void ad(int i) {
        this.JZ = i;
    }
}
