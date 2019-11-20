package com.baidu.swan.apps.b.c;

import android.app.Activity;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.b.c.d;
/* loaded from: classes2.dex */
public interface e<T extends d> extends TypedCallbackHandler {
    T Cs();

    String Ct();

    String Cu();

    void a(com.baidu.swan.apps.core.c cVar);

    void a(com.baidu.swan.apps.core.f.b bVar);

    void b(com.baidu.swan.apps.core.f.b bVar);

    void destroy();

    String getUserAgent();

    void loadUrl(String str);

    void onPause();

    void onResume();

    void x(Activity activity);
}
