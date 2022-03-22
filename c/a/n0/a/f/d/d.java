package c.a.n0.a.f.d;

import androidx.annotation.NonNull;
import c.a.n0.q.i.a;
import com.baidu.searchbox.http.callback.ResponseCallback;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface d {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, a.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull c.a.n0.a.t1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, c.a.n0.a.p2.g1.c<String> cVar);
}
