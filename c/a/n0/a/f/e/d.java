package c.a.n0.a.f.e;

import android.app.Activity;
import androidx.annotation.UiThread;
import c.a.n0.a.f.e.c;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
/* loaded from: classes.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    SwanAppWebViewManager.d J();

    @UiThread
    void Q();

    void X(c.a.n0.a.x.j.c cVar);

    String a();

    String c();

    void d(c.a.n0.a.x.b bVar);

    void destroy();

    String e0();

    void f(Activity activity);

    void h0();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void s();

    T u();

    void v(c.a.n0.a.x.j.c cVar);
}
