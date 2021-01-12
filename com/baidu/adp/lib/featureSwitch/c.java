package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Lq = "_crashtime";
    public static String Lr = "_crashtype";
    private int Ls;
    private int Lt;
    private b Lu;

    public c(b bVar) {
        this.Ls = 0;
        this.Lt = 0;
        this.Lu = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Lu = bVar;
        if (this.Lu.getMaxCrashTimes() > 0 && this.Lu.lC() != null) {
            this.Ls = lF();
            if (this.Ls == -1) {
                reset();
            }
        }
        if (!bVar.lB()) {
            this.Lt = lE();
        }
        this.Lu.k(this.Lt, true);
    }

    public b lD() {
        return this.Lu;
    }

    public String getName() {
        return this.Lu.getName();
    }

    public int getDefaultType() {
        return this.Lu.getDefaultType();
    }

    public int getType() {
        return this.Lt;
    }

    public boolean ai(int i) {
        if (this.Lu.getMaxCrashTimes() >= 0 && this.Ls >= this.Lu.getMaxCrashTimes() + 2) {
            i = this.Lu.getOffType();
        }
        if (i == this.Lt) {
            return false;
        }
        this.Lt = i;
        this.Lu.k(this.Lt, false);
        aj(i);
        return true;
    }

    public boolean bE(String str) {
        String[] switchLibs;
        String[] lC;
        if (str == null || this.Lu.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Lu.lC() != null) {
            for (String str2 : this.Lu.lC()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Ls++;
                    ak(this.Ls);
                    if (this.Ls >= this.Lu.getMaxCrashTimes()) {
                        aj(this.Lu.getOffType());
                        this.Lt = this.Lu.getOffType();
                        this.Lu.k(this.Lu.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Lu.getSwitchLibs() != null) {
            for (String str3 : this.Lu.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Ls++;
                    ak(this.Ls);
                    if (this.Ls >= this.Lu.getMaxCrashTimes()) {
                        aj(this.Lu.getOffType());
                        this.Lt = this.Lu.getOffType();
                        this.Lu.k(this.Lu.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void aj(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Lu.getName() + Lr, i);
        edit.commit();
    }

    private int lE() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Lu.getName() + Lr, this.Lu.getDefaultType());
    }

    private int lF() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Lu.getName() + Lq, -1);
    }

    private void ak(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Lu.getName() + Lq, i);
        edit.commit();
    }

    public void reset() {
        this.Ls = 0;
    }

    public void al(int i) {
        this.Ls = i;
    }
}
