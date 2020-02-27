package com.baidu.fsg.face.liveness;

import com.baidu.fsg.face.base.e;
/* loaded from: classes4.dex */
public class SapiLivenessOperation implements e {
    public OperationType operationType;

    /* loaded from: classes4.dex */
    public enum OperationType {
        RECOGNIZE("RECOGNIZE"),
        VIDEORECOG("VIDEOREOCG");
        
        public String name;

        OperationType(String str) {
            this.name = str;
        }
    }
}
