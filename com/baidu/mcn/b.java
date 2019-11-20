package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String ayD = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences ayE;
    private Set<String> ayF;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b ayG = new b();
    }

    public static b ze() {
        return a.ayG;
    }

    private b() {
        this.ayE = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void dt(String str) {
        if (!StringUtils.isNull(str)) {
            this.ayF = this.ayE.getStringSet(ayD, null);
            if (this.ayF == null) {
                this.ayF = new HashSet();
            }
            this.ayF.add(str);
            this.ayE.edit().putStringSet(ayD, this.ayF).commit();
        }
    }

    public boolean du(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.ayF == null) {
            this.ayF = this.ayE.getStringSet(ayD, null);
        }
        if (this.ayF != null) {
            return this.ayF.contains(str);
        }
        return false;
    }
}
