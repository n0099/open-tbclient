package c.a.s0.v.g.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.v.g.h.c;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public interface a {
    public static final AtomicReference<a> a = new AtomicReference<>();

    void a(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c c();

    void d(String str);
}
