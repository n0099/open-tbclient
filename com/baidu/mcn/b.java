package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String afa = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences afb;
    private Set<String> afc;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b afd = new b();
    }

    public static b tJ() {
        return a.afd;
    }

    private b() {
        this.afb = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void cD(String str) {
        if (!StringUtils.isNull(str)) {
            this.afc = this.afb.getStringSet(afa, null);
            if (this.afc == null) {
                this.afc = new HashSet();
            }
            this.afc.add(str);
            this.afb.edit().putStringSet(afa, this.afc).commit();
        }
    }

    public boolean cE(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.afc == null) {
            this.afc = this.afb.getStringSet(afa, null);
        }
        if (this.afc != null) {
            return this.afc.contains(str);
        }
        return false;
    }
}
