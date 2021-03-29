package com.baidu.mobads;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class MobadsPermissionSettings {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8146a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8147b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8148c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8149d = true;

    public static boolean hasPermissionGranted(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("permission_location".equalsIgnoreCase(str)) {
            return f8147b;
        }
        if ("permission_storage".equalsIgnoreCase(str)) {
            return f8148c;
        }
        if ("permission_app_list".equalsIgnoreCase(str)) {
            return f8149d;
        }
        if ("permission_read_phone_state".equalsIgnoreCase(str)) {
            return f8146a;
        }
        return false;
    }

    public static void setPermissionAppList(boolean z) {
        f8149d = z;
    }

    public static void setPermissionLocation(boolean z) {
        f8147b = z;
    }

    public static void setPermissionReadDeviceID(boolean z) {
        f8146a = z;
    }

    public static void setPermissionStorage(boolean z) {
        f8148c = z;
    }
}
