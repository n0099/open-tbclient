package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e {
    public static String tx = "_crashtime";
    public static String ty = "_crashtype";
    private int tA;
    private c tB;
    private int tz;

    public e(c cVar) {
        this.tz = 0;
        this.tA = 0;
        this.tB = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tB = cVar;
        if (this.tB.getMaxCrashTimes() > 0 && this.tB.gw() != null) {
            this.tz = gy();
            if (this.tz == -1) {
                reset();
            }
        }
        this.tA = gx();
        this.tB.b(this.tA, true);
    }

    public String getName() {
        return this.tB.getName();
    }

    public int getDefaultType() {
        return this.tB.getDefaultType();
    }

    public int getType() {
        return this.tA;
    }

    public boolean G(int i) {
        if (this.tB.getMaxCrashTimes() >= 0 && this.tz >= this.tB.getMaxCrashTimes() + 2) {
            i = this.tB.getOffType();
        }
        if (i == this.tA) {
            return false;
        }
        this.tA = i;
        this.tB.b(this.tA, false);
        H(i);
        return true;
    }

    public boolean af(String str) {
        if (str == null || this.tB.getMaxCrashTimes() <= 0 || this.tB.gw() == null) {
            return false;
        }
        for (String str2 : this.tB.gw()) {
            if (str.indexOf(str2) != -1) {
                this.tz++;
                I(this.tz);
                if (this.tz >= this.tB.getMaxCrashTimes()) {
                    H(this.tB.getOffType());
                    this.tA = this.tB.getOffType();
                    this.tB.b(this.tB.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void H(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tB.getName()) + ty, i);
        edit.commit();
    }

    private int gx() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tB.getName()) + ty, this.tB.getDefaultType());
    }

    private int gy() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tB.getName()) + tx, -1);
    }

    private void I(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tB.getName()) + tx, i);
        edit.commit();
    }

    public void reset() {
        this.tz = 0;
        I(0);
        H(getDefaultType());
    }

    public void J(int i) {
        this.tz = i;
    }
}
