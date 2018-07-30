package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String yo = "_crashtime";
    public static String yp = "_crashtype";
    private int yq;
    private int yr;
    private b ys;

    public c(b bVar) {
        this.yq = 0;
        this.yr = 0;
        this.ys = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ys = bVar;
        if (this.ys.ho() > 0 && this.ys.hs() != null) {
            this.yq = hu();
            if (this.yq == -1) {
                reset();
            }
        }
        if (!bVar.hr()) {
            this.yr = ht();
        }
        this.ys.f(this.yr, true);
    }

    public String getName() {
        return this.ys.getName();
    }

    public int hm() {
        return this.ys.hm();
    }

    public int getType() {
        return this.yr;
    }

    public boolean S(int i) {
        if (this.ys.ho() >= 0 && this.yq >= this.ys.ho() + 2) {
            i = this.ys.hn();
        }
        if (i == this.yr) {
            return false;
        }
        this.yr = i;
        this.ys.f(this.yr, false);
        T(i);
        return true;
    }

    public boolean aw(String str) {
        String[] hp;
        String[] hs;
        if (str == null || this.ys.ho() <= 0) {
            return false;
        }
        if (this.ys.hs() != null) {
            for (String str2 : this.ys.hs()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.yq++;
                    U(this.yq);
                    if (this.yq >= this.ys.ho()) {
                        T(this.ys.hn());
                        this.yr = this.ys.hn();
                        this.ys.f(this.ys.hn(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.ys.hp() != null) {
            for (String str3 : this.ys.hp()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.yq++;
                    U(this.yq);
                    if (this.yq >= this.ys.ho()) {
                        T(this.ys.hn());
                        this.yr = this.ys.hn();
                        this.ys.f(this.ys.hn(), false);
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
        edit.putInt(this.ys.getName() + yp, i);
        edit.commit();
    }

    private int ht() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ys.getName() + yp, this.ys.hm());
    }

    private int hu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ys.getName() + yo, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.ys.getName() + yo, i);
        edit.commit();
    }

    public void reset() {
        this.yq = 0;
    }

    public void V(int i) {
        this.yq = i;
    }
}
