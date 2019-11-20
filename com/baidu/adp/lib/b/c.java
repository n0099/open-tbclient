package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String nO = "_crashtime";
    public static String nP = "_crashtype";
    private int nQ;
    private int nR;
    private b nS;

    public c(b bVar) {
        this.nQ = 0;
        this.nR = 0;
        this.nS = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.nS = bVar;
        if (this.nS.fl() > 0 && this.nS.fp() != null) {
            this.nQ = fs();
            if (this.nQ == -1) {
                reset();
            }
        }
        if (!bVar.fo()) {
            this.nR = fq();
        }
        this.nS.f(this.nR, true);
    }

    public String getName() {
        return this.nS.getName();
    }

    public int fj() {
        return this.nS.fj();
    }

    public int getType() {
        return this.nR;
    }

    public boolean D(int i) {
        if (this.nS.fl() >= 0 && this.nQ >= this.nS.fl() + 2) {
            i = this.nS.fk();
        }
        if (i == this.nR) {
            return false;
        }
        this.nR = i;
        this.nS.f(this.nR, false);
        E(i);
        return true;
    }

    public boolean ae(String str) {
        String[] fm;
        String[] fp;
        if (str == null || this.nS.fl() <= 0) {
            return false;
        }
        if (this.nS.fp() != null) {
            for (String str2 : this.nS.fp()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.nQ++;
                    F(this.nQ);
                    if (this.nQ >= this.nS.fl()) {
                        E(this.nS.fk());
                        this.nR = this.nS.fk();
                        this.nS.f(this.nS.fk(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.nS.fm() != null) {
            for (String str3 : this.nS.fm()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.nQ++;
                    F(this.nQ);
                    if (this.nQ >= this.nS.fl()) {
                        E(this.nS.fk());
                        this.nR = this.nS.fk();
                        this.nS.f(this.nS.fk(), false);
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
        edit.putInt(this.nS.getName() + nP, i);
        edit.commit();
    }

    private int fq() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.nS.getName() + nP, this.nS.fj());
    }

    private int fs() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.nS.getName() + nO, -1);
    }

    private void F(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.nS.getName() + nO, i);
        edit.commit();
    }

    public void reset() {
        this.nQ = 0;
    }

    public void G(int i) {
        this.nQ = i;
    }
}
