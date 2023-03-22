package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.sk0;
import com.baidu.tieba.wj0;
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

    int a(@NonNull wj0 wj0Var, @NonNull sk0 sk0Var);

    void b(@NonNull wj0 wj0Var);

    void c(@NonNull wj0 wj0Var);

    void d(@NonNull wj0 wj0Var, @NonNull sk0 sk0Var);
}
