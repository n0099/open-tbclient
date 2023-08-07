package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.av3;
import com.baidu.tieba.bv3;
import com.baidu.tieba.cv3;
import com.baidu.tieba.dv3;
import com.baidu.tieba.fv3;
import com.baidu.tieba.gv3;
import com.baidu.tieba.yu3;
import com.baidu.tieba.zu3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", cv3.class, dv3.class),
    FRAMEWORK("framework", av3.class, bv3.class),
    EXTENSION(ETAG.KEY_EXTENSION, yu3.class, zu3.class),
    TIP_MSG("tipmsgs", fv3.class, gv3.class);
    
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
