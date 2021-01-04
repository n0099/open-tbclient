package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Ls = "_crashtime";
    public static String Lt = "_crashtype";
    private int Lu;
    private int Lv;
    private b Lw;

    public c(b bVar) {
        this.Lu = 0;
        this.Lv = 0;
        this.Lw = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Lw = bVar;
        if (this.Lw.getMaxCrashTimes() > 0 && this.Lw.lC() != null) {
            this.Lu = lF();
            if (this.Lu == -1) {
                reset();
            }
        }
        if (!bVar.lB()) {
            this.Lv = lE();
        }
        this.Lw.k(this.Lv, true);
    }

    public b lD() {
        return this.Lw;
    }

    public String getName() {
        return this.Lw.getName();
    }

    public int getDefaultType() {
        return this.Lw.getDefaultType();
    }

    public int getType() {
        return this.Lv;
    }

    public boolean ai(int i) {
        if (this.Lw.getMaxCrashTimes() >= 0 && this.Lu >= this.Lw.getMaxCrashTimes() + 2) {
            i = this.Lw.getOffType();
        }
        if (i == this.Lv) {
            return false;
        }
        this.Lv = i;
        this.Lw.k(this.Lv, false);
        aj(i);
        return true;
    }

    public boolean bE(String str) {
        String[] switchLibs;
        String[] lC;
        if (str == null || this.Lw.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Lw.lC() != null) {
            for (String str2 : this.Lw.lC()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Lu++;
                    ak(this.Lu);
                    if (this.Lu >= this.Lw.getMaxCrashTimes()) {
                        aj(this.Lw.getOffType());
                        this.Lv = this.Lw.getOffType();
                        this.Lw.k(this.Lw.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Lw.getSwitchLibs() != null) {
            for (String str3 : this.Lw.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Lu++;
                    ak(this.Lu);
                    if (this.Lu >= this.Lw.getMaxCrashTimes()) {
                        aj(this.Lw.getOffType());
                        this.Lv = this.Lw.getOffType();
                        this.Lw.k(this.Lw.getOffType(), false);
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
        edit.putInt(this.Lw.getName() + Lt, i);
        edit.commit();
    }

    private int lE() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Lw.getName() + Lt, this.Lw.getDefaultType());
    }

    private int lF() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Lw.getName() + Ls, -1);
    }

    private void ak(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Lw.getName() + Ls, i);
        edit.commit();
    }

    public void reset() {
        this.Lu = 0;
    }

    public void al(int i) {
        this.Lu = i;
    }
}
