package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String qi = "_crashtime";
    public static String qj = "_crashtype";
    private int ql;
    private int qm;
    private b qn;

    public c(b bVar) {
        this.ql = 0;
        this.qm = 0;
        this.qn = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.qn = bVar;
        if (this.qn.getMaxCrashTimes() > 0 && this.qn.fE() != null) {
            this.ql = fH();
            if (this.ql == -1) {
                reset();
            }
        }
        if (!bVar.fD()) {
            this.qm = fG();
        }
        this.qn.f(this.qm, true);
    }

    public b fF() {
        return this.qn;
    }

    public String getName() {
        return this.qn.getName();
    }

    public int getDefaultType() {
        return this.qn.getDefaultType();
    }

    public int getType() {
        return this.qm;
    }

    public boolean H(int i) {
        if (this.qn.getMaxCrashTimes() >= 0 && this.ql >= this.qn.getMaxCrashTimes() + 2) {
            i = this.qn.getOffType();
        }
        if (i == this.qm) {
            return false;
        }
        this.qm = i;
        this.qn.f(this.qm, false);
        I(i);
        return true;
    }

    public boolean aj(String str) {
        String[] switchLibs;
        String[] fE;
        if (str == null || this.qn.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.qn.fE() != null) {
            for (String str2 : this.qn.fE()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.ql++;
                    J(this.ql);
                    if (this.ql >= this.qn.getMaxCrashTimes()) {
                        I(this.qn.getOffType());
                        this.qm = this.qn.getOffType();
                        this.qn.f(this.qn.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.qn.getSwitchLibs() != null) {
            for (String str3 : this.qn.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.ql++;
                    J(this.ql);
                    if (this.ql >= this.qn.getMaxCrashTimes()) {
                        I(this.qn.getOffType());
                        this.qm = this.qn.getOffType();
                        this.qn.f(this.qn.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void I(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.qn.getName() + qj, i);
        edit.commit();
    }

    private int fG() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.qn.getName() + qj, this.qn.getDefaultType());
    }

    private int fH() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.qn.getName() + qi, -1);
    }

    private void J(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.qn.getName() + qi, i);
        edit.commit();
    }

    public void reset() {
        this.ql = 0;
    }

    public void K(int i) {
        this.ql = i;
    }
}
