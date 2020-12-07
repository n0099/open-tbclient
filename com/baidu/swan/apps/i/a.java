package com.baidu.swan.apps.i;

import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
/* loaded from: classes25.dex */
public class a {
    public static String getSearchboxHostForHttps() {
        return BaseUrlManager.ONLINE_URL;
    }

    public static String anG() {
        return String.format("%s/smtapp/ad/similar", getSearchboxHostForHttps());
    }

    public static String anH() {
        return String.format("%s/smtapp/ad/auto", getSearchboxHostForHttps());
    }

    public static String anI() {
        return String.format("%s/searchbox?action=userx&type=attribute", getSearchboxHostForHttps());
    }

    public static String getGameServerHost() {
        return "https://gamecenter.baidu.com";
    }
}
