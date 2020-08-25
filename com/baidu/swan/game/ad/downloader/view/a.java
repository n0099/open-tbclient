package com.baidu.swan.game.ad.downloader.view;

import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes19.dex */
public class a {
    public String name;
    public String url;
    public SwanAdDownloadState dkj = SwanAdDownloadState.NOT_START;
    public int percent = Integer.parseInt("0");

    private a() {
    }

    public static a cB(String str, String str2) {
        a aVar = new a();
        aVar.url = str;
        aVar.name = str2;
        return aVar;
    }
}
