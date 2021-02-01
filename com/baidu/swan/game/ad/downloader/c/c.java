package com.baidu.swan.game.ad.downloader.c;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.core.a;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes5.dex */
public interface c {
    void a(@NonNull String str, @NonNull Uri uri, @NonNull a.AbstractC0503a<Boolean> abstractC0503a);

    void destroy();

    void e(DownloadInfo downloadInfo);

    void g(DownloadInfo downloadInfo);

    void h(DownloadInfo downloadInfo);

    void i(DownloadInfo downloadInfo);

    DownloadInfo va(String str);
}
