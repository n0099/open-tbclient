package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;
/* loaded from: classes15.dex */
public class PermissionUtils {

    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final PermissionUtils f2739a = new PermissionUtils();
    }

    private PermissionUtils() {
    }

    public static PermissionUtils getInstance() {
        return a.f2739a;
    }

    public boolean isIndoorNaviAuthorized() {
        return c.a().b();
    }
}
