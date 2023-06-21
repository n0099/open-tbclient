package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.aw3;
import com.baidu.tieba.bw3;
import com.baidu.tieba.cw3;
import com.baidu.tieba.dw3;
import com.baidu.tieba.ew3;
import com.baidu.tieba.gw3;
import com.baidu.tieba.hw3;
import com.baidu.tieba.zv3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", dw3.class, ew3.class),
    FRAMEWORK("framework", bw3.class, cw3.class),
    EXTENSION(ETAG.KEY_EXTENSION, zv3.class, aw3.class),
    TIP_MSG("tipmsgs", gw3.class, hw3.class);
    
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
