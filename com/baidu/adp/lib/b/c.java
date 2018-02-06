package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String ahW = "_crashtime";
    public static String ahX = "_crashtype";
    private int ahY;
    private int ahZ;
    private b aia;

    public c(b bVar) {
        this.ahY = 0;
        this.ahZ = 0;
        this.aia = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.aia = bVar;
        if (this.aia.mu() > 0 && this.aia.mx() != null) {
            this.ahY = mz();
            if (this.ahY == -1) {
                reset();
            }
        }
        this.ahZ = my();
        this.aia.q(this.ahZ, true);
    }

    public String getName() {
        return this.aia.getName();
    }

    public int ms() {
        return this.aia.ms();
    }

    public int getType() {
        return this.ahZ;
    }

    public boolean cR(int i) {
        if (this.aia.mu() >= 0 && this.ahY >= this.aia.mu() + 2) {
            i = this.aia.mt();
        }
        if (i == this.ahZ) {
            return false;
        }
        this.ahZ = i;
        this.aia.q(this.ahZ, false);
        cS(i);
        return true;
    }

    public boolean am(String str) {
        String[] mv;
        String[] mx;
        if (str == null || this.aia.mu() <= 0) {
            return false;
        }
        if (this.aia.mx() != null) {
            for (String str2 : this.aia.mx()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.ahY++;
                    cT(this.ahY);
                    if (this.ahY >= this.aia.mu()) {
                        cS(this.aia.mt());
                        this.ahZ = this.aia.mt();
                        this.aia.q(this.aia.mt(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.aia.mv() != null) {
            for (String str3 : this.aia.mv()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.ahY++;
                    cT(this.ahY);
                    if (this.ahY >= this.aia.mu()) {
                        cS(this.aia.mt());
                        this.ahZ = this.aia.mt();
                        this.aia.q(this.aia.mt(), false);
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
        edit.putInt(this.aia.getName() + ahX, i);
        edit.commit();
    }

    private int my() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.aia.getName() + ahX, this.aia.ms());
    }

    private int mz() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.aia.getName() + ahW, -1);
    }

    private void cT(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.aia.getName() + ahW, i);
        edit.commit();
    }

    public void reset() {
        this.ahY = 0;
    }

    public void cU(int i) {
        this.ahY = i;
    }
}
