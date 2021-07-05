package com.baidu.smallgame.sdk.permission;

import com.baidu.searchbox.v8engine.NotProguard;
@NotProguard
/* loaded from: classes4.dex */
public interface PermissionProxy {
    public static final String SCOPE_ID_CAMERA = "mapp_camera";
    public static final String SCOPE_ID_RECORD = "mapp_record";

    void requestPermission(String str, PermissionListener permissionListener);
}
