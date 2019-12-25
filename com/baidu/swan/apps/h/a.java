package com.baidu.swan.apps.h;
/* loaded from: classes9.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String Ik() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String Il() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String Im() {
        return String.format("%s/ma/ai", getSearchboxHostForHttps());
    }

    public static String In() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }
}
