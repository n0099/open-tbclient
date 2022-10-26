package com.baidu.smallgame.sdk.permission;
/* loaded from: classes2.dex */
public interface PermissionListener {
    public static final int PERMISSION_OK = 0;
    public static final int PERMISSION_SYSTEM_DENY = 1;
    public static final int PERMISSION_USER_DENY = 2;

    void onPermissionResult(String str, int i);
}
