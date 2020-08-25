package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String KA = "_crashtime";
    public static String KC = "_crashtype";
    private int KD;
    private int KE;
    private b KF;

    public c(b bVar) {
        this.KD = 0;
        this.KE = 0;
        this.KF = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.KF = bVar;
        if (this.KF.getMaxCrashTimes() > 0 && this.KF.lZ() != null) {
            this.KD = mc();
            if (this.KD == -1) {
                reset();
            }
        }
        if (!bVar.lY()) {
            this.KE = mb();
        }
        this.KF.k(this.KE, true);
    }

    public b ma() {
        return this.KF;
    }

    public String getName() {
        return this.KF.getName();
    }

    public int getDefaultType() {
        return this.KF.getDefaultType();
    }

    public int getType() {
        return this.KE;
    }

    public boolean ae(int i) {
        if (this.KF.getMaxCrashTimes() >= 0 && this.KD >= this.KF.getMaxCrashTimes() + 2) {
            i = this.KF.getOffType();
        }
        if (i == this.KE) {
            return false;
        }
        this.KE = i;
        this.KF.k(this.KE, false);
        af(i);
        return true;
    }

    public boolean bF(String str) {
        String[] switchLibs;
        String[] lZ;
        if (str == null || this.KF.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.KF.lZ() != null) {
            for (String str2 : this.KF.lZ()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.KD++;
                    ag(this.KD);
                    if (this.KD >= this.KF.getMaxCrashTimes()) {
                        af(this.KF.getOffType());
                        this.KE = this.KF.getOffType();
                        this.KF.k(this.KF.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.KF.getSwitchLibs() != null) {
            for (String str3 : this.KF.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.KD++;
                    ag(this.KD);
                    if (this.KD >= this.KF.getMaxCrashTimes()) {
                        af(this.KF.getOffType());
                        this.KE = this.KF.getOffType();
                        this.KF.k(this.KF.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void af(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.KF.getName() + KC, i);
        edit.commit();
    }

    private int mb() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.KF.getName() + KC, this.KF.getDefaultType());
    }

    private int mc() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.KF.getName() + KA, -1);
    }

    private void ag(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.KF.getName() + KA, i);
        edit.commit();
    }

    public void reset() {
        this.KD = 0;
    }

    public void ah(int i) {
        this.KD = i;
    }
}
