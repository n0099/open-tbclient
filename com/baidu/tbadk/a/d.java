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
    private static Boolean etS = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.etT)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.etT.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zO(String str) {
        e zN = c.bhD().zN(str);
        return (zN == null || TextUtils.isEmpty(zN.etT) || !zN.etT.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> bhE() {
        return c.bhD().bhE();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.bhD().j(bdUniqueId);
    }

    public static boolean bhJ() {
        return k.E("70_3");
    }

    public static boolean bhK() {
        return a(h.etU, "11_7_pb_b");
    }

    public static boolean bhL() {
        return a(h.etU, "11_7_pb_c");
    }

    public static boolean bhM() {
        return a(h.etU, "11_7_pb_d");
    }

    public static boolean bhN() {
        return true;
    }

    public static boolean bhO() {
        return a(com.baidu.tbadk.a.a.e.etU, "11_7_index_b");
    }

    public static boolean bhP() {
        return a(f.etU, "11_8_hot_a");
    }

    public static boolean bhQ() {
        return a(f.etU, "11_8_hot_b");
    }

    public static boolean bhR() {
        return a(i.etU, "11_9_pb_gif_size_a");
    }

    public static boolean bhS() {
        return a(com.baidu.tbadk.a.a.b.etU, "11_9_backuser_a");
    }

    public static boolean bhT() {
        return zO("11_9_post_thread_title_out_a");
    }

    public static boolean bhU() {
        return bhN();
    }

    public static boolean bhV() {
        return false;
    }

    public static boolean bhW() {
        return bhK() || bhL();
    }

    public static boolean bhX() {
        return true;
    }

    public static boolean bhY() {
        return true;
    }

    public static boolean bhZ() {
        return a(com.baidu.tbadk.a.a.d.etU, "11_9_frs_page_guide_a");
    }

    public static boolean bia() {
        return bib() || bic();
    }

    public static boolean bib() {
        return a(j.etU, "11_9_discover_hot_card_slogan");
    }

    public static boolean bic() {
        return a(j.etU, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bid() {
        return a(com.baidu.tbadk.a.a.c.etU, "11_10_user_like_tab_a") || a(com.baidu.tbadk.a.a.c.etU, "11_10_user_like_tab_b");
    }
}
