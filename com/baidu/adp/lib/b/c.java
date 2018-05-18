package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String si = "_crashtime";
    public static String sj = "_crashtype";
    private int sk;
    private int sl;
    private b sm;

    public c(b bVar) {
        this.sk = 0;
        this.sl = 0;
        this.sm = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.sm = bVar;
        if (this.sm.ey() > 0 && this.sm.eB() != null) {
            this.sk = eD();
            if (this.sk == -1) {
                reset();
            }
        }
        this.sl = eC();
        this.sm.f(this.sl, true);
    }

    public String getName() {
        return this.sm.getName();
    }

    public int ew() {
        return this.sm.ew();
    }

    public int getType() {
        return this.sl;
    }

    public boolean R(int i) {
        if (this.sm.ey() >= 0 && this.sk >= this.sm.ey() + 2) {
            i = this.sm.ex();
        }
        if (i == this.sl) {
            return false;
        }
        this.sl = i;
        this.sm.f(this.sl, false);
        S(i);
        return true;
    }

    public boolean aj(String str) {
        String[] ez;
        String[] eB;
        if (str == null || this.sm.ey() <= 0) {
            return false;
        }
        if (this.sm.eB() != null) {
            for (String str2 : this.sm.eB()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.sk++;
                    T(this.sk);
                    if (this.sk >= this.sm.ey()) {
                        S(this.sm.ex());
                        this.sl = this.sm.ex();
                        this.sm.f(this.sm.ex(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.sm.ez() != null) {
            for (String str3 : this.sm.ez()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.sk++;
                    T(this.sk);
                    if (this.sk >= this.sm.ey()) {
                        S(this.sm.ex());
                        this.sl = this.sm.ex();
                        this.sm.f(this.sm.ex(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void S(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.sm.getName() + sj, i);
        edit.commit();
    }

    private int eC() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.sm.getName() + sj, this.sm.ew());
    }

    private int eD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.sm.getName() + si, -1);
    }

    private void T(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.sm.getName() + si, i);
        edit.commit();
    }

    public void reset() {
        this.sk = 0;
    }

    public void U(int i) {
        this.sk = i;
    }
}
