package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class f {
    public static boolean aQw() {
        return (TextUtils.isEmpty(aQz()) || TextUtils.isEmpty(aQA()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aWM().aXa().longValue() >= 604800000) ? false : true;
    }

    public static boolean aQx() {
        return (TextUtils.isEmpty(aQB()) || TextUtils.isEmpty(aQC()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aWM().aXa().longValue() >= 604800000) ? false : true;
    }

    public static boolean aQy() {
        return com.baidu.swan.games.utils.c.aWM().aXd() && aQx();
    }

    public static String aQz() {
        return com.baidu.swan.games.utils.c.aWM().aQz();
    }

    public static String aQA() {
        return com.baidu.swan.games.utils.c.aWM().aWY();
    }

    public static String aQB() {
        return com.baidu.swan.games.utils.c.aWM().aQB();
    }

    public static String aQC() {
        return com.baidu.swan.games.utils.c.aWM().aWZ();
    }

    public static boolean aQD() {
        return com.baidu.swan.games.utils.c.aWM().aXb();
    }

    public static boolean aQE() {
        return aQx() && com.baidu.swan.games.utils.c.aWM().aXc();
    }
}
