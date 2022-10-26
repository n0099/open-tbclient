package com.baidu.smallgame.sdk.permission;
/* loaded from: classes2.dex */
public interface PermissionProxy {
    public static final String SCOPE_ID_CAMERA = "mapp_camera";
    public static final String SCOPE_ID_RECORD = "mapp_record";

    void requestPermission(String str, PermissionListener permissionListener);
}
