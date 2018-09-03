package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String yp = "_crashtime";
    public static String yq = "_crashtype";
    private int yr;
    private int ys;
    private b yt;

    public c(b bVar) {
        this.yr = 0;
        this.ys = 0;
        this.yt = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.yt = bVar;
        if (this.yt.ho() > 0 && this.yt.hs() != null) {
            this.yr = hu();
            if (this.yr == -1) {
                reset();
            }
        }
        if (!bVar.hr()) {
            this.ys = ht();
        }
        this.yt.f(this.ys, true);
    }

    public String getName() {
        return this.yt.getName();
    }

    public int hm() {
        return this.yt.hm();
    }

    public int getType() {
        return this.ys;
    }

    public boolean S(int i) {
        if (this.yt.ho() >= 0 && this.yr >= this.yt.ho() + 2) {
            i = this.yt.hn();
        }
        if (i == this.ys) {
            return false;
        }
        this.ys = i;
        this.yt.f(this.ys, false);
        T(i);
        return true;
    }

    public boolean aw(String str) {
        String[] hp;
        String[] hs;
        if (str == null || this.yt.ho() <= 0) {
            return false;
        }
        if (this.yt.hs() != null) {
            for (String str2 : this.yt.hs()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.yr++;
                    U(this.yr);
                    if (this.yr >= this.yt.ho()) {
                        T(this.yt.hn());
                        this.ys = this.yt.hn();
                        this.yt.f(this.yt.hn(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.yt.hp() != null) {
            for (String str3 : this.yt.hp()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.yr++;
                    U(this.yr);
                    if (this.yr >= this.yt.ho()) {
                        T(this.yt.hn());
                        this.ys = this.yt.hn();
                        this.yt.f(this.yt.hn(), false);
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
        edit.putInt(this.yt.getName() + yq, i);
        edit.commit();
    }

    private int ht() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.yt.getName() + yq, this.yt.hm());
    }

    private int hu() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.yt.getName() + yp, -1);
    }

    private void U(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.yt.getName() + yp, i);
        edit.commit();
    }

    public void reset() {
        this.yr = 0;
    }

    public void V(int i) {
        this.yr = i;
    }
}
