package c.a.p0.p;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes2.dex */
public interface a {
    String a();

    CookieManager f();

    int g();

    Context getAppContext();

    int getReadTimeout();

    boolean h();

    boolean i();

    boolean isDebug();

    void j(String str, HttpRequestBuilder httpRequestBuilder);

    int k();

    List<Interceptor> l();

    int m();
}
