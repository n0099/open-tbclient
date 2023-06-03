package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.model.KernelMediaRuntimeInfo;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/player/interfaces/OnMediaRuntimeInfoListener;", "", "onInfo", "", "runtimeInfo", "Lcom/baidu/searchbox/player/model/KernelMediaRuntimeInfo;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface OnMediaRuntimeInfoListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onInfo(OnMediaRuntimeInfoListener onMediaRuntimeInfoListener, KernelMediaRuntimeInfo kernelMediaRuntimeInfo) {
        }
    }

    void onInfo(KernelMediaRuntimeInfo kernelMediaRuntimeInfo);
}
