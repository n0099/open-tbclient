package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String sj = "_crashtime";
    public static String sk = "_crashtype";
    private int sl;
    private int sm;
    private b so;

    public c(b bVar) {
        this.sl = 0;
        this.sm = 0;
        this.so = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.so = bVar;
        if (this.so.ey() > 0 && this.so.eB() != null) {
            this.sl = eD();
            if (this.sl == -1) {
                reset();
            }
        }
        this.sm = eC();
        this.so.f(this.sm, true);
    }

    public String getName() {
        return this.so.getName();
    }

    public int ew() {
        return this.so.ew();
    }

    public int getType() {
        return this.sm;
    }

    public boolean R(int i) {
        if (this.so.ey() >= 0 && this.sl >= this.so.ey() + 2) {
            i = this.so.ex();
        }
        if (i == this.sm) {
            return false;
        }
        this.sm = i;
        this.so.f(this.sm, false);
        S(i);
        return true;
    }

    public boolean aj(String str) {
        String[] ez;
        String[] eB;
        if (str == null || this.so.ey() <= 0) {
            return false;
        }
        if (this.so.eB() != null) {
            for (String str2 : this.so.eB()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.sl++;
                    T(this.sl);
                    if (this.sl >= this.so.ey()) {
                        S(this.so.ex());
                        this.sm = this.so.ex();
                        this.so.f(this.so.ex(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.so.ez() != null) {
            for (String str3 : this.so.ez()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.sl++;
                    T(this.sl);
                    if (this.sl >= this.so.ey()) {
                        S(this.so.ex());
                        this.sm = this.so.ex();
                        this.so.f(this.so.ex(), false);
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
        edit.putInt(this.so.getName() + sk, i);
        edit.commit();
    }

    private int eC() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.so.getName() + sk, this.so.ew());
    }

    private int eD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.so.getName() + sj, -1);
    }

    private void T(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.so.getName() + sj, i);
        edit.commit();
    }

    public void reset() {
        this.sl = 0;
    }

    public void U(int i) {
        this.sl = i;
    }
}
