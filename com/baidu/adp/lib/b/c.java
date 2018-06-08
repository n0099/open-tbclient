package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String yv = "_crashtime";
    public static String yw = "_crashtype";
    private int yx;
    private int yy;
    private b yz;

    public c(b bVar) {
        this.yx = 0;
        this.yy = 0;
        this.yz = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.yz = bVar;
        if (this.yz.hp() > 0 && this.yz.hs() != null) {
            this.yx = hu();
            if (this.yx == -1) {
                reset();
            }
        }
        this.yy = ht();
        this.yz.f(this.yy, true);
    }

    public String getName() {
        return this.yz.getName();
    }

    public int hn() {
        return this.yz.hn();
    }

    public int getType() {
        return this.yy;
    }

    public boolean S(int i) {
        if (this.yz.hp() >= 0 && this.yx >= this.yz.hp() + 2) {
            i = this.yz.ho();
        }
        if (i == this.yy) {
            return false;
        }
        this.yy = i;
        this.yz.f(this.yy, false);
        T(i);
        return true;
    }

    public boolean av(String str) {
        String[] hq;
        String[] hs;
        if (str == null || this.yz.hp() <= 0) {
            return false;
        }
        if (this.yz.hs() != null) {
            for (String str2 : this.yz.hs()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.yx++;
                    U(this.yx);
                    if (this.yx >= this.yz.hp()) {
                        T(this.yz.ho());
                        this.yy = this.yz.ho();
                        this.yz.f(this.yz.ho(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.yz.hq() != null) {
            for (String str3 : this.yz.hq()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.yx++;
                    U(this.yx);
                    if (this.yx >= this.yz.hp()) {
                        T(this.yz.ho());
                        this.yy = this.yz.ho();
                        this.yz.f(this.yz.ho(), false);
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
        edit.putInt(this.yz.getName() + yw, i);
        edit.commit();
    }

    private int ht() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.yz.getName() + yw, this.yz.hn());
    }

    private int hu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.yz.getName() + yv, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.yz.getName() + yv, i);
        edit.commit();
    }

    public void reset() {
        this.yx = 0;
    }

    public void V(int i) {
        this.yx = i;
    }
}
