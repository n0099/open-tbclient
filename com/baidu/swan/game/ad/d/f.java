package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes19.dex */
public class f {
    public static boolean aJq() {
        return (TextUtils.isEmpty(aJt()) || TextUtils.isEmpty(aJu()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aPG().aPU().longValue() >= 604800000) ? false : true;
    }

    public static boolean aJr() {
        return (TextUtils.isEmpty(aJv()) || TextUtils.isEmpty(aJw()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aPG().aPU().longValue() >= 604800000) ? false : true;
    }

    public static boolean aJs() {
        return com.baidu.swan.games.utils.c.aPG().aPX() && aJr();
    }

    public static String aJt() {
        return com.baidu.swan.games.utils.c.aPG().aJt();
    }

    public static String aJu() {
        return com.baidu.swan.games.utils.c.aPG().aPS();
    }

    public static String aJv() {
        return com.baidu.swan.games.utils.c.aPG().aJv();
    }

    public static String aJw() {
        return com.baidu.swan.games.utils.c.aPG().aPT();
    }

    public static boolean aJx() {
        return com.baidu.swan.games.utils.c.aPG().aPV();
    }

    public static boolean aJy() {
        return aJr() && com.baidu.swan.games.utils.c.aPG().aPW();
    }
}
