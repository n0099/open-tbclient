package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.gt3;
import com.baidu.tieba.ht3;
import com.baidu.tieba.it3;
import com.baidu.tieba.jt3;
import com.baidu.tieba.kt3;
import com.baidu.tieba.lt3;
import com.baidu.tieba.nt3;
import com.baidu.tieba.ot3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", kt3.class, lt3.class),
    FRAMEWORK("framework", it3.class, jt3.class),
    EXTENSION(ETAG.KEY_EXTENSION, gt3.class, ht3.class),
    TIP_MSG("tipmsgs", nt3.class, ot3.class);
    
    public String mName;
    public Class<? extends Object> mParamsProvider;
    public Class<? extends Object> mProcessor;

    ConfigNode(String str, Class cls, Class cls2) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
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

    public String getName() {
        return this.mName;
    }

    public Class<? extends Object> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends Object> getProcessor() {
        return this.mProcessor;
    }
}
