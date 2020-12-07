package com.baidu.tbadk.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.a.a.j;
import com.baidu.tbadk.a.a.k;
import com.baidu.tbadk.a.a.l;
import com.baidu.tbadk.a.a.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static Boolean ezp = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.ezq)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.ezq.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Ap(String str) {
        e Ao = c.bkb().Ao(str);
        return (Ao == null || TextUtils.isEmpty(Ao.ezq) || !Ao.ezq.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> bkc() {
        return c.bkb().bkc();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bkb().j(bdUniqueId);
    }

    public static boolean bkh() {
        return false;
    }

    public static boolean bki() {
        return false;
    }

    public static boolean bkj() {
        return true;
    }

    public static boolean bkk() {
        return a(f.ezr, "11_8_hot_a");
    }

    public static boolean bkl() {
        return a(f.ezr, "11_8_hot_b");
    }

    public static boolean bkm() {
        return false;
    }

    public static boolean bkn() {
        return a(com.baidu.tbadk.a.a.b.ezr, "11_9_backuser_a");
    }

    public static boolean bko() {
        return a(m.ezr, "12_0_staticopt_a");
    }

    public static boolean bkp() {
        return Ap("11_9_post_thread_title_out_a");
    }

    public static boolean bkq() {
        return bkj();
    }

    public static boolean bkr() {
        return false;
    }

    public static boolean bks() {
        return bkC() != 0;
    }

    public static boolean bkt() {
        return true;
    }

    public static boolean bku() {
        return true;
    }

    public static boolean bkv() {
        return a(com.baidu.tbadk.a.a.d.ezr, "11_9_frs_page_guide_a");
    }

    public static boolean bkw() {
        return bkx() || bky();
    }

    public static boolean bkx() {
        return a(l.ezr, "11_9_discover_hot_card_slogan");
    }

    public static boolean bky() {
        return a(l.ezr, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bkz() {
        return a(com.baidu.tbadk.a.a.c.ezr, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.ezr, "11_10_user_like_tab_b");
    }

    public static boolean bkA() {
        return TbadkCoreApplication.ISARCOREUI;
    }

    public static boolean bkB() {
        return Ap("12_0_B_brand_level_a");
    }

    public static void e(View view, boolean z) {
        if (bkA() && view != null) {
            view.setPadding(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007), view.getPaddingTop(), z ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) : 0, view.getPaddingBottom());
        }
    }

    public static int bkC() {
        if (a(k.ezr, "12_1_pb_sub_post_a")) {
            return 2;
        }
        if (a(k.ezr, "12_1_pb_sub_post_b")) {
            return 3;
        }
        if (a(k.ezr, "12_1_pb_sub_post_c")) {
            return 4;
        }
        return a(k.ezr, "12_1_pb_sub_post_d") ? 5 : 0;
    }

    public static boolean bkD() {
        return a(j.ezr, "12_1_pb_a");
    }

    public static boolean bkE() {
        return a(j.ezr, "12_1_pb_b");
    }

    public static boolean bkF() {
        return a(j.ezr, "12_1_pb_c");
    }

    public static boolean bkG() {
        return bkD() || bkE() || bkF();
    }
}
