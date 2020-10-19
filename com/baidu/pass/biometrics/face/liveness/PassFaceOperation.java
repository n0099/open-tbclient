package com.baidu.pass.biometrics.face.liveness;

import com.baidu.pass.biometrics.base.PassBiometricOperation;
/* loaded from: classes18.dex */
public class PassFaceOperation implements PassBiometricOperation {
    public OperationType operationType = OperationType.RECOGNIZE;

    /* loaded from: classes18.dex */
    public enum OperationType {
        RECOGNIZE("RECOGNIZE");
        
        public String operateName;

        OperationType(String str) {
            this.operateName = str;
        }
    }
}
