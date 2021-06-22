package com.baidu.swan.config.core;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.kwai.player.qos.KwaiQosInfo;
import d.a.m0.d.g.a;
import d.a.m0.d.g.b;
/* loaded from: classes3.dex */
public enum ConfigNode {
    HOST_INFO(KwaiQosInfo.HOST_INFO, a.class, b.class),
    FRAMEWORK("framework", d.a.m0.d.f.a.class, d.a.m0.d.f.b.class),
    EXTENSION(ETAG.KEY_EXTENSION, d.a.m0.d.e.a.class, d.a.m0.d.e.b.class),
    TIP_MSG("tipmsgs", d.a.m0.d.h.a.class, d.a.m0.d.h.b.class);
    
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
