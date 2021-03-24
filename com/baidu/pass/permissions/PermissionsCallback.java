package com.baidu.pass.permissions;
/* loaded from: classes2.dex */
public abstract class PermissionsCallback implements com.baidu.pass.a {
    public static final int ERROR_CANCLE = -2;
    public static final int ERROR_FORBID_FOREVER = -3;
    public static final int ERROR_NO_PERMISSION = -1;

    public abstract void onFailure(int i);

    public abstract void onSuccess();
}
