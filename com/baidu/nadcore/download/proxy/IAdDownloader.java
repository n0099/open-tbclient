package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.tk0;
import com.baidu.tieba.xj0;
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

    int a(@NonNull xj0 xj0Var, @NonNull tk0 tk0Var);

    void b(@NonNull xj0 xj0Var);

    void c(@NonNull xj0 xj0Var);

    void d(@NonNull xj0 xj0Var, @NonNull tk0 tk0Var);
}
