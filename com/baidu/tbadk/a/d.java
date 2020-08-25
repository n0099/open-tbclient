package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.a.a.f;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {
    private static Boolean dRl = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.dRm)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.dRm.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<BdUniqueId, e> aZO() {
        return c.aZN().aZO();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.aZN().j(bdUniqueId);
    }

    public static boolean aZS() {
        return f.C("70_3");
    }

    public static boolean aZT() {
        return a(com.baidu.tbadk.a.a.e.dRn, "11_7_pb_a");
    }

    public static boolean aZU() {
        return a(com.baidu.tbadk.a.a.e.dRn, "11_7_pb_b");
    }

    public static boolean aZV() {
        return a(com.baidu.tbadk.a.a.e.dRn, "11_7_pb_c");
    }

    public static boolean aZW() {
        return a(com.baidu.tbadk.a.a.e.dRn, "11_7_pb_d");
    }

    public static boolean aZX() {
        return a(com.baidu.tbadk.a.a.e.dRn, "11_7_pb_e");
    }

    public static boolean aZY() {
        return a(com.baidu.tbadk.a.a.b.dRn, "11_7_index_a");
    }

    public static boolean aZZ() {
        return a(com.baidu.tbadk.a.a.b.dRn, "11_7_index_b");
    }

    public static boolean baa() {
        return a(com.baidu.tbadk.a.a.b.dRn, "11_7_index_e");
    }

    public static boolean bab() {
        return a(com.baidu.tbadk.a.a.c.dRn, "11_8_hot_a");
    }

    public static boolean bac() {
        return a(com.baidu.tbadk.a.a.c.dRn, "11_8_hot_b");
    }

    public static boolean bad() {
        return aZY();
    }

    public static boolean bae() {
        return baa();
    }

    public static boolean baf() {
        return aZT() || aZU() || aZW();
    }

    public static boolean bag() {
        return aZU() || aZV();
    }

    public static boolean bah() {
        return aZT() || aZU() || aZX();
    }

    public static boolean bai() {
        return aZT() || aZU() || aZV() || aZW() || aZX();
    }
}
