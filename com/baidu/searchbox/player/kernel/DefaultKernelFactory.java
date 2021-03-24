package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes3.dex */
public class DefaultKernelFactory implements IKernelFactory {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    @PublicMethod
    public AbsVideoKernel create(@NonNull String str) {
        char c2;
        switch (str.hashCode()) {
            case -1026184943:
                if (str.equals("NormalVideoKernel")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -745233251:
                if (str.equals("TextureVideoKernel")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 313531039:
                if (str.equals("CyberVideoKernel")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1194622411:
                if (str.equals("SurfaceVideoKernel")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return new NormalVideoKernel();
                }
                return new CyberVideoKernel();
            }
            return new SurfaceVideoKernel();
        }
        return new TextureVideoKernel(new StretchTextureView(BDPlayerConfig.getAppContext()));
    }
}
