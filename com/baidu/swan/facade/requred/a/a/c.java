package com.baidu.swan.facade.requred.a.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes16.dex */
public class c implements g {
    private final g cwd = new com.baidu.swan.game.ad.downloader.view.b();

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.cwd.getRealView();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.cwd.P(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        this.cwd.a(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ku(String str) {
        this.cwd.ku(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ahV() {
        this.cwd.ahV();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void updateProgress(int i) {
        this.cwd.updateProgress(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2) {
        return this.cwd.a(context, aVar, aVar2);
    }
}
