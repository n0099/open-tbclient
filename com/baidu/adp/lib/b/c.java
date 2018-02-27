package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String ahQ = "_crashtime";
    public static String ahR = "_crashtype";
    private int ahS;
    private int ahT;
    private b ahU;

    public c(b bVar) {
        this.ahS = 0;
        this.ahT = 0;
        this.ahU = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ahU = bVar;
        if (this.ahU.mu() > 0 && this.ahU.mx() != null) {
            this.ahS = mz();
            if (this.ahS == -1) {
                reset();
            }
        }
        this.ahT = my();
        this.ahU.q(this.ahT, true);
    }

    public String getName() {
        return this.ahU.getName();
    }

    public int ms() {
        return this.ahU.ms();
    }

    public int getType() {
        return this.ahT;
    }

    public boolean cR(int i) {
        if (this.ahU.mu() >= 0 && this.ahS >= this.ahU.mu() + 2) {
            i = this.ahU.mt();
        }
        if (i == this.ahT) {
            return false;
        }
        this.ahT = i;
        this.ahU.q(this.ahT, false);
        cS(i);
        return true;
    }

    public boolean am(String str) {
        String[] mv;
        String[] mx;
        if (str == null || this.ahU.mu() <= 0) {
            return false;
        }
        if (this.ahU.mx() != null) {
            for (String str2 : this.ahU.mx()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.ahS++;
                    cT(this.ahS);
                    if (this.ahS >= this.ahU.mu()) {
                        cS(this.ahU.mt());
                        this.ahT = this.ahU.mt();
                        this.ahU.q(this.ahU.mt(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.ahU.mv() != null) {
            for (String str3 : this.ahU.mv()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.ahS++;
                    cT(this.ahS);
                    if (this.ahS >= this.ahU.mu()) {
                        cS(this.ahU.mt());
                        this.ahT = this.ahU.mt();
                        this.ahU.q(this.ahU.mt(), false);
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
        edit.putInt(this.ahU.getName() + ahR, i);
        edit.commit();
    }

    private int my() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ahU.getName() + ahR, this.ahU.ms());
    }

    private int mz() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.ahU.getName() + ahQ, -1);
    }

    private void cT(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.ahU.getName() + ahQ, i);
        edit.commit();
    }

    public void reset() {
        this.ahS = 0;
    }

    public void cU(int i) {
        this.ahS = i;
    }
}
