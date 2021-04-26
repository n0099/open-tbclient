package com.baidu.pass.biometrics.base;
/* loaded from: classes2.dex */
public abstract class PassBiometricFactory {
    public static PassBiometricFactory getDefaultFactory() {
        return PassBiometricDefaultFactory.getInstance();
    }

    public abstract PassBiometric getBiometric(int i2);
}
