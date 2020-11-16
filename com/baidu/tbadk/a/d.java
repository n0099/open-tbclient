package com.baidu.tbadk.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.a.a.h;
import com.baidu.tbadk.a.a.i;
import com.baidu.tbadk.a.a.j;
import com.baidu.tbadk.a.a.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static Boolean esm = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.esn)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.esn.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zI(String str) {
        e zH = c.bgW().zH(str);
        return (zH == null || TextUtils.isEmpty(zH.esn) || !zH.esn.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> bgX() {
        return c.bgW().bgX();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bgW().j(bdUniqueId);
    }

    public static boolean bhc() {
        return a(h.eso, "11_7_pb_b");
    }

    public static boolean bhd() {
        return a(h.eso, "11_7_pb_c");
    }

    public static boolean bhe() {
        return a(h.eso, "11_7_pb_d");
    }

    public static boolean bhf() {
        return true;
    }

    public static boolean bhg() {
        return a(f.eso, "11_8_hot_a");
    }

    public static boolean bhh() {
        return a(f.eso, "11_8_hot_b");
    }

    public static boolean bhi() {
        return a(i.eso, "11_9_pb_gif_size_a");
    }

    public static boolean bhj() {
        return a(com.baidu.tbadk.a.a.b.eso, "11_9_backuser_a");
    }

    public static boolean bhk() {
        return a(k.eso, "12_0_staticopt_a");
    }

    public static boolean bhl() {
        return zI("11_9_post_thread_title_out_a");
    }

    public static boolean bhm() {
        return bhf();
    }

    public static boolean bhn() {
        return false;
    }

    public static boolean bho() {
        return bhc() || bhd();
    }

    public static boolean bhp() {
        return true;
    }

    public static boolean bhq() {
        return true;
    }

    public static boolean bhr() {
        return a(com.baidu.tbadk.a.a.d.eso, "11_9_frs_page_guide_a");
    }

    public static boolean bhs() {
        return bht() || bhu();
    }

    public static boolean bht() {
        return a(j.eso, "11_9_discover_hot_card_slogan");
    }

    public static boolean bhu() {
        return a(j.eso, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bhv() {
        return a(com.baidu.tbadk.a.a.c.eso, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.eso, "11_10_user_like_tab_b");
    }

    public static boolean bhw() {
        return TbadkCoreApplication.ISARCOREUI;
    }

    public static boolean bhx() {
        return zI("12_0_B_brand_level_a");
    }

    public static void e(View view, boolean z) {
        if (bhw() && view != null) {
            view.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007), view.getPaddingTop(), z ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) : 0, view.getPaddingBottom());
        }
    }
}
