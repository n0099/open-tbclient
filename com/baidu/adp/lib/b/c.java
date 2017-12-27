package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String ahV = "_crashtime";
    public static String ahW = "_crashtype";
    private int ahX;
    private int ahY;
    private b ahZ;

    public c(b bVar) {
        this.ahX = 0;
        this.ahY = 0;
        this.ahZ = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ahZ = bVar;
        if (this.ahZ.mt() > 0 && this.ahZ.mw() != null) {
            this.ahX = my();
            if (this.ahX == -1) {
                reset();
            }
        }
        this.ahY = mx();
        this.ahZ.n(this.ahY, true);
    }

    public String getName() {
        return this.ahZ.getName();
    }

    public int mr() {
        return this.ahZ.mr();
    }

    public int getType() {
        return this.ahY;
    }

    public boolean cR(int i) {
        if (this.ahZ.mt() >= 0 && this.ahX >= this.ahZ.mt() + 2) {
            i = this.ahZ.ms();
        }
        if (i == this.ahY) {
            return false;
        }
        this.ahY = i;
        this.ahZ.n(this.ahY, false);
        cS(i);
        return true;
    }

    public boolean am(String str) {
        String[] mu;
        String[] mw;
        if (str == null || this.ahZ.mt() <= 0) {
            return false;
        }
        if (this.ahZ.mw() != null) {
            for (String str2 : this.ahZ.mw()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.ahX++;
                    cT(this.ahX);
                    if (this.ahX >= this.ahZ.mt()) {
                        cS(this.ahZ.ms());
                        this.ahY = this.ahZ.ms();
                        this.ahZ.n(this.ahZ.ms(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.ahZ.mu() != null) {
            for (String str3 : this.ahZ.mu()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.ahX++;
                    cT(this.ahX);
                    if (this.ahX >= this.ahZ.mt()) {
                        cS(this.ahZ.ms());
                        this.ahY = this.ahZ.ms();
                        this.ahZ.n(this.ahZ.ms(), false);
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
        edit.putInt(this.ahZ.getName() + ahW, i);
        edit.commit();
    }

    private int mx() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ahZ.getName() + ahW, this.ahZ.mr());
    }

    private int my() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ahZ.getName() + ahV, -1);
    }

    private void cT(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.ahZ.getName() + ahV, i);
        edit.commit();
    }

    public void reset() {
        this.ahX = 0;
    }

    public void cU(int i) {
        this.ahX = i;
    }
}
