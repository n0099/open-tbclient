package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.a.a.h;
import com.baidu.tbadk.a.a.i;
import com.baidu.tbadk.a.a.j;
import com.baidu.tbadk.a.a.k;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static Boolean efA = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.efB)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.efB.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zh(String str) {
        e zg = c.bdk().zg(str);
        return (zg == null || TextUtils.isEmpty(zg.efB) || !zg.efB.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> bdl() {
        return c.bdk().bdl();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bdk().j(bdUniqueId);
    }

    public static boolean bdq() {
        return k.D("70_3");
    }

    public static boolean bdr() {
        return a(h.efC, "11_7_pb_b");
    }

    public static boolean bds() {
        return a(h.efC, "11_7_pb_c");
    }

    public static boolean bdt() {
        return a(h.efC, "11_7_pb_d");
    }

    public static boolean bdu() {
        return true;
    }

    public static boolean bdv() {
        return a(com.baidu.tbadk.a.a.e.efC, "11_7_index_b");
    }

    public static boolean bdw() {
        return a(f.efC, "11_8_hot_a");
    }

    public static boolean bdx() {
        return a(f.efC, "11_8_hot_b");
    }

    public static boolean bdy() {
        return a(i.efC, "11_9_pb_gif_size_a");
    }

    public static boolean bdz() {
        return a(com.baidu.tbadk.a.a.b.efC, "11_9_backuser_a");
    }

    public static boolean bdA() {
        return zh("11_9_post_thread_title_out_a");
    }

    public static boolean bdB() {
        return bdu();
    }

    public static boolean bdC() {
        return false;
    }

    public static boolean bdD() {
        return bdr() || bds();
    }

    public static boolean bdE() {
        return true;
    }

    public static boolean bdF() {
        return true;
    }

    public static boolean bdG() {
        return a(com.baidu.tbadk.a.a.d.efC, "11_9_frs_page_guide_a");
    }

    public static boolean bdH() {
        return bdI() || bdJ();
    }

    public static boolean bdI() {
        return a(j.efC, "11_9_discover_hot_card_slogan");
    }

    public static boolean bdJ() {
        return a(j.efC, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bdK() {
        return a(com.baidu.tbadk.a.a.c.efC, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.efC, "11_10_user_like_tab_b");
    }
}
