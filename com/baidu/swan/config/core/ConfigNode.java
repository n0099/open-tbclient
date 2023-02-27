package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.mt3;
import com.baidu.tieba.nt3;
import com.baidu.tieba.ot3;
import com.baidu.tieba.pt3;
import com.baidu.tieba.qt3;
import com.baidu.tieba.rt3;
import com.baidu.tieba.tt3;
import com.baidu.tieba.ut3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO("host_info", qt3.class, rt3.class),
    FRAMEWORK("framework", ot3.class, pt3.class),
    EXTENSION(ETAG.KEY_EXTENSION, mt3.class, nt3.class),
    TIP_MSG("tipmsgs", tt3.class, ut3.class);
    
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
