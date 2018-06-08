package com.baidu.ar.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class DeviceUuidFactory {
    protected static UUID a;

    public DeviceUuidFactory(Context context) {
        if (a == null) {
            synchronized (DeviceUuidFactory.class) {
                if (a == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                    String string = sharedPreferences.getString("device_id", null);
                    if (string != null) {
                        a = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        try {
                            if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            }
                            sharedPreferences.edit().putString("device_id", a.toString()).commit();
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public UUID getDeviceUuid() {
        return a;
    }
}
