package com.baidu.searchbox.player.kernel;

import android.util.LruCache;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/player/kernel/KernelCachePool;", "Landroid/util/LruCache;", "", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "maxSize", "", "(I)V", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KernelCachePool extends LruCache<String, BaseKernelLayer> {
    public KernelCachePool() {
        this(0, 1, null);
    }

    public KernelCachePool(int i) {
        super(i);
    }

    public /* synthetic */ KernelCachePool(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, String str, BaseKernelLayer baseKernelLayer, BaseKernelLayer baseKernelLayer2) {
        BDVideoPlayer bDVideoPlayer;
        if (baseKernelLayer != null) {
            bDVideoPlayer = baseKernelLayer.getBindPlayer();
        } else {
            bDVideoPlayer = null;
        }
        if (bDVideoPlayer == null && baseKernelLayer != null) {
            baseKernelLayer.release();
        }
        super.entryRemoved(z, (boolean) str, baseKernelLayer, baseKernelLayer2);
    }
}
