package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.cn0;
import com.baidu.tieba.gm0;
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

    int a(@NonNull gm0 gm0Var, @NonNull cn0 cn0Var);

    void b(@NonNull gm0 gm0Var);

    void c(@NonNull gm0 gm0Var);

    void d(@NonNull gm0 gm0Var, @NonNull cn0 cn0Var);
}
