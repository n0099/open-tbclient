package com.baidu.fsg.base;

import android.content.Context;
/* loaded from: classes4.dex */
public class EnvConfig {
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    protected static final String a = "https://jrws.baidu.com";
    private static final String c = "https://jrws.baidu.com";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static String DEFAULT_ENVIRONMENT = ENVIRONMENT_ONLINE;
    protected static String b = "https://jrws.baidu.com";
    private static EnvConfig d = null;

    public static synchronized EnvConfig getInstance(Context context) {
        EnvConfig b2;
        synchronized (EnvConfig.class) {
            b2 = c.b();
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized EnvConfig a() {
        EnvConfig envConfig;
        synchronized (EnvConfig.class) {
            if (d == null && d == null) {
                d = new EnvConfig();
            }
            envConfig = d;
        }
        return envConfig;
    }

    public void initEnv() {
        b();
    }

    public static synchronized EnvConfig getInstance() {
        EnvConfig b2;
        synchronized (EnvConfig.class) {
            b2 = c.b();
        }
        return b2;
    }

    public String getEnvironment() {
        return DEFAULT_ENVIRONMENT;
    }

    private void b() {
        b = "https://jrws.baidu.com";
        DEFAULT_ENVIRONMENT = ENVIRONMENT_ONLINE;
    }

    public String getRimHttpsHost() {
        return b;
    }
}
