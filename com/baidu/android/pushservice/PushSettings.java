package com.baidu.android.pushservice;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
    private static Context f686a;

    public static String a() {
        if (f686a == null) {
            Log.e("PushSettings", "mContext == null");
            return "";
        }
        return Settings.System.getString(f686a.getContentResolver(), "com.baidu.pushservice.channel_id");
    }

    public static void a(int i) {
        if (f686a == null) {
            Log.w("PushSettings", "setCurPeriod mContext == null");
        } else {
            Settings.System.putInt(f686a.getContentResolver(), "com.baidu.pushservice.cur_period", i);
        }
    }

    public static void a(long j) {
        if (f686a == null) {
            Log.w("PushSettings", "setLastSendStatisticTime mContext == null");
        } else {
            Settings.System.putLong(f686a.getContentResolver(), "com.baidu.pushservice.cst", j);
        }
    }

    public static void a(Context context) {
        f686a = context;
    }

    public static void a(Context context, String str) {
        if (context == null) {
            Log.w("PushSettings", "removeUninstalledAppLbsSwitch mContext == null");
        } else if (!TextUtils.isEmpty(str)) {
            String string = Settings.System.getString(context.getContentResolver(), "com.baidu.pushservice.le");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String[] split = string.trim().split(",");
            for (String str2 : split) {
                if (!str2.equals(str)) {
                    sb.append(str2 + ",");
                }
            }
            Settings.System.putString(context.getContentResolver(), "com.baidu.pushservice.le", sb.toString());
        }
    }

    public static void a(Context context, boolean z) {
        String[] split;
        int i;
        boolean z2 = false;
        if (context == null) {
            Log.w("PushSettings", "setLbsEnabled mContext == null");
        } else if (TextUtils.isEmpty(context.getPackageName())) {
            Log.w("PushSettings", "mContext.getPackageName() == null");
        } else {
            String string = Settings.System.getString(context.getContentResolver(), "com.baidu.pushservice.le");
            if (TextUtils.isEmpty(string)) {
                if (z) {
                    Settings.System.putString(context.getContentResolver(), "com.baidu.pushservice.le", context.getPackageName() + ",");
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : string.trim().split(",")) {
                if (str.equals(context.getPackageName())) {
                    z2 = true;
                    i = z ? 0 : i + 1;
                }
                sb.append(str + ",");
            }
            if (!z2) {
                sb.append(context.getPackageName() + ",");
            }
            Settings.System.putString(context.getContentResolver(), "com.baidu.pushservice.le", sb.toString());
        }
    }

    public static void a(String str) {
        if (f686a == null) {
            Log.e("PushSettings", "setChannelId mContext == null");
        } else {
            Settings.System.putString(f686a.getContentResolver(), "com.baidu.pushservice.channel_id", str);
        }
    }

    public static void a(String str, int i, String str2) {
        String str3;
        if (f686a == null) {
            Log.e("PushSettings", "setApiInfo mContext == null");
        } else if (i == 9) {
            try {
                HashMap g = g();
                if (g == null || !g.containsKey("com.baidu.pushservice" + str)) {
                    return;
                }
                g.remove("com.baidu.pushservice" + str);
                a(g);
                Settings.System.putString(f686a.getContentResolver(), "com.baidu.pushservice" + str, "");
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
                hashMap = g();
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
            Settings.System.putString(f686a.getContentResolver(), "com.baidu.pushservice" + str, str3);
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
        if (f686a == null) {
            Log.e("PushSettings", "getChannelToken mContext == null");
            return "";
        }
        return Settings.System.getString(f686a.getContentResolver(), "com.baidu.pushservice.channel_token_rsa");
    }

    public static String b(String str) {
        if (f686a == null) {
            Log.e("PushSettings", "setApiInfo mContext == null");
            return "";
        }
        String string = Settings.System.getString(f686a.getContentResolver(), "com.baidu.pushservice" + str);
        if (TextUtils.isEmpty(string)) {
            try {
                string = (String) g().get("com.baidu.pushservice" + str);
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

    public static void b(int i) {
        if (f686a == null) {
            Log.w("PushSettings", "setStatisticSendDisabled mContext == null");
        } else {
            Settings.System.putInt(f686a.getContentResolver(), "com.baidu.pushservice.sd", i);
        }
    }

    public static void b(long j) {
        if (f686a == null) {
            Log.w("PushSettings", "setLastSendLbsTime mContext == null");
        } else {
            Settings.System.putLong(f686a.getContentResolver(), "com.baidu.pushservice.clt", j);
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

    public static long c(Context context) {
        if (context == null) {
            Log.e("PushSettings", "getLastSendStatisticTime mContext == null");
            return 0L;
        }
        try {
            return Settings.System.getLong(context.getContentResolver(), "com.baidu.pushservice.cst");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void c(long j) {
        if (f686a == null) {
            Log.w("PushSettings", "setLastSendStatisticTime mContext == null");
        } else {
            Settings.System.putLong(f686a.getContentResolver(), "com.baidu.pushservice.st", j);
        }
    }

    public static void c(String str) {
        if (f686a == null) {
            Log.e("PushSettings", "setChannelToken mContext == null");
        } else {
            Settings.System.putString(f686a.getContentResolver(), "com.baidu.pushservice.channel_token_rsa", str);
        }
    }

    public static boolean c() {
        if (f686a == null) {
            return false;
        }
        try {
            return Settings.System.getInt(f686a.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }

    public static int d() {
        if (f686a == null) {
            Log.e("PushSettings", "getCurPeriod mContext == null");
            return 0;
        }
        try {
            return Settings.System.getInt(f686a.getContentResolver(), "com.baidu.pushservice.cur_period");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long d(Context context) {
        if (context == null) {
            Log.e("PushSettings", "getLastSendLbsTime mContext == null");
            return 0L;
        }
        try {
            return Settings.System.getLong(context.getContentResolver(), "com.baidu.pushservice.clt");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static int e() {
        return Settings.System.getInt(f686a.getContentResolver(), "com.baidu.pushservice.sd", 0);
    }

    public static void e(Context context) {
        if (context == null) {
            Log.w("PushSettings", "refreshLbsSwitchInfo mContext == null");
            return;
        }
        String string = Settings.System.getString(context.getContentResolver(), "com.baidu.pushservice.le");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = string.trim().split(",");
        PackageManager packageManager = context.getPackageManager();
        for (String str : split) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("PushSettings", Log.getStackTraceString(e));
            }
            if (packageInfo != null) {
                sb.append(str + ",");
            }
        }
        Settings.System.putString(f686a.getContentResolver(), "com.baidu.pushservice.le", sb.toString());
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

    public static boolean f() {
        return !TextUtils.isEmpty(Settings.System.getString(f686a.getContentResolver(), "com.baidu.pushservice.le"));
    }

    private static HashMap g() {
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
}
