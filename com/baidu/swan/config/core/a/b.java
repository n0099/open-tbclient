package com.baidu.swan.config.core.a;

import com.baidu.swan.config.core.ConfigNode;
import com.baidu.swan.config.e;
/* loaded from: classes10.dex */
public class b {
    public static c a(ConfigNode configNode) {
        Class<? extends c> paramsProvider;
        if (configNode != null && (paramsProvider = configNode.getParamsProvider()) != null) {
            try {
                return paramsProvider.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }
}
