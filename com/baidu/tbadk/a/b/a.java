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

    public static int bnf() {
        if (d.bmV()) {
            return 1;
        }
        if (d.bmW()) {
            return 503;
        }
        if (d.bmX()) {
            return Am(bni());
        }
        return 1;
    }

    private static int Am(String str) {
        return (!eIV.equals(str) && eIW.equals(str)) ? 503 : 1;
    }

    private static String bng() {
        return eIS + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bnh() {
        return eIT + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bni() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getString(bng(), eIV);
    }

    public static void An(String str) {
        if (eIV.equals(str) || eIW.equals(str)) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putString(bng(), str);
        }
    }

    public static int bnj() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt(bnh(), eIU);
    }

    public static void om(int i) {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt(bnh(), i);
    }
}
