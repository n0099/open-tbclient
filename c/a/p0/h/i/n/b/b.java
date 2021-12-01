package c.a.p0.h.i.n.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {
    String a();

    boolean b(Context context, Intent intent, String str, String str2, String str3);

    String c();

    boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.p0.h.i.k.f.a aVar);

    String e();

    String getAppId();

    String getAppKey();

    String getSdkVersion();

    String k();

    String l(String str);

    String m();

    int n();

    String o(String str);

    int p();

    int q();

    Uri r(@NonNull Context context, @NonNull File file);

    String s();

    JSONObject t();

    boolean u(View view);
}
