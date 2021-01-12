package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class f {
    public static boolean aSc() {
        return (TextUtils.isEmpty(aSf()) || TextUtils.isEmpty(aSg()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aYs().aYG().longValue() >= 604800000) ? false : true;
    }

    public static boolean aSd() {
        return (TextUtils.isEmpty(aSh()) || TextUtils.isEmpty(aSi()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aYs().aYG().longValue() >= 604800000) ? false : true;
    }

    public static boolean aSe() {
        return com.baidu.swan.games.utils.c.aYs().aYJ() && aSd();
    }

    public static String aSf() {
        return com.baidu.swan.games.utils.c.aYs().aSf();
    }

    public static String aSg() {
        return com.baidu.swan.games.utils.c.aYs().aYE();
    }

    public static String aSh() {
        return com.baidu.swan.games.utils.c.aYs().aSh();
    }

    public static String aSi() {
        return com.baidu.swan.games.utils.c.aYs().aYF();
    }

    public static boolean aSj() {
        return com.baidu.swan.games.utils.c.aYs().aYH();
    }

    public static boolean aSk() {
        return aSd() && com.baidu.swan.games.utils.c.aYs().aYI();
    }
}
