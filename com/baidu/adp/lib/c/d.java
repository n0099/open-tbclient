package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String jS = "_crashtime";
    public static String jT = "_crashtype";
    private int jU;
    private int jV;
    private c jW;

    public d(c cVar) {
        this.jU = 0;
        this.jV = 0;
        this.jW = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.jW = cVar;
        if (this.jW.getMaxCrashTimes() > 0 && this.jW.cQ() != null) {
            this.jU = cS();
            if (this.jU == -1) {
                reset();
            }
        }
        this.jV = cR();
        this.jW.b(this.jV, true);
    }

    public String getName() {
        return this.jW.getName();
    }

    public int getDefaultType() {
        return this.jW.getDefaultType();
    }

    public int getType() {
        return this.jV;
    }

    public boolean I(int i) {
        if (this.jW.getMaxCrashTimes() >= 0 && this.jU >= this.jW.getMaxCrashTimes() + 2) {
            i = this.jW.getOffType();
        }
        if (i == this.jV) {
            return false;
        }
        this.jV = i;
        this.jW.b(this.jV, false);
        J(i);
        return true;
    }

    public boolean Y(String str) {
        String[] switchLibs;
        String[] cQ;
        if (str == null || this.jW.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.jW.cQ() != null) {
            for (String str2 : this.jW.cQ()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.jU++;
                    K(this.jU);
                    if (this.jU >= this.jW.getMaxCrashTimes()) {
                        J(this.jW.getOffType());
                        this.jV = this.jW.getOffType();
                        this.jW.b(this.jW.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.jW.getSwitchLibs() != null) {
            for (String str3 : this.jW.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.jU++;
                    K(this.jU);
                    if (this.jU >= this.jW.getMaxCrashTimes()) {
                        J(this.jW.getOffType());
                        this.jV = this.jW.getOffType();
                        this.jW.b(this.jW.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void J(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.jW.getName()) + jT, i);
        edit.commit();
    }

    private int cR() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.jW.getName()) + jT, this.jW.getDefaultType());
    }

    private int cS() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.jW.getName()) + jS, -1);
    }

    private void K(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.jW.getName()) + jS, i);
        edit.commit();
    }

    public void reset() {
        this.jU = 0;
    }

    public void L(int i) {
        this.jU = i;
    }
}
