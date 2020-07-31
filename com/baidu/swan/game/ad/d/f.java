package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class f {
    public static boolean aAH() {
        return (TextUtils.isEmpty(aAK()) || TextUtils.isEmpty(aAL()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aGP().aHd().longValue() >= 604800000) ? false : true;
    }

    public static boolean aAI() {
        return (TextUtils.isEmpty(aAM()) || TextUtils.isEmpty(aAN()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aGP().aHd().longValue() >= 604800000) ? false : true;
    }

    public static boolean aAJ() {
        return com.baidu.swan.games.utils.c.aGP().aHg() && aAI();
    }

    public static String aAK() {
        return com.baidu.swan.games.utils.c.aGP().aAK();
    }

    public static String aAL() {
        return com.baidu.swan.games.utils.c.aGP().aHb();
    }

    public static String aAM() {
        return com.baidu.swan.games.utils.c.aGP().aAM();
    }

    public static String aAN() {
        return com.baidu.swan.games.utils.c.aGP().aHc();
    }

    public static boolean aAO() {
        return com.baidu.swan.games.utils.c.aGP().aHe();
    }

    public static boolean aAP() {
        return aAI() && com.baidu.swan.games.utils.c.aGP().aHf();
    }
}
