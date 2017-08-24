package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String vQ = "_crashtime";
    public static String vR = "_crashtype";
    private int vS;
    private int vT;
    private b vU;

    public c(b bVar) {
        this.vS = 0;
        this.vT = 0;
        this.vU = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.vU = bVar;
        if (this.vU.fb() > 0 && this.vU.fe() != null) {
            this.vS = fg();
            if (this.vS == -1) {
                reset();
            }
        }
        this.vT = ff();
        this.vU.d(this.vT, true);
    }

    public String getName() {
        return this.vU.getName();
    }

    public int eZ() {
        return this.vU.eZ();
    }

    public int getType() {
        return this.vT;
    }

    public boolean ab(int i) {
        if (this.vU.fb() >= 0 && this.vS >= this.vU.fb() + 2) {
            i = this.vU.fa();
        }
        if (i == this.vT) {
            return false;
        }
        this.vT = i;
        this.vU.d(this.vT, false);
        ac(i);
        return true;
    }

    public boolean al(String str) {
        String[] fc;
        String[] fe;
        if (str == null || this.vU.fb() <= 0) {
            return false;
        }
        if (this.vU.fe() != null) {
            for (String str2 : this.vU.fe()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.vS++;
                    ad(this.vS);
                    if (this.vS >= this.vU.fb()) {
                        ac(this.vU.fa());
                        this.vT = this.vU.fa();
                        this.vU.d(this.vU.fa(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.vU.fc() != null) {
            for (String str3 : this.vU.fc()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.vS++;
                    ad(this.vS);
                    if (this.vS >= this.vU.fb()) {
                        ac(this.vU.fa());
                        this.vT = this.vU.fa();
                        this.vU.d(this.vU.fa(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void ac(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.vU.getName() + vR, i);
        edit.commit();
    }

    private int ff() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.vU.getName() + vR, this.vU.eZ());
    }

    private int fg() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.vU.getName() + vQ, -1);
    }

    private void ad(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.vU.getName() + vQ, i);
        edit.commit();
    }

    public void reset() {
        this.vS = 0;
    }

    public void ae(int i) {
        this.vS = i;
    }
}
