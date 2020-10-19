package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bJX = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bJY;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bJZ = new b();
    }

    public static b Vw() {
        return a.bJZ;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void iF(String str) {
        if (!StringUtils.isNull(str)) {
            this.bJY = this.mPreference.getStringSet(bJX, null);
            if (this.bJY == null) {
                this.bJY = new HashSet();
            }
            this.bJY.add(str);
            this.mPreference.edit().putStringSet(bJX, this.bJY).commit();
        }
    }

    public boolean iG(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bJY == null) {
            this.bJY = this.mPreference.getStringSet(bJX, null);
        }
        if (this.bJY != null) {
            return this.bJY.contains(str);
        }
        return false;
    }
}
