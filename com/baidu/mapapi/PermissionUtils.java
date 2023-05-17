package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;
/* loaded from: classes3.dex */
public class PermissionUtils {

    /* loaded from: classes3.dex */
    public static class a {
        public static final PermissionUtils a = new PermissionUtils();
    }

    public PermissionUtils() {
    }

    public static PermissionUtils getInstance() {
        return a.a;
    }

    public boolean isIndoorNaviAuthorized() {
        return c.a().b();
    }

    public boolean isWalkARNaviAuthorized() {
        return c.a().c();
    }
}
