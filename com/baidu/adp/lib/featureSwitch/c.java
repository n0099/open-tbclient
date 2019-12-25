package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String ql = "_crashtime";
    public static String qm = "_crashtype";
    private int qn;
    private int qo;
    private b qp;

    public c(b bVar) {
        this.qn = 0;
        this.qo = 0;
        this.qp = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.qp = bVar;
        if (this.qp.getMaxCrashTimes() > 0 && this.qp.fE() != null) {
            this.qn = fH();
            if (this.qn == -1) {
                reset();
            }
        }
        if (!bVar.fD()) {
            this.qo = fG();
        }
        this.qp.f(this.qo, true);
    }

    public b fF() {
        return this.qp;
    }

    public String getName() {
        return this.qp.getName();
    }

    public int getDefaultType() {
        return this.qp.getDefaultType();
    }

    public int getType() {
        return this.qo;
    }

    public boolean E(int i) {
        if (this.qp.getMaxCrashTimes() >= 0 && this.qn >= this.qp.getMaxCrashTimes() + 2) {
            i = this.qp.getOffType();
        }
        if (i == this.qo) {
            return false;
        }
        this.qo = i;
        this.qp.f(this.qo, false);
        F(i);
        return true;
    }

    public boolean aj(String str) {
        String[] switchLibs;
        String[] fE;
        if (str == null || this.qp.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.qp.fE() != null) {
            for (String str2 : this.qp.fE()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.qn++;
                    G(this.qn);
                    if (this.qn >= this.qp.getMaxCrashTimes()) {
                        F(this.qp.getOffType());
                        this.qo = this.qp.getOffType();
                        this.qp.f(this.qp.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.qp.getSwitchLibs() != null) {
            for (String str3 : this.qp.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.qn++;
                    G(this.qn);
                    if (this.qn >= this.qp.getMaxCrashTimes()) {
                        F(this.qp.getOffType());
                        this.qo = this.qp.getOffType();
                        this.qp.f(this.qp.getOffType(), false);
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
        edit.putInt(this.qp.getName() + qm, i);
        edit.commit();
    }

    private int fG() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.qp.getName() + qm, this.qp.getDefaultType());
    }

    private int fH() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.qp.getName() + ql, -1);
    }

    private void G(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.qp.getName() + ql, i);
        edit.commit();
    }

    public void reset() {
        this.qn = 0;
    }

    public void H(int i) {
        this.qn = i;
    }
}
