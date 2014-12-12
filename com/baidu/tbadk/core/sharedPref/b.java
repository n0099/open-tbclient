package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String Gt = null;
    private SharedPreferences Gu = null;
    private String Gv = null;
    private String Gx = null;
    private static b Gs = null;
    private static ContentResolver mContentResolver = null;
    private static HashMap<String, String> Gw = null;

    private b() {
        Gw = new HashMap<>();
        Gw.put(a.Gn, TbConfig.SETTINGFILE);
        Gw.put(a.Go, "remote_settings");
        Gw.put(a.Gp, "bdservice_settings");
        mContentResolver = TbadkCoreApplication.m255getInst().getApp().getContentResolver();
    }

    public static void cv() {
        if (Gw != null) {
            Gw.clear();
        }
        Gs = null;
    }

    public static synchronized b og() {
        b bVar;
        synchronized (b.class) {
            if (Gs == null) {
                Gs = new b();
            }
            bVar = Gs;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cb(str)) {
            String value = getValue(str);
            if (value != null) {
                try {
                    return Boolean.parseBoolean(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            return z;
        }
        this.Gu = getSharedPreferences();
        return this.Gu.getBoolean(str, z);
    }

    public boolean g(String str, boolean z) {
        String value = getValue(str);
        if (value != null) {
            try {
                return Boolean.parseBoolean(value);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return z;
            }
        }
        return z;
    }

    public int getInt(String str, int i) {
        if (cb(str)) {
            String value = getValue(str);
            if (value != null) {
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            return i;
        }
        this.Gu = getSharedPreferences();
        return this.Gu.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cb(str)) {
            String value = getValue(str);
            if (value != null) {
                try {
                    return Long.parseLong(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            return j;
        }
        this.Gu = getSharedPreferences();
        return this.Gu.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cb(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Gu = getSharedPreferences();
        return this.Gu.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cb(str)) {
            i(str, z);
            return;
        }
        this.Gu = getSharedPreferences();
        EditorHelper.putBoolean(this.Gu, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cb(str)) {
            R(str, str2);
            return;
        }
        this.Gu = getSharedPreferences();
        EditorHelper.putString(this.Gu, str, str2);
    }

    public void putInt(String str, int i) {
        if (cb(str)) {
            l(str, i);
            return;
        }
        this.Gu = getSharedPreferences();
        EditorHelper.putInt(this.Gu, str, i);
    }

    public void putLong(String str, long j) {
        if (cb(str)) {
            d(str, j);
            return;
        }
        this.Gu = getSharedPreferences();
        EditorHelper.putLong(this.Gu, str, j);
    }

    public void remove(String str) {
        if (cb(str)) {
            removeValue(str);
            return;
        }
        this.Gu = getSharedPreferences();
        EditorHelper.remove(this.Gu, str);
    }

    private boolean cb(String str) {
        if (str == null || str.length() == 0 || TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
            return false;
        }
        int length = a.Gq.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Gq[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(oj()) + str));
    }

    private void R(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(oj()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void l(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(oj()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void d(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(oj()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(oj()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(oj()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Gv == null || this.Gv.length() == 0) {
            if (this.Gt == null || this.Gt.length() == 0) {
                this.Gt = oh();
            }
            if (Gw.containsKey(this.Gt)) {
                this.Gv = Gw.get(this.Gt);
            } else {
                this.Gv = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m255getInst().getApp().getSharedPreferences(this.Gv, 0);
    }

    private String oh() {
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.m255getInst().getApp().getSystemService("activity");
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
        return a.Gn;
    }

    public void oi() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m255getInst().getApp().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            og().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                og().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                og().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                og().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                og().putString("client_id", string5);
            }
        }
    }

    protected String oj() {
        if (this.Gx == null) {
            String packageName = TbadkCoreApplication.m255getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.Gx = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Gx = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Gx;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (l.fu()) {
            com.baidu.adp.lib.g.l.em().c(new c(this, uri, contentValues));
        } else {
            b(uri, contentValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Uri uri, ContentValues contentValues) {
        try {
            mContentResolver.insert(uri, contentValues);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }

    protected String b(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void c(Uri uri) {
        if (l.fu()) {
            com.baidu.adp.lib.g.l.em().c(new d(this, uri));
        } else {
            d(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Uri uri) {
        try {
            mContentResolver.delete(uri, null, null);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }
}
