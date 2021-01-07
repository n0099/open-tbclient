package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String cis = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> cit;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b ciu = new b();
    }

    public static b adv() {
        return a.ciu;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void jC(String str) {
        if (!StringUtils.isNull(str)) {
            this.cit = this.mPreference.getStringSet(cis, null);
            if (this.cit == null) {
                this.cit = new HashSet();
            }
            this.cit.add(str);
            this.mPreference.edit().putStringSet(cis, this.cit).commit();
        }
    }

    public boolean jD(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.cit == null) {
            this.cit = this.mPreference.getStringSet(cis, null);
        }
        if (this.cit != null) {
            return this.cit.contains(str);
        }
        return false;
    }
}
