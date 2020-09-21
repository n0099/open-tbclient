package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes3.dex */
class c implements ThreadFactory {
    private String a;

    public c(String str) {
        this.a = "BaiduMapSDK-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.a);
    }
}
