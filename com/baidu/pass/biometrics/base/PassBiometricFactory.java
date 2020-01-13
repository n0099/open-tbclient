package com.baidu.pass.biometrics.base;
/* loaded from: classes5.dex */
public abstract class PassBiometricFactory {
    public abstract PassBiometric getBiometric(int i);

    public static PassBiometricFactory getDefaultFactory() {
        return PassBiometricDefaultFactory.getInstance();
    }
}
