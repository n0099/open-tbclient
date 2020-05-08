package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String Jn = "_crashtime";
    public static String Jo = "_crashtype";
    private int Jp;
    private int Jq;
    private b Jr;

    public c(b bVar) {
        this.Jp = 0;
        this.Jq = 0;
        this.Jr = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Jr = bVar;
        if (this.Jr.getMaxCrashTimes() > 0 && this.Jr.ki() != null) {
            this.Jp = kl();
            if (this.Jp == -1) {
                reset();
            }
        }
        if (!bVar.kh()) {
            this.Jq = kk();
        }
        this.Jr.i(this.Jq, true);
    }

    public b kj() {
        return this.Jr;
    }

    public String getName() {
        return this.Jr.getName();
    }

    public int getDefaultType() {
        return this.Jr.getDefaultType();
    }

    public int getType() {
        return this.Jq;
    }

    public boolean T(int i) {
        if (this.Jr.getMaxCrashTimes() >= 0 && this.Jp >= this.Jr.getMaxCrashTimes() + 2) {
            i = this.Jr.getOffType();
        }
        if (i == this.Jq) {
            return false;
        }
        this.Jq = i;
        this.Jr.i(this.Jq, false);
        U(i);
        return true;
    }

    public boolean by(String str) {
        String[] switchLibs;
        String[] ki;
        if (str == null || this.Jr.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Jr.ki() != null) {
            for (String str2 : this.Jr.ki()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.Jp++;
                    V(this.Jp);
                    if (this.Jp >= this.Jr.getMaxCrashTimes()) {
                        U(this.Jr.getOffType());
                        this.Jq = this.Jr.getOffType();
                        this.Jr.i(this.Jr.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Jr.getSwitchLibs() != null) {
            for (String str3 : this.Jr.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.Jp++;
                    V(this.Jp);
                    if (this.Jp >= this.Jr.getMaxCrashTimes()) {
                        U(this.Jr.getOffType());
                        this.Jq = this.Jr.getOffType();
                        this.Jr.i(this.Jr.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Jr.getName() + Jo, i);
        edit.commit();
    }

    private int kk() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Jr.getName() + Jo, this.Jr.getDefaultType());
    }

    private int kl() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Jr.getName() + Jn, -1);
    }

    private void V(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Jr.getName() + Jn, i);
        edit.commit();
    }

    public void reset() {
        this.Jp = 0;
    }

    public void W(int i) {
        this.Jp = i;
    }
}
