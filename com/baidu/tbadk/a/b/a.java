package com.baidu.tbadk.a.b;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private static String eEh = "key_user_last_access_tab_";
    private static String eEi = "key_frs_new_area_tab_sort_";
    public static int eEj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public static final String eEk = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);
    public static final String eEl = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static int bjl() {
        if (d.bjb()) {
            return 1;
        }
        if (d.bjc()) {
            return 503;
        }
        if (d.bjd()) {
            return zb(bjo());
        }
        return 1;
    }

    private static int zb(String str) {
        return (!eEk.equals(str) && eEl.equals(str)) ? 503 : 1;
    }

    private static String bjm() {
        return eEh + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bjn() {
        return eEi + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bjo() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getString(bjm(), eEk);
    }

    public static void zc(String str) {
        if (eEk.equals(str) || eEl.equals(str)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putString(bjm(), str);
        }
    }

    public static int bjp() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt(bjn(), eEj);
    }

    public static void mG(int i) {
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(bjn(), i);
    }
}
