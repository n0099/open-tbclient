package com.baidu.swan.apps.h;
/* loaded from: classes10.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String IG() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String IH() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String II() {
        return String.format("%s/ma/ai", getSearchboxHostForHttps());
    }

    public static String IJ() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }
}
