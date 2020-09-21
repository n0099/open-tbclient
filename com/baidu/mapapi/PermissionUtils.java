package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;
/* loaded from: classes3.dex */
public class PermissionUtils {

    /* loaded from: classes3.dex */
    private static class a {
        private static final PermissionUtils a = new PermissionUtils();
    }

    private PermissionUtils() {
    }

    public static PermissionUtils getInstance() {
        return a.a;
    }

    public boolean isIndoorNaviAuthorized() {
        return c.a().b();
    }
}
