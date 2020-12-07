package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;
/* loaded from: classes26.dex */
public class PermissionUtils {

    /* loaded from: classes26.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final PermissionUtils f1963a = new PermissionUtils();
    }

    private PermissionUtils() {
    }

    public static PermissionUtils getInstance() {
        return a.f1963a;
    }

    public boolean isIndoorNaviAuthorized() {
        return c.a().b();
    }
}
