package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bhp = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bhq;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bhr = new b();
    }

    public static b JE() {
        return a.bhr;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void ft(String str) {
        if (!StringUtils.isNull(str)) {
            this.bhq = this.mPreference.getStringSet(bhp, null);
            if (this.bhq == null) {
                this.bhq = new HashSet();
            }
            this.bhq.add(str);
            this.mPreference.edit().putStringSet(bhp, this.bhq).commit();
        }
    }

    public boolean fu(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bhq == null) {
            this.bhq = this.mPreference.getStringSet(bhp, null);
        }
        if (this.bhq != null) {
            return this.bhq.contains(str);
        }
        return false;
    }
}
