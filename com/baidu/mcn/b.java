package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static String bzV = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bzW;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public static b bzX = new b();
    }

    public static b SM() {
        return a.bzX;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void hH(String str) {
        if (!StringUtils.isNull(str)) {
            this.bzW = this.mPreference.getStringSet(bzV, null);
            if (this.bzW == null) {
                this.bzW = new HashSet();
            }
            this.bzW.add(str);
            this.mPreference.edit().putStringSet(bzV, this.bzW).commit();
        }
    }

    public boolean hI(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bzW == null) {
            this.bzW = this.mPreference.getStringSet(bzV, null);
        }
        if (this.bzW != null) {
            return this.bzW.contains(str);
        }
        return false;
    }
}
