package com.baidu.tbadk.a.b;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private static String eIS = "key_user_last_access_tab_";
    private static String eIT = "key_frs_new_area_tab_sort_";
    public static int eIU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public static final String eIV = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);
    public static final String eIW = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static int bne() {
        if (d.bmU()) {
            return 1;
        }
        if (d.bmV()) {
            return 503;
        }
        if (d.bmW()) {
            return Am(bnh());
        }
        return 1;
    }

    private static int Am(String str) {
        return (!eIV.equals(str) && eIW.equals(str)) ? 503 : 1;
    }

    private static String bnf() {
        return eIS + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bng() {
        return eIT + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bnh() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getString(bnf(), eIV);
    }

    public static void An(String str) {
        if (eIV.equals(str) || eIW.equals(str)) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putString(bnf(), str);
        }
    }

    public static int bni() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt(bng(), eIU);
    }

    public static void om(int i) {
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt(bng(), i);
    }
}
