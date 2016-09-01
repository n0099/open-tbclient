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
    private String Yp = null;
    private SharedPreferences Yq = null;
    private String Yr = null;
    private String Yt = null;
    private static b Yn = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Yo = true;
    private static HashMap<String, String> Ys = null;

    private b() {
        Ys = new HashMap<>();
        Ys.put(a.Yc, TbConfig.SETTINGFILE);
        Ys.put(a.Yd, "remote_settings");
        Ys.put(a.Ye, "bdservice_settings");
        Ys.put(a.Yf, a.Yi);
        Ys.put(a.Yg, a.Yj);
        Ys.put(a.Yh, a.Yk);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b tS() {
        b bVar;
        synchronized (b.class) {
            if (Yn == null) {
                Yn = new b();
            }
            bVar = Yn;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cL(str)) {
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
        this.Yq = getSharedPreferences();
        return this.Yq.getBoolean(str, z);
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
        if (cL(str)) {
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
        this.Yq = getSharedPreferences();
        return this.Yq.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cL(str)) {
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
        this.Yq = getSharedPreferences();
        return this.Yq.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cL(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Yq = getSharedPreferences();
        return this.Yq.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cL(str)) {
            j(str, z);
            return;
        }
        this.Yq = getSharedPreferences();
        EditorHelper.putBoolean(this.Yq, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cL(str)) {
            U(str, str2);
            return;
        }
        this.Yq = getSharedPreferences();
        EditorHelper.putString(this.Yq, str, str2);
    }

    public void putInt(String str, int i) {
        if (cL(str)) {
            q(str, i);
            return;
        }
        this.Yq = getSharedPreferences();
        EditorHelper.putInt(this.Yq, str, i);
    }

    public void putLong(String str, long j) {
        if (cL(str)) {
            f(str, j);
            return;
        }
        this.Yq = getSharedPreferences();
        EditorHelper.putLong(this.Yq, str, j);
    }

    public void remove(String str) {
        if (cL(str)) {
            removeValue(str);
            return;
        }
        this.Yq = getSharedPreferences();
        EditorHelper.remove(this.Yq, str);
    }

    private boolean cL(String str) {
        if (str == null || str.length() == 0 || !Yo) {
            return false;
        }
        int length = a.Yl.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Yl[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(tU()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tU()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tU()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tU()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tU()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(tU()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Yr == null || this.Yr.length() == 0) {
            if (this.Yp == null || this.Yp.length() == 0) {
                this.Yp = eO();
            }
            if (Ys.containsKey(this.Yp)) {
                this.Yr = Ys.get(this.Yp);
            } else {
                this.Yr = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.Yr, 0);
    }

    private String eO() {
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.m9getInst().getSystemService("activity");
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
        return a.Yc;
    }

    public void tT() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tS().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tS().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tS().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                tS().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tS().putString("client_id", string5);
            }
        }
    }

    protected String tU() {
        if (this.Yt == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Yt = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Yt = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Yt;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.gC()) {
            com.baidu.adp.lib.h.k.eH().f(new c(this, uri, contentValues));
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

    protected String c(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void d(Uri uri) {
        if (k.gC()) {
            com.baidu.adp.lib.h.k.eH().f(new d(this, uri));
        } else {
            e(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Uri uri) {
        try {
            mContentResolver.delete(uri, null, null);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }

    public static String cM(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
