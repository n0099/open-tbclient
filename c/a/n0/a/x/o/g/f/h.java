package c.a.n0.a.x.o.g.f;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
/* loaded from: classes.dex */
public interface h {

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        WebResourceResponse b(String str, Map<String, String> map, boolean z);

        boolean c();

        String d();

        String getMimeType();

        Map<String, String> getRequestHeaders();
    }

    WebResourceResponse a(@NonNull a aVar);
}
