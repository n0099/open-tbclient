package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String tL = "_crashtime";
    public static String tM = "_crashtype";
    private int tN;
    private int tO;
    private c tP;

    public d(c cVar) {
        this.tN = 0;
        this.tO = 0;
        this.tP = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.tP = cVar;
        if (this.tP.getMaxCrashTimes() > 0 && this.tP.gt() != null) {
            this.tN = gv();
            if (this.tN == -1) {
                reset();
            }
        }
        this.tO = gu();
        this.tP.b(this.tO, true);
    }

    public String getName() {
        return this.tP.getName();
    }

    public int getDefaultType() {
        return this.tP.getDefaultType();
    }

    public int getType() {
        return this.tO;
    }

    public boolean K(int i) {
        if (this.tP.getMaxCrashTimes() >= 0 && this.tN >= this.tP.getMaxCrashTimes() + 2) {
            i = this.tP.getOffType();
        }
        if (i == this.tO) {
            return false;
        }
        this.tO = i;
        this.tP.b(this.tO, false);
        L(i);
        return true;
    }

    public boolean ai(String str) {
        if (str == null || this.tP.getMaxCrashTimes() <= 0 || this.tP.gt() == null) {
            return false;
        }
        for (String str2 : this.tP.gt()) {
            if (str.indexOf(str2) != -1) {
                this.tN++;
                M(this.tN);
                if (this.tN >= this.tP.getMaxCrashTimes()) {
                    L(this.tP.getOffType());
                    this.tO = this.tP.getOffType();
                    this.tP.b(this.tP.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void L(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tP.getName()) + tM, i);
        edit.commit();
    }

    private int gu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tP.getName()) + tM, this.tP.getDefaultType());
    }

    private int gv() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.tP.getName()) + tL, -1);
    }

    private void M(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.tP.getName()) + tL, i);
        edit.commit();
    }

    public void reset() {
        this.tN = 0;
    }

    public void N(int i) {
        this.tN = i;
    }
}
