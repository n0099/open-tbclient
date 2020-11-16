package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bWs = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bWt;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bWu = new b();
    }

    public static b Zg() {
        return a.bWu;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void jf(String str) {
        if (!StringUtils.isNull(str)) {
            this.bWt = this.mPreference.getStringSet(bWs, null);
            if (this.bWt == null) {
                this.bWt = new HashSet();
            }
            this.bWt.add(str);
            this.mPreference.edit().putStringSet(bWs, this.bWt).commit();
        }
    }

    public boolean jg(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bWt == null) {
            this.bWt = this.mPreference.getStringSet(bWs, null);
        }
        if (this.bWt != null) {
            return this.bWt.contains(str);
        }
        return false;
    }
}
