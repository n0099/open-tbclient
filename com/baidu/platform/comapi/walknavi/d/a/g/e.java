package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    protected static UUID f4245a;

    public e(Context context) {
        try {
            if (f4245a == null && context != null) {
                synchronized (e.class) {
                    if (f4245a == null && context != null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                        String string = sharedPreferences.getString("device_id", null);
                        if (string != null) {
                            f4245a = UUID.fromString(string);
                        } else {
                            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                            try {
                                if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                    f4245a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                                } else {
                                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                    f4245a = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                                }
                            } catch (UnsupportedEncodingException e) {
                            }
                            sharedPreferences.edit().putString("device_id", f4245a.toString()).commit();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            a.a("DeviceUuidFactory exception: " + e2.getMessage());
        }
    }

    public UUID a() {
        return f4245a;
    }
}
