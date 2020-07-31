package com.baidu.swan.apps.adaptation.b;

import android.app.Activity;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.adaptation.b.d;
/* loaded from: classes7.dex */
public interface e<T extends d> extends TypedCallbackHandler {
    T UP();

    String UQ();

    String UR();

    void US();

    void a(com.baidu.swan.apps.core.e eVar);

    void a(com.baidu.swan.apps.core.f.c cVar);

    void attachActivity(Activity activity);

    void b(com.baidu.swan.apps.core.f.c cVar);

    void destroy();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();
}
