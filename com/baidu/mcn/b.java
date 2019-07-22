package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String afx = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences afy;
    private Set<String> afz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b afA = new b();
    }

    public static b uj() {
        return a.afA;
    }

    private b() {
        this.afy = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void cI(String str) {
        if (!StringUtils.isNull(str)) {
            this.afz = this.afy.getStringSet(afx, null);
            if (this.afz == null) {
                this.afz = new HashSet();
            }
            this.afz.add(str);
            this.afy.edit().putStringSet(afx, this.afz).commit();
        }
    }

    public boolean cJ(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.afz == null) {
            this.afz = this.afy.getStringSet(afx, null);
        }
        if (this.afz != null) {
            return this.afz.contains(str);
        }
        return false;
    }
}
