package com.baidu.pyramid.runtime.service;
/* loaded from: classes2.dex */
public class ServiceNotFoundException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ServiceNotFoundException(String str) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("No service published ");
        sb.append(str == null ? "" : str);
    }
}
