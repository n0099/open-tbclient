package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String Ch = null;
    private SharedPreferences Ci = null;
    private String Cj = null;
    private String Cl = null;
    private static b Cg = null;
    private static ContentResolver mContentResolver = null;
    private static HashMap<String, String> Ck = null;

    private b() {
        Ck = new HashMap<>();
        Ck.put(a.Cb, TbConfig.SETTINGFILE);
        Ck.put(a.Cc, "remote_settings");
        Ck.put(a.Cd, "bdservice_settings");
        mContentResolver = TbadkApplication.m251getInst().getApp().getContentResolver();
    }

    public static synchronized b lk() {
        b bVar;
        synchronized (b.class) {
            if (Cg == null) {
                Cg = new b();
            }
            bVar = Cg;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (bj(str)) {
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
        this.Ci = getSharedPreferences();
        return this.Ci.getBoolean(str, z);
    }

    public boolean e(String str, boolean z) {
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
        if (bj(str)) {
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
        this.Ci = getSharedPreferences();
        return this.Ci.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (bj(str)) {
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
        this.Ci = getSharedPreferences();
        return this.Ci.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (bj(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Ci = getSharedPreferences();
        return this.Ci.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (bj(str)) {
            g(str, z);
            return;
        }
        this.Ci = getSharedPreferences();
        EditorHelper.putBoolean(this.Ci, str, z);
    }

    public void f(String str, boolean z) {
        g(str, z);
    }

    public void putString(String str, String str2) {
        if (bj(str)) {
            H(str, str2);
            return;
        }
        this.Ci = getSharedPreferences();
        EditorHelper.putString(this.Ci, str, str2);
    }

    public void putInt(String str, int i) {
        if (bj(str)) {
            l(str, i);
            return;
        }
        this.Ci = getSharedPreferences();
        EditorHelper.putInt(this.Ci, str, i);
    }

    public void putLong(String str, long j) {
        if (bj(str)) {
            b(str, j);
            return;
        }
        this.Ci = getSharedPreferences();
        EditorHelper.putLong(this.Ci, str, j);
    }

    public void remove(String str) {
        if (bj(str)) {
            removeValue(str);
            return;
        }
        this.Ci = getSharedPreferences();
        EditorHelper.remove(this.Ci, str);
    }

    private boolean bj(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.Ce.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Ce[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return a(Uri.parse(String.valueOf(ln()) + str));
    }

    private void H(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(ln()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void l(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(ln()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void b(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(ln()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void g(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(ln()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        b(Uri.parse(String.valueOf(ln()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Cj == null || this.Cj.length() == 0) {
            if (this.Ch == null || this.Ch.length() == 0) {
                this.Ch = ll();
            }
            if (Ck.containsKey(this.Ch)) {
                this.Cj = Ck.get(this.Ch);
            } else {
                this.Cj = TbConfig.SETTINGFILE;
            }
        }
        return TbadkApplication.m251getInst().getApp().getSharedPreferences(this.Cj, 0);
    }

    private String ll() {
        ActivityManager activityManager = (ActivityManager) TbadkApplication.m251getInst().getApp().getSystemService("activity");
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
        return a.Cb;
    }

    public void lm() {
        SharedPreferences sharedPreferences = TbadkApplication.m251getInst().getApp().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            lk().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                lk().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                lk().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                lk().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                lk().putString("client_id", string5);
            }
        }
    }

    protected String ln() {
        if (this.Cl == null) {
            String packageName = TbadkApplication.m251getInst().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.Cl = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Cl = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Cl;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (m.fu()) {
            k.el().b(new c(this, uri, contentValues));
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

    protected String a(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void b(Uri uri) {
        if (m.fu()) {
            k.el().b(new d(this, uri));
        } else {
            c(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Uri uri) {
        try {
            mContentResolver.delete(uri, null, null);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }
}
