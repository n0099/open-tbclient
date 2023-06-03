package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.vm0;
import com.baidu.tieba.zl0;
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

    int a(@NonNull zl0 zl0Var, @NonNull vm0 vm0Var);

    void b(@NonNull zl0 zl0Var);

    void c(@NonNull zl0 zl0Var);

    void d(@NonNull zl0 zl0Var, @NonNull vm0 vm0Var);
}
