package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public enum ConfigNode {
    HOST_INFO("host_info", com.baidu.swan.config.c.a.class, com.baidu.swan.config.c.b.class),
    FRAMEWORK("framework", com.baidu.swan.config.b.a.class, com.baidu.swan.config.b.b.class),
    EXTENSION(ETAG.KEY_EXTENSION, com.baidu.swan.config.a.a.class, com.baidu.swan.config.a.b.class),
    TIP_MSG("tipmsgs", com.baidu.swan.config.d.a.class, com.baidu.swan.config.d.b.class);
    
    private String mName;
    private Class<? extends com.baidu.swan.config.core.a.c> mParamsProvider;
    private Class<? extends com.baidu.swan.config.core.b.c> mProcessor;

    ConfigNode(String str, Class cls, Class cls2) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
    }

    public String getName() {
        return this.mName;
    }

    public Class<? extends com.baidu.swan.config.core.a.c> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends com.baidu.swan.config.core.b.c> getProcessor() {
        return this.mProcessor;
    }

    public static ConfigNode getNodeByConfigName(String str) {
        ConfigNode[] values;
        for (ConfigNode configNode : values()) {
            if (configNode != null && TextUtils.equals(configNode.getName(), str)) {
                return configNode;
            }
        }
        return null;
    }
}
