package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static UUID f10007a;

    public e(Context context) {
        UUID randomUUID;
        try {
            if (f10007a != null || context == null) {
                return;
            }
            synchronized (e.class) {
                if (f10007a == null && context != null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                    String string = sharedPreferences.getString(Constants.KEY_DEVICE_ID, null);
                    if (string != null) {
                        f10007a = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        try {
                            if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                f10007a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            } else {
                                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                if (deviceId != null) {
                                    randomUUID = UUID.nameUUIDFromBytes(deviceId.getBytes("utf8"));
                                } else {
                                    randomUUID = UUID.randomUUID();
                                }
                                f10007a = randomUUID;
                            }
                        } catch (UnsupportedEncodingException unused) {
                        }
                        sharedPreferences.edit().putString(Constants.KEY_DEVICE_ID, f10007a.toString()).commit();
                    }
                }
            }
        } catch (Exception e2) {
            a.a("DeviceUuidFactory exception: " + e2.getMessage());
        }
    }

    public UUID a() {
        return f10007a;
    }
}
