package com.baidu.swan.apps.h;
/* loaded from: classes11.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String Vy() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String Vz() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String VA() {
        return String.format("%s/ma/ai", getSearchboxHostForHttps());
    }

    public static String VB() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
