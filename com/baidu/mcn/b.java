package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String cjo = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> cjp;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b cjq = new b();
    }

    public static b abu() {
        return a.cjq;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void jd(String str) {
        if (!StringUtils.isNull(str)) {
            this.cjp = this.mPreference.getStringSet(cjo, null);
            if (this.cjp == null) {
                this.cjp = new HashSet();
            }
            this.cjp.add(str);
            this.mPreference.edit().putStringSet(cjo, this.cjp).commit();
        }
    }

    public boolean je(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.cjp == null) {
            this.cjp = this.mPreference.getStringSet(cjo, null);
        }
        if (this.cjp != null) {
            return this.cjp.contains(str);
        }
        return false;
    }
}
