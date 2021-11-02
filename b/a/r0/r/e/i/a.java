package b.a.r0.r.e.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.r0.r.e.h.c;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f22996a = new AtomicReference<>();

    void a(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c c();

    void d(String str);
}
