package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aGq = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> aGr;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aGs = new b();
    }

    public static b AS() {
        return a.aGs;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void ei(String str) {
        if (!StringUtils.isNull(str)) {
            this.aGr = this.mPreference.getStringSet(aGq, null);
            if (this.aGr == null) {
                this.aGr = new HashSet();
            }
            this.aGr.add(str);
            this.mPreference.edit().putStringSet(aGq, this.aGr).commit();
        }
    }

    public boolean ej(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aGr == null) {
            this.aGr = this.mPreference.getStringSet(aGq, null);
        }
        if (this.aGr != null) {
            return this.aGr.contains(str);
        }
        return false;
    }
}
