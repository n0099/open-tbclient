package com.baidu.swan.apps.h;
/* loaded from: classes11.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return "https://mbd.baidu.com";
    }

    public static String La() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String Lb() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String Lc() {
        return String.format("%s/ma/ai", getSearchboxHostForHttps());
    }

    public static String Ld() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }
}
