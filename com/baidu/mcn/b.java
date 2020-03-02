package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aLo = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> aLp;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aLq = new b();
    }

    public static b DG() {
        return a.aLq;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void eA(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLp = this.mPreference.getStringSet(aLo, null);
            if (this.aLp == null) {
                this.aLp = new HashSet();
            }
            this.aLp.add(str);
            this.mPreference.edit().putStringSet(aLo, this.aLp).commit();
        }
    }

    public boolean eB(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aLp == null) {
            this.aLp = this.mPreference.getStringSet(aLo, null);
        }
        if (this.aLp != null) {
            return this.aLp.contains(str);
        }
        return false;
    }
}
