package com.baidu.tbadk;

import android.content.SharedPreferences;
import d.a.j0.r.d0.b;
/* loaded from: classes3.dex */
public class TbadkSettings {
    public static TbadkSettings mSettings = new TbadkSettings();
    public SharedPreferences sp;

    public static TbadkSettings getInst() {
        return mSettings;
    }

    public boolean isContains(String str) {
        return b.j().s(str);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.j().g(str, z);
    }

    public int loadInt(String str, int i2) {
        return b.j().k(str, i2);
    }

    public long loadLong(String str, long j) {
        return b.j().l(str, j);
    }

    public String loadString(String str, String str2) {
        return b.j().p(str, str2);
    }

    public void saveBoolean(String str, boolean z) {
        b.j().t(str, z);
    }

    public void saveInt(String str, int i2) {
        b.j().v(str, i2);
    }

    public void saveLong(String str, long j) {
        b.j().w(str, j);
    }

    public void saveString(String str, String str2) {
        b.j().x(str, str2);
    }
}
