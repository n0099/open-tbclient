package com.baidu.swan.apps.i;
/* loaded from: classes7.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String aky() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String akz() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String akA() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
