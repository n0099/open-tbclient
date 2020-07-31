package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String buk = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bul;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bum = new b();
    }

    public static b MN() {
        return a.bum;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void gm(String str) {
        if (!StringUtils.isNull(str)) {
            this.bul = this.mPreference.getStringSet(buk, null);
            if (this.bul == null) {
                this.bul = new HashSet();
            }
            this.bul.add(str);
            this.mPreference.edit().putStringSet(buk, this.bul).commit();
        }
    }

    public boolean gn(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bul == null) {
            this.bul = this.mPreference.getStringSet(buk, null);
        }
        if (this.bul != null) {
            return this.bul.contains(str);
        }
        return false;
    }
}
