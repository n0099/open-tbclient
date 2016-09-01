package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String mP = "_crashtime";
    public static String mQ = "_crashtype";
    private int mS;
    private int mT;
    private c mU;

    public d(c cVar) {
        this.mS = 0;
        this.mT = 0;
        this.mU = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.mU = cVar;
        if (this.mU.getMaxCrashTimes() > 0 && this.mU.dK() != null) {
            this.mS = dM();
            if (this.mS == -1) {
                reset();
            }
        }
        this.mT = dL();
        this.mU.d(this.mT, true);
    }

    public String getName() {
        return this.mU.getName();
    }

    public int getDefaultType() {
        return this.mU.getDefaultType();
    }

    public int getType() {
        return this.mT;
    }

    public boolean Y(int i) {
        if (this.mU.getMaxCrashTimes() >= 0 && this.mS >= this.mU.getMaxCrashTimes() + 2) {
            i = this.mU.getOffType();
        }
        if (i == this.mT) {
            return false;
        }
        this.mT = i;
        this.mU.d(this.mT, false);
        Z(i);
        return true;
    }

    public boolean ab(String str) {
        String[] switchLibs;
        String[] dK;
        if (str == null || this.mU.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.mU.dK() != null) {
            for (String str2 : this.mU.dK()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.mS++;
                    aa(this.mS);
                    if (this.mS >= this.mU.getMaxCrashTimes()) {
                        Z(this.mU.getOffType());
                        this.mT = this.mU.getOffType();
                        this.mU.d(this.mU.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.mU.getSwitchLibs() != null) {
            for (String str3 : this.mU.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.mS++;
                    aa(this.mS);
                    if (this.mS >= this.mU.getMaxCrashTimes()) {
                        Z(this.mU.getOffType());
                        this.mT = this.mU.getOffType();
                        this.mU.d(this.mU.getOffType(), false);
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
        edit.putInt(String.valueOf(this.mU.getName()) + mQ, i);
        edit.commit();
    }

    private int dL() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.mU.getName()) + mQ, this.mU.getDefaultType());
    }

    private int dM() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.mU.getName()) + mP, -1);
    }

    private void aa(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.mU.getName()) + mP, i);
        edit.commit();
    }

    public void reset() {
        this.mS = 0;
    }

    public void ab(int i) {
        this.mS = i;
    }
}
