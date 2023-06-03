package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class DumediaKernelFactory implements IKernelFactory {
    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    public AbsVideoKernel create(@NonNull String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1026184943) {
            if (hashCode != 313531039) {
                if (hashCode == 345101574 && str.equals(CyberInlineVideoKernel.KERNEL_TYPE_CYBER_INLINE)) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals(AbsVideoKernel.CYBER_PLAYER)) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (str.equals(AbsVideoKernel.NORMAL_PLAYER)) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                return new NormalVideoKernel();
            }
            return new CyberInlineVideoKernel();
        }
        return new CyberVideoKernel();
    }
}
