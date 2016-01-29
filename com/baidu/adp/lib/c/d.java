package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class d {
    public static String tW = "_crashtime";
    public static String tX = "_crashtype";
    private int tY;
    private int tZ;
    private c ua;

    public d(c cVar) {
        this.tY = 0;
        this.tZ = 0;
        this.ua = null;
        if (cVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.ua = cVar;
        if (this.ua.getMaxCrashTimes() > 0 && this.ua.gB() != null) {
            this.tY = gD();
            if (this.tY == -1) {
                reset();
            }
        }
        this.tZ = gC();
        this.ua.b(this.tZ, true);
    }

    public String getName() {
        return this.ua.getName();
    }

    public int getDefaultType() {
        return this.ua.getDefaultType();
    }

    public int getType() {
        return this.tZ;
    }

    public boolean V(int i) {
        if (this.ua.getMaxCrashTimes() >= 0 && this.tY >= this.ua.getMaxCrashTimes() + 2) {
            i = this.ua.getOffType();
        }
        if (i == this.tZ) {
            return false;
        }
        this.tZ = i;
        this.ua.b(this.tZ, false);
        W(i);
        return true;
    }

    public boolean ah(String str) {
        if (str == null || this.ua.getMaxCrashTimes() <= 0 || this.ua.gB() == null) {
            return false;
        }
        for (String str2 : this.ua.gB()) {
            if (str.indexOf(str2) != -1) {
                this.tY++;
                X(this.tY);
                if (this.tY >= this.ua.getMaxCrashTimes()) {
                    W(this.ua.getOffType());
                    this.tZ = this.ua.getOffType();
                    this.ua.b(this.ua.getOffType(), false);
                }
                return true;
            }
        }
        return false;
    }

    private void W(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.ua.getName()) + tX, i);
        edit.commit();
    }

    private int gC() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.ua.getName()) + tX, this.ua.getDefaultType());
    }

    private int gD() {
        return BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.ua.getName()) + tW, -1);
    }

    private void X(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.ua.getName()) + tW, i);
        edit.commit();
    }

    public void reset() {
        this.tY = 0;
    }

    public void Y(int i) {
        this.tY = i;
    }
}
