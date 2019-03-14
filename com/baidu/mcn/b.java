package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aeO = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences aeP;
    private Set<String> aeQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aeR = new b();
    }

    public static b sY() {
        return a.aeR;
    }

    private b() {
        this.aeP = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void cQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.aeQ = this.aeP.getStringSet(aeO, null);
            if (this.aeQ == null) {
                this.aeQ = new HashSet();
            }
            this.aeQ.add(str);
            this.aeP.edit().putStringSet(aeO, this.aeQ).commit();
        }
    }

    public boolean cR(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aeQ == null) {
            this.aeQ = this.aeP.getStringSet(aeO, null);
        }
        if (this.aeQ != null) {
            return this.aeQ.contains(str);
        }
        return false;
    }
}
