package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class f {
    public static boolean aVW() {
        return (TextUtils.isEmpty(aVZ()) || TextUtils.isEmpty(aWa()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.bcm().bcA().longValue() >= 604800000) ? false : true;
    }

    public static boolean aVX() {
        return (TextUtils.isEmpty(aWb()) || TextUtils.isEmpty(aWc()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.bcm().bcA().longValue() >= 604800000) ? false : true;
    }

    public static boolean aVY() {
        return com.baidu.swan.games.utils.c.bcm().bcD() && aVX();
    }

    public static String aVZ() {
        return com.baidu.swan.games.utils.c.bcm().aVZ();
    }

    public static String aWa() {
        return com.baidu.swan.games.utils.c.bcm().bcy();
    }

    public static String aWb() {
        return com.baidu.swan.games.utils.c.bcm().aWb();
    }

    public static String aWc() {
        return com.baidu.swan.games.utils.c.bcm().bcz();
    }

    public static boolean aWd() {
        return com.baidu.swan.games.utils.c.bcm().bcB();
    }

    public static boolean aWe() {
        return aVX() && com.baidu.swan.games.utils.c.bcm().bcC();
    }
}
