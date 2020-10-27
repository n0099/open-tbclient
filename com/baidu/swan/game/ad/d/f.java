package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class f {
    public static boolean aOE() {
        return (TextUtils.isEmpty(aOH()) || TextUtils.isEmpty(aOI()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aUU().aVi().longValue() >= 604800000) ? false : true;
    }

    public static boolean aOF() {
        return (TextUtils.isEmpty(aOJ()) || TextUtils.isEmpty(aOK()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aUU().aVi().longValue() >= 604800000) ? false : true;
    }

    public static boolean aOG() {
        return com.baidu.swan.games.utils.c.aUU().aVl() && aOF();
    }

    public static String aOH() {
        return com.baidu.swan.games.utils.c.aUU().aOH();
    }

    public static String aOI() {
        return com.baidu.swan.games.utils.c.aUU().aVg();
    }

    public static String aOJ() {
        return com.baidu.swan.games.utils.c.aUU().aOJ();
    }

    public static String aOK() {
        return com.baidu.swan.games.utils.c.aUU().aVh();
    }

    public static boolean aOL() {
        return com.baidu.swan.games.utils.c.aUU().aVj();
    }

    public static boolean aOM() {
        return aOF() && com.baidu.swan.games.utils.c.aUU().aVk();
    }
}
