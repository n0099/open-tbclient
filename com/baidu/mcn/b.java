package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String chN = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> chO;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b chP = new b();
    }

    public static b abr() {
        return a.chP;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void iX(String str) {
        if (!StringUtils.isNull(str)) {
            this.chO = this.mPreference.getStringSet(chN, null);
            if (this.chO == null) {
                this.chO = new HashSet();
            }
            this.chO.add(str);
            this.mPreference.edit().putStringSet(chN, this.chO).commit();
        }
    }

    public boolean iY(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.chO == null) {
            this.chO = this.mPreference.getStringSet(chN, null);
        }
        if (this.chO != null) {
            return this.chO.contains(str);
        }
        return false;
    }
}
