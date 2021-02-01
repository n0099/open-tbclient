package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class f {
    public static boolean aSo() {
        return (TextUtils.isEmpty(aSr()) || TextUtils.isEmpty(aSs()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aYE().aYS().longValue() >= 604800000) ? false : true;
    }

    public static boolean aSp() {
        return (TextUtils.isEmpty(aSt()) || TextUtils.isEmpty(aSu()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aYE().aYS().longValue() >= 604800000) ? false : true;
    }

    public static boolean aSq() {
        return com.baidu.swan.games.utils.c.aYE().aYV() && aSp();
    }

    public static String aSr() {
        return com.baidu.swan.games.utils.c.aYE().aSr();
    }

    public static String aSs() {
        return com.baidu.swan.games.utils.c.aYE().aYQ();
    }

    public static String aSt() {
        return com.baidu.swan.games.utils.c.aYE().aSt();
    }

    public static String aSu() {
        return com.baidu.swan.games.utils.c.aYE().aYR();
    }

    public static boolean aSv() {
        return com.baidu.swan.games.utils.c.aYE().aYT();
    }

    public static boolean aSw() {
        return aSp() && com.baidu.swan.games.utils.c.aYE().aYU();
    }
}
