package com.baidu.swan.game.ad.downloader.c;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.core.a;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes19.dex */
public interface c {
    void a(@NonNull String str, @NonNull Uri uri, @NonNull a.AbstractC0482a<Boolean> abstractC0482a);

    void destroy();

    void e(DownloadInfo downloadInfo);

    void g(DownloadInfo downloadInfo);

    void h(DownloadInfo downloadInfo);

    void i(DownloadInfo downloadInfo);

    DownloadInfo tE(String str);
}
