package com.baidu.swan.apps.adaptation.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes3.dex */
public interface g<VIEW extends View> {
    void M(Object obj);

    g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2);

    void a(SwanAdDownloadState swanAdDownloadState);

    void aaP();

    VIEW getRealView();

    void ja(String str);

    void updateProgress(int i);
}
