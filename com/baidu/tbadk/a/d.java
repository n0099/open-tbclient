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
    private static Boolean enY = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.enZ)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.enZ.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zA(String str) {
        e zz = c.bfd().zz(str);
        return (zz == null || TextUtils.isEmpty(zz.enZ) || !zz.enZ.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> bfe() {
        return c.bfd().bfe();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bfd().j(bdUniqueId);
    }

    public static boolean bfj() {
        return k.E("70_3");
    }

    public static boolean bfk() {
        return a(h.eoa, "11_7_pb_b");
    }

    public static boolean bfl() {
        return a(h.eoa, "11_7_pb_c");
    }

    public static boolean bfm() {
        return a(h.eoa, "11_7_pb_d");
    }

    public static boolean bfn() {
        return true;
    }

    public static boolean bfo() {
        return a(com.baidu.tbadk.a.a.e.eoa, "11_7_index_b");
    }

    public static boolean bfp() {
        return a(f.eoa, "11_8_hot_a");
    }

    public static boolean bfq() {
        return a(f.eoa, "11_8_hot_b");
    }

    public static boolean bfr() {
        return a(i.eoa, "11_9_pb_gif_size_a");
    }

    public static boolean bfs() {
        return a(com.baidu.tbadk.a.a.b.eoa, "11_9_backuser_a");
    }

    public static boolean bft() {
        return zA("11_9_post_thread_title_out_a");
    }

    public static boolean bfu() {
        return bfn();
    }

    public static boolean bfv() {
        return false;
    }

    public static boolean bfw() {
        return bfk() || bfl();
    }

    public static boolean bfx() {
        return true;
    }

    public static boolean bfy() {
        return true;
    }

    public static boolean bfz() {
        return a(com.baidu.tbadk.a.a.d.eoa, "11_9_frs_page_guide_a");
    }

    public static boolean bfA() {
        return bfB() || bfC();
    }

    public static boolean bfB() {
        return a(j.eoa, "11_9_discover_hot_card_slogan");
    }

    public static boolean bfC() {
        return a(j.eoa, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bfD() {
        return a(com.baidu.tbadk.a.a.c.eoa, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.eoa, "11_10_user_like_tab_b");
    }
}
