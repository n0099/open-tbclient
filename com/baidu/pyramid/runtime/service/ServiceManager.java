package com.baidu.pyramid.runtime.service;

import d.b.b0.b.b.c;
/* loaded from: classes2.dex */
public class ServiceManager {
    public static <T> T getService(ServiceReference serviceReference) {
        return (T) c.a(serviceReference);
    }
}
