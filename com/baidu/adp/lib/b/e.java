package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e {
    public static String hR = "_crashtime";
    public static String hS = "_crashtype";
    private int hT;
    private int hU;
    private c hV;

    public e(c cVar) {
        this.hT = 0;
        this.hU = 0;
        this.hV = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.hV = cVar;
        if (this.hV.getMaxCrashTimes() > 0 && this.hV.cY() != null) {
            this.hT = da();
            if (this.hT == -1) {
                reset();
            }
        }
        this.hU = cZ();
        this.hV.b(this.hU, true);
    }

    public String getName() {
        return this.hV.getName();
    }

    public int getDefaultType() {
        return this.hV.getDefaultType();
    }

    public int getType() {
        return this.hU;
    }

    public boolean s(int i) {
        if (this.hV.getMaxCrashTimes() >= 0 && this.hT >= this.hV.getMaxCrashTimes() + 2) {
            i = this.hV.getOffType();
        }
        if (i == this.hU) {
            return false;
        }
        this.hU = i;
        this.hV.b(this.hU, false);
        t(i);
        return true;
    }

    public boolean T(String str) {
        if (str == null || this.hV.getMaxCrashTimes() <= 0 || this.hV.cY() == null) {
            return false;
        }
        for (String str2 : this.hV.cY()) {
            if (str.indexOf(str2) != -1) {
                this.hT++;
                u(this.hT);
                if (this.hT >= this.hV.getMaxCrashTimes()) {
                    t(this.hV.getOffType());
                    this.hU = this.hV.getOffType();
                    this.hV.b(this.hV.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void t(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.hV.getName()) + hS, i);
        edit.commit();
    }

    private int cZ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.hV.getName()) + hS, this.hV.getDefaultType());
    }

    private int da() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.hV.getName()) + hR, -1);
    }

    private void u(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.hV.getName()) + hR, i);
        edit.commit();
    }

    public void reset() {
        this.hT = 0;
        u(0);
        t(getDefaultType());
    }

    public void v(int i) {
        this.hT = i;
    }
}
