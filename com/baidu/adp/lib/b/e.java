package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e {
    public static String hY = "_crashtime";
    public static String hZ = "_crashtype";
    private int ia;
    private int ib;
    private c ic;

    public e(c cVar) {
        this.ia = 0;
        this.ib = 0;
        this.ic = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ic = cVar;
        if (this.ic.getMaxCrashTimes() > 0 && this.ic.cZ() != null) {
            this.ia = db();
            if (this.ia == -1) {
                reset();
            }
        }
        this.ib = da();
        this.ic.b(this.ib, true);
    }

    public String getName() {
        return this.ic.getName();
    }

    public int getDefaultType() {
        return this.ic.getDefaultType();
    }

    public int getType() {
        return this.ib;
    }

    public boolean A(int i) {
        if (this.ic.getMaxCrashTimes() >= 0 && this.ia >= this.ic.getMaxCrashTimes() + 2) {
            i = this.ic.getOffType();
        }
        if (i == this.ib) {
            return false;
        }
        this.ib = i;
        this.ic.b(this.ib, false);
        B(i);
        return true;
    }

    public boolean Y(String str) {
        if (str == null || this.ic.getMaxCrashTimes() <= 0 || this.ic.cZ() == null) {
            return false;
        }
        for (String str2 : this.ic.cZ()) {
            if (str.indexOf(str2) != -1) {
                this.ia++;
                C(this.ia);
                if (this.ia >= this.ic.getMaxCrashTimes()) {
                    B(this.ic.getOffType());
                    this.ib = this.ic.getOffType();
                    this.ic.b(this.ic.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void B(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.ic.getName()) + hZ, i);
        edit.commit();
    }

    private int da() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.ic.getName()) + hZ, this.ic.getDefaultType());
    }

    private int db() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.ic.getName()) + hY, -1);
    }

    private void C(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.ic.getName()) + hY, i);
        edit.commit();
    }

    public void reset() {
        this.ia = 0;
        C(0);
        B(getDefaultType());
    }

    public void D(int i) {
        this.ia = i;
    }
}
