package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bzY = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bzZ;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bAa = new b();
    }

    public static b SM() {
        return a.bAa;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void hI(String str) {
        if (!StringUtils.isNull(str)) {
            this.bzZ = this.mPreference.getStringSet(bzY, null);
            if (this.bzZ == null) {
                this.bzZ = new HashSet();
            }
            this.bzZ.add(str);
            this.mPreference.edit().putStringSet(bzY, this.bzZ).commit();
        }
    }

    public boolean hJ(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bzZ == null) {
            this.bzZ = this.mPreference.getStringSet(bzY, null);
        }
        if (this.bzZ != null) {
            return this.bzZ.contains(str);
        }
        return false;
    }
}
