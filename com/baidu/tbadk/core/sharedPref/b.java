package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    private static b a = null;
    private static ContentResolver b = null;
    private static HashMap<String, String> f = null;
    private String c = null;
    private SharedPreferences d = null;
    private String e = null;

    private b() {
        HashMap<String, String> hashMap = new HashMap<>();
        f = hashMap;
        hashMap.put(a.a, "settings");
        f.put(a.b, "remote_settings");
        f.put(a.c, "bdservice_settings");
        b = TbadkApplication.j().b().getContentResolver();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public final boolean a(String str, boolean z) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Boolean.parseBoolean(c);
                } catch (NumberFormatException e) {
                    f.b("SharedPrefHelper", "getBoolean", "Convert error:" + c);
                    return z;
                }
            }
            return z;
        }
        this.d = c();
        return this.d.getBoolean(str, z);
    }

    public final int a(String str, int i) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Integer.parseInt(c);
                } catch (NumberFormatException e) {
                    f.b("SharedPrefHelper", "getInt", "Convert error:" + c);
                    return i;
                }
            }
            return i;
        }
        this.d = c();
        return this.d.getInt(str, i);
    }

    public final long a(String str, long j) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Long.parseLong(c);
                } catch (NumberFormatException e) {
                    f.b("SharedPrefHelper", "getLong", "Convert error:" + c);
                    return j;
                }
            }
            return j;
        }
        this.d = c();
        return this.d.getLong(str, j);
    }

    public final String a(String str, String str2) {
        if (b(str)) {
            String c = c(str);
            return c != null ? c : str2;
        }
        this.d = c();
        return this.d.getString(str, str2);
    }

    public final void b(String str, boolean z) {
        if (b(str)) {
            Uri parse = Uri.parse("content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/" + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            b.insert(parse, contentValues);
            return;
        }
        this.d = c();
        EditorHelper.putBoolean(this.d, str, z);
    }

    public final void b(String str, String str2) {
        if (b(str)) {
            Uri parse = Uri.parse("content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/" + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            b.insert(parse, contentValues);
            return;
        }
        this.d = c();
        EditorHelper.putString(this.d, str, str2);
    }

    public final void b(String str, int i) {
        if (b(str)) {
            Uri parse = Uri.parse("content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/" + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            b.insert(parse, contentValues);
            return;
        }
        this.d = c();
        EditorHelper.putInt(this.d, str, i);
    }

    public final void b(String str, long j) {
        if (b(str)) {
            Uri parse = Uri.parse("content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/" + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            b.insert(parse, contentValues);
            return;
        }
        this.d = c();
        EditorHelper.putLong(this.d, str, j);
    }

    public final void a(String str) {
        if (b(str)) {
            b.delete(Uri.parse("content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/" + str), null, null);
            return;
        }
        this.d = c();
        EditorHelper.remove(this.d, str);
    }

    private static boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.d.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.d[i])) {
                return true;
            }
        }
        return false;
    }

    private static String c(String str) {
        return b.getType(Uri.parse("content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/" + str));
    }

    private synchronized SharedPreferences c() {
        String str;
        SharedPreferences sharedPreferences;
        synchronized (this) {
            if (this.e == null || this.e.length() == 0) {
                if (this.c == null || this.c.length() == 0) {
                    ActivityManager activityManager = (ActivityManager) TbadkApplication.j().b().getSystemService("activity");
                    if (activityManager != null) {
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                        int myPid = Process.myPid();
                        if (runningAppProcesses != null) {
                            for (int i = 0; i < runningAppProcesses.size(); i++) {
                                if (runningAppProcesses.get(i).pid == myPid) {
                                    str = runningAppProcesses.get(i).processName;
                                    break;
                                }
                            }
                        }
                    }
                    str = a.a;
                    this.c = str;
                }
                if (f.containsKey(this.c)) {
                    this.e = f.get(this.c);
                } else {
                    this.e = "settings";
                }
            }
            sharedPreferences = TbadkApplication.j().b().getSharedPreferences(this.e, 0);
        }
        return sharedPreferences;
    }

    public static void b() {
        SharedPreferences sharedPreferences = TbadkApplication.j().b().getSharedPreferences("settings", 0);
        String string = sharedPreferences.getString("lase_version", "");
        String c = n.c();
        if (string != null && string.length() != 0 && c != null && c.length() != 0 && !string.equals(c) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(c) <= 0) {
            a().b("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                a().b("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                a().b("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                a().b("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                a().b("client_id", string5);
            }
        }
    }
}
