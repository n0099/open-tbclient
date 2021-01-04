package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class f {
    public static boolean aVV() {
        return (TextUtils.isEmpty(aVY()) || TextUtils.isEmpty(aVZ()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.bcl().bcz().longValue() >= 604800000) ? false : true;
    }

    public static boolean aVW() {
        return (TextUtils.isEmpty(aWa()) || TextUtils.isEmpty(aWb()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.bcl().bcz().longValue() >= 604800000) ? false : true;
    }

    public static boolean aVX() {
        return com.baidu.swan.games.utils.c.bcl().bcC() && aVW();
    }

    public static String aVY() {
        return com.baidu.swan.games.utils.c.bcl().aVY();
    }

    public static String aVZ() {
        return com.baidu.swan.games.utils.c.bcl().bcx();
    }

    public static String aWa() {
        return com.baidu.swan.games.utils.c.bcl().aWa();
    }

    public static String aWb() {
        return com.baidu.swan.games.utils.c.bcl().bcy();
    }

    public static boolean aWc() {
        return com.baidu.swan.games.utils.c.bcl().bcA();
    }

    public static boolean aWd() {
        return aVW() && com.baidu.swan.games.utils.c.bcl().bcB();
    }
}
