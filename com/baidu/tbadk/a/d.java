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
    private static Boolean dTz = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.dTA)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.dTA.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean yv(String str) {
        e yu = c.baC().yu(str);
        return (yu == null || TextUtils.isEmpty(yu.dTA) || !yu.dTA.equalsIgnoreCase(str)) ? false : true;
    }

    public static Map<BdUniqueId, e> baD() {
        return c.baC().baD();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.baC().j(bdUniqueId);
    }

    public static boolean baI() {
        return k.C("70_3");
    }

    public static boolean baJ() {
        return a(h.dTB, "11_7_pb_b");
    }

    public static boolean baK() {
        return a(h.dTB, "11_7_pb_c");
    }

    public static boolean baL() {
        return a(h.dTB, "11_7_pb_d");
    }

    public static boolean baM() {
        return true;
    }

    public static boolean baN() {
        return a(com.baidu.tbadk.a.a.e.dTB, "11_7_index_b");
    }

    public static boolean baO() {
        return a(f.dTB, "11_8_hot_a");
    }

    public static boolean baP() {
        return a(f.dTB, "11_8_hot_b");
    }

    public static boolean baQ() {
        return a(i.dTB, "11_9_pb_gif_size_a");
    }

    public static boolean baR() {
        return a(com.baidu.tbadk.a.a.b.dTB, "11_9_backuser_a");
    }

    public static boolean baS() {
        return yv("11_9_post_thread_title_out_a");
    }

    public static boolean baT() {
        return baM();
    }

    public static boolean baU() {
        return false;
    }

    public static boolean baV() {
        return baJ() || baK();
    }

    public static boolean baW() {
        return true;
    }

    public static boolean baX() {
        return true;
    }

    public static boolean baY() {
        return a(com.baidu.tbadk.a.a.d.dTB, "11_9_frs_page_guide_a");
    }

    public static boolean baZ() {
        return bba() || bbb();
    }

    public static boolean bba() {
        return a(j.dTB, "11_9_discover_hot_card_slogan");
    }

    public static boolean bbb() {
        return a(j.dTB, "11_9_discover_hot_card_hot_text");
    }

    public static boolean bbc() {
        return false;
    }
}
