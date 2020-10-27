package com.baidu.swan.apps.adaptation.b;

import android.app.Activity;
import android.support.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.adaptation.b.d;
/* loaded from: classes10.dex */
public interface e<T extends d> extends TypedCallbackHandler {
    void a(com.baidu.swan.apps.core.f.c cVar);

    void a(com.baidu.swan.apps.core.g gVar);

    T agh();

    String agi();

    String agj();

    void agk();

    @UiThread
    void agl();

    @UiThread
    void agm();

    void attachActivity(Activity activity);

    void b(com.baidu.swan.apps.core.f.c cVar);

    void destroy();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();
}
