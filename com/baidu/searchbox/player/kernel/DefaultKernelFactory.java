package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes4.dex */
public class DefaultKernelFactory implements IKernelFactory {
    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    @PublicMethod
    public AbsVideoKernel create(@NonNull String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1026184943:
                if (str.equals(AbsVideoKernel.NORMAL_PLAYER)) {
                    c = 3;
                    break;
                }
                break;
            case -745233251:
                if (str.equals(AbsVideoKernel.TEXTURE_PLAYER)) {
                    c = 0;
                    break;
                }
                break;
            case 313531039:
                if (str.equals(AbsVideoKernel.CYBER_PLAYER)) {
                    c = 2;
                    break;
                }
                break;
            case 1194622411:
                if (str.equals(AbsVideoKernel.SURFACE_PLAYER)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new TextureVideoKernel(new StretchTextureView(BDPlayerConfig.getAppContext()));
            case 1:
                return new SurfaceVideoKernel();
            case 2:
                return new CyberVideoKernel();
            default:
                return new NormalVideoKernel();
        }
    }
}
