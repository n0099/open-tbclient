package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String KZ = "_crashtime";
    public static String La = "_crashtype";
    private int Lb;
    private int Lc;
    private b Ld;

    public c(b bVar) {
        this.Lb = 0;
        this.Lc = 0;
        this.Ld = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Ld = bVar;
        if (this.Ld.getMaxCrashTimes() > 0 && this.Ld.me() != null) {
            this.Lb = mh();
            if (this.Lb == -1) {
                reset();
            }
        }
        if (!bVar.md()) {
            this.Lc = mg();
        }
        this.Ld.k(this.Lc, true);
    }

    public b mf() {
        return this.Ld;
    }

    public String getName() {
        return this.Ld.getName();
    }

    public int getDefaultType() {
        return this.Ld.getDefaultType();
    }

    public int getType() {
        return this.Lc;
    }

    public boolean af(int i) {
        if (this.Ld.getMaxCrashTimes() >= 0 && this.Lb >= this.Ld.getMaxCrashTimes() + 2) {
            i = this.Ld.getOffType();
        }
        if (i == this.Lc) {
            return false;
        }
        this.Lc = i;
        this.Ld.k(this.Lc, false);
        ag(i);
        return true;
    }

    public boolean bH(String str) {
        String[] switchLibs;
        String[] me;
        if (str == null || this.Ld.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Ld.me() != null) {
            for (String str2 : this.Ld.me()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Lb++;
                    ah(this.Lb);
                    if (this.Lb >= this.Ld.getMaxCrashTimes()) {
                        ag(this.Ld.getOffType());
                        this.Lc = this.Ld.getOffType();
                        this.Ld.k(this.Ld.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Ld.getSwitchLibs() != null) {
            for (String str3 : this.Ld.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Lb++;
                    ah(this.Lb);
                    if (this.Lb >= this.Ld.getMaxCrashTimes()) {
                        ag(this.Ld.getOffType());
                        this.Lc = this.Ld.getOffType();
                        this.Ld.k(this.Ld.getOffType(), false);
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
        edit.putInt(this.Ld.getName() + La, i);
        edit.commit();
    }

    private int mg() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Ld.getName() + La, this.Ld.getDefaultType());
    }

    private int mh() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Ld.getName() + KZ, -1);
    }

    private void ah(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Ld.getName() + KZ, i);
        edit.commit();
    }

    public void reset() {
        this.Lb = 0;
    }

    public void ai(int i) {
        this.Lb = i;
    }
}
