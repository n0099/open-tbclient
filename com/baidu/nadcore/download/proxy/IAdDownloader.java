package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.ml0;
import com.baidu.tieba.qk0;
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

    int a(@NonNull qk0 qk0Var, @NonNull ml0 ml0Var);

    void b(@NonNull qk0 qk0Var);

    void c(@NonNull qk0 qk0Var);

    void d(@NonNull qk0 qk0Var, @NonNull ml0 ml0Var);
}
