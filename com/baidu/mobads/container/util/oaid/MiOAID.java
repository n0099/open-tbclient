package com.baidu.mobads.container.util.oaid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class MiOAID {
    public static String getMIOAID(Context context) {
        if (context == null) {
            return null;
        }
        try {
            UniqueIdUtils.sendSDKTypeLog(context, "mi-start", "");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            if (cls != null) {
                Object newInstance = cls.newInstance();
                Method method = cls.getMethod("getOAID", Context.class);
                if (newInstance != null && method != null) {
                    String str = (String) method.invoke(newInstance, context);
                    if (TextUtils.isEmpty(str)) {
                        UniqueIdUtils.sendSDKTypeLog(context, "mi-empty", "");
                    } else {
                        UniqueIdUtils.sendSDKTypeLog(context, "mi-valid", str);
                        UniqueIdUtils.miitOAID = str;
                    }
                    return str;
                }
            }
        } catch (Throwable th) {
            UniqueIdUtils.sendSDKTypeLog(context, "mi-error" + th.getMessage(), "");
        }
        return null;
    }

    public static boolean isXiaomiBrand() {
        try {
            String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
            if (TextUtils.isEmpty(phoneOSBrand)) {
                return false;
            }
            if (!phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI)) {
                if (!phoneOSBrand.equalsIgnoreCase("redmi")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
