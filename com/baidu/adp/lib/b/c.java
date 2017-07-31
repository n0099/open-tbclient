package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String vO = "_crashtime";
    public static String vP = "_crashtype";
    private int vQ;
    private int vR;
    private b vS;

    public c(b bVar) {
        this.vQ = 0;
        this.vR = 0;
        this.vS = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.vS = bVar;
        if (this.vS.fb() > 0 && this.vS.fe() != null) {
            this.vQ = fg();
            if (this.vQ == -1) {
                reset();
            }
        }
        this.vR = ff();
        this.vS.d(this.vR, true);
    }

    public String getName() {
        return this.vS.getName();
    }

    public int eZ() {
        return this.vS.eZ();
    }

    public int getType() {
        return this.vR;
    }

    public boolean ab(int i) {
        if (this.vS.fb() >= 0 && this.vQ >= this.vS.fb() + 2) {
            i = this.vS.fa();
        }
        if (i == this.vR) {
            return false;
        }
        this.vR = i;
        this.vS.d(this.vR, false);
        ac(i);
        return true;
    }

    public boolean ak(String str) {
        String[] fc;
        String[] fe;
        if (str == null || this.vS.fb() <= 0) {
            return false;
        }
        if (this.vS.fe() != null) {
            for (String str2 : this.vS.fe()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.vQ++;
                    ad(this.vQ);
                    if (this.vQ >= this.vS.fb()) {
                        ac(this.vS.fa());
                        this.vR = this.vS.fa();
                        this.vS.d(this.vS.fa(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.vS.fc() != null) {
            for (String str3 : this.vS.fc()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.vQ++;
                    ad(this.vQ);
                    if (this.vQ >= this.vS.fb()) {
                        ac(this.vS.fa());
                        this.vR = this.vS.fa();
                        this.vS.d(this.vS.fa(), false);
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
        edit.putInt(this.vS.getName() + vP, i);
        edit.commit();
    }

    private int ff() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.vS.getName() + vP, this.vS.eZ());
    }

    private int fg() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.vS.getName() + vO, -1);
    }

    private void ad(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.vS.getName() + vO, i);
        edit.commit();
    }

    public void reset() {
        this.vQ = 0;
    }

    public void ae(int i) {
        this.vQ = i;
    }
}
