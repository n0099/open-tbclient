package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String oo = "_crashtime";
    public static String oq = "_crashtype";
    private int or;
    private int ot;
    private b ou;

    public c(b bVar) {
        this.or = 0;
        this.ot = 0;
        this.ou = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ou = bVar;
        if (this.ou.fl() > 0 && this.ou.fp() != null) {
            this.or = fs();
            if (this.or == -1) {
                reset();
            }
        }
        if (!bVar.fo()) {
            this.ot = fq();
        }
        this.ou.f(this.ot, true);
    }

    public String getName() {
        return this.ou.getName();
    }

    public int fj() {
        return this.ou.fj();
    }

    public int getType() {
        return this.ot;
    }

    public boolean D(int i) {
        if (this.ou.fl() >= 0 && this.or >= this.ou.fl() + 2) {
            i = this.ou.fk();
        }
        if (i == this.ot) {
            return false;
        }
        this.ot = i;
        this.ou.f(this.ot, false);
        E(i);
        return true;
    }

    public boolean ae(String str) {
        String[] fm;
        String[] fp;
        if (str == null || this.ou.fl() <= 0) {
            return false;
        }
        if (this.ou.fp() != null) {
            for (String str2 : this.ou.fp()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.or++;
                    F(this.or);
                    if (this.or >= this.ou.fl()) {
                        E(this.ou.fk());
                        this.ot = this.ou.fk();
                        this.ou.f(this.ou.fk(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.ou.fm() != null) {
            for (String str3 : this.ou.fm()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.or++;
                    F(this.or);
                    if (this.or >= this.ou.fl()) {
                        E(this.ou.fk());
                        this.ot = this.ou.fk();
                        this.ou.f(this.ou.fk(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void E(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.ou.getName() + oq, i);
        edit.commit();
    }

    private int fq() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ou.getName() + oq, this.ou.fj());
    }

    private int fs() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ou.getName() + oo, -1);
    }

    private void F(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.ou.getName() + oo, i);
        edit.commit();
    }

    public void reset() {
        this.or = 0;
    }

    public void G(int i) {
        this.or = i;
    }
}
