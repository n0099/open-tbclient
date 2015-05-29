package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e {
    public static String tI = "_crashtime";
    public static String tJ = "_crashtype";
    private int tK;
    private int tL;
    private c tM;

    public e(c cVar) {
        this.tK = 0;
        this.tL = 0;
        this.tM = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tM = cVar;
        if (this.tM.getMaxCrashTimes() > 0 && this.tM.gA() != null) {
            this.tK = gC();
            if (this.tK == -1) {
                reset();
            }
        }
        this.tL = gB();
        this.tM.b(this.tL, true);
    }

    public String getName() {
        return this.tM.getName();
    }

    public int getDefaultType() {
        return this.tM.getDefaultType();
    }

    public int getType() {
        return this.tL;
    }

    public boolean H(int i) {
        if (this.tM.getMaxCrashTimes() >= 0 && this.tK >= this.tM.getMaxCrashTimes() + 2) {
            i = this.tM.getOffType();
        }
        if (i == this.tL) {
            return false;
        }
        this.tL = i;
        this.tM.b(this.tL, false);
        I(i);
        return true;
    }

    public boolean ah(String str) {
        if (str == null || this.tM.getMaxCrashTimes() <= 0 || this.tM.gA() == null) {
            return false;
        }
        for (String str2 : this.tM.gA()) {
            if (str.indexOf(str2) != -1) {
                this.tK++;
                J(this.tK);
                if (this.tK >= this.tM.getMaxCrashTimes()) {
                    I(this.tM.getOffType());
                    this.tL = this.tM.getOffType();
                    this.tM.b(this.tM.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void I(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tM.getName()) + tJ, i);
        edit.commit();
    }

    private int gB() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tM.getName()) + tJ, this.tM.getDefaultType());
    }

    private int gC() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tM.getName()) + tI, -1);
    }

    private void J(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tM.getName()) + tI, i);
        edit.commit();
    }

    public void reset() {
        this.tK = 0;
    }

    public void K(int i) {
        this.tK = i;
    }
}
