package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class e {
    protected static UUID a;

    public e(Context context) {
        try {
            if (a == null && context != null) {
                synchronized (e.class) {
                    if (a == null && context != null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                        String string = sharedPreferences.getString(Constants.KEY_DEVICE_ID, null);
                        if (string != null) {
                            a = UUID.fromString(string);
                        } else {
                            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                            try {
                                if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                    a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                                } else {
                                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                    a = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                                }
                            } catch (UnsupportedEncodingException e) {
                            }
                            sharedPreferences.edit().putString(Constants.KEY_DEVICE_ID, a.toString()).commit();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            a.a("DeviceUuidFactory exception: " + e2.getMessage());
        }
    }

    public UUID a() {
        return a;
    }
}
