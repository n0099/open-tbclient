package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes15.dex */
class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private String f4387a;

    public c(String str) {
        this.f4387a = "BaiduMapSDK-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f4387a);
    }
}
