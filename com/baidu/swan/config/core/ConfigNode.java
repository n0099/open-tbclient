package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.swan.config.c.a;
import com.baidu.swan.config.c.b;
import com.baidu.webkit.internal.ETAG;
import com.kwai.player.qos.KwaiQosInfo;
/* loaded from: classes15.dex */
public enum ConfigNode {
    HOST_INFO(KwaiQosInfo.HOST_INFO, a.class, b.class),
    FRAMEWORK("framework", com.baidu.swan.config.b.a.class, com.baidu.swan.config.b.b.class),
    EXTENSION(ETAG.KEY_EXTENSION, com.baidu.swan.config.a.a.class, com.baidu.swan.config.a.b.class),
    TIP_MSG("tipmsgs", com.baidu.swan.config.d.a.class, com.baidu.swan.config.d.b.class);
    
    private String mName;
    private Class<? extends Object> mParamsProvider;
    private Class<? extends Object> mProcessor;

    ConfigNode(String str, Class cls, Class cls2) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
    }

    public String getName() {
        return this.mName;
    }

    public Class<? extends Object> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends Object> getProcessor() {
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
