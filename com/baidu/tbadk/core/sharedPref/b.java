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
    private String GC = null;
    private SharedPreferences GD = null;
    private String GE = null;
    private String GG = null;
    private static b GB = null;
    private static ContentResolver mContentResolver = null;
    private static HashMap<String, String> GF = null;

    private b() {
        GF = new HashMap<>();
        GF.put(a.Gq, TbConfig.SETTINGFILE);
        GF.put(a.Gr, "remote_settings");
        GF.put(a.Gs, "bdservice_settings");
        GF.put(a.Gt, a.Gw);
        GF.put(a.Gu, a.Gx);
        GF.put(a.Gv, a.Gy);
        mContentResolver = TbadkCoreApplication.m255getInst().getApp().getContentResolver();
    }

    public static void ct() {
        if (GF != null) {
            GF.clear();
        }
        GB = null;
    }

    public static synchronized b oj() {
        b bVar;
        synchronized (b.class) {
            if (GB == null) {
                GB = new b();
            }
            bVar = GB;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (bZ(str)) {
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
        this.GD = getSharedPreferences();
        return this.GD.getBoolean(str, z);
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
        if (bZ(str)) {
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
        this.GD = getSharedPreferences();
        return this.GD.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (bZ(str)) {
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
        this.GD = getSharedPreferences();
        return this.GD.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (bZ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.GD = getSharedPreferences();
        return this.GD.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (bZ(str)) {
            i(str, z);
            return;
        }
        this.GD = getSharedPreferences();
        EditorHelper.putBoolean(this.GD, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (bZ(str)) {
            U(str, str2);
            return;
        }
        this.GD = getSharedPreferences();
        EditorHelper.putString(this.GD, str, str2);
    }

    public void putInt(String str, int i) {
        if (bZ(str)) {
            l(str, i);
            return;
        }
        this.GD = getSharedPreferences();
        EditorHelper.putInt(this.GD, str, i);
    }

    public void putLong(String str, long j) {
        if (bZ(str)) {
            d(str, j);
            return;
        }
        this.GD = getSharedPreferences();
        EditorHelper.putLong(this.GD, str, j);
    }

    public void remove(String str) {
        if (bZ(str)) {
            removeValue(str);
            return;
        }
        this.GD = getSharedPreferences();
        EditorHelper.remove(this.GD, str);
    }

    private boolean bZ(String str) {
        if (str == null || str.length() == 0 || TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
            return false;
        }
        int length = a.Gz.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Gz[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(om()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(om()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void l(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(om()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void d(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(om()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(om()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(om()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.GE == null || this.GE.length() == 0) {
            if (this.GC == null || this.GC.length() == 0) {
                this.GC = ok();
            }
            if (GF.containsKey(this.GC)) {
                this.GE = GF.get(this.GC);
            } else {
                this.GE = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m255getInst().getApp().getSharedPreferences(this.GE, 0);
    }

    private String ok() {
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
        return a.Gq;
    }

    public void ol() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m255getInst().getApp().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            oj().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                oj().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                oj().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                oj().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                oj().putString("client_id", string5);
            }
        }
    }

    protected String om() {
        if (this.GG == null) {
            String packageName = TbadkCoreApplication.m255getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.GG = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.GG = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.GG;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (l.ft()) {
            com.baidu.adp.lib.g.l.ek().c(new c(this, uri, contentValues));
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
        if (l.ft()) {
            com.baidu.adp.lib.g.l.ek().c(new d(this, uri));
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
