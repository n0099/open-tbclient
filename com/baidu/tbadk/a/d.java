package com.baidu.tbadk.a;

import android.os.Build;
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
    private static Boolean eHK = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.eHL)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.eHL.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zz(String str) {
        e zx = c.biL().zx(str);
        return (zx == null || TextUtils.isEmpty(zx.eHL) || !zx.eHL.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> biM() {
        return c.biL().biM();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.biL().j(bdUniqueId);
    }

    public static boolean biR() {
        return true;
    }

    public static boolean biS() {
        return a(h.eHM, "11_8_hot_b");
    }

    public static boolean biT() {
        return a(com.baidu.tbadk.a.a.b.eHM, "11_9_backuser_a");
    }

    public static boolean biU() {
        return a(p.eHM, "12_3_staticopt_a");
    }

    public static boolean biV() {
        return Build.VERSION.SDK_INT >= 21 && zz("12_2_picpage_bear_a");
    }

    public static boolean biW() {
        return Build.VERSION.SDK_INT >= 21 && zz("11_9_pb_bear_a");
    }

    public static boolean biX() {
        return Build.VERSION.SDK_INT >= 21 && zz("12_2_frs_bear_a");
    }

    public static boolean biY() {
        return zz("11_9_post_thread_title_out_a");
    }

    public static boolean biZ() {
        return biR();
    }

    public static boolean bja() {
        return false;
    }

    public static boolean bjb() {
        return bjk() != 0;
    }

    public static boolean bjc() {
        return true;
    }

    public static boolean bjd() {
        return true;
    }

    public static boolean bje() {
        return a(com.baidu.tbadk.a.a.d.eHM, "11_9_frs_page_guide_a");
    }

    public static boolean bjf() {
        return bjg() || bjh();
    }

    public static boolean bjg() {
        return a(n.eHM, "11_9_discover_hot_card_slogan");
    }

    public static boolean bjh() {
        return a(n.eHM, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bji() {
        return a(com.baidu.tbadk.a.a.c.eHM, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.eHM, "11_10_user_like_tab_b");
    }

    public static boolean bjj() {
        return false;
    }

    public static int bjk() {
        if (a(m.eHM, "12_1_pb_sub_post_a")) {
            return 2;
        }
        if (a(m.eHM, "12_1_pb_sub_post_b")) {
            return 3;
        }
        if (a(m.eHM, "12_1_pb_sub_post_c")) {
            return 4;
        }
        return a(m.eHM, "12_1_pb_sub_post_d") ? 5 : 0;
    }

    public static boolean bjl() {
        return a(l.eHM, "12_1_pb_a");
    }

    public static boolean bjm() {
        return a(l.eHM, "12_1_pb_b");
    }

    public static boolean bjn() {
        return a(l.eHM, "12_1_pb_c");
    }

    public static boolean bjo() {
        return bjl() || bjm() || bjn();
    }

    public static boolean bjp() {
        return a(f.eHM, "12_2_frs_default_tab_a");
    }

    public static boolean bjq() {
        return a(f.eHM, "12_2_frs_default_tab_b");
    }

    public static boolean bjr() {
        return a(f.eHM, "12_2_frs_default_tab_c");
    }

    public static boolean bjs() {
        return bjp() || bjq() || bjr();
    }

    public static boolean bjt() {
        return a(com.baidu.tbadk.a.a.e.eHM, "12_2_frs_default_sort_a");
    }

    public static boolean bju() {
        return a(j.eHM, "12_2_pb_picpage_a");
    }

    public static boolean bjv() {
        return a(j.eHM, "12_2_pb_picpage_b");
    }

    public static boolean bjw() {
        return a(r.eHM, "12_3_video_release_a");
    }

    public static boolean bjx() {
        return a(r.eHM, "12_3_video_release_b");
    }

    public static boolean bjy() {
        return a(r.eHM, "12_3_video_release_c");
    }

    public static boolean bjz() {
        return a(r.eHM, "12_3_video_release_d");
    }

    public static boolean bjA() {
        return a(r.eHM, "12_3_video_release_e");
    }

    public static boolean bjB() {
        return a(k.eHM, "12_3_pb_outer_item_a");
    }

    public static boolean bjC() {
        return bjw() || bjy();
    }

    public static boolean bjD() {
        return bjx() || bjz();
    }

    public static boolean bjE() {
        return a(o.eHM, "12_3_search_login_a");
    }
}
