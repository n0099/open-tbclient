package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.sh0;
import com.baidu.tieba.wg0;
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

    int a(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var);

    void b(@NonNull wg0 wg0Var);

    void c(@NonNull wg0 wg0Var);

    void d(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var);
}
