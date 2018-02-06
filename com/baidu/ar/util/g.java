package com.baidu.ar.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class g {
    protected static UUID a;

    public g(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                    String string = sharedPreferences.getString(Constants.HTTP_DEVICE_ID, null);
                    if (string != null) {
                        a = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        try {
                            if ("9774d56d682e549c".equals(string2) || TextUtils.isEmpty(string2)) {
                                String deviceId = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
                                a = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                            } else {
                                a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            }
                            sharedPreferences.edit().putString(Constants.HTTP_DEVICE_ID, a.toString()).commit();
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public UUID a() {
        return a;
    }
}
