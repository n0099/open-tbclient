package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class f {
    public static boolean aSr() {
        return (TextUtils.isEmpty(aSu()) || TextUtils.isEmpty(aSv()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aYH().aYV().longValue() >= 604800000) ? false : true;
    }

    public static boolean aSs() {
        return (TextUtils.isEmpty(aSw()) || TextUtils.isEmpty(aSx()) || System.currentTimeMillis() - com.baidu.swan.games.utils.c.aYH().aYV().longValue() >= 604800000) ? false : true;
    }

    public static boolean aSt() {
        return com.baidu.swan.games.utils.c.aYH().aYY() && aSs();
    }

    public static String aSu() {
        return com.baidu.swan.games.utils.c.aYH().aSu();
    }

    public static String aSv() {
        return com.baidu.swan.games.utils.c.aYH().aYT();
    }

    public static String aSw() {
        return com.baidu.swan.games.utils.c.aYH().aSw();
    }

    public static String aSx() {
        return com.baidu.swan.games.utils.c.aYH().aYU();
    }

    public static boolean aSy() {
        return com.baidu.swan.games.utils.c.aYH().aYW();
    }

    public static boolean aSz() {
        return aSs() && com.baidu.swan.games.utils.c.aYH().aYX();
    }
}
