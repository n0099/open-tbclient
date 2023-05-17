package com.baidu.searchbox.player.assistant;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class KernelCacheAssistant {
    public static final String KEY_REUSE_KERNEL_ID = "videoPlayerReuseID";
    public final HashMap<String, BaseKernelLayer> mKernelCache;

    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final KernelCacheAssistant mInstance = new KernelCacheAssistant();
    }

    public KernelCacheAssistant() {
        this.mKernelCache = new HashMap<>(2);
    }

    public static KernelCacheAssistant get() {
        return Holder.mInstance;
    }

    public void release() {
        for (BaseKernelLayer baseKernelLayer : this.mKernelCache.values()) {
            if (baseKernelLayer != null) {
                baseKernelLayer.release();
            }
        }
        this.mKernelCache.clear();
    }

    @Nullable
    public BaseKernelLayer getCache(@Nullable String str) {
        return this.mKernelCache.get(str);
    }

    public boolean isInCache(@Nullable BaseKernelLayer baseKernelLayer) {
        return this.mKernelCache.containsValue(baseKernelLayer);
    }

    @Nullable
    public BaseKernelLayer removeCache(String str) {
        return this.mKernelCache.remove(str);
    }

    public void putCache(@Nullable String str, @Nullable BaseKernelLayer baseKernelLayer) {
        if (baseKernelLayer != null && !TextUtils.isEmpty(str)) {
            this.mKernelCache.put(str, baseKernelLayer);
        }
    }
}
