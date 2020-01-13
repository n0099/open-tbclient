package com.baidu.searchbox.net.update.ioc;
/* loaded from: classes5.dex */
public class UpdateRuntime {
    private static DefaultUpdateContext sDefaultUpdateContext = new DefaultUpdateContext();

    public static IUpdateContext getUpdateContext() {
        return sDefaultUpdateContext;
    }
}
