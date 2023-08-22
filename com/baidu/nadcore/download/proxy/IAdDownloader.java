package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.dm0;
import com.baidu.tieba.hl0;
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

    int a(@NonNull hl0 hl0Var, @NonNull dm0 dm0Var);

    void b(@NonNull hl0 hl0Var);

    void c(@NonNull hl0 hl0Var);

    void d(@NonNull hl0 hl0Var, @NonNull dm0 dm0Var);
}
