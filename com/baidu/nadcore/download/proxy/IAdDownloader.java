package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.ah0;
import com.baidu.tieba.eg0;
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

    int a(@NonNull eg0 eg0Var, @NonNull ah0 ah0Var);

    void b(@NonNull eg0 eg0Var);

    void c(@NonNull eg0 eg0Var);

    void d(@NonNull eg0 eg0Var, @NonNull ah0 ah0Var);
}
