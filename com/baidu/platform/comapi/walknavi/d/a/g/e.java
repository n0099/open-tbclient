package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    protected static UUID f2988a;

    public e(Context context) {
        try {
            if (f2988a == null && context != null) {
                synchronized (e.class) {
                    if (f2988a == null && context != null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                        String string = sharedPreferences.getString("device_id", null);
                        if (string != null) {
                            f2988a = UUID.fromString(string);
                        } else {
                            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                            try {
                                if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                    f2988a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                                } else {
                                    f2988a = UUID.randomUUID();
                                }
                            } catch (UnsupportedEncodingException e) {
                            }
                            sharedPreferences.edit().putString("device_id", f2988a.toString()).commit();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            a.a("DeviceUuidFactory exception: " + e2.getMessage());
        }
    }

    public UUID a() {
        return f2988a;
    }
}
