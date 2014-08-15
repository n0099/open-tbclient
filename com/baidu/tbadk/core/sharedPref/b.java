package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.e.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private static ContentResolver b = null;
    private static HashMap<String, String> f = null;
    private String c = null;
    private SharedPreferences d = null;
    private String e = null;
    private String g = null;

    private b() {
        f = new HashMap<>();
        f.put(a.a, TbConfig.SETTINGFILE);
        f.put(a.b, "remote_settings");
        f.put(a.c, "bdservice_settings");
        b = TbadkApplication.m252getInst().getApp().getContentResolver();
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

    public boolean a(String str, boolean z) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Boolean.parseBoolean(c);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            return z;
        }
        this.d = d();
        return this.d.getBoolean(str, z);
    }

    public int a(String str, int i) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Integer.parseInt(c);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            return i;
        }
        this.d = d();
        return this.d.getInt(str, i);
    }

    public long a(String str, long j) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Long.parseLong(c);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            return j;
        }
        this.d = d();
        return this.d.getLong(str, j);
    }

    public String a(String str, String str2) {
        if (b(str)) {
            String c = c(str);
            return c != null ? c : str2;
        }
        this.d = d();
        return this.d.getString(str, str2);
    }

    public void b(String str, boolean z) {
        if (b(str)) {
            c(str, z);
            return;
        }
        this.d = d();
        EditorHelper.putBoolean(this.d, str, z);
    }

    public void b(String str, String str2) {
        if (b(str)) {
            c(str, str2);
            return;
        }
        this.d = d();
        EditorHelper.putString(this.d, str, str2);
    }

    public void b(String str, int i) {
        if (b(str)) {
            c(str, i);
            return;
        }
        this.d = d();
        EditorHelper.putInt(this.d, str, i);
    }

    public void b(String str, long j) {
        if (b(str)) {
            c(str, j);
            return;
        }
        this.d = d();
        EditorHelper.putLong(this.d, str, j);
    }

    public void a(String str) {
        if (b(str)) {
            d(str);
            return;
        }
        this.d = d();
        EditorHelper.remove(this.d, str);
    }

    private boolean b(String str) {
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

    private String c(String str) {
        return a(Uri.parse(String.valueOf(c()) + str));
    }

    private void c(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(c()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void c(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(c()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void c(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(c()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void c(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(c()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void d(String str) {
        b(Uri.parse(String.valueOf(c()) + str));
    }

    private synchronized SharedPreferences d() {
        if (this.e == null || this.e.length() == 0) {
            if (this.c == null || this.c.length() == 0) {
                this.c = e();
            }
            if (f.containsKey(this.c)) {
                this.e = f.get(this.c);
            } else {
                this.e = TbConfig.SETTINGFILE;
            }
        }
        return TbadkApplication.m252getInst().getApp().getSharedPreferences(this.e, 0);
    }

    private String e() {
        ActivityManager activityManager = (ActivityManager) TbadkApplication.m252getInst().getApp().getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= runningAppProcesses.size()) {
                        break;
                    } else if (runningAppProcesses.get(i2).pid != myPid) {
                        i = i2 + 1;
                    } else {
                        return runningAppProcesses.get(i2).processName;
                    }
                }
            }
        }
        return a.a;
    }

    public void b() {
        SharedPreferences sharedPreferences = TbadkApplication.m252getInst().getApp().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
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

    protected String c() {
        if (this.g == null) {
            String packageName = TbadkApplication.m252getInst().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.g = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.g = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.g;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (j.b()) {
            e.a().a(new c(this, uri, contentValues));
        } else {
            b(uri, contentValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Uri uri, ContentValues contentValues) {
        try {
            b.insert(uri, contentValues);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }

    protected String a(Uri uri) {
        try {
            return b.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void b(Uri uri) {
        if (j.b()) {
            e.a().a(new d(this, uri));
        } else {
            c(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Uri uri) {
        try {
            b.delete(uri, null, null);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }
}
