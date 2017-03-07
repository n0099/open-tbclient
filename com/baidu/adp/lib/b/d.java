package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String uD = "_crashtime";
    public static String uE = "_crashtype";
    private int uF;
    private int uG;
    private c uH;

    public d(c cVar) {
        this.uF = 0;
        this.uG = 0;
        this.uH = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.uH = cVar;
        if (this.uH.getMaxCrashTimes() > 0 && this.uH.eQ() != null) {
            this.uF = eS();
            if (this.uF == -1) {
                reset();
            }
        }
        this.uG = eR();
        this.uH.d(this.uG, true);
    }

    public String getName() {
        return this.uH.getName();
    }

    public int getDefaultType() {
        return this.uH.getDefaultType();
    }

    public int getType() {
        return this.uG;
    }

    public boolean Z(int i) {
        if (this.uH.getMaxCrashTimes() >= 0 && this.uF >= this.uH.getMaxCrashTimes() + 2) {
            i = this.uH.getOffType();
        }
        if (i == this.uG) {
            return false;
        }
        this.uG = i;
        this.uH.d(this.uG, false);
        aa(i);
        return true;
    }

    public boolean aa(String str) {
        String[] switchLibs;
        String[] eQ;
        if (str == null || this.uH.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.uH.eQ() != null) {
            for (String str2 : this.uH.eQ()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.uF++;
                    ab(this.uF);
                    if (this.uF >= this.uH.getMaxCrashTimes()) {
                        aa(this.uH.getOffType());
                        this.uG = this.uH.getOffType();
                        this.uH.d(this.uH.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.uH.getSwitchLibs() != null) {
            for (String str3 : this.uH.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.uF++;
                    ab(this.uF);
                    if (this.uF >= this.uH.getMaxCrashTimes()) {
                        aa(this.uH.getOffType());
                        this.uG = this.uH.getOffType();
                        this.uH.d(this.uH.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.uH.getName()) + uE, i);
        edit.commit();
    }

    private int eR() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uH.getName()) + uE, this.uH.getDefaultType());
    }

    private int eS() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.uH.getName()) + uD, -1);
    }

    private void ab(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.uH.getName()) + uD, i);
        edit.commit();
    }

    public void reset() {
        this.uF = 0;
    }

    public void ac(int i) {
        this.uF = i;
    }
}
