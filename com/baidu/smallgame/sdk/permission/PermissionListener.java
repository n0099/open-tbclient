package com.baidu.smallgame.sdk.permission;

import com.baidu.searchbox.v8engine.NotProguard;
@NotProguard
/* loaded from: classes3.dex */
public interface PermissionListener {
    public static final int PERMISSION_OK = 0;
    public static final int PERMISSION_SYSTEM_DENY = 1;
    public static final int PERMISSION_USER_DENY = 2;

    void onPermissionResult(String str, int i);
}
