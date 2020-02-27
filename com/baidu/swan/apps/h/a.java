package com.baidu.swan.apps.h;
/* loaded from: classes11.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String KV() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String KW() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String KX() {
        return String.format("%s/ma/ai", getSearchboxHostForHttps());
    }

    public static String KY() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }
}
