package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String KJ = "_crashtime";
    public static String KK = "_crashtype";
    private int KL;
    private int KM;
    private b KN;

    public c(b bVar) {
        this.KL = 0;
        this.KM = 0;
        this.KN = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.KN = bVar;
        if (this.KN.getMaxCrashTimes() > 0 && this.KN.md() != null) {
            this.KL = mg();
            if (this.KL == -1) {
                reset();
            }
        }
        if (!bVar.mc()) {
            this.KM = mf();
        }
        this.KN.k(this.KM, true);
    }

    public b me() {
        return this.KN;
    }

    public String getName() {
        return this.KN.getName();
    }

    public int getDefaultType() {
        return this.KN.getDefaultType();
    }

    public int getType() {
        return this.KM;
    }

    public boolean af(int i) {
        if (this.KN.getMaxCrashTimes() >= 0 && this.KL >= this.KN.getMaxCrashTimes() + 2) {
            i = this.KN.getOffType();
        }
        if (i == this.KM) {
            return false;
        }
        this.KM = i;
        this.KN.k(this.KM, false);
        ag(i);
        return true;
    }

    public boolean bH(String str) {
        String[] switchLibs;
        String[] md;
        if (str == null || this.KN.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.KN.md() != null) {
            for (String str2 : this.KN.md()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.KL++;
                    ah(this.KL);
                    if (this.KL >= this.KN.getMaxCrashTimes()) {
                        ag(this.KN.getOffType());
                        this.KM = this.KN.getOffType();
                        this.KN.k(this.KN.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.KN.getSwitchLibs() != null) {
            for (String str3 : this.KN.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.KL++;
                    ah(this.KL);
                    if (this.KL >= this.KN.getMaxCrashTimes()) {
                        ag(this.KN.getOffType());
                        this.KM = this.KN.getOffType();
                        this.KN.k(this.KN.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void ag(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.KN.getName() + KK, i);
        edit.commit();
    }

    private int mf() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.KN.getName() + KK, this.KN.getDefaultType());
    }

    private int mg() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.KN.getName() + KJ, -1);
    }

    private void ah(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.KN.getName() + KJ, i);
        edit.commit();
    }

    public void reset() {
        this.KL = 0;
    }

    public void ai(int i) {
        this.KL = i;
    }
}
