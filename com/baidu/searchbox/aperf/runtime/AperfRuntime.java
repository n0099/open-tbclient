package com.baidu.searchbox.aperf.runtime;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
/* loaded from: classes6.dex */
public class AperfRuntime {

    /* loaded from: classes6.dex */
    public static final class Runtime {
        private static final String sProcessUUID = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        public static String getProcessUUID() {
            return sProcessUUID;
        }
    }
}
