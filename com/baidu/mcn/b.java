package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String cbH = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> cbI;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b cbJ = new b();
    }

    public static b abJ() {
        return a.cbJ;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void jJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.cbI = this.mPreference.getStringSet(cbH, null);
            if (this.cbI == null) {
                this.cbI = new HashSet();
            }
            this.cbI.add(str);
            this.mPreference.edit().putStringSet(cbH, this.cbI).commit();
        }
    }

    public boolean jK(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.cbI == null) {
            this.cbI = this.mPreference.getStringSet(cbH, null);
        }
        if (this.cbI != null) {
            return this.cbI.contains(str);
        }
        return false;
    }
}
