package com.baidu.searchbox.player.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.assistant.KernelCacheAssistant;
import com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes3.dex */
public abstract class AbsKernelReuseHelper implements IKernelLayerReuseHelper {
    public abstract boolean performAutoDetachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str);

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public boolean attachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        BaseKernelLayer validCache = getValidCache(bDVideoPlayer, str);
        if (validCache == null) {
            return false;
        }
        BdVideoLog.d("ReuseHelper:  attach,cache is " + validCache + ",cacheKey is " + str);
        validCache.resume();
        bDVideoPlayer.setKLayerCacheKey(str);
        bDVideoPlayer.restoreVideoTask(validCache);
        bDVideoPlayer.attachKernelLayer(validCache);
        return true;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    @Nullable
    public BaseKernelLayer getValidCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        return KernelCacheAssistant.get().removeCache(str);
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public boolean detachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BaseKernelLayer detachKernelLayer = bDVideoPlayer.detachKernelLayer();
        BdVideoLog.d("ReuseHelper: detach,cache is " + detachKernelLayer + ",cacheKey is " + str);
        if (detachKernelLayer != null) {
            detachKernelLayer.pause();
            KernelCacheAssistant.get().putCache(str, detachKernelLayer);
            return true;
        }
        return true;
    }
}
