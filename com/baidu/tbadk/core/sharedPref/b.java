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
    private String Yu = null;
    private SharedPreferences Yv = null;
    private String Yw = null;
    private String Yy = null;
    private static b Ys = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Yt = true;
    private static HashMap<String, String> Yx = null;

    private b() {
        Yx = new HashMap<>();
        Yx.put(a.Yh, TbConfig.SETTINGFILE);
        Yx.put(a.Yi, "remote_settings");
        Yx.put(a.Yj, "bdservice_settings");
        Yx.put(a.Yk, a.Yn);
        Yx.put(a.Yl, a.Yo);
        Yx.put(a.Ym, a.Yp);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b tW() {
        b bVar;
        synchronized (b.class) {
            if (Ys == null) {
                Ys = new b();
            }
            bVar = Ys;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cQ(str)) {
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
        this.Yv = getSharedPreferences();
        return this.Yv.getBoolean(str, z);
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
        if (cQ(str)) {
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
        this.Yv = getSharedPreferences();
        return this.Yv.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cQ(str)) {
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
        this.Yv = getSharedPreferences();
        return this.Yv.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cQ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Yv = getSharedPreferences();
        return this.Yv.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cQ(str)) {
            j(str, z);
            return;
        }
        this.Yv = getSharedPreferences();
        EditorHelper.putBoolean(this.Yv, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cQ(str)) {
            U(str, str2);
            return;
        }
        this.Yv = getSharedPreferences();
        EditorHelper.putString(this.Yv, str, str2);
    }

    public void putInt(String str, int i) {
        if (cQ(str)) {
            q(str, i);
            return;
        }
        this.Yv = getSharedPreferences();
        EditorHelper.putInt(this.Yv, str, i);
    }

    public void putLong(String str, long j) {
        if (cQ(str)) {
            f(str, j);
            return;
        }
        this.Yv = getSharedPreferences();
        EditorHelper.putLong(this.Yv, str, j);
    }

    public void remove(String str) {
        if (cQ(str)) {
            removeValue(str);
            return;
        }
        this.Yv = getSharedPreferences();
        EditorHelper.remove(this.Yv, str);
    }

    private boolean cQ(String str) {
        if (str == null || str.length() == 0 || !Yt) {
            return false;
        }
        int length = a.Yq.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Yq[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(tY()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tY()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tY()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tY()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tY()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(tY()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Yw == null || this.Yw.length() == 0) {
            if (this.Yu == null || this.Yu.length() == 0) {
                this.Yu = eO();
            }
            if (Yx.containsKey(this.Yu)) {
                this.Yw = Yx.get(this.Yu);
            } else {
                this.Yw = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.Yw, 0);
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
        return a.Yh;
    }

    public void tX() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tW().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tW().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tW().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                tW().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tW().putString("client_id", string5);
            }
        }
    }

    protected String tY() {
        if (this.Yy == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Yy = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Yy = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Yy;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.gC()) {
            new c(this, uri, contentValues).execute(new Void[0]);
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
            new d(this, uri).execute(new Void[0]);
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

    public static String cR(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
