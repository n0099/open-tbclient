package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static Boolean dIe = null;

    public static boolean a(BdUniqueId bdUniqueId, String... strArr) {
        return a(j(bdUniqueId), strArr);
    }

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.dIf)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.dIf.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<BdUniqueId, e> aRx() {
        return c.aRw().aRx();
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.aRw().j(bdUniqueId);
    }

    public static boolean aRB() {
        return com.baidu.tbadk.a.a.e.B("70_3");
    }

    public static boolean aRC() {
        return com.baidu.tbadk.a.a.e.B("71_2");
    }

    public static boolean aRD() {
        return a(com.baidu.tbadk.a.a.d.dIg, "11_7_pb_a");
    }

    public static boolean aRE() {
        return a(com.baidu.tbadk.a.a.d.dIg, "11_7_pb_b");
    }

    public static boolean aRF() {
        return a(com.baidu.tbadk.a.a.d.dIg, "11_7_pb_c");
    }

    public static boolean aRG() {
        return a(com.baidu.tbadk.a.a.d.dIg, "11_7_pb_d");
    }

    public static boolean aRH() {
        return a(com.baidu.tbadk.a.a.d.dIg, "11_7_pb_e");
    }

    public static boolean aRI() {
        return a(com.baidu.tbadk.a.a.b.dIg, "11_7_index_a");
    }

    public static boolean aRJ() {
        return a(com.baidu.tbadk.a.a.b.dIg, "11_7_index_b");
    }

    public static boolean aRK() {
        return a(com.baidu.tbadk.a.a.b.dIg, "11_7_index_e");
    }

    public static boolean aRL() {
        return aRI();
    }

    public static boolean aRM() {
        return aRK();
    }

    public static boolean aRN() {
        if (dIe == null) {
            dIe = Boolean.valueOf(aRC());
        }
        return dIe.booleanValue();
    }

    public static boolean aRO() {
        return aRD() || aRE() || aRG();
    }

    public static boolean aRP() {
        return aRE() || aRF();
    }

    public static boolean aRQ() {
        return aRD() || aRE() || aRH();
    }

    public static boolean aRR() {
        return aRD() || aRE() || aRF() || aRG() || aRH();
    }
}
