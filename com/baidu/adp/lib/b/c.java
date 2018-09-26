package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String AI = "_crashtime";
    public static String AJ = "_crashtype";
    private int AK;
    private int AM;
    private b AN;

    public c(b bVar) {
        this.AK = 0;
        this.AM = 0;
        this.AN = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.AN = bVar;
        if (this.AN.iu() > 0 && this.AN.iy() != null) {
            this.AK = iA();
            if (this.AK == -1) {
                reset();
            }
        }
        if (!bVar.ix()) {
            this.AM = iz();
        }
        this.AN.f(this.AM, true);
    }

    public String getName() {
        return this.AN.getName();
    }

    public int is() {
        return this.AN.is();
    }

    public int getType() {
        return this.AM;
    }

    public boolean aa(int i) {
        if (this.AN.iu() >= 0 && this.AK >= this.AN.iu() + 2) {
            i = this.AN.it();
        }
        if (i == this.AM) {
            return false;
        }
        this.AM = i;
        this.AN.f(this.AM, false);
        ab(i);
        return true;
    }

    public boolean aN(String str) {
        String[] iv;
        String[] iy;
        if (str == null || this.AN.iu() <= 0) {
            return false;
        }
        if (this.AN.iy() != null) {
            for (String str2 : this.AN.iy()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.AK++;
                    ac(this.AK);
                    if (this.AK >= this.AN.iu()) {
                        ab(this.AN.it());
                        this.AM = this.AN.it();
                        this.AN.f(this.AN.it(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.AN.iv() != null) {
            for (String str3 : this.AN.iv()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.AK++;
                    ac(this.AK);
                    if (this.AK >= this.AN.iu()) {
                        ab(this.AN.it());
                        this.AM = this.AN.it();
                        this.AN.f(this.AN.it(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void ab(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.AN.getName() + AJ, i);
        edit.commit();
    }

    private int iz() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.AN.getName() + AJ, this.AN.is());
    }

    private int iA() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.AN.getName() + AI, -1);
    }

    private void ac(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.AN.getName() + AI, i);
        edit.commit();
    }

    public void reset() {
        this.AK = 0;
    }

    public void ad(int i) {
        this.AK = i;
    }
}
