package com.baidu.tbadk;

import android.content.SharedPreferences;
import d.b.h0.r.d0.b;
/* loaded from: classes3.dex */
public class TbadkSettings {
    public static TbadkSettings mSettings = new TbadkSettings();
    public SharedPreferences sp;

    public static TbadkSettings getInst() {
        return mSettings;
    }

    public boolean isContains(String str) {
        return b.i().r(str);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.i().g(str, z);
    }

    public int loadInt(String str, int i) {
        return b.i().j(str, i);
    }

    public long loadLong(String str, long j) {
        return b.i().k(str, j);
    }

    public String loadString(String str, String str2) {
        return b.i().o(str, str2);
    }

    public void saveBoolean(String str, boolean z) {
        b.i().s(str, z);
    }

    public void saveInt(String str, int i) {
        b.i().u(str, i);
    }

    public void saveLong(String str, long j) {
        b.i().v(str, j);
    }

    public void saveString(String str, String str2) {
        b.i().w(str, str2);
    }
}
