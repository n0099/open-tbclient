package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.d;
/* loaded from: classes2.dex */
public class PermissionUtils {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final PermissionUtils f6733a = new PermissionUtils();
    }

    public PermissionUtils() {
    }

    public static PermissionUtils getInstance() {
        return a.f6733a;
    }

    public boolean isIndoorNaviAuthorized() {
        return d.a().b();
    }
}
