package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String zd = "_crashtime";
    public static String ze = "_crashtype";
    private int zf;
    private int zg;
    private b zh;

    public c(b bVar) {
        this.zf = 0;
        this.zg = 0;
        this.zh = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.zh = bVar;
        if (this.zh.hB() > 0 && this.zh.hF() != null) {
            this.zf = hH();
            if (this.zf == -1) {
                reset();
            }
        }
        if (!bVar.hE()) {
            this.zg = hG();
        }
        this.zh.f(this.zg, true);
    }

    public String getName() {
        return this.zh.getName();
    }

    public int hz() {
        return this.zh.hz();
    }

    public int getType() {
        return this.zg;
    }

    public boolean S(int i) {
        if (this.zh.hB() >= 0 && this.zf >= this.zh.hB() + 2) {
            i = this.zh.hA();
        }
        if (i == this.zg) {
            return false;
        }
        this.zg = i;
        this.zh.f(this.zg, false);
        T(i);
        return true;
    }

    public boolean ax(String str) {
        String[] hC;
        String[] hF;
        if (str == null || this.zh.hB() <= 0) {
            return false;
        }
        if (this.zh.hF() != null) {
            for (String str2 : this.zh.hF()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.zf++;
                    U(this.zf);
                    if (this.zf >= this.zh.hB()) {
                        T(this.zh.hA());
                        this.zg = this.zh.hA();
                        this.zh.f(this.zh.hA(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.zh.hC() != null) {
            for (String str3 : this.zh.hC()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.zf++;
                    U(this.zf);
                    if (this.zf >= this.zh.hB()) {
                        T(this.zh.hA());
                        this.zg = this.zh.hA();
                        this.zh.f(this.zh.hA(), false);
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
        edit.putInt(this.zh.getName() + ze, i);
        edit.commit();
    }

    private int hG() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.zh.getName() + ze, this.zh.hz());
    }

    private int hH() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.zh.getName() + zd, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.zh.getName() + zd, i);
        edit.commit();
    }

    public void reset() {
        this.zf = 0;
    }

    public void V(int i) {
        this.zf = i;
    }
}
