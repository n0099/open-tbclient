package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private static Boolean dxb = null;

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.dxc)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.dxc.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.aMf().j(bdUniqueId);
    }

    public static boolean aMi() {
        return com.baidu.tbadk.a.a.c.B("70_2");
    }

    public static boolean aMj() {
        return com.baidu.tbadk.a.a.c.B("70_3");
    }

    public static boolean aMk() {
        return com.baidu.tbadk.a.a.c.B("70_4");
    }

    public static boolean aMl() {
        return com.baidu.tbadk.a.a.c.B("70_6");
    }

    public static boolean aMm() {
        return com.baidu.tbadk.a.a.c.B("71_2");
    }

    public static boolean aMn() {
        return aMk() || aMl();
    }

    public static boolean aMo() {
        return aMk() || aMl();
    }

    public static boolean aMp() {
        return aMk() || aMl();
    }

    public static boolean aMq() {
        return aMi() || aMl();
    }

    public static boolean aMr() {
        return aMi() || aMl();
    }

    public static boolean aMs() {
        if (dxb == null) {
            dxb = Boolean.valueOf(aMm());
        }
        return dxb.booleanValue();
    }

    public static boolean aMt() {
        return aMk() || aMl();
    }
}
