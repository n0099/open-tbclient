package com.baidu.tbadk.a.b;

import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private static String eGo = "key_user_last_access_tab_";
    private static String eGp = "key_frs_new_area_tab_sort_";
    public static int eGq = Integer.MAX_VALUE;
    public static final String eGr = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);
    public static final String eGs = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static int bjG() {
        if (d.bjn()) {
            return 1;
        }
        if (d.bjo()) {
            return 503;
        }
        if (d.bjp()) {
            return zt(bjJ());
        }
        return 1;
    }

    private static int zt(String str) {
        return (!eGr.equals(str) && eGs.equals(str)) ? 503 : 1;
    }

    private static String bjH() {
        return eGo + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bjI() {
        return eGp + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bjJ() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getString(bjH(), eGr);
    }

    public static void zu(String str) {
        if (eGr.equals(str) || eGs.equals(str)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(bjH(), str);
        }
    }

    public static int bjK() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt(bjI(), eGq);
    }

    public static void mJ(int i) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(bjI(), i);
    }
}
