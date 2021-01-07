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
    private static Boolean eIN = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.eIO)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.eIO.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Al(String str) {
        e Aj = c.bmr().Aj(str);
        return (Aj == null || TextUtils.isEmpty(Aj.eIO) || !Aj.eIO.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> bms() {
        return c.bmr().bms();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bmr().j(bdUniqueId);
    }

    public static boolean bmx() {
        return true;
    }

    public static boolean bmy() {
        return a(h.eIP, "11_8_hot_b");
    }

    public static boolean bmz() {
        return a(com.baidu.tbadk.a.a.b.eIP, "11_9_backuser_a");
    }

    public static boolean bmA() {
        return a(n.eIP, "12_0_staticopt_a");
    }

    public static boolean bmB() {
        return Al("12_2_picpage_bear_a");
    }

    public static boolean bmC() {
        return Al("11_9_pb_bear_a");
    }

    public static boolean bmD() {
        return Al("12_2_frs_bear_a");
    }

    public static boolean bmE() {
        return Al("11_9_post_thread_title_out_a");
    }

    public static boolean bmF() {
        return bmx();
    }

    public static boolean bmG() {
        return false;
    }

    public static boolean bmH() {
        return bmQ() != 0;
    }

    public static boolean bmI() {
        return true;
    }

    public static boolean bmJ() {
        return true;
    }

    public static boolean bmK() {
        return a(com.baidu.tbadk.a.a.d.eIP, "11_9_frs_page_guide_a");
    }

    public static boolean bmL() {
        return bmM() || bmN();
    }

    public static boolean bmM() {
        return a(m.eIP, "11_9_discover_hot_card_slogan");
    }

    public static boolean bmN() {
        return a(m.eIP, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bmO() {
        return a(com.baidu.tbadk.a.a.c.eIP, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.eIP, "11_10_user_like_tab_b");
    }

    public static boolean bmP() {
        return false;
    }

    public static int bmQ() {
        if (a(l.eIP, "12_1_pb_sub_post_a")) {
            return 2;
        }
        if (a(l.eIP, "12_1_pb_sub_post_b")) {
            return 3;
        }
        if (a(l.eIP, "12_1_pb_sub_post_c")) {
            return 4;
        }
        return a(l.eIP, "12_1_pb_sub_post_d") ? 5 : 0;
    }

    public static boolean bmR() {
        return a(k.eIP, "12_1_pb_a");
    }

    public static boolean bmS() {
        return a(k.eIP, "12_1_pb_b");
    }

    public static boolean bmT() {
        return a(k.eIP, "12_1_pb_c");
    }

    public static boolean bmU() {
        return bmR() || bmS() || bmT();
    }

    public static boolean bmV() {
        return a(f.eIP, "12_2_frs_default_tab_a");
    }

    public static boolean bmW() {
        return a(f.eIP, "12_2_frs_default_tab_b");
    }

    public static boolean bmX() {
        return a(f.eIP, "12_2_frs_default_tab_c");
    }

    public static boolean bmY() {
        return bmV() || bmW() || bmX();
    }

    public static boolean bmZ() {
        return a(com.baidu.tbadk.a.a.e.eIP, "12_2_frs_default_sort_a");
    }

    public static boolean bna() {
        return a(j.eIP, "12_2_pb_picpage_a");
    }

    public static boolean bnb() {
        return a(j.eIP, "12_2_pb_picpage_b");
    }
}
