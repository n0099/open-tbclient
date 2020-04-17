package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bhk = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bhl;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bhm = new b();
    }

    public static b JF() {
        return a.bhm;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void ft(String str) {
        if (!StringUtils.isNull(str)) {
            this.bhl = this.mPreference.getStringSet(bhk, null);
            if (this.bhl == null) {
                this.bhl = new HashSet();
            }
            this.bhl.add(str);
            this.mPreference.edit().putStringSet(bhk, this.bhl).commit();
        }
    }

    public boolean fu(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bhl == null) {
            this.bhl = this.mPreference.getStringSet(bhk, null);
        }
        if (this.bhl != null) {
            return this.bhl.contains(str);
        }
        return false;
    }
}
