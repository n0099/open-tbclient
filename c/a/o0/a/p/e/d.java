package c.a.o0.a.p.e;

import android.app.Activity;
import androidx.annotation.UiThread;
import c.a.o0.a.p.e.c;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
/* loaded from: classes.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    @UiThread
    void O();

    void U(c.a.o0.a.h0.j.c cVar);

    String a();

    String b0();

    String c();

    void d(c.a.o0.a.h0.b bVar);

    void destroy();

    void e0();

    void f(Activity activity);

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void r();

    T t();

    void u(c.a.o0.a.h0.j.c cVar);
}
