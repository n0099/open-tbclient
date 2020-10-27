package com.baidu.swan.apps.i;
/* loaded from: classes10.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String aiG() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String aiH() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String aiI() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
