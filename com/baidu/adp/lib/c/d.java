package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String tN = "_crashtime";
    public static String tO = "_crashtype";
    private int tP;
    private int tQ;
    private c tR;

    public d(c cVar) {
        this.tP = 0;
        this.tQ = 0;
        this.tR = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tR = cVar;
        if (this.tR.getMaxCrashTimes() > 0 && this.tR.gt() != null) {
            this.tP = gv();
            if (this.tP == -1) {
                reset();
            }
        }
        this.tQ = gu();
        this.tR.b(this.tQ, true);
    }

    public String getName() {
        return this.tR.getName();
    }

    public int getDefaultType() {
        return this.tR.getDefaultType();
    }

    public int getType() {
        return this.tQ;
    }

    public boolean K(int i) {
        if (this.tR.getMaxCrashTimes() >= 0 && this.tP >= this.tR.getMaxCrashTimes() + 2) {
            i = this.tR.getOffType();
        }
        if (i == this.tQ) {
            return false;
        }
        this.tQ = i;
        this.tR.b(this.tQ, false);
        L(i);
        return true;
    }

    public boolean ai(String str) {
        if (str == null || this.tR.getMaxCrashTimes() <= 0 || this.tR.gt() == null) {
            return false;
        }
        for (String str2 : this.tR.gt()) {
            if (str.indexOf(str2) != -1) {
                this.tP++;
                M(this.tP);
                if (this.tP >= this.tR.getMaxCrashTimes()) {
                    L(this.tR.getOffType());
                    this.tQ = this.tR.getOffType();
                    this.tR.b(this.tR.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void L(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tR.getName()) + tO, i);
        edit.commit();
    }

    private int gu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tR.getName()) + tO, this.tR.getDefaultType());
    }

    private int gv() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tR.getName()) + tN, -1);
    }

    private void M(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tR.getName()) + tN, i);
        edit.commit();
    }

    public void reset() {
        this.tP = 0;
    }

    public void N(int i) {
        this.tP = i;
    }
}
