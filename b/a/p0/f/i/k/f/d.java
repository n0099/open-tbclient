package b.a.p0.f.i.k.f;

import android.net.Uri;
import androidx.annotation.NonNull;
import b.a.p0.f.i.k.d.a;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes.dex */
public interface d {
    void a(DownloadInfo downloadInfo);

    void b(DownloadInfo downloadInfo);

    void c(DownloadInfo downloadInfo);

    void d(DownloadInfo downloadInfo);

    void destroy();

    void f(@NonNull String str, @NonNull Uri uri, @NonNull a.d<Boolean> dVar);

    DownloadInfo g(String str);
}
