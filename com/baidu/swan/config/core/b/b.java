package com.baidu.swan.config.core.b;

import com.baidu.swan.config.core.ConfigNode;
import com.baidu.swan.config.e;
/* loaded from: classes11.dex */
public class b {
    public static c b(ConfigNode configNode) {
        Class<? extends c> processor;
        if (configNode != null && (processor = configNode.getProcessor()) != null) {
            try {
                return processor.newInstance();
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
