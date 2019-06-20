package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String zc = "_crashtime";
    public static String zd = "_crashtype";
    private int ze;
    private int zf;
    private b zg;

    public c(b bVar) {
        this.ze = 0;
        this.zf = 0;
        this.zg = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.zg = bVar;
        if (this.zg.hB() > 0 && this.zg.hF() != null) {
            this.ze = hH();
            if (this.ze == -1) {
                reset();
            }
        }
        if (!bVar.hE()) {
            this.zf = hG();
        }
        this.zg.f(this.zf, true);
    }

    public String getName() {
        return this.zg.getName();
    }

    public int hz() {
        return this.zg.hz();
    }

    public int getType() {
        return this.zf;
    }

    public boolean S(int i) {
        if (this.zg.hB() >= 0 && this.ze >= this.zg.hB() + 2) {
            i = this.zg.hA();
        }
        if (i == this.zf) {
            return false;
        }
        this.zf = i;
        this.zg.f(this.zf, false);
        T(i);
        return true;
    }

    public boolean ax(String str) {
        String[] hC;
        String[] hF;
        if (str == null || this.zg.hB() <= 0) {
            return false;
        }
        if (this.zg.hF() != null) {
            for (String str2 : this.zg.hF()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.ze++;
                    U(this.ze);
                    if (this.ze >= this.zg.hB()) {
                        T(this.zg.hA());
                        this.zf = this.zg.hA();
                        this.zg.f(this.zg.hA(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.zg.hC() != null) {
            for (String str3 : this.zg.hC()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.ze++;
                    U(this.ze);
                    if (this.ze >= this.zg.hB()) {
                        T(this.zg.hA());
                        this.zf = this.zg.hA();
                        this.zg.f(this.zg.hA(), false);
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
        edit.putInt(this.zg.getName() + zd, i);
        edit.commit();
    }

    private int hG() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.zg.getName() + zd, this.zg.hz());
    }

    private int hH() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.zg.getName() + zc, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.zg.getName() + zc, i);
        edit.commit();
    }

    public void reset() {
        this.ze = 0;
    }

    public void V(int i) {
        this.ze = i;
    }
}
