package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String ayV = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences ayW;
    private Set<String> ayX;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b ayY = new b();
    }

    public static b zd() {
        return a.ayY;
    }

    private b() {
        this.ayW = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void dt(String str) {
        if (!StringUtils.isNull(str)) {
            this.ayX = this.ayW.getStringSet(ayV, null);
            if (this.ayX == null) {
                this.ayX = new HashSet();
            }
            this.ayX.add(str);
            this.ayW.edit().putStringSet(ayV, this.ayX).commit();
        }
    }

    public boolean du(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.ayX == null) {
            this.ayX = this.ayW.getStringSet(ayV, null);
        }
        if (this.ayX != null) {
            return this.ayX.contains(str);
        }
        return false;
    }
}
