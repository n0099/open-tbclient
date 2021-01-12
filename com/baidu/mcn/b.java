package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String cdF = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> cdG;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b cdH = new b();
    }

    public static b ZC() {
        return a.cdH;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void ir(String str) {
        if (!StringUtils.isNull(str)) {
            this.cdG = this.mPreference.getStringSet(cdF, null);
            if (this.cdG == null) {
                this.cdG = new HashSet();
            }
            this.cdG.add(str);
            this.mPreference.edit().putStringSet(cdF, this.cdG).commit();
        }
    }

    public boolean is(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.cdG == null) {
            this.cdG = this.mPreference.getStringSet(cdF, null);
        }
        if (this.cdG != null) {
            return this.cdG.contains(str);
        }
        return false;
    }
}
