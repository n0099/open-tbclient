package com.baidu.swan.apps.adaptation.b;

import android.app.Activity;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.adaptation.b.d;
/* loaded from: classes11.dex */
public interface e<T extends d> extends TypedCallbackHandler {
    T Un();

    String Uo();

    String Up();

    void Uq();

    void a(com.baidu.swan.apps.core.b bVar);

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
