package com.baidu.fsg.base;

import android.content.Context;
/* loaded from: classes2.dex */
public class EnvConfig {
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";

    /* renamed from: a  reason: collision with root package name */
    public static final String f5136a = "https://jrws.baidu.com";

    /* renamed from: b  reason: collision with root package name */
    public static String f5137b = "https://jrws.baidu.com";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5138c = "https://jrws.baidu.com";

    /* renamed from: d  reason: collision with root package name */
    public static EnvConfig f5139d;

    public static synchronized EnvConfig a() {
        EnvConfig envConfig;
        synchronized (EnvConfig.class) {
            if (f5139d == null && f5139d == null) {
                f5139d = new EnvConfig();
            }
            envConfig = f5139d;
        }
        return envConfig;
    }

    private void b() {
        f5137b = "https://jrws.baidu.com";
        DEFAULT_ENVIRONMENT = "ONLINE";
    }

    public static synchronized EnvConfig getInstance(Context context) {
        EnvConfig b2;
        synchronized (EnvConfig.class) {
            b2 = c.b();
        }
        return b2;
    }

    public String getEnvironment() {
        return DEFAULT_ENVIRONMENT;
    }

    public String getRimHttpsHost() {
        return f5137b;
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
}
