package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.pp3;
import com.baidu.tieba.qp3;
import com.baidu.tieba.rp3;
import com.baidu.tieba.sp3;
import com.baidu.tieba.tp3;
import com.baidu.tieba.up3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.xp3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public enum ConfigNode {
    HOST_INFO("host_info", tp3.class, up3.class),
    FRAMEWORK("framework", rp3.class, sp3.class),
    EXTENSION(ETAG.KEY_EXTENSION, pp3.class, qp3.class),
    TIP_MSG("tipmsgs", wp3.class, xp3.class);
    
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
