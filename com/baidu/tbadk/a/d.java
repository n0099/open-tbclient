package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private static Boolean dCh = null;

    public static boolean a(e eVar, String... strArr) {
        if (eVar == null || TextUtils.isEmpty(eVar.dCi)) {
            return false;
        }
        for (String str : strArr) {
            if (eVar.dCi.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static e j(BdUniqueId bdUniqueId) {
        return c.aNI().j(bdUniqueId);
    }

    public static boolean aNL() {
        return com.baidu.tbadk.a.a.c.A("70_2");
    }

    public static boolean aNM() {
        return com.baidu.tbadk.a.a.c.A("70_3");
    }

    public static boolean aNN() {
        return com.baidu.tbadk.a.a.c.A("70_4");
    }

    public static boolean aNO() {
        return com.baidu.tbadk.a.a.c.A("70_6");
    }

    public static boolean aNP() {
        return com.baidu.tbadk.a.a.c.A("71_2");
    }

    public static boolean aNQ() {
        return aNN() || aNO();
    }

    public static boolean aNR() {
        return aNN() || aNO();
    }

    public static boolean aNS() {
        return aNN() || aNO();
    }

    public static boolean aNT() {
        return aNL() || aNO();
    }

    public static boolean aNU() {
        return aNL() || aNO();
    }

    public static boolean aNV() {
        if (dCh == null) {
            dCh = Boolean.valueOf(aNP());
        }
        return dCh.booleanValue();
    }

    public static boolean aNW() {
        return aNN() || aNO();
    }
}
