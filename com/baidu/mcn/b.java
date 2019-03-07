package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aeN = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences aeO;
    private Set<String> aeP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aeQ = new b();
    }

    public static b sY() {
        return a.aeQ;
    }

    private b() {
        this.aeO = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void cQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.aeP = this.aeO.getStringSet(aeN, null);
            if (this.aeP == null) {
                this.aeP = new HashSet();
            }
            this.aeP.add(str);
            this.aeO.edit().putStringSet(aeN, this.aeP).commit();
        }
    }

    public boolean cR(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aeP == null) {
            this.aeP = this.aeO.getStringSet(aeN, null);
        }
        if (this.aeP != null) {
            return this.aeP.contains(str);
        }
        return false;
    }
}
