package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String ahY = "_crashtime";
    public static String ahZ = "_crashtype";
    private int aia;
    private int aib;
    private b aic;

    public c(b bVar) {
        this.aia = 0;
        this.aib = 0;
        this.aic = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.aic = bVar;
        if (this.aic.mu() > 0 && this.aic.mx() != null) {
            this.aia = mz();
            if (this.aia == -1) {
                reset();
            }
        }
        this.aib = my();
        this.aic.n(this.aib, true);
    }

    public String getName() {
        return this.aic.getName();
    }

    public int ms() {
        return this.aic.ms();
    }

    public int getType() {
        return this.aib;
    }

    public boolean cR(int i) {
        if (this.aic.mu() >= 0 && this.aia >= this.aic.mu() + 2) {
            i = this.aic.mt();
        }
        if (i == this.aib) {
            return false;
        }
        this.aib = i;
        this.aic.n(this.aib, false);
        cS(i);
        return true;
    }

    public boolean am(String str) {
        String[] mv;
        String[] mx;
        if (str == null || this.aic.mu() <= 0) {
            return false;
        }
        if (this.aic.mx() != null) {
            for (String str2 : this.aic.mx()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.aia++;
                    cT(this.aia);
                    if (this.aia >= this.aic.mu()) {
                        cS(this.aic.mt());
                        this.aib = this.aic.mt();
                        this.aic.n(this.aic.mt(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.aic.mv() != null) {
            for (String str3 : this.aic.mv()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.aia++;
                    cT(this.aia);
                    if (this.aia >= this.aic.mu()) {
                        cS(this.aic.mt());
                        this.aib = this.aic.mt();
                        this.aic.n(this.aic.mt(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void cS(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.aic.getName() + ahZ, i);
        edit.commit();
    }

    private int my() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.aic.getName() + ahZ, this.aic.ms());
    }

    private int mz() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.aic.getName() + ahY, -1);
    }

    private void cT(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.aic.getName() + ahY, i);
        edit.commit();
    }

    public void reset() {
        this.aia = 0;
    }

    public void cU(int i) {
        this.aia = i;
    }
}
