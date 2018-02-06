package com.baidu.sapi2.biometrics.liveness;
/* loaded from: classes2.dex */
public class SapiLivenessOperation implements com.baidu.fsg.biometrics.base.e {
    public OperationType operationType;

    /* loaded from: classes2.dex */
    public enum OperationType {
        RECOGNIZE("RECOGNIZE");
        
        public String name;

        OperationType(String str) {
            this.name = str;
        }
    }
}
