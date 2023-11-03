package com.baidu.nadcore.download.proxy;

import androidx.annotation.NonNull;
import com.baidu.tieba.rh0;
import com.baidu.tieba.vg0;
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

    int a(@NonNull vg0 vg0Var, @NonNull rh0 rh0Var);

    void b(@NonNull vg0 vg0Var);

    void c(@NonNull vg0 vg0Var);

    void d(@NonNull vg0 vg0Var, @NonNull rh0 rh0Var);
}
