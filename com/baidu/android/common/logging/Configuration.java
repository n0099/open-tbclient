package com.baidu.android.common.logging;

import java.io.InputStream;
import java.util.Properties;
/* loaded from: classes.dex */
final class Configuration {
    public static final String CONFIGURATION_FILENAME = "log.cfg";
    private static Properties sProperties;

    static {
        InputStream resourceAsStream = Configuration.class.getResourceAsStream("/log.cfg");
        sProperties = new Properties();
        try {
            sProperties.load(resourceAsStream);
        } catch (Exception e) {
            sProperties = null;
        }
    }

    private Configuration() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLogEnabled() {
        if (sProperties != null) {
            return "true".equals(sProperties.getProperty("enabled", Boolean.toString(true)));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldLog2Fie() {
        if (sProperties != null) {
            return "true".equals(sProperties.getProperty("log2file", "false"));
        }
        return false;
    }
}
