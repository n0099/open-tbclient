package c.a.p0.h.a.c.f;

import android.net.Uri;
import androidx.annotation.NonNull;
import c.a.p0.h.a.c.d.a;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public interface d {
    void a(DownloadInfo downloadInfo);

    void b(DownloadInfo downloadInfo);

    void c(DownloadInfo downloadInfo);

    void d(DownloadInfo downloadInfo);

    void destroy();

    void f(@NonNull String str, @NonNull Uri uri, @NonNull a.d<Boolean> dVar);

    DownloadInfo g(String str);
}
