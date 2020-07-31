package com.baidu.swan.apps.adaptation.a;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
/* loaded from: classes7.dex */
public interface g<VIEW extends View> {
    void K(Object obj);

    void Tk();

    g a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2);

    void a(SwanAdDownloadState swanAdDownloadState);

    VIEW getRealView();

    void hl(String str);
}
