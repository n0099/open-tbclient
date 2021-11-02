package b.a.p0.a.p.d;

import androidx.annotation.NonNull;
import b.a.p0.n.i.a;
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

    boolean i(@NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, b.a.p0.a.v2.e1.b<String> bVar);
}
