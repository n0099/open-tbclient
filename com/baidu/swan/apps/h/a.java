package com.baidu.swan.apps.h;
/* loaded from: classes11.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String SO() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String SP() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String SQ() {
        return String.format("%s/ma/ai", getSearchboxHostForHttps());
    }

    public static String SR() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }
}
