package com.baidu.swan.apps.i;
/* loaded from: classes10.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String agM() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String agN() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String agO() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
