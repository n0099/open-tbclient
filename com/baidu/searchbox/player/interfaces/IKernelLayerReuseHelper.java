package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
/* loaded from: classes2.dex */
public interface IKernelLayerReuseHelper {
    boolean attachCache(BDVideoPlayer bDVideoPlayer, String str);

    boolean detachCache(BDVideoPlayer bDVideoPlayer, String str);

    BaseKernelLayer getValidCache(BDVideoPlayer bDVideoPlayer, String str);
}
