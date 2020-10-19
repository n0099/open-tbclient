package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private String f2944a;

    public c(String str) {
        this.f2944a = "BaiduMapSDK-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f2944a);
    }
}
