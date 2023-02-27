package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.cm0;
import com.baidu.tieba.gl0;
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

    int a(@NonNull gl0 gl0Var, @NonNull cm0 cm0Var);

    void b(@NonNull gl0 gl0Var);

    void c(@NonNull gl0 gl0Var);

    void d(@NonNull gl0 gl0Var, @NonNull cm0 cm0Var);
}
