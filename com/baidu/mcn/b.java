package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aeU = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private SharedPreferences aeV;
    private Set<String> aeW;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aeX = new b();
    }

    public static b sX() {
        return a.aeX;
    }

    private b() {
        this.aeV = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void cS(String str) {
        if (!StringUtils.isNull(str)) {
            this.aeW = this.aeV.getStringSet(aeU, null);
            if (this.aeW == null) {
                this.aeW = new HashSet();
            }
            this.aeW.add(str);
            this.aeV.edit().putStringSet(aeU, this.aeW).commit();
        }
    }

    public boolean cT(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aeW == null) {
            this.aeW = this.aeV.getStringSet(aeU, null);
        }
        if (this.aeW != null) {
            return this.aeW.contains(str);
        }
        return false;
    }
}
