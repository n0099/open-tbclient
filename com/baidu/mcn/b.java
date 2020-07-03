package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String btN = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> btO;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b btP = new b();
    }

    public static b MG() {
        return a.btP;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void gn(String str) {
        if (!StringUtils.isNull(str)) {
            this.btO = this.mPreference.getStringSet(btN, null);
            if (this.btO == null) {
                this.btO = new HashSet();
            }
            this.btO.add(str);
            this.mPreference.edit().putStringSet(btN, this.btO).commit();
        }
    }

    public boolean go(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.btO == null) {
            this.btO = this.mPreference.getStringSet(btN, null);
        }
        if (this.btO != null) {
            return this.btO.contains(str);
        }
        return false;
    }
}
