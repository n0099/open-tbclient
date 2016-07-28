package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String kx = "_crashtime";
    public static String ky = "_crashtype";
    private int kA;
    private int kB;
    private c kC;

    public d(c cVar) {
        this.kA = 0;
        this.kB = 0;
        this.kC = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.kC = cVar;
        if (this.kC.getMaxCrashTimes() > 0 && this.kC.cP() != null) {
            this.kA = cR();
            if (this.kA == -1) {
                reset();
            }
        }
        this.kB = cQ();
        this.kC.d(this.kB, true);
    }

    public String getName() {
        return this.kC.getName();
    }

    public int getDefaultType() {
        return this.kC.getDefaultType();
    }

    public int getType() {
        return this.kB;
    }

    public boolean L(int i) {
        if (this.kC.getMaxCrashTimes() >= 0 && this.kA >= this.kC.getMaxCrashTimes() + 2) {
            i = this.kC.getOffType();
        }
        if (i == this.kB) {
            return false;
        }
        this.kB = i;
        this.kC.d(this.kB, false);
        M(i);
        return true;
    }

    public boolean aa(String str) {
        String[] switchLibs;
        String[] cP;
        if (str == null || this.kC.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.kC.cP() != null) {
            for (String str2 : this.kC.cP()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.kA++;
                    N(this.kA);
                    if (this.kA >= this.kC.getMaxCrashTimes()) {
                        M(this.kC.getOffType());
                        this.kB = this.kC.getOffType();
                        this.kC.d(this.kC.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.kC.getSwitchLibs() != null) {
            for (String str3 : this.kC.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.kA++;
                    N(this.kA);
                    if (this.kA >= this.kC.getMaxCrashTimes()) {
                        M(this.kC.getOffType());
                        this.kB = this.kC.getOffType();
                        this.kC.d(this.kC.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void M(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.kC.getName()) + ky, i);
        edit.commit();
    }

    private int cQ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.kC.getName()) + ky, this.kC.getDefaultType());
    }

    private int cR() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.kC.getName()) + kx, -1);
    }

    private void N(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.kC.getName()) + kx, i);
        edit.commit();
    }

    public void reset() {
        this.kA = 0;
    }

    public void O(int i) {
        this.kA = i;
    }
}
