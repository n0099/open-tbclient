package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.em0;
import com.baidu.tieba.il0;
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

    int a(@NonNull il0 il0Var, @NonNull em0 em0Var);

    void b(@NonNull il0 il0Var);

    void c(@NonNull il0 il0Var);

    void d(@NonNull il0 il0Var, @NonNull em0 em0Var);
}
