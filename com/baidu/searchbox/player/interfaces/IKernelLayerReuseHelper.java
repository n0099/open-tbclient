package com.baidu.searchbox.player.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
/* loaded from: classes3.dex */
public interface IKernelLayerReuseHelper {
    boolean attachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str);

    boolean detachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str);

    @Nullable
    BaseKernelLayer getValidCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str);
}
