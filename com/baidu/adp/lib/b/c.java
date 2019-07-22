package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String zi = "_crashtime";
    public static String zj = "_crashtype";
    private int zk;
    private int zl;
    private b zm;

    public c(b bVar) {
        this.zk = 0;
        this.zl = 0;
        this.zm = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.zm = bVar;
        if (this.zm.hL() > 0 && this.zm.hP() != null) {
            this.zk = hR();
            if (this.zk == -1) {
                reset();
            }
        }
        if (!bVar.hO()) {
            this.zl = hQ();
        }
        this.zm.f(this.zl, true);
    }

    public String getName() {
        return this.zm.getName();
    }

    public int hJ() {
        return this.zm.hJ();
    }

    public int getType() {
        return this.zl;
    }

    public boolean S(int i) {
        if (this.zm.hL() >= 0 && this.zk >= this.zm.hL() + 2) {
            i = this.zm.hK();
        }
        if (i == this.zl) {
            return false;
        }
        this.zl = i;
        this.zm.f(this.zl, false);
        T(i);
        return true;
    }

    public boolean ay(String str) {
        String[] hM;
        String[] hP;
        if (str == null || this.zm.hL() <= 0) {
            return false;
        }
        if (this.zm.hP() != null) {
            for (String str2 : this.zm.hP()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.zk++;
                    U(this.zk);
                    if (this.zk >= this.zm.hL()) {
                        T(this.zm.hK());
                        this.zl = this.zm.hK();
                        this.zm.f(this.zm.hK(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.zm.hM() != null) {
            for (String str3 : this.zm.hM()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.zk++;
                    U(this.zk);
                    if (this.zk >= this.zm.hL()) {
                        T(this.zm.hK());
                        this.zl = this.zm.hK();
                        this.zm.f(this.zm.hK(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void T(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.zm.getName() + zj, i);
        edit.commit();
    }

    private int hQ() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.zm.getName() + zj, this.zm.hJ());
    }

    private int hR() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.zm.getName() + zi, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.zm.getName() + zi, i);
        edit.commit();
    }

    public void reset() {
        this.zk = 0;
    }

    public void V(int i) {
        this.zk = i;
    }
}
