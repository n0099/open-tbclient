package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String yt = "_crashtime";
    public static String yu = "_crashtype";
    private int yv;
    private int yw;
    private b yx;

    public c(b bVar) {
        this.yv = 0;
        this.yw = 0;
        this.yx = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.yx = bVar;
        if (this.yx.hp() > 0 && this.yx.hs() != null) {
            this.yv = hu();
            if (this.yv == -1) {
                reset();
            }
        }
        this.yw = ht();
        this.yx.f(this.yw, true);
    }

    public String getName() {
        return this.yx.getName();
    }

    public int hn() {
        return this.yx.hn();
    }

    public int getType() {
        return this.yw;
    }

    public boolean S(int i) {
        if (this.yx.hp() >= 0 && this.yv >= this.yx.hp() + 2) {
            i = this.yx.ho();
        }
        if (i == this.yw) {
            return false;
        }
        this.yw = i;
        this.yx.f(this.yw, false);
        T(i);
        return true;
    }

    public boolean av(String str) {
        String[] hq;
        String[] hs;
        if (str == null || this.yx.hp() <= 0) {
            return false;
        }
        if (this.yx.hs() != null) {
            for (String str2 : this.yx.hs()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.yv++;
                    U(this.yv);
                    if (this.yv >= this.yx.hp()) {
                        T(this.yx.ho());
                        this.yw = this.yx.ho();
                        this.yx.f(this.yx.ho(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.yx.hq() != null) {
            for (String str3 : this.yx.hq()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.yv++;
                    U(this.yv);
                    if (this.yv >= this.yx.hp()) {
                        T(this.yx.ho());
                        this.yw = this.yx.ho();
                        this.yx.f(this.yx.ho(), false);
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
        edit.putInt(this.yx.getName() + yu, i);
        edit.commit();
    }

    private int ht() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.yx.getName() + yu, this.yx.hn());
    }

    private int hu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.yx.getName() + yt, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.yx.getName() + yt, i);
        edit.commit();
    }

    public void reset() {
        this.yv = 0;
    }

    public void V(int i) {
        this.yv = i;
    }
}
