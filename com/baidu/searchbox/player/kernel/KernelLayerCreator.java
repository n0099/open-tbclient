package com.baidu.searchbox.player.kernel;

import com.baidu.searchbox.player.layer.BaseKernelLayer;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/kernel/KernelLayerCreator;", "", "()V", "createKernelLayer", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class KernelLayerCreator {
    public BaseKernelLayer createKernelLayer() {
        return new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER);
    }
}
