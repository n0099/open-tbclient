package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class EmptyKernelFactory implements IKernelFactory {
    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    public AbsVideoKernel create(@NonNull String str) {
        return new EmptyKernel();
    }
}
