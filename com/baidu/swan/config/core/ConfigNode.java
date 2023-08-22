package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.dv3;
import com.baidu.tieba.ev3;
import com.baidu.tieba.fv3;
import com.baidu.tieba.gv3;
import com.baidu.tieba.hv3;
import com.baidu.tieba.iv3;
import com.baidu.tieba.kv3;
import com.baidu.tieba.lv3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", hv3.class, iv3.class),
    FRAMEWORK("framework", fv3.class, gv3.class),
    EXTENSION(ETAG.KEY_EXTENSION, dv3.class, ev3.class),
    TIP_MSG("tipmsgs", kv3.class, lv3.class);
    
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
