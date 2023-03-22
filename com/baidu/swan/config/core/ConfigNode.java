package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.as3;
import com.baidu.tieba.bs3;
import com.baidu.tieba.tr3;
import com.baidu.tieba.ur3;
import com.baidu.tieba.vr3;
import com.baidu.tieba.wr3;
import com.baidu.tieba.xr3;
import com.baidu.tieba.yr3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO("host_info", xr3.class, yr3.class),
    FRAMEWORK("framework", vr3.class, wr3.class),
    EXTENSION(ETAG.KEY_EXTENSION, tr3.class, ur3.class),
    TIP_MSG("tipmsgs", as3.class, bs3.class);
    
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
