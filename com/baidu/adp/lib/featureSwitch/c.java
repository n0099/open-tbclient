package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String qh = "_crashtime";
    public static String qi = "_crashtype";
    private int qj;
    private int ql;
    private b qm;

    public c(b bVar) {
        this.qj = 0;
        this.ql = 0;
        this.qm = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.qm = bVar;
        if (this.qm.getMaxCrashTimes() > 0 && this.qm.fE() != null) {
            this.qj = fH();
            if (this.qj == -1) {
                reset();
            }
        }
        if (!bVar.fD()) {
            this.ql = fG();
        }
        this.qm.f(this.ql, true);
    }

    public b fF() {
        return this.qm;
    }

    public String getName() {
        return this.qm.getName();
    }

    public int getDefaultType() {
        return this.qm.getDefaultType();
    }

    public int getType() {
        return this.ql;
    }

    public boolean E(int i) {
        if (this.qm.getMaxCrashTimes() >= 0 && this.qj >= this.qm.getMaxCrashTimes() + 2) {
            i = this.qm.getOffType();
        }
        if (i == this.ql) {
            return false;
        }
        this.ql = i;
        this.qm.f(this.ql, false);
        F(i);
        return true;
    }

    public boolean aj(String str) {
        String[] switchLibs;
        String[] fE;
        if (str == null || this.qm.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.qm.fE() != null) {
            for (String str2 : this.qm.fE()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.qj++;
                    G(this.qj);
                    if (this.qj >= this.qm.getMaxCrashTimes()) {
                        F(this.qm.getOffType());
                        this.ql = this.qm.getOffType();
                        this.qm.f(this.qm.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.qm.getSwitchLibs() != null) {
            for (String str3 : this.qm.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.qj++;
                    G(this.qj);
                    if (this.qj >= this.qm.getMaxCrashTimes()) {
                        F(this.qm.getOffType());
                        this.ql = this.qm.getOffType();
                        this.qm.f(this.qm.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void F(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.qm.getName() + qi, i);
        edit.commit();
    }

    private int fG() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.qm.getName() + qi, this.qm.getDefaultType());
    }

    private int fH() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.qm.getName() + qh, -1);
    }

    private void G(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.qm.getName() + qh, i);
        edit.commit();
    }

    public void reset() {
        this.qj = 0;
    }

    public void H(int i) {
        this.qj = i;
    }
}
