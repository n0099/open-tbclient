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
    private String Yj = null;
    private SharedPreferences Yk = null;
    private String Yl = null;
    private String Yn = null;
    private static b Yh = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Yi = true;
    private static HashMap<String, String> Ym = null;

    private b() {
        Ym = new HashMap<>();
        Ym.put(a.XW, TbConfig.SETTINGFILE);
        Ym.put(a.XX, "remote_settings");
        Ym.put(a.XY, "bdservice_settings");
        Ym.put(a.XZ, a.Yc);
        Ym.put(a.Ya, a.Yd);
        Ym.put(a.Yb, a.Ye);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b tr() {
        b bVar;
        synchronized (b.class) {
            if (Yh == null) {
                Yh = new b();
            }
            bVar = Yh;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cz(str)) {
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
        this.Yk = getSharedPreferences();
        return this.Yk.getBoolean(str, z);
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
        if (cz(str)) {
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
        this.Yk = getSharedPreferences();
        return this.Yk.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cz(str)) {
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
        this.Yk = getSharedPreferences();
        return this.Yk.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cz(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Yk = getSharedPreferences();
        return this.Yk.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cz(str)) {
            i(str, z);
            return;
        }
        this.Yk = getSharedPreferences();
        EditorHelper.putBoolean(this.Yk, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cz(str)) {
            X(str, str2);
            return;
        }
        this.Yk = getSharedPreferences();
        EditorHelper.putString(this.Yk, str, str2);
    }

    public void putInt(String str, int i) {
        if (cz(str)) {
            o(str, i);
            return;
        }
        this.Yk = getSharedPreferences();
        EditorHelper.putInt(this.Yk, str, i);
    }

    public void putLong(String str, long j) {
        if (cz(str)) {
            f(str, j);
            return;
        }
        this.Yk = getSharedPreferences();
        EditorHelper.putLong(this.Yk, str, j);
    }

    public void remove(String str) {
        if (cz(str)) {
            removeValue(str);
            return;
        }
        this.Yk = getSharedPreferences();
        EditorHelper.remove(this.Yk, str);
    }

    private boolean cz(String str) {
        if (str == null || str.length() == 0 || !Yi) {
            return false;
        }
        int length = a.Yf.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Yf[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(tt()) + str));
    }

    private void X(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tt()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void o(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tt()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tt()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tt()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(tt()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Yl == null || this.Yl.length() == 0) {
            if (this.Yj == null || this.Yj.length() == 0) {
                this.Yj = ho();
            }
            if (Ym.containsKey(this.Yj)) {
                this.Yl = Ym.get(this.Yj);
            } else {
                this.Yl = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.Yl, 0);
    }

    private String ho() {
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
        return a.XW;
    }

    public void ts() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tr().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tr().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tr().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                tr().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tr().putString("client_id", string5);
            }
        }
    }

    protected String tt() {
        if (this.Yn == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Yn = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Yn = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Yn;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.jc()) {
            com.baidu.adp.lib.g.k.hh().c(new c(this, uri, contentValues));
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
        if (k.jc()) {
            com.baidu.adp.lib.g.k.hh().c(new d(this, uri));
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
