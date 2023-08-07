package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.am0;
import com.baidu.tieba.el0;
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

    int a(@NonNull el0 el0Var, @NonNull am0 am0Var);

    void b(@NonNull el0 el0Var);

    void c(@NonNull el0 el0Var);

    void d(@NonNull el0 el0Var, @NonNull am0 am0Var);
}
