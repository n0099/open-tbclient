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
    private String YZ = null;
    private SharedPreferences Za = null;
    private String Zb = null;
    private String Zd = null;
    private static b YX = null;
    private static ContentResolver mContentResolver = null;
    public static boolean YY = true;
    private static HashMap<String, String> Zc = null;

    private b() {
        Zc = new HashMap<>();
        Zc.put(a.YM, TbConfig.SETTINGFILE);
        Zc.put(a.YN, "remote_settings");
        Zc.put(a.YO, "bdservice_settings");
        Zc.put(a.YP, a.YS);
        Zc.put(a.YQ, a.YT);
        Zc.put(a.YR, a.YU);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b tZ() {
        b bVar;
        synchronized (b.class) {
            if (YX == null) {
                YX = new b();
            }
            bVar = YX;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cH(str)) {
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
        this.Za = getSharedPreferences();
        return this.Za.getBoolean(str, z);
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
        if (cH(str)) {
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
        this.Za = getSharedPreferences();
        return this.Za.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cH(str)) {
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
        this.Za = getSharedPreferences();
        return this.Za.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cH(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Za = getSharedPreferences();
        return this.Za.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cH(str)) {
            j(str, z);
            return;
        }
        this.Za = getSharedPreferences();
        EditorHelper.putBoolean(this.Za, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cH(str)) {
            U(str, str2);
            return;
        }
        this.Za = getSharedPreferences();
        EditorHelper.putString(this.Za, str, str2);
    }

    public void putInt(String str, int i) {
        if (cH(str)) {
            o(str, i);
            return;
        }
        this.Za = getSharedPreferences();
        EditorHelper.putInt(this.Za, str, i);
    }

    public void putLong(String str, long j) {
        if (cH(str)) {
            f(str, j);
            return;
        }
        this.Za = getSharedPreferences();
        EditorHelper.putLong(this.Za, str, j);
    }

    public void remove(String str) {
        if (cH(str)) {
            removeValue(str);
            return;
        }
        this.Za = getSharedPreferences();
        EditorHelper.remove(this.Za, str);
    }

    private boolean cH(String str) {
        if (str == null || str.length() == 0 || !YY) {
            return false;
        }
        int length = a.YV.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.YV[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(ub()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(ub()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void o(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(ub()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(ub()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(ub()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(ub()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Zb == null || this.Zb.length() == 0) {
            if (this.YZ == null || this.YZ.length() == 0) {
                this.YZ = hr();
            }
            if (Zc.containsKey(this.YZ)) {
                this.Zb = Zc.get(this.YZ);
            } else {
                this.Zb = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.Zb, 0);
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
        return a.YM;
    }

    public void ua() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tZ().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tZ().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tZ().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                tZ().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tZ().putString("client_id", string5);
            }
        }
    }

    protected String ub() {
        if (this.Zd == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Zd = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Zd = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Zd;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.jf()) {
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
        if (k.jf()) {
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
