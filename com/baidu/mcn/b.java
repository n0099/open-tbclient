package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bSs = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bSt;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bSu = new b();
    }

    public static b Xq() {
        return a.bSu;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void iY(String str) {
        if (!StringUtils.isNull(str)) {
            this.bSt = this.mPreference.getStringSet(bSs, null);
            if (this.bSt == null) {
                this.bSt = new HashSet();
            }
            this.bSt.add(str);
            this.mPreference.edit().putStringSet(bSs, this.bSt).commit();
        }
    }

    public boolean iZ(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bSt == null) {
            this.bSt = this.mPreference.getStringSet(bSs, null);
        }
        if (this.bSt != null) {
            return this.bSt.contains(str);
        }
        return false;
    }
}
