package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.dm0;
import com.baidu.tieba.zm0;
/* loaded from: classes3.dex */
public interface IAdDownloader {

    /* loaded from: classes3.dex */
    public enum STATE {
        NOT_START,
        DOWNLOADING,
        DOWNLOAD_PAUSED,
        DOWNLOADED,
        DOWNLOAD_FAILED
    }

    int a(@NonNull dm0 dm0Var, @NonNull zm0 zm0Var);

    void b(@NonNull dm0 dm0Var);

    void c(@NonNull dm0 dm0Var);

    void d(@NonNull dm0 dm0Var, @NonNull zm0 zm0Var);
}
