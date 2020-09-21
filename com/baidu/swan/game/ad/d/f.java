package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class f {
    public static boolean aKb() {
        return (TextUtils.isEmpty(aKe()) || TextUtils.isEmpty(aKf()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aQr().aQF().longValue() >= 604800000) ? false : true;
    }

    public static boolean aKc() {
        return (TextUtils.isEmpty(aKg()) || TextUtils.isEmpty(aKh()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aQr().aQF().longValue() >= 604800000) ? false : true;
    }

    public static boolean aKd() {
        return com.baidu.swan.games.utils.c.aQr().aQI() && aKc();
    }

    public static String aKe() {
        return com.baidu.swan.games.utils.c.aQr().aKe();
    }

    public static String aKf() {
        return com.baidu.swan.games.utils.c.aQr().aQD();
    }

    public static String aKg() {
        return com.baidu.swan.games.utils.c.aQr().aKg();
    }

    public static String aKh() {
        return com.baidu.swan.games.utils.c.aQr().aQE();
    }

    public static boolean aKi() {
        return com.baidu.swan.games.utils.c.aQr().aQG();
    }

    public static boolean aKj() {
        return aKc() && com.baidu.swan.games.utils.c.aQr().aQH();
    }
}
