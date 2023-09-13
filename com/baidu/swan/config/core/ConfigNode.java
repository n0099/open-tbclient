package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.hv3;
import com.baidu.tieba.iv3;
import com.baidu.tieba.jv3;
import com.baidu.tieba.kv3;
import com.baidu.tieba.lv3;
import com.baidu.tieba.mv3;
import com.baidu.tieba.ov3;
import com.baidu.tieba.pv3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", lv3.class, mv3.class),
    FRAMEWORK("framework", jv3.class, kv3.class),
    EXTENSION(ETAG.KEY_EXTENSION, hv3.class, iv3.class),
    TIP_MSG("tipmsgs", ov3.class, pv3.class);
    
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
