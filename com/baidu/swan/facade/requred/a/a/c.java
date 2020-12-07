package com.baidu.swan.facade.requred.a.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes8.dex */
public class c implements g {
    private final g cBl = new com.baidu.swan.game.ad.downloader.view.b();

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.cBl.getRealView();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.cBl.P(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        this.cBl.a(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void kV(String str) {
        this.cBl.kV(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void akv() {
        this.cBl.akv();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void updateProgress(int i) {
        this.cBl.updateProgress(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2) {
        return this.cBl.a(context, aVar, aVar2);
    }
}
