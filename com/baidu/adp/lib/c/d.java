package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String mQ = "_crashtime";
    public static String mS = "_crashtype";
    private int mT;
    private int mU;
    private c mV;

    public d(c cVar) {
        this.mT = 0;
        this.mU = 0;
        this.mV = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.mV = cVar;
        if (this.mV.getMaxCrashTimes() > 0 && this.mV.dK() != null) {
            this.mT = dM();
            if (this.mT == -1) {
                reset();
            }
        }
        this.mU = dL();
        this.mV.d(this.mU, true);
    }

    public String getName() {
        return this.mV.getName();
    }

    public int getDefaultType() {
        return this.mV.getDefaultType();
    }

    public int getType() {
        return this.mU;
    }

    public boolean Y(int i) {
        if (this.mV.getMaxCrashTimes() >= 0 && this.mT >= this.mV.getMaxCrashTimes() + 2) {
            i = this.mV.getOffType();
        }
        if (i == this.mU) {
            return false;
        }
        this.mU = i;
        this.mV.d(this.mU, false);
        Z(i);
        return true;
    }

    public boolean ab(String str) {
        String[] switchLibs;
        String[] dK;
        if (str == null || this.mV.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.mV.dK() != null) {
            for (String str2 : this.mV.dK()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.mT++;
                    aa(this.mT);
                    if (this.mT >= this.mV.getMaxCrashTimes()) {
                        Z(this.mV.getOffType());
                        this.mU = this.mV.getOffType();
                        this.mV.d(this.mV.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.mV.getSwitchLibs() != null) {
            for (String str3 : this.mV.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.mT++;
                    aa(this.mT);
                    if (this.mT >= this.mV.getMaxCrashTimes()) {
                        Z(this.mV.getOffType());
                        this.mU = this.mV.getOffType();
                        this.mV.d(this.mV.getOffType(), false);
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
        edit.putInt(String.valueOf(this.mV.getName()) + mS, i);
        edit.commit();
    }

    private int dL() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.mV.getName()) + mS, this.mV.getDefaultType());
    }

    private int dM() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.mV.getName()) + mQ, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.mV.getName()) + mQ, i);
        edit.commit();
    }

    public void reset() {
        this.mT = 0;
    }

    public void ab(int i) {
        this.mT = i;
    }
}
