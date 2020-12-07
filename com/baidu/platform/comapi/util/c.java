package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes26.dex */
class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private String f2948a;

    public c(String str) {
        this.f2948a = "BaiduMapSDK-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f2948a);
    }
}
