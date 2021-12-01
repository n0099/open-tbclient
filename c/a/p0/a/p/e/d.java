package c.a.p0.a.p.e;

import android.app.Activity;
import androidx.annotation.UiThread;
import c.a.p0.a.p.e.c;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
/* loaded from: classes.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    SwanAppWebViewManager.d I();

    @UiThread
    void P();

    void W(c.a.p0.a.h0.j.c cVar);

    String a();

    String c();

    void d(c.a.p0.a.h0.b bVar);

    String d0();

    void destroy();

    void f(Activity activity);

    void g0();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void r();

    T t();

    void u(c.a.p0.a.h0.j.c cVar);
}
