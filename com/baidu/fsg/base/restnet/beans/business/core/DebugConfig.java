package com.baidu.fsg.base.restnet.beans.business.core;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public final class DebugConfig {
    private static final String CONFIG_FILE = "rim_config.properties";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    private static final String RIM_BASE_HOST = "https://jrws.baidu.com";
    private static final String RIM_ENVIRONMENT = "environment";
    private static final String RIM_HTTPS_HOST = "rim_https_host";
    private static final String fixedRimHttpsHostForH5 = "https://jrws.baidu.com";
    private File mConfigFile;
    private Properties mProperties = loadProperties();
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static String DEFAULT_ENVIRONMENT = ENVIRONMENT_ONLINE;
    private static boolean mDebug = false;
    private static String serverRimHttps = "https://jrws.baidu.com";
    private static DebugConfig mInstance = null;

    private DebugConfig(Context context) {
        this.mConfigFile = null;
        this.mConfigFile = new File(String.valueOf(Environment.getExternalStorageDirectory()) + "/" + CONFIG_FILE);
    }

    public static synchronized DebugConfig getInstance(Context context) {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (mInstance == null && mInstance == null) {
                mInstance = new DebugConfig(context);
            }
            debugConfig = mInstance;
        }
        return debugConfig;
    }

    public static synchronized DebugConfig getInstance() {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (mInstance == null && mInstance == null) {
                mInstance = new DebugConfig(null);
            }
            debugConfig = mInstance;
        }
        return debugConfig;
    }

    public void readConfigHost(boolean z) {
    }

    private void readExternalConfig() {
        serverRimHttps = getValue(RIM_HTTPS_HOST);
        if (TextUtils.isEmpty(serverRimHttps)) {
            serverRimHttps = "https://jrws.baidu.com";
        }
    }

    private String getValue(String str) {
        this.mProperties = loadProperties();
        if (LogUtil.DEBUG) {
            LogUtil.logd("name=" + str + "#value=" + this.mProperties.getProperty(str));
        }
        return this.mProperties.getProperty(str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0027 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0039 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Properties loadProperties() {
        ?? e;
        ?? properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                e = new FileInputStream(this.mConfigFile);
                try {
                    properties.load(e);
                    if (e != 0) {
                        try {
                            e.close();
                        } catch (IOException e2) {
                            e = e2;
                        }
                    }
                } catch (Exception e3) {
                    LogUtil.d("DebugConfig", "the wallet_config.properties is not exist!!");
                    if (e != 0) {
                        try {
                            e.close();
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    return properties;
                }
            } catch (Throwable th) {
                fileInputStream = e;
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = 0;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
            }
            throw th;
        }
        return properties;
    }

    public String getEnvironment() {
        return mDebug ? getValue(RIM_ENVIRONMENT) : DEFAULT_ENVIRONMENT;
    }

    public String getProperty(String str, String str2) {
        if (!mDebug) {
            LogUtil.logd("没有打开DEBUG开关 返回默认值=" + str2);
            return str2;
        }
        String value = getValue(str);
        if (TextUtils.isEmpty(value)) {
            LogUtil.logd("配置文件没有配置 返回默认值=" + str2);
            return str2;
        }
        LogUtil.logd("返回配置文件的值 value=" + value);
        return value;
    }

    public void changeOnline() {
        mDebug = false;
        serverRimHttps = "https://jrws.baidu.com";
        DEFAULT_ENVIRONMENT = ENVIRONMENT_ONLINE;
    }

    public void changeQA() {
        mDebug = true;
        DEFAULT_ENVIRONMENT = ENVIRONMENT_QA;
        readConfigHost(mDebug);
    }

    public String getRimHttpsHost() {
        return serverRimHttps;
    }

    public void setRimHttpsHost(String str) {
        serverRimHttps = str;
    }

    public String getFixedRimHttpsHostForH5() {
        return "https://jrws.baidu.com";
    }
}
