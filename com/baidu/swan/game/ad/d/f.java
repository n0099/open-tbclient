package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class f {
    public static boolean aMK() {
        return (TextUtils.isEmpty(aMN()) || TextUtils.isEmpty(aMO()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aTa().aTo().longValue() >= 604800000) ? false : true;
    }

    public static boolean aML() {
        return (TextUtils.isEmpty(aMP()) || TextUtils.isEmpty(aMQ()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aTa().aTo().longValue() >= 604800000) ? false : true;
    }

    public static boolean aMM() {
        return com.baidu.swan.games.utils.c.aTa().aTr() && aML();
    }

    public static String aMN() {
        return com.baidu.swan.games.utils.c.aTa().aMN();
    }

    public static String aMO() {
        return com.baidu.swan.games.utils.c.aTa().aTm();
    }

    public static String aMP() {
        return com.baidu.swan.games.utils.c.aTa().aMP();
    }

    public static String aMQ() {
        return com.baidu.swan.games.utils.c.aTa().aTn();
    }

    public static boolean aMR() {
        return com.baidu.swan.games.utils.c.aTa().aTp();
    }

    public static boolean aMS() {
        return aML() && com.baidu.swan.games.utils.c.aTa().aTq();
    }
}
