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
    private String Yq = null;
    private SharedPreferences Yr = null;
    private String Ys = null;
    private String Yu = null;
    private static b Yo = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Yp = true;
    private static HashMap<String, String> Yt = null;

    private b() {
        Yt = new HashMap<>();
        Yt.put(a.Yd, TbConfig.SETTINGFILE);
        Yt.put(a.Ye, "remote_settings");
        Yt.put(a.Yf, "bdservice_settings");
        Yt.put(a.Yg, a.Yj);
        Yt.put(a.Yh, a.Yk);
        Yt.put(a.Yi, a.Yl);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b tx() {
        b bVar;
        synchronized (b.class) {
            if (Yo == null) {
                Yo = new b();
            }
            bVar = Yo;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cy(str)) {
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
        this.Yr = getSharedPreferences();
        return this.Yr.getBoolean(str, z);
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
        if (cy(str)) {
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
        this.Yr = getSharedPreferences();
        return this.Yr.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cy(str)) {
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
        this.Yr = getSharedPreferences();
        return this.Yr.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cy(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Yr = getSharedPreferences();
        return this.Yr.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cy(str)) {
            i(str, z);
            return;
        }
        this.Yr = getSharedPreferences();
        EditorHelper.putBoolean(this.Yr, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cy(str)) {
            Y(str, str2);
            return;
        }
        this.Yr = getSharedPreferences();
        EditorHelper.putString(this.Yr, str, str2);
    }

    public void putInt(String str, int i) {
        if (cy(str)) {
            o(str, i);
            return;
        }
        this.Yr = getSharedPreferences();
        EditorHelper.putInt(this.Yr, str, i);
    }

    public void putLong(String str, long j) {
        if (cy(str)) {
            f(str, j);
            return;
        }
        this.Yr = getSharedPreferences();
        EditorHelper.putLong(this.Yr, str, j);
    }

    public void remove(String str) {
        if (cy(str)) {
            removeValue(str);
            return;
        }
        this.Yr = getSharedPreferences();
        EditorHelper.remove(this.Yr, str);
    }

    private boolean cy(String str) {
        if (str == null || str.length() == 0 || !Yp) {
            return false;
        }
        int length = a.Ym.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Ym[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(tz()) + str));
    }

    private void Y(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tz()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void o(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tz()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tz()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tz()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(tz()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Ys == null || this.Ys.length() == 0) {
            if (this.Yq == null || this.Yq.length() == 0) {
                this.Yq = hn();
            }
            if (Yt.containsKey(this.Yq)) {
                this.Ys = Yt.get(this.Yq);
            } else {
                this.Ys = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.Ys, 0);
    }

    private String hn() {
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
        return a.Yd;
    }

    public void ty() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tx().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tx().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tx().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                tx().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tx().putString("client_id", string5);
            }
        }
    }

    protected String tz() {
        if (this.Yu == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Yu = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Yu = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Yu;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.jb()) {
            com.baidu.adp.lib.g.k.hg().c(new c(this, uri, contentValues));
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
        if (k.jb()) {
            com.baidu.adp.lib.g.k.hg().c(new d(this, uri));
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
