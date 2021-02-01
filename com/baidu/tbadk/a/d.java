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
import com.baidu.tbadk.a.a.o;
import com.baidu.tbadk.a.a.p;
import com.baidu.tbadk.a.a.r;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static Boolean eGj = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.eGk)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.eGk.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zs(String str) {
        e zq = c.biJ().zq(str);
        return (zq == null || TextUtils.isEmpty(zq.eGk) || !zq.eGk.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> biK() {
        return c.biJ().biK();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.biJ().j(bdUniqueId);
    }

    public static boolean biP() {
        return true;
    }

    public static boolean biQ() {
        return a(h.eGl, "11_8_hot_b");
    }

    public static boolean biR() {
        return a(com.baidu.tbadk.a.a.b.eGl, "11_9_backuser_a");
    }

    public static boolean biS() {
        return a(p.eGl, "12_0_staticopt_a");
    }

    public static boolean biT() {
        return zs("12_2_picpage_bear_a");
    }

    public static boolean biU() {
        return zs("11_9_pb_bear_a");
    }

    public static boolean biV() {
        return zs("12_2_frs_bear_a");
    }

    public static boolean biW() {
        return zs("11_9_post_thread_title_out_a");
    }

    public static boolean biX() {
        return biP();
    }

    public static boolean biY() {
        return false;
    }

    public static boolean biZ() {
        return bji() != 0;
    }

    public static boolean bja() {
        return true;
    }

    public static boolean bjb() {
        return true;
    }

    public static boolean bjc() {
        return a(com.baidu.tbadk.a.a.d.eGl, "11_9_frs_page_guide_a");
    }

    public static boolean bjd() {
        return bje() || bjf();
    }

    public static boolean bje() {
        return a(n.eGl, "11_9_discover_hot_card_slogan");
    }

    public static boolean bjf() {
        return a(n.eGl, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bjg() {
        return a(com.baidu.tbadk.a.a.c.eGl, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.eGl, "11_10_user_like_tab_b");
    }

    public static boolean bjh() {
        return false;
    }

    public static int bji() {
        if (a(m.eGl, "12_1_pb_sub_post_a")) {
            return 2;
        }
        if (a(m.eGl, "12_1_pb_sub_post_b")) {
            return 3;
        }
        if (a(m.eGl, "12_1_pb_sub_post_c")) {
            return 4;
        }
        return a(m.eGl, "12_1_pb_sub_post_d") ? 5 : 0;
    }

    public static boolean bjj() {
        return a(l.eGl, "12_1_pb_a");
    }

    public static boolean bjk() {
        return a(l.eGl, "12_1_pb_b");
    }

    public static boolean bjl() {
        return a(l.eGl, "12_1_pb_c");
    }

    public static boolean bjm() {
        return bjj() || bjk() || bjl();
    }

    public static boolean bjn() {
        return a(f.eGl, "12_2_frs_default_tab_a");
    }

    public static boolean bjo() {
        return a(f.eGl, "12_2_frs_default_tab_b");
    }

    public static boolean bjp() {
        return a(f.eGl, "12_2_frs_default_tab_c");
    }

    public static boolean bjq() {
        return bjn() || bjo() || bjp();
    }

    public static boolean bjr() {
        return a(com.baidu.tbadk.a.a.e.eGl, "12_2_frs_default_sort_a");
    }

    public static boolean bjs() {
        return a(j.eGl, "12_2_pb_picpage_a");
    }

    public static boolean bjt() {
        return a(j.eGl, "12_2_pb_picpage_b");
    }

    public static boolean bju() {
        return a(r.eGl, "12_3_video_release_a");
    }

    public static boolean bjv() {
        return a(r.eGl, "12_3_video_release_b");
    }

    public static boolean bjw() {
        return a(r.eGl, "12_3_video_release_c");
    }

    public static boolean bjx() {
        return a(r.eGl, "12_3_video_release_d");
    }

    public static boolean bjy() {
        return a(r.eGl, "12_3_video_release_e");
    }

    public static boolean bjz() {
        return a(k.eGl, "12_3_pb_outer_item_a");
    }

    public static boolean bjA() {
        return bju() || bjw();
    }

    public static boolean bjB() {
        return bjv() || bjx();
    }

    public static boolean bjC() {
        return a(o.eGl, "12_3_search_login_a");
    }
}
