package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.g.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String Tm = null;
    private SharedPreferences Tn = null;
    private String To = null;
    private String Tq = null;
    private static b Tk = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Tl = true;
    private static HashMap<String, String> Tp = null;

    private b() {
        Tp = new HashMap<>();
        Tp.put(a.SZ, TbConfig.SETTINGFILE);
        Tp.put(a.Ta, "remote_settings");
        Tp.put(a.Tb, "bdservice_settings");
        Tp.put(a.Tc, a.Tf);
        Tp.put(a.Td, a.Tg);
        Tp.put(a.Te, a.Th);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b sl() {
        b bVar;
        synchronized (b.class) {
            if (Tk == null) {
                Tk = new b();
            }
            bVar = Tk;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cr(str)) {
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
        this.Tn = getSharedPreferences();
        return this.Tn.getBoolean(str, z);
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
        if (cr(str)) {
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
        this.Tn = getSharedPreferences();
        return this.Tn.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cr(str)) {
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
        this.Tn = getSharedPreferences();
        return this.Tn.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cr(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Tn = getSharedPreferences();
        return this.Tn.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cr(str)) {
            i(str, z);
            return;
        }
        this.Tn = getSharedPreferences();
        EditorHelper.putBoolean(this.Tn, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cr(str)) {
            Z(str, str2);
            return;
        }
        this.Tn = getSharedPreferences();
        EditorHelper.putString(this.Tn, str, str2);
    }

    public void putInt(String str, int i) {
        if (cr(str)) {
            m(str, i);
            return;
        }
        this.Tn = getSharedPreferences();
        EditorHelper.putInt(this.Tn, str, i);
    }

    public void putLong(String str, long j) {
        if (cr(str)) {
            f(str, j);
            return;
        }
        this.Tn = getSharedPreferences();
        EditorHelper.putLong(this.Tn, str, j);
    }

    public void remove(String str) {
        if (cr(str)) {
            removeValue(str);
            return;
        }
        this.Tn = getSharedPreferences();
        EditorHelper.remove(this.Tn, str);
    }

    private boolean cr(String str) {
        if (str == null || str.length() == 0 || !Tl) {
            return false;
        }
        int length = a.Ti.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Ti[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(sn()) + str));
    }

    private void Z(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(sn()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void m(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(sn()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(sn()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(sn()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(sn()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.To == null || this.To.length() == 0) {
            if (this.Tm == null || this.Tm.length() == 0) {
                this.Tm = iD();
            }
            if (Tp.containsKey(this.Tm)) {
                this.To = Tp.get(this.Tm);
            } else {
                this.To = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.To, 0);
    }

    private String iD() {
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
        return a.SZ;
    }

    public void sm() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            sl().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                sl().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                sl().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                sl().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                sl().putString("client_id", string5);
            }
        }
    }

    protected String sn() {
        if (this.Tq == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Tq = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Tq = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Tq;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (n.jl()) {
            l.ht().c(new c(this, uri, contentValues));
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
        if (n.jl()) {
            l.ht().c(new d(this, uri));
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
