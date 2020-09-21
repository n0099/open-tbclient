package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String bDv = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> bDw;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b bDx = new b();
    }

    public static b TD() {
        return a.bDx;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void ie(String str) {
        if (!StringUtils.isNull(str)) {
            this.bDw = this.mPreference.getStringSet(bDv, null);
            if (this.bDw == null) {
                this.bDw = new HashSet();
            }
            this.bDw.add(str);
            this.mPreference.edit().putStringSet(bDv, this.bDw).commit();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m29if(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.bDw == null) {
            this.bDw = this.mPreference.getStringSet(bDv, null);
        }
        if (this.bDw != null) {
            return this.bDw.contains(str);
        }
        return false;
    }
}
