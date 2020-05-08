package com.baidu.swan.apps.adaptation.b;

import android.app.Activity;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.adaptation.b.d;
/* loaded from: classes11.dex */
public interface e<T extends d> extends TypedCallbackHandler {
    void D(Activity activity);

    T QD();

    String QE();

    String QF();

    void QG();

    void a(com.baidu.swan.apps.core.b bVar);

    void a(com.baidu.swan.apps.core.f.c cVar);

    void b(com.baidu.swan.apps.core.f.c cVar);

    void destroy();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();
}
