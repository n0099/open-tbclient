package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Lo = "_crashtime";
    public static String Lp = "_crashtype";
    private int Lq;
    private int Lr;
    private b Ls;

    public c(b bVar) {
        this.Lq = 0;
        this.Lr = 0;
        this.Ls = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Ls = bVar;
        if (this.Ls.getMaxCrashTimes() > 0 && this.Ls.lB() != null) {
            this.Lq = lE();
            if (this.Lq == -1) {
                reset();
            }
        }
        if (!bVar.lA()) {
            this.Lr = lD();
        }
        this.Ls.k(this.Lr, true);
    }

    public b lC() {
        return this.Ls;
    }

    public String getName() {
        return this.Ls.getName();
    }

    public int getDefaultType() {
        return this.Ls.getDefaultType();
    }

    public int getType() {
        return this.Lr;
    }

    public boolean ai(int i) {
        if (this.Ls.getMaxCrashTimes() >= 0 && this.Lq >= this.Ls.getMaxCrashTimes() + 2) {
            i = this.Ls.getOffType();
        }
        if (i == this.Lr) {
            return false;
        }
        this.Lr = i;
        this.Ls.k(this.Lr, false);
        aj(i);
        return true;
    }

    public boolean bE(String str) {
        String[] switchLibs;
        String[] lB;
        if (str == null || this.Ls.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Ls.lB() != null) {
            for (String str2 : this.Ls.lB()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Lq++;
                    ak(this.Lq);
                    if (this.Lq >= this.Ls.getMaxCrashTimes()) {
                        aj(this.Ls.getOffType());
                        this.Lr = this.Ls.getOffType();
                        this.Ls.k(this.Ls.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Ls.getSwitchLibs() != null) {
            for (String str3 : this.Ls.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Lq++;
                    ak(this.Lq);
                    if (this.Lq >= this.Ls.getMaxCrashTimes()) {
                        aj(this.Ls.getOffType());
                        this.Lr = this.Ls.getOffType();
                        this.Ls.k(this.Ls.getOffType(), false);
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
        edit.putInt(this.Ls.getName() + Lp, i);
        edit.commit();
    }

    private int lD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Ls.getName() + Lp, this.Ls.getDefaultType());
    }

    private int lE() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Ls.getName() + Lo, -1);
    }

    private void ak(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Ls.getName() + Lo, i);
        edit.commit();
    }

    public void reset() {
        this.Lq = 0;
    }

    public void al(int i) {
        this.Lq = i;
    }
}
