package com.baidu.searchbox.player.kernel;

import com.baidu.searchbox.player.layer.BaseKernelLayer;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/kernel/YYKernelLayer;", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "()V", "getYYVideoKernel", "Lcom/baidu/searchbox/player/kernel/YYVideoKernel;", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YYKernelLayer extends BaseKernelLayer {
    public YYKernelLayer() {
        super(YYVideoKernel.KERNEL_TYPE_YY);
    }

    public final YYVideoKernel getYYVideoKernel() {
        AbsVideoKernel videoKernel = getVideoKernel();
        if (videoKernel instanceof YYVideoKernel) {
            return (YYVideoKernel) videoKernel;
        }
        return null;
    }
}
