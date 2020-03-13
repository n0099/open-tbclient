package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String aLp = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> aLq;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b aLr = new b();
    }

    public static b DG() {
        return a.aLr;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void eA(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLq = this.mPreference.getStringSet(aLp, null);
            if (this.aLq == null) {
                this.aLq = new HashSet();
            }
            this.aLq.add(str);
            this.mPreference.edit().putStringSet(aLp, this.aLq).commit();
        }
    }

    public boolean eB(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.aLq == null) {
            this.aLq = this.mPreference.getStringSet(aLp, null);
        }
        if (this.aLq != null) {
            return this.aLq.contains(str);
        }
        return false;
    }
}
