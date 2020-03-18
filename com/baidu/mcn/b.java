package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aLD = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> aLE;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aLF = new b();
    }

    public static b DN() {
        return a.aLF;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void ez(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLE = this.mPreference.getStringSet(aLD, null);
            if (this.aLE == null) {
                this.aLE = new HashSet();
            }
            this.aLE.add(str);
            this.mPreference.edit().putStringSet(aLD, this.aLE).commit();
        }
    }

    public boolean eA(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aLE == null) {
            this.aLE = this.mPreference.getStringSet(aLD, null);
        }
        if (this.aLE != null) {
            return this.aLE.contains(str);
        }
        return false;
    }
}
