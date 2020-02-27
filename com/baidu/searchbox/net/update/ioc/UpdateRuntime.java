package com.baidu.searchbox.net.update.ioc;
/* loaded from: classes7.dex */
public class UpdateRuntime {
    private static DefaultUpdateContext sDefaultUpdateContext = new DefaultUpdateContext();

    public static IUpdateContext getUpdateContext() {
        return sDefaultUpdateContext;
    }
}
