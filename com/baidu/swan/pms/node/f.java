package com.baidu.swan.pms.node;
/* loaded from: classes11.dex */
public class f {
    public static c a(Node node) {
        Class<? extends c> processor;
        if (node != null && (processor = node.getProcessor()) != null) {
            try {
                return processor.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }
}
