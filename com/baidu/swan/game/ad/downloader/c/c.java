package com.baidu.swan.game.ad.downloader.c;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.core.a;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes14.dex */
public interface c {
    void a(@NonNull String str, @NonNull Uri uri, @NonNull a.AbstractC0508a<Boolean> abstractC0508a);

    void destroy();

    void e(DownloadInfo downloadInfo);

    void g(DownloadInfo downloadInfo);

    void h(DownloadInfo downloadInfo);

    void i(DownloadInfo downloadInfo);

    DownloadInfo vd(String str);
}
