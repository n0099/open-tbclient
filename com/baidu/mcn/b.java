package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bYc = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bYd;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bYe = new b();
    }

    public static b ZP() {
        return a.bYe;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void jl(String str) {
        if (!StringUtils.isNull(str)) {
            this.bYd = this.mPreference.getStringSet(bYc, null);
            if (this.bYd == null) {
                this.bYd = new HashSet();
            }
            this.bYd.add(str);
            this.mPreference.edit().putStringSet(bYc, this.bYd).commit();
        }
    }

    public boolean jm(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bYd == null) {
            this.bYd = this.mPreference.getStringSet(bYc, null);
        }
        if (this.bYd != null) {
            return this.bYd.contains(str);
        }
        return false;
    }
}
