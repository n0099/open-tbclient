package com.baidu.swan.facade.requred.a.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes20.dex */
public class c implements g {
    private final g bTm = new com.baidu.swan.game.ad.downloader.view.b();

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.bTm.getRealView();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void L(Object obj) {
        this.bTm.L(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        this.bTm.a(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void iG(String str) {
        this.bTm.iG(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void aag() {
        this.bTm.aag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void updateProgress(int i) {
        this.bTm.updateProgress(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2) {
        return this.bTm.a(context, aVar, aVar2);
    }
}
