package com.baidu.pass.face.platform;
/* loaded from: classes2.dex */
public enum LicenseStatusEnum {
    StateSuccess,
    StateWarningValidityComing,
    StateErrorBegin,
    StateErrorNotFindLicense,
    StateErrorExpired,
    StateErrorAuthorized,
    StateErrorNetwork,
    StateNotInit,
    StateInitializing,
    StateUnknown;

    public static LicenseStatusEnum getLicenseStatus(int i2) {
        return StateUnknown;
    }
}
