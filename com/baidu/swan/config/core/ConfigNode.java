package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import d.a.h0.c.g.a;
import d.a.h0.c.g.b;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO("host_info", a.class, b.class),
    FRAMEWORK("framework", d.a.h0.c.f.a.class, d.a.h0.c.f.b.class),
    EXTENSION(ETAG.KEY_EXTENSION, d.a.h0.c.e.a.class, d.a.h0.c.e.b.class),
    TIP_MSG("tipmsgs", d.a.h0.c.h.a.class, d.a.h0.c.h.b.class);
    
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
