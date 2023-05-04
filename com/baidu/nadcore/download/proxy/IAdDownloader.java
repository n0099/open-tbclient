package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.ak0;
import com.baidu.tieba.wk0;
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

    int a(@NonNull ak0 ak0Var, @NonNull wk0 wk0Var);

    void b(@NonNull ak0 ak0Var);

    void c(@NonNull ak0 ak0Var);

    void d(@NonNull ak0 ak0Var, @NonNull wk0 wk0Var);
}
