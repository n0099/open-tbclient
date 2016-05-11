package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String jU = "_crashtime";
    public static String jV = "_crashtype";
    private int jW;
    private int jX;
    private c jY;

    public d(c cVar) {
        this.jW = 0;
        this.jX = 0;
        this.jY = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.jY = cVar;
        if (this.jY.getMaxCrashTimes() > 0 && this.jY.cP() != null) {
            this.jW = cR();
            if (this.jW == -1) {
                reset();
            }
        }
        this.jX = cQ();
        this.jY.b(this.jX, true);
    }

    public String getName() {
        return this.jY.getName();
    }

    public int getDefaultType() {
        return this.jY.getDefaultType();
    }

    public int getType() {
        return this.jX;
    }

    public boolean I(int i) {
        if (this.jY.getMaxCrashTimes() >= 0 && this.jW >= this.jY.getMaxCrashTimes() + 2) {
            i = this.jY.getOffType();
        }
        if (i == this.jX) {
            return false;
        }
        this.jX = i;
        this.jY.b(this.jX, false);
        J(i);
        return true;
    }

    public boolean Y(String str) {
        String[] switchLibs;
        String[] cP;
        if (str == null || this.jY.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.jY.cP() != null) {
            for (String str2 : this.jY.cP()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.jW++;
                    K(this.jW);
                    if (this.jW >= this.jY.getMaxCrashTimes()) {
                        J(this.jY.getOffType());
                        this.jX = this.jY.getOffType();
                        this.jY.b(this.jY.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.jY.getSwitchLibs() != null) {
            for (String str3 : this.jY.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.jW++;
                    K(this.jW);
                    if (this.jW >= this.jY.getMaxCrashTimes()) {
                        J(this.jY.getOffType());
                        this.jX = this.jY.getOffType();
                        this.jY.b(this.jY.getOffType(), false);
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
        edit.putInt(String.valueOf(this.jY.getName()) + jV, i);
        edit.commit();
    }

    private int cQ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.jY.getName()) + jV, this.jY.getDefaultType());
    }

    private int cR() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.jY.getName()) + jU, -1);
    }

    private void K(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.jY.getName()) + jU, i);
        edit.commit();
    }

    public void reset() {
        this.jW = 0;
    }

    public void L(int i) {
        this.jW = i;
    }
}
