package com.baidu.mobads;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class MobadsPermissionSettings {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2352a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = true;

    public static void setPermissionReadDeviceID(boolean z) {
        f2352a = z;
    }

    public static void setPermissionLocation(boolean z) {
        b = z;
    }

    public static void setPermissionStorage(boolean z) {
        c = z;
    }

    public static void setPermissionAppList(boolean z) {
        d = z;
    }

    public static boolean hasPermissionGranted(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("permission_location".equalsIgnoreCase(str)) {
                return b;
            }
            if ("permission_storage".equalsIgnoreCase(str)) {
                return c;
            }
            if ("permission_app_list".equalsIgnoreCase(str)) {
                return d;
            }
            if ("permission_read_phone_state".equalsIgnoreCase(str)) {
                return f2352a;
            }
        }
        return false;
    }
}
