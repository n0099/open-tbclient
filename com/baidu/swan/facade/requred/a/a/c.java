package com.baidu.swan.facade.requred.a.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes3.dex */
public class c implements g {
    private final g bVq = new com.baidu.swan.game.ad.downloader.view.b();

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.bVq.getRealView();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void M(Object obj) {
        this.bVq.M(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        this.bVq.a(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ja(String str) {
        this.bVq.ja(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void aaP() {
        this.bVq.aaP();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void updateProgress(int i) {
        this.bVq.updateProgress(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2) {
        return this.bVq.a(context, aVar, aVar2);
    }
}
