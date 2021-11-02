package b.a.p0.a.p.e;

import android.app.Activity;
import androidx.annotation.UiThread;
import b.a.p0.a.p.e.c;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
/* loaded from: classes.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    @UiThread
    void N();

    void T(b.a.p0.a.h0.j.c cVar);

    String a();

    String a0();

    String b();

    void c(b.a.p0.a.h0.b bVar);

    void d0();

    void destroy();

    void e(Activity activity);

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void q();

    T s();

    void t(b.a.p0.a.h0.j.c cVar);
}
