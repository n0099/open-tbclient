package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Jk = "_crashtime";
    public static String Jl = "_crashtype";
    private int Jm;
    private int Jn;
    private b Jo;

    public c(b bVar) {
        this.Jm = 0;
        this.Jn = 0;
        this.Jo = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Jo = bVar;
        if (this.Jo.getMaxCrashTimes() > 0 && this.Jo.ki() != null) {
            this.Jm = kl();
            if (this.Jm == -1) {
                reset();
            }
        }
        if (!bVar.kh()) {
            this.Jn = kk();
        }
        this.Jo.i(this.Jn, true);
    }

    public b kj() {
        return this.Jo;
    }

    public String getName() {
        return this.Jo.getName();
    }

    public int getDefaultType() {
        return this.Jo.getDefaultType();
    }

    public int getType() {
        return this.Jn;
    }

    public boolean T(int i) {
        if (this.Jo.getMaxCrashTimes() >= 0 && this.Jm >= this.Jo.getMaxCrashTimes() + 2) {
            i = this.Jo.getOffType();
        }
        if (i == this.Jn) {
            return false;
        }
        this.Jn = i;
        this.Jo.i(this.Jn, false);
        U(i);
        return true;
    }

    public boolean by(String str) {
        String[] switchLibs;
        String[] ki;
        if (str == null || this.Jo.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Jo.ki() != null) {
            for (String str2 : this.Jo.ki()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Jm++;
                    V(this.Jm);
                    if (this.Jm >= this.Jo.getMaxCrashTimes()) {
                        U(this.Jo.getOffType());
                        this.Jn = this.Jo.getOffType();
                        this.Jo.i(this.Jo.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Jo.getSwitchLibs() != null) {
            for (String str3 : this.Jo.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Jm++;
                    V(this.Jm);
                    if (this.Jm >= this.Jo.getMaxCrashTimes()) {
                        U(this.Jo.getOffType());
                        this.Jn = this.Jo.getOffType();
                        this.Jo.i(this.Jo.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Jo.getName() + Jl, i);
        edit.commit();
    }

    private int kk() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Jo.getName() + Jl, this.Jo.getDefaultType());
    }

    private int kl() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Jo.getName() + Jk, -1);
    }

    private void V(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Jo.getName() + Jk, i);
        edit.commit();
    }

    public void reset() {
        this.Jm = 0;
    }

    public void W(int i) {
        this.Jm = i;
    }
}
