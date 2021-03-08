package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static String MP = "_crashtime";
    public static String MQ = "_crashtype";
    private int MR;
    private int MS;
    private b MT;

    public c(b bVar) {
        this.MR = 0;
        this.MS = 0;
        this.MT = null;
        if (bVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.MT = bVar;
        if (this.MT.getMaxCrashTimes() > 0 && this.MT.lB() != null) {
            this.MR = lE();
            if (this.MR == -1) {
                reset();
            }
        }
        if (!bVar.lA()) {
            this.MS = lD();
        }
        this.MT.k(this.MS, true);
    }

    public b lC() {
        return this.MT;
    }

    public String getName() {
        return this.MT.getName();
    }

    public int getDefaultType() {
        return this.MT.getDefaultType();
    }

    public int getType() {
        return this.MS;
    }

    public boolean ai(int i) {
        if (this.MT.getMaxCrashTimes() >= 0 && this.MR >= this.MT.getMaxCrashTimes() + 2) {
            i = this.MT.getOffType();
        }
        if (i == this.MS) {
            return false;
        }
        this.MS = i;
        this.MT.k(this.MS, false);
        aj(i);
        return true;
    }

    public boolean bI(String str) {
        String[] switchLibs;
        String[] lB;
        if (str == null || this.MT.getMaxCrashTimes() <= 0) {
            return false;
        }
        if (this.MT.lB() != null) {
            for (String str2 : this.MT.lB()) {
                if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                    this.MR++;
                    ak(this.MR);
                    if (this.MR >= this.MT.getMaxCrashTimes()) {
                        aj(this.MT.getOffType());
                        this.MS = this.MT.getOffType();
                        this.MT.k(this.MT.getOffType(), false);
                        return true;
                    }
                    return true;
                }
            }
        }
        if (this.MT.getSwitchLibs() != null) {
            for (String str3 : this.MT.getSwitchLibs()) {
                if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                    this.MR++;
                    ak(this.MR);
                    if (this.MR >= this.MT.getMaxCrashTimes()) {
                        aj(this.MT.getOffType());
                        this.MS = this.MT.getOffType();
                        this.MT.k(this.MT.getOffType(), false);
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
        edit.putInt(this.MT.getName() + MQ, i);
        edit.commit();
    }

    private int lD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.MT.getName() + MQ, this.MT.getDefaultType());
    }

    private int lE() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(this.MT.getName() + MP, -1);
    }

    private void ak(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.MT.getName() + MP, i);
        edit.commit();
    }

    public void reset() {
        this.MR = 0;
    }

    public void al(int i) {
        this.MR = i;
    }
}
