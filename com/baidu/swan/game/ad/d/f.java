package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class f {
    public static boolean aTB() {
        return (TextUtils.isEmpty(aTE()) || TextUtils.isEmpty(aTF()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aZR().baf().longValue() >= 604800000) ? false : true;
    }

    public static boolean aTC() {
        return (TextUtils.isEmpty(aTG()) || TextUtils.isEmpty(aTH()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aZR().baf().longValue() >= 604800000) ? false : true;
    }

    public static boolean aTD() {
        return com.baidu.swan.games.utils.c.aZR().bai() && aTC();
    }

    public static String aTE() {
        return com.baidu.swan.games.utils.c.aZR().aTE();
    }

    public static String aTF() {
        return com.baidu.swan.games.utils.c.aZR().bad();
    }

    public static String aTG() {
        return com.baidu.swan.games.utils.c.aZR().aTG();
    }

    public static String aTH() {
        return com.baidu.swan.games.utils.c.aZR().bae();
    }

    public static boolean aTI() {
        return com.baidu.swan.games.utils.c.aZR().bag();
    }

    public static boolean aTJ() {
        return aTC() && com.baidu.swan.games.utils.c.aZR().bah();
    }
}
