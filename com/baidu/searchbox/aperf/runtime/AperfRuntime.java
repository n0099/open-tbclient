package com.baidu.searchbox.aperf.runtime;

import java.util.UUID;
/* loaded from: classes3.dex */
public class AperfRuntime {

    /* loaded from: classes3.dex */
    public static final class Runtime {
        public static final String sProcessUUID = UUID.randomUUID().toString().replace("-", "");

        public static String getProcessUUID() {
            return sProcessUUID;
        }
    }
}
