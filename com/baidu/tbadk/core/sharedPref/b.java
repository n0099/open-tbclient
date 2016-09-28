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
    private String YC = null;
    private SharedPreferences YD = null;
    private String YE = null;
    private String YG = null;
    private static b YA = null;
    private static ContentResolver mContentResolver = null;
    public static boolean YB = true;
    private static HashMap<String, String> YF = null;

    private b() {
        YF = new HashMap<>();
        YF.put(a.Yp, TbConfig.SETTINGFILE);
        YF.put(a.Yq, "remote_settings");
        YF.put(a.Yr, "bdservice_settings");
        YF.put(a.Ys, a.Yv);
        YF.put(a.Yt, a.Yw);
        YF.put(a.Yu, a.Yx);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b uh() {
        b bVar;
        synchronized (b.class) {
            if (YA == null) {
                YA = new b();
            }
            bVar = YA;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cN(str)) {
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
        this.YD = getSharedPreferences();
        return this.YD.getBoolean(str, z);
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
        if (cN(str)) {
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
        this.YD = getSharedPreferences();
        return this.YD.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cN(str)) {
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
        this.YD = getSharedPreferences();
        return this.YD.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cN(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.YD = getSharedPreferences();
        return this.YD.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cN(str)) {
            j(str, z);
            return;
        }
        this.YD = getSharedPreferences();
        EditorHelper.putBoolean(this.YD, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cN(str)) {
            U(str, str2);
            return;
        }
        this.YD = getSharedPreferences();
        EditorHelper.putString(this.YD, str, str2);
    }

    public void putInt(String str, int i) {
        if (cN(str)) {
            q(str, i);
            return;
        }
        this.YD = getSharedPreferences();
        EditorHelper.putInt(this.YD, str, i);
    }

    public void putLong(String str, long j) {
        if (cN(str)) {
            f(str, j);
            return;
        }
        this.YD = getSharedPreferences();
        EditorHelper.putLong(this.YD, str, j);
    }

    public void remove(String str) {
        if (cN(str)) {
            removeValue(str);
            return;
        }
        this.YD = getSharedPreferences();
        EditorHelper.remove(this.YD, str);
    }

    private boolean cN(String str) {
        if (str == null || str.length() == 0 || !YB) {
            return false;
        }
        int length = a.Yy.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Yy[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(uk()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(uk()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(uk()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(uk()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(uk()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(uk()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.YE == null || this.YE.length() == 0) {
            if (this.YC == null || this.YC.length() == 0) {
                this.YC = eO();
            }
            if (YF.containsKey(this.YC)) {
                this.YE = YF.get(this.YC);
            } else {
                this.YE = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.YE, 0);
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
        return a.Yp;
    }

    public void uj() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            uh().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                uh().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                uh().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                uh().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                uh().putString("client_id", string5);
            }
        }
    }

    protected String uk() {
        if (this.YG == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.YG = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.YG = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.YG;
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

    public static String cO(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
