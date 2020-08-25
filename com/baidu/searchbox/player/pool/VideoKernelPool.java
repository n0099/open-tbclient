package com.baidu.searchbox.player.pool;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
/* loaded from: classes19.dex */
public class VideoKernelPool {
    private static final FIFOPool<AbsVideoKernel> sPool = new FIFOPool<>(5);

    /* loaded from: classes19.dex */
    private static class InstanceHolder {
        private static final VideoKernelPool INSTANCE = new VideoKernelPool();

        private InstanceHolder() {
        }
    }

    private VideoKernelPool() {
    }

    public static VideoKernelPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @NonNull
    public synchronized AbsVideoKernel obtain() {
        AbsVideoKernel acquire;
        acquire = sPool.acquire(AbsVideoKernel.NORMAL_PLAYER);
        if (acquire == null) {
            sPool.add(BDPlayerConfig.getKernelFactory().create(AbsVideoKernel.NORMAL_PLAYER));
            acquire = sPool.acquire();
        }
        return acquire;
    }

    @NonNull
    public synchronized AbsVideoKernel obtain(String str) {
        AbsVideoKernel acquire;
        acquire = sPool.acquire(str);
        if (acquire == null) {
            sPool.add(BDPlayerConfig.getKernelFactory().create(str));
            acquire = sPool.acquire();
        }
        return acquire;
    }

    public synchronized void recycle(AbsVideoKernel absVideoKernel) {
        sPool.release((FIFOPool<AbsVideoKernel>) absVideoKernel);
    }
}
