package com.baidu.ar.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class e {
    protected static UUID uuid;

    public e(Context context) {
        if (uuid == null) {
            synchronized (e.class) {
                if (uuid == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                    String string = sharedPreferences.getString("device_id", null);
                    if (string != null) {
                        uuid = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        try {
                            if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                uuid = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            }
                            if (uuid != null) {
                                sharedPreferences.edit().putString("device_id", uuid.toString()).apply();
                            }
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public UUID fl() {
        return uuid;
    }
}
