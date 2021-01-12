package com.baidu.swan.facade.requred.a.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes6.dex */
public class c implements g {
    private final g cBp = new com.baidu.swan.game.ad.downloader.view.b();

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.cBp.getRealView();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.cBp.P(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        this.cBp.a(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void jD(String str) {
        this.cBp.jD(str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ahM() {
        this.cBp.ahM();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void updateProgress(int i) {
        this.cBp.updateProgress(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2) {
        return this.cBp.a(context, aVar, aVar2);
    }
}
