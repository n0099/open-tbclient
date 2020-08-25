package com.baidu.pass.biometrics.base;
/* loaded from: classes20.dex */
public abstract class PassBiometricFactory {
    public static PassBiometricFactory getDefaultFactory() {
        return PassBiometricDefaultFactory.getInstance();
    }

    public abstract PassBiometric getBiometric(int i);
}
