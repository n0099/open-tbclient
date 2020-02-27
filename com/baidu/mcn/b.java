package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aLn = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> aLo;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aLp = new b();
    }

    public static b DE() {
        return a.aLp;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void eA(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLo = this.mPreference.getStringSet(aLn, null);
            if (this.aLo == null) {
                this.aLo = new HashSet();
            }
            this.aLo.add(str);
            this.mPreference.edit().putStringSet(aLn, this.aLo).commit();
        }
    }

    public boolean eB(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aLo == null) {
            this.aLo = this.mPreference.getStringSet(aLn, null);
        }
        if (this.aLo != null) {
            return this.aLo.contains(str);
        }
        return false;
    }
}
