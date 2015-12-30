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
    private String ZC = null;
    private SharedPreferences ZD = null;
    private String ZE = null;
    private String ZG = null;
    private static b ZA = null;
    private static ContentResolver mContentResolver = null;
    public static boolean ZB = true;
    private static HashMap<String, String> ZF = null;

    private b() {
        ZF = new HashMap<>();
        ZF.put(a.Zp, TbConfig.SETTINGFILE);
        ZF.put(a.Zq, "remote_settings");
        ZF.put(a.Zr, "bdservice_settings");
        ZF.put(a.Zs, a.Zv);
        ZF.put(a.Zt, a.Zw);
        ZF.put(a.Zu, a.Zx);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b tJ() {
        b bVar;
        synchronized (b.class) {
            if (ZA == null) {
                ZA = new b();
            }
            bVar = ZA;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cK(str)) {
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
        this.ZD = getSharedPreferences();
        return this.ZD.getBoolean(str, z);
    }

    public boolean h(String str, boolean z) {
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
        if (cK(str)) {
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
        this.ZD = getSharedPreferences();
        return this.ZD.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cK(str)) {
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
        this.ZD = getSharedPreferences();
        return this.ZD.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cK(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.ZD = getSharedPreferences();
        return this.ZD.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cK(str)) {
            j(str, z);
            return;
        }
        this.ZD = getSharedPreferences();
        EditorHelper.putBoolean(this.ZD, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cK(str)) {
            T(str, str2);
            return;
        }
        this.ZD = getSharedPreferences();
        EditorHelper.putString(this.ZD, str, str2);
    }

    public void putInt(String str, int i) {
        if (cK(str)) {
            o(str, i);
            return;
        }
        this.ZD = getSharedPreferences();
        EditorHelper.putInt(this.ZD, str, i);
    }

    public void putLong(String str, long j) {
        if (cK(str)) {
            f(str, j);
            return;
        }
        this.ZD = getSharedPreferences();
        EditorHelper.putLong(this.ZD, str, j);
    }

    public void remove(String str) {
        if (cK(str)) {
            removeValue(str);
            return;
        }
        this.ZD = getSharedPreferences();
        EditorHelper.remove(this.ZD, str);
    }

    private boolean cK(String str) {
        if (str == null || str.length() == 0 || !ZB) {
            return false;
        }
        int length = a.Zy.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Zy[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(tL()) + str));
    }

    private void T(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tL()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void o(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tL()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tL()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tL()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(tL()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.ZE == null || this.ZE.length() == 0) {
            if (this.ZC == null || this.ZC.length() == 0) {
                this.ZC = hr();
            }
            if (ZF.containsKey(this.ZC)) {
                this.ZE = ZF.get(this.ZC);
            } else {
                this.ZE = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.ZE, 0);
    }

    private String hr() {
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
        return a.Zp;
    }

    public void tK() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tJ().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tJ().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tJ().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                tJ().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tJ().putString("client_id", string5);
            }
        }
    }

    protected String tL() {
        if (this.ZG == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.ZG = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.ZG = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.ZG;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.jg()) {
            com.baidu.adp.lib.h.k.hk().c(new c(this, uri, contentValues));
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
        if (k.jg()) {
            com.baidu.adp.lib.h.k.hk().c(new d(this, uri));
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
