package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.a.a.h;
import com.baidu.tbadk.a.a.j;
import com.baidu.tbadk.a.a.k;
import com.baidu.tbadk.a.a.l;
import com.baidu.tbadk.a.a.m;
import com.baidu.tbadk.a.a.n;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static Boolean eEc = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.eEd)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.eEd.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean za(String str) {
        e yY = c.bix().yY(str);
        return (yY == null || TextUtils.isEmpty(yY.eEd) || !yY.eEd.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> biy() {
        return c.bix().biy();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bix().j(bdUniqueId);
    }

    public static boolean biD() {
        return true;
    }

    public static boolean biE() {
        return a(h.eEe, "11_8_hot_b");
    }

    public static boolean biF() {
        return a(com.baidu.tbadk.a.a.b.eEe, "11_9_backuser_a");
    }

    public static boolean biG() {
        return a(n.eEe, "12_0_staticopt_a");
    }

    public static boolean biH() {
        return za("12_2_picpage_bear_a");
    }

    public static boolean biI() {
        return za("11_9_pb_bear_a");
    }

    public static boolean biJ() {
        return za("12_2_frs_bear_a");
    }

    public static boolean biK() {
        return za("11_9_post_thread_title_out_a");
    }

    public static boolean biL() {
        return biD();
    }

    public static boolean biM() {
        return false;
    }

    public static boolean biN() {
        return biW() != 0;
    }

    public static boolean biO() {
        return true;
    }

    public static boolean biP() {
        return true;
    }

    public static boolean biQ() {
        return a(com.baidu.tbadk.a.a.d.eEe, "11_9_frs_page_guide_a");
    }

    public static boolean biR() {
        return biS() || biT();
    }

    public static boolean biS() {
        return a(m.eEe, "11_9_discover_hot_card_slogan");
    }

    public static boolean biT() {
        return a(m.eEe, "11_9_discover_hot_card_hot_text");
    }

    public static boolean biU() {
        return a(com.baidu.tbadk.a.a.c.eEe, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.eEe, "11_10_user_like_tab_b");
    }

    public static boolean biV() {
        return false;
    }

    public static int biW() {
        if (a(l.eEe, "12_1_pb_sub_post_a")) {
            return 2;
        }
        if (a(l.eEe, "12_1_pb_sub_post_b")) {
            return 3;
        }
        if (a(l.eEe, "12_1_pb_sub_post_c")) {
            return 4;
        }
        return a(l.eEe, "12_1_pb_sub_post_d") ? 5 : 0;
    }

    public static boolean biX() {
        return a(k.eEe, "12_1_pb_a");
    }

    public static boolean biY() {
        return a(k.eEe, "12_1_pb_b");
    }

    public static boolean biZ() {
        return a(k.eEe, "12_1_pb_c");
    }

    public static boolean bja() {
        return biX() || biY() || biZ();
    }

    public static boolean bjb() {
        return a(f.eEe, "12_2_frs_default_tab_a");
    }

    public static boolean bjc() {
        return a(f.eEe, "12_2_frs_default_tab_b");
    }

    public static boolean bjd() {
        return a(f.eEe, "12_2_frs_default_tab_c");
    }

    public static boolean bje() {
        return bjb() || bjc() || bjd();
    }

    public static boolean bjf() {
        return a(com.baidu.tbadk.a.a.e.eEe, "12_2_frs_default_sort_a");
    }

    public static boolean bjg() {
        return a(j.eEe, "12_2_pb_picpage_a");
    }

    public static boolean bjh() {
        return a(j.eEe, "12_2_pb_picpage_b");
    }
}
