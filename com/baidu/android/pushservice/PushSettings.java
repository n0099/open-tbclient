package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.browser.core.util.BdUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PushSettings {

    /* renamed from: a  reason: collision with root package name */
    private static Context f585a;

    public static String a() {
        if (f585a == null) {
            Log.e("PushSettings", "mContext == null");
            return "";
        }
        return Settings.System.getString(f585a.getContentResolver(), "com.baidu.pushservice.channel_id");
    }

    public static void a(Context context) {
        f585a = context;
    }

    public static void a(String str) {
        if (f585a == null) {
            Log.e("PushSettings", "setChannelId mContext == null");
        } else {
            Settings.System.putString(f585a.getContentResolver(), "com.baidu.pushservice.channel_id", str);
        }
    }

    public static void a(String str, int i, String str2) {
        String str3;
        if (f585a == null) {
            Log.e("PushSettings", "setApiInfo mContext == null");
        } else if (i == 9) {
            try {
                HashMap d = d();
                if (d == null || !d.containsKey("com.baidu.pushservice" + str)) {
                    return;
                }
                d.remove("com.baidu.pushservice" + str);
                a(d);
                Settings.System.putString(f585a.getContentResolver(), "com.baidu.pushservice" + str, "");
            } catch (Exception e) {
                Log.d("PushSettings", "set appInfo exception");
            }
        } else {
            try {
                str3 = Base64.encode(AESUtil.encrypt("2011121211143000", "9876543210123456", (i + str2).getBytes()), BdUtil.UTF8);
            } catch (Exception e2) {
                str3 = "";
                Log.i("PushSettings", "setAppInfo exception");
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            HashMap hashMap = null;
            try {
                hashMap = d();
            } catch (Exception e3) {
                Log.i("PushSettings", "set AppInfo exception" + e3.toString());
            }
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            if (!hashMap.containsKey("com.baidu.pushservice" + str)) {
                hashMap.put("com.baidu.pushservice" + str, str3);
                a(hashMap);
            }
            Settings.System.putString(f585a.getContentResolver(), "com.baidu.pushservice" + str, str3);
        }
    }

    private static void a(HashMap hashMap) {
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(absolutePath, "baidu/pushservice/files");
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(absolutePath, "baidu/pushservice/files/apps"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            Log.i("PushSettings", "setAppInfo read file exception");
        }
    }

    public static String b() {
        if (f585a == null) {
            Log.e("PushSettings", "getChannelToken mContext == null");
            return "";
        }
        return Settings.System.getString(f585a.getContentResolver(), "com.baidu.pushservice.channel_token_rsa");
    }

    public static String b(String str) {
        if (f585a == null) {
            Log.e("PushSettings", "setApiInfo mContext == null");
            return "";
        }
        String string = Settings.System.getString(f585a.getContentResolver(), "com.baidu.pushservice" + str);
        if (TextUtils.isEmpty(string)) {
            try {
                string = (String) d().get("com.baidu.pushservice" + str);
            } catch (Exception e) {
                return "";
            }
        }
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(AESUtil.decrypt("2011121211143000", "9876543210123456", Base64.decode(string.getBytes())));
        } catch (Exception e2) {
            return "";
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            Log.e("PushSettings", "getConnectState, context == null");
            return true;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "com.baidu.pushservice.PushSettings.connect_state") == 1;
        } catch (Settings.SettingNotFoundException e) {
            Log.w("PushSettings", "com.baidu.pushservice.PushSettings.connect_state setting is not set.");
            return true;
        }
    }

    public static void c(String str) {
        if (f585a == null) {
            Log.e("PushSettings", "setChannelToken mContext == null");
        } else {
            Settings.System.putString(f585a.getContentResolver(), "com.baidu.pushservice.channel_token_rsa", str);
        }
    }

    public static boolean c() {
        if (f585a == null) {
            return false;
        }
        try {
            return Settings.System.getInt(f585a.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }

    private static HashMap d() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "baidu/pushservice/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "apps");
        if (file2.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file2));
            new HashMap();
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            return hashMap;
        }
        return null;
    }

    public static void enableDebugMode(Context context, boolean z) {
        if (context == null) {
            Log.e("PushSettings", "enableDebugMode context == null");
        } else if (z) {
            Settings.System.putInt(context.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode", 1);
        } else {
            Settings.System.putInt(context.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode", 0);
        }
    }
}
