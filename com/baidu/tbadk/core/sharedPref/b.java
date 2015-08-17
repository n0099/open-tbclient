package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String Yh = null;
    private SharedPreferences Yi = null;
    private String Yj = null;
    private String Yl = null;
    private static b Yf = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Yg = true;
    private static HashMap<String, String> Yk = null;

    private b() {
        Yk = new HashMap<>();
        Yk.put(a.XU, TbConfig.SETTINGFILE);
        Yk.put(a.XV, "remote_settings");
        Yk.put(a.XW, "bdservice_settings");
        Yk.put(a.XX, a.Ya);
        Yk.put(a.XY, a.Yb);
        Yk.put(a.XZ, a.Yc);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b ts() {
        b bVar;
        synchronized (b.class) {
            if (Yf == null) {
                Yf = new b();
            }
            bVar = Yf;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cs(str)) {
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
        this.Yi = getSharedPreferences();
        return this.Yi.getBoolean(str, z);
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
        if (cs(str)) {
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
        this.Yi = getSharedPreferences();
        return this.Yi.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cs(str)) {
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
        this.Yi = getSharedPreferences();
        return this.Yi.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cs(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Yi = getSharedPreferences();
        return this.Yi.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cs(str)) {
            i(str, z);
            return;
        }
        this.Yi = getSharedPreferences();
        EditorHelper.putBoolean(this.Yi, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cs(str)) {
            Y(str, str2);
            return;
        }
        this.Yi = getSharedPreferences();
        EditorHelper.putString(this.Yi, str, str2);
    }

    public void putInt(String str, int i) {
        if (cs(str)) {
            o(str, i);
            return;
        }
        this.Yi = getSharedPreferences();
        EditorHelper.putInt(this.Yi, str, i);
    }

    public void putLong(String str, long j) {
        if (cs(str)) {
            f(str, j);
            return;
        }
        this.Yi = getSharedPreferences();
        EditorHelper.putLong(this.Yi, str, j);
    }

    public void remove(String str) {
        if (cs(str)) {
            removeValue(str);
            return;
        }
        this.Yi = getSharedPreferences();
        EditorHelper.remove(this.Yi, str);
    }

    private boolean cs(String str) {
        if (str == null || str.length() == 0 || !Yg) {
            return false;
        }
        int length = a.Yd.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Yd[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(tu()) + str));
    }

    private void Y(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tu()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void o(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tu()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tu()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tu()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(tu()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Yj == null || this.Yj.length() == 0) {
            if (this.Yh == null || this.Yh.length() == 0) {
                this.Yh = hq();
            }
            if (Yk.containsKey(this.Yh)) {
                this.Yj = Yk.get(this.Yh);
            } else {
                this.Yj = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.Yj, 0);
    }

    private String hq() {
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.m411getInst().getSystemService("activity");
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
        return a.XU;
    }

    public void tt() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            ts().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                ts().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                ts().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                ts().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                ts().putString("client_id", string5);
            }
        }
    }

    protected String tu() {
        if (this.Yl == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Yl = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Yl = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Yl;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.je()) {
            com.baidu.adp.lib.g.k.hj().c(new c(this, uri, contentValues));
        } else {
            b(uri, contentValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Uri uri, ContentValues contentValues) {
        try {
            mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
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
        if (k.je()) {
            com.baidu.adp.lib.g.k.hj().c(new d(this, uri));
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
