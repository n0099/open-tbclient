package com.baidu.tbadk.a.b;

import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private static String eHP = "key_user_last_access_tab_";
    private static String eHQ = "key_frs_new_area_tab_sort_";
    public static int eHR = Integer.MAX_VALUE;
    public static final String eHS = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);
    public static final String eHT = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static int bjI() {
        if (d.bjp()) {
            return 1;
        }
        if (d.bjq()) {
            return 503;
        }
        if (d.bjr()) {
            return zA(bjL());
        }
        return 1;
    }

    private static int zA(String str) {
        return (!eHS.equals(str) && eHT.equals(str)) ? 503 : 1;
    }

    private static String bjJ() {
        return eHP + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bjK() {
        return eHQ + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bjL() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getString(bjJ(), eHS);
    }

    public static void zB(String str) {
        if (eHS.equals(str) || eHT.equals(str)) {
            com.baidu.tbadk.core.sharedPref.b.brR().putString(bjJ(), str);
        }
    }

    public static int bjM() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt(bjK(), eHR);
    }

    public static void mK(int i) {
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(bjK(), i);
    }
}
