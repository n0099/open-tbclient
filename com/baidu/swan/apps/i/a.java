package com.baidu.swan.apps.i;
/* loaded from: classes3.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String aeb() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String aec() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String aed() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
