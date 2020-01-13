package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aHi = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> aHj;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aHk = new b();
    }

    public static b Bo() {
        return a.aHk;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void el(String str) {
        if (!StringUtils.isNull(str)) {
            this.aHj = this.mPreference.getStringSet(aHi, null);
            if (this.aHj == null) {
                this.aHj = new HashSet();
            }
            this.aHj.add(str);
            this.mPreference.edit().putStringSet(aHi, this.aHj).commit();
        }
    }

    public boolean em(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aHj == null) {
            this.aHj = this.mPreference.getStringSet(aHi, null);
        }
        if (this.aHj != null) {
            return this.aHj.contains(str);
        }
        return false;
    }
}
