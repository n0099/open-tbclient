package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String mK = "_crashtime";
    public static String mL = "_crashtype";
    private int mM;
    private int mN;
    private c mO;

    public d(c cVar) {
        this.mM = 0;
        this.mN = 0;
        this.mO = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.mO = cVar;
        if (this.mO.getMaxCrashTimes() > 0 && this.mO.dI() != null) {
            this.mM = dK();
            if (this.mM == -1) {
                reset();
            }
        }
        this.mN = dJ();
        this.mO.d(this.mN, true);
    }

    public String getName() {
        return this.mO.getName();
    }

    public int getDefaultType() {
        return this.mO.getDefaultType();
    }

    public int getType() {
        return this.mN;
    }

    public boolean Z(int i) {
        if (this.mO.getMaxCrashTimes() >= 0 && this.mM >= this.mO.getMaxCrashTimes() + 2) {
            i = this.mO.getOffType();
        }
        if (i == this.mN) {
            return false;
        }
        this.mN = i;
        this.mO.d(this.mN, false);
        aa(i);
        return true;
    }

    public boolean ab(String str) {
        String[] switchLibs;
        String[] dI;
        if (str == null || this.mO.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.mO.dI() != null) {
            for (String str2 : this.mO.dI()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.mM++;
                    ab(this.mM);
                    if (this.mM >= this.mO.getMaxCrashTimes()) {
                        aa(this.mO.getOffType());
                        this.mN = this.mO.getOffType();
                        this.mO.d(this.mO.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.mO.getSwitchLibs() != null) {
            for (String str3 : this.mO.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.mM++;
                    ab(this.mM);
                    if (this.mM >= this.mO.getMaxCrashTimes()) {
                        aa(this.mO.getOffType());
                        this.mN = this.mO.getOffType();
                        this.mO.d(this.mO.getOffType(), false);
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
        edit.putInt(String.valueOf(this.mO.getName()) + mL, i);
        edit.commit();
    }

    private int dJ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.mO.getName()) + mL, this.mO.getDefaultType());
    }

    private int dK() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.mO.getName()) + mK, -1);
    }

    private void ab(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.mO.getName()) + mK, i);
        edit.commit();
    }

    public void reset() {
        this.mM = 0;
    }

    public void ac(int i) {
        this.mM = i;
    }
}
