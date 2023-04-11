package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.bs3;
import com.baidu.tieba.cs3;
import com.baidu.tieba.ur3;
import com.baidu.tieba.vr3;
import com.baidu.tieba.wr3;
import com.baidu.tieba.xr3;
import com.baidu.tieba.yr3;
import com.baidu.tieba.zr3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO("host_info", yr3.class, zr3.class),
    FRAMEWORK("framework", wr3.class, xr3.class),
    EXTENSION(ETAG.KEY_EXTENSION, ur3.class, vr3.class),
    TIP_MSG("tipmsgs", bs3.class, cs3.class);
    
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
