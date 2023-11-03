package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.gq3;
import com.baidu.tieba.hq3;
import com.baidu.tieba.iq3;
import com.baidu.tieba.jq3;
import com.baidu.tieba.kq3;
import com.baidu.tieba.lq3;
import com.baidu.tieba.nq3;
import com.baidu.tieba.oq3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", kq3.class, lq3.class),
    FRAMEWORK("framework", iq3.class, jq3.class),
    EXTENSION(ETAG.KEY_EXTENSION, gq3.class, hq3.class),
    TIP_MSG("tipmsgs", nq3.class, oq3.class);
    
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
