package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.uk0;
import com.baidu.tieba.yj0;
/* loaded from: classes2.dex */
public interface IAdDownloader {

    /* loaded from: classes2.dex */
    public enum STATE {
        NOT_START,
        DOWNLOADING,
        DOWNLOAD_PAUSED,
        DOWNLOADED,
        DOWNLOAD_FAILED
    }

    int a(@NonNull yj0 yj0Var, @NonNull uk0 uk0Var);

    void b(@NonNull yj0 yj0Var);

    void c(@NonNull yj0 yj0Var);

    void d(@NonNull yj0 yj0Var, @NonNull uk0 uk0Var);
}
