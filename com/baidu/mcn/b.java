package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aeT = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences aeU;
    private Set<String> aeV;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aeW = new b();
    }

    public static b sX() {
        return a.aeW;
    }

    private b() {
        this.aeU = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void cS(String str) {
        if (!StringUtils.isNull(str)) {
            this.aeV = this.aeU.getStringSet(aeT, null);
            if (this.aeV == null) {
                this.aeV = new HashSet();
            }
            this.aeV.add(str);
            this.aeU.edit().putStringSet(aeT, this.aeV).commit();
        }
    }

    public boolean cT(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aeV == null) {
            this.aeV = this.aeU.getStringSet(aeT, null);
        }
        if (this.aeV != null) {
            return this.aeV.contains(str);
        }
        return false;
    }
}
