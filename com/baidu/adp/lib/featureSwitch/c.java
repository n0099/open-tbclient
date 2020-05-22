package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Jx = "_crashtime";
    public static String Jy = "_crashtype";
    private int JA;
    private b JB;
    private int Jz;

    public c(b bVar) {
        this.Jz = 0;
        this.JA = 0;
        this.JB = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.JB = bVar;
        if (this.JB.getMaxCrashTimes() > 0 && this.JB.kk() != null) {
            this.Jz = kn();
            if (this.Jz == -1) {
                reset();
            }
        }
        if (!bVar.kj()) {
            this.JA = km();
        }
        this.JB.i(this.JA, true);
    }

    public b kl() {
        return this.JB;
    }

    public String getName() {
        return this.JB.getName();
    }

    public int getDefaultType() {
        return this.JB.getDefaultType();
    }

    public int getType() {
        return this.JA;
    }

    public boolean U(int i) {
        if (this.JB.getMaxCrashTimes() >= 0 && this.Jz >= this.JB.getMaxCrashTimes() + 2) {
            i = this.JB.getOffType();
        }
        if (i == this.JA) {
            return false;
        }
        this.JA = i;
        this.JB.i(this.JA, false);
        V(i);
        return true;
    }

    public boolean bz(String str) {
        String[] switchLibs;
        String[] kk;
        if (str == null || this.JB.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.JB.kk() != null) {
            for (String str2 : this.JB.kk()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Jz++;
                    W(this.Jz);
                    if (this.Jz >= this.JB.getMaxCrashTimes()) {
                        V(this.JB.getOffType());
                        this.JA = this.JB.getOffType();
                        this.JB.i(this.JB.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.JB.getSwitchLibs() != null) {
            for (String str3 : this.JB.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Jz++;
                    W(this.Jz);
                    if (this.Jz >= this.JB.getMaxCrashTimes()) {
                        V(this.JB.getOffType());
                        this.JA = this.JB.getOffType();
                        this.JB.i(this.JB.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void V(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.JB.getName() + Jy, i);
        edit.commit();
    }

    private int km() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.JB.getName() + Jy, this.JB.getDefaultType());
    }

    private int kn() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.JB.getName() + Jx, -1);
    }

    private void W(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.JB.getName() + Jx, i);
        edit.commit();
    }

    public void reset() {
        this.Jz = 0;
    }

    public void X(int i) {
        this.Jz = i;
    }
}
