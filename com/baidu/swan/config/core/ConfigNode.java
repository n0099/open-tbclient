package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.tieba.as3;
import com.baidu.tieba.cs3;
import com.baidu.tieba.ds3;
import com.baidu.tieba.vr3;
import com.baidu.tieba.wr3;
import com.baidu.tieba.xr3;
import com.baidu.tieba.yr3;
import com.baidu.tieba.zr3;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO("host_info", zr3.class, as3.class),
    FRAMEWORK("framework", xr3.class, yr3.class),
    EXTENSION(ETAG.KEY_EXTENSION, vr3.class, wr3.class),
    TIP_MSG("tipmsgs", cs3.class, ds3.class);
    
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
