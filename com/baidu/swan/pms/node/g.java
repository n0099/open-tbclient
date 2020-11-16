package com.baidu.swan.pms.node;
/* loaded from: classes6.dex */
public class g {
    public static d a(Node node) {
        Class<? extends d> processor;
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
