package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
/* loaded from: classes3.dex */
public class VideoKernelPool {
    public static final FIFOPool<AbsVideoKernel> sPool = new FIFOPool<>(5);

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        public static final VideoKernelPool INSTANCE = new VideoKernelPool();
    }

    public VideoKernelPool() {
    }

    public static VideoKernelPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @NonNull
    public synchronized AbsVideoKernel obtain() {
        AbsVideoKernel acquire = sPool.acquire(AbsVideoKernel.NORMAL_PLAYER);
        if (acquire != null) {
            return acquire;
        }
        sPool.add(BDPlayerConfig.getKernelFactory().create(AbsVideoKernel.NORMAL_PLAYER));
        return sPool.acquire();
    }

    @NonNull
    public synchronized AbsVideoKernel obtain(String str) {
        AbsVideoKernel acquire = sPool.acquire(str);
        if (acquire != null) {
            return acquire;
        }
        sPool.add(BDPlayerConfig.getKernelFactory().create(str));
        return sPool.acquire();
    }

    public synchronized void recycle(AbsVideoKernel absVideoKernel) {
        sPool.release((FIFOPool<AbsVideoKernel>) absVideoKernel);
    }
}
