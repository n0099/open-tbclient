package com.baidu.pyramid.runtime.service;
/* loaded from: classes5.dex */
public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(String str) {
        super("No service published " + (str == null ? "" : str));
    }
}
