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
    private String Za = null;
    private SharedPreferences Zb = null;
    private String Zc = null;
    private String Ze = null;
    private static b YY = null;
    private static ContentResolver mContentResolver = null;
    public static boolean YZ = true;
    private static HashMap<String, String> Zd = null;

    private b() {
        Zd = new HashMap<>();
        Zd.put(a.YN, TbConfig.SETTINGFILE);
        Zd.put(a.YO, "remote_settings");
        Zd.put(a.YP, "bdservice_settings");
        Zd.put(a.YQ, a.YT);
        Zd.put(a.YR, a.YU);
        Zd.put(a.YS, a.YV);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b um() {
        b bVar;
        synchronized (b.class) {
            if (YY == null) {
                YY = new b();
            }
            bVar = YY;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cP(str)) {
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
        this.Zb = getSharedPreferences();
        return this.Zb.getBoolean(str, z);
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
        if (cP(str)) {
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
        this.Zb = getSharedPreferences();
        return this.Zb.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cP(str)) {
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
        this.Zb = getSharedPreferences();
        return this.Zb.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cP(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Zb = getSharedPreferences();
        return this.Zb.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cP(str)) {
            j(str, z);
            return;
        }
        this.Zb = getSharedPreferences();
        EditorHelper.putBoolean(this.Zb, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cP(str)) {
            U(str, str2);
            return;
        }
        this.Zb = getSharedPreferences();
        EditorHelper.putString(this.Zb, str, str2);
    }

    public void putInt(String str, int i) {
        if (cP(str)) {
            q(str, i);
            return;
        }
        this.Zb = getSharedPreferences();
        EditorHelper.putInt(this.Zb, str, i);
    }

    public void putLong(String str, long j) {
        if (cP(str)) {
            f(str, j);
            return;
        }
        this.Zb = getSharedPreferences();
        EditorHelper.putLong(this.Zb, str, j);
    }

    public void remove(String str) {
        if (cP(str)) {
            removeValue(str);
            return;
        }
        this.Zb = getSharedPreferences();
        EditorHelper.remove(this.Zb, str);
    }

    private boolean cP(String str) {
        if (str == null || str.length() == 0 || !YZ) {
            return false;
        }
        int length = a.YW.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.YW[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(uo()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(uo()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(uo()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(uo()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(uo()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(uo()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Zc == null || this.Zc.length() == 0) {
            if (this.Za == null || this.Za.length() == 0) {
                this.Za = eO();
            }
            if (Zd.containsKey(this.Za)) {
                this.Zc = Zd.get(this.Za);
            } else {
                this.Zc = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.Zc, 0);
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
        return a.YN;
    }

    public void un() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            um().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                um().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                um().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                um().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                um().putString("client_id", string5);
            }
        }
    }

    protected String uo() {
        if (this.Ze == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Ze = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Ze = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Ze;
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

    public static String cQ(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
