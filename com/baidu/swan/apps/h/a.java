package com.baidu.swan.apps.h;
/* loaded from: classes7.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String Xl() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String Xm() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String Xn() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
