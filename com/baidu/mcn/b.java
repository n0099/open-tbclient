package com.baidu.mcn;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static String boN = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("advert_hide_list");
    private Set<String> boO;
    private SharedPreferences mPreference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static b boP = new b();
    }

    public static b Lx() {
        return a.boP;
    }

    private b() {
        this.mPreference = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }

    public void gf(String str) {
        if (!StringUtils.isNull(str)) {
            this.boO = this.mPreference.getStringSet(boN, null);
            if (this.boO == null) {
                this.boO = new HashSet();
            }
            this.boO.add(str);
            this.mPreference.edit().putStringSet(boN, this.boO).commit();
        }
    }

    public boolean gg(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.boO == null) {
            this.boO = this.mPreference.getStringSet(boN, null);
        }
        if (this.boO != null) {
            return this.boO.contains(str);
        }
        return false;
    }
}
