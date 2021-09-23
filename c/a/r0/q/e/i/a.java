package c.a.r0.q.e.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.q.e.h.c;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f24150a = new AtomicReference<>();

    void a(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c c();

    void d(String str);
}
