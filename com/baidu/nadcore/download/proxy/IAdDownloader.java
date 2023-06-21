package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.am0;
import com.baidu.tieba.wm0;
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

    int a(@NonNull am0 am0Var, @NonNull wm0 wm0Var);

    void b(@NonNull am0 am0Var);

    void c(@NonNull am0 am0Var);

    void d(@NonNull am0 am0Var, @NonNull wm0 wm0Var);
}
