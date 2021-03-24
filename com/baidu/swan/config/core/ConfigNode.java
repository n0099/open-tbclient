package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.kwai.player.qos.KwaiQosInfo;
import d.b.g0.c.g.a;
import d.b.g0.c.g.b;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO(KwaiQosInfo.HOST_INFO, a.class, b.class),
    FRAMEWORK("framework", d.b.g0.c.f.a.class, d.b.g0.c.f.b.class),
    EXTENSION(ETAG.KEY_EXTENSION, d.b.g0.c.e.a.class, d.b.g0.c.e.b.class),
    TIP_MSG("tipmsgs", d.b.g0.c.h.a.class, d.b.g0.c.h.b.class);
    
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
