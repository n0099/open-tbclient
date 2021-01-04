package com.baidu.fsg.base;

import android.content.Context;
/* loaded from: classes6.dex */
public class EnvConfig {
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";

    /* renamed from: a  reason: collision with root package name */
    protected static final String f1906a = "https://jrws.baidu.com";
    private static final String c = "https://jrws.baidu.com";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static String DEFAULT_ENVIRONMENT = ENVIRONMENT_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    protected static String f1907b = "https://jrws.baidu.com";
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
        f1907b = "https://jrws.baidu.com";
        DEFAULT_ENVIRONMENT = ENVIRONMENT_ONLINE;
    }

    public String getRimHttpsHost() {
        return f1907b;
    }
}
