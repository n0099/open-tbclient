package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.hq3;
import com.baidu.tieba.iq3;
import com.baidu.tieba.jq3;
import com.baidu.tieba.kq3;
import com.baidu.tieba.lq3;
import com.baidu.tieba.mq3;
import com.baidu.tieba.oq3;
import com.baidu.tieba.pq3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", lq3.class, mq3.class),
    FRAMEWORK("framework", jq3.class, kq3.class),
    EXTENSION(ETAG.KEY_EXTENSION, hq3.class, iq3.class),
    TIP_MSG("tipmsgs", oq3.class, pq3.class);
    
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
