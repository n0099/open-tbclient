package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String LX = "_crashtime";
    public static String LY = "_crashtype";
    private int LZ;
    private int Ma;
    private b Mb;

    public c(b bVar) {
        this.LZ = 0;
        this.Ma = 0;
        this.Mb = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.Mb = bVar;
        if (this.Mb.getMaxCrashTimes() > 0 && this.Mb.me() != null) {
            this.LZ = mh();
            if (this.LZ == -1) {
                reset();
            }
        }
        if (!bVar.md()) {
            this.Ma = mg();
        }
        this.Mb.k(this.Ma, true);
    }

    public b mf() {
        return this.Mb;
    }

    public String getName() {
        return this.Mb.getName();
    }

    public int getDefaultType() {
        return this.Mb.getDefaultType();
    }

    public int getType() {
        return this.Ma;
    }

    public boolean ai(int i) {
        if (this.Mb.getMaxCrashTimes() >= 0 && this.LZ >= this.Mb.getMaxCrashTimes() + 2) {
            i = this.Mb.getOffType();
        }
        if (i == this.Ma) {
            return false;
        }
        this.Ma = i;
        this.Mb.k(this.Ma, false);
        aj(i);
        return true;
    }

    public boolean bK(String str) {
        String[] switchLibs;
        String[] me;
        if (str == null || this.Mb.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.Mb.me() != null) {
            for (String str2 : this.Mb.me()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.LZ++;
                    ak(this.LZ);
                    if (this.LZ >= this.Mb.getMaxCrashTimes()) {
                        aj(this.Mb.getOffType());
                        this.Ma = this.Mb.getOffType();
                        this.Mb.k(this.Mb.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.Mb.getSwitchLibs() != null) {
            for (String str3 : this.Mb.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.LZ++;
                    ak(this.LZ);
                    if (this.LZ >= this.Mb.getMaxCrashTimes()) {
                        aj(this.Mb.getOffType());
                        this.Ma = this.Mb.getOffType();
                        this.Mb.k(this.Mb.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void aj(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Mb.getName() + LY, i);
        edit.commit();
    }

    private int mg() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Mb.getName() + LY, this.Mb.getDefaultType());
    }

    private int mh() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.Mb.getName() + LX, -1);
    }

    private void ak(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.Mb.getName() + LX, i);
        edit.commit();
    }

    public void reset() {
        this.LZ = 0;
    }

    public void al(int i) {
        this.LZ = i;
    }
}
