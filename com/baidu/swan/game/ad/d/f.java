package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class f {
    public static boolean aRe() {
        return (TextUtils.isEmpty(aRh()) || TextUtils.isEmpty(aRi()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aXu().aXI().longValue() >= 604800000) ? false : true;
    }

    public static boolean aRf() {
        return (TextUtils.isEmpty(aRj()) || TextUtils.isEmpty(aRk()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aXu().aXI().longValue() >= 604800000) ? false : true;
    }

    public static boolean aRg() {
        return com.baidu.swan.games.utils.c.aXu().aXL() && aRf();
    }

    public static String aRh() {
        return com.baidu.swan.games.utils.c.aXu().aRh();
    }

    public static String aRi() {
        return com.baidu.swan.games.utils.c.aXu().aXG();
    }

    public static String aRj() {
        return com.baidu.swan.games.utils.c.aXu().aRj();
    }

    public static String aRk() {
        return com.baidu.swan.games.utils.c.aXu().aXH();
    }

    public static boolean aRl() {
        return com.baidu.swan.games.utils.c.aXu().aXJ();
    }

    public static boolean aRm() {
        return aRf() && com.baidu.swan.games.utils.c.aXu().aXK();
    }
}
