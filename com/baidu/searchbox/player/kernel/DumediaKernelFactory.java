package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes3.dex */
public class DumediaKernelFactory implements IKernelFactory {
    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    @PublicMethod
    public AbsVideoKernel create(@NonNull String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1026184943) {
            if (hashCode == 313531039 && str.equals(AbsVideoKernel.CYBER_PLAYER)) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals(AbsVideoKernel.NORMAL_PLAYER)) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            return new NormalVideoKernel();
        }
        return new CyberVideoKernel();
    }
}
