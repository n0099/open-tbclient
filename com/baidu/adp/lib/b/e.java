package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e {
    public static String ia = "_crashtime";
    public static String ib = "_crashtype";
    private int ic;
    private int ie;
    private c ig;

    public e(c cVar) {
        this.ic = 0;
        this.ie = 0;
        this.ig = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ig = cVar;
        if (this.ig.getMaxCrashTimes() > 0 && this.ig.cX() != null) {
            this.ic = cZ();
            if (this.ic == -1) {
                reset();
            }
        }
        this.ie = cY();
        this.ig.b(this.ie, true);
    }

    public String getName() {
        return this.ig.getName();
    }

    public int getDefaultType() {
        return this.ig.getDefaultType();
    }

    public int getType() {
        return this.ie;
    }

    public boolean F(int i) {
        if (this.ig.getMaxCrashTimes() >= 0 && this.ic >= this.ig.getMaxCrashTimes() + 2) {
            i = this.ig.getOffType();
        }
        if (i == this.ie) {
            return false;
        }
        this.ie = i;
        this.ig.b(this.ie, false);
        G(i);
        return true;
    }

    public boolean Y(String str) {
        if (str == null || this.ig.getMaxCrashTimes() <= 0 || this.ig.cX() == null) {
            return false;
        }
        for (String str2 : this.ig.cX()) {
            if (str.indexOf(str2) != -1) {
                this.ic++;
                H(this.ic);
                if (this.ic >= this.ig.getMaxCrashTimes()) {
                    G(this.ig.getOffType());
                    this.ie = this.ig.getOffType();
                    this.ig.b(this.ig.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void G(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.ig.getName()) + ib, i);
        edit.commit();
    }

    private int cY() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.ig.getName()) + ib, this.ig.getDefaultType());
    }

    private int cZ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.ig.getName()) + ia, -1);
    }

    private void H(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.ig.getName()) + ia, i);
        edit.commit();
    }

    public void reset() {
        this.ic = 0;
        H(0);
        G(getDefaultType());
    }

    public void I(int i) {
        this.ic = i;
    }
}
