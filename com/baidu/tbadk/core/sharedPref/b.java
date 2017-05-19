package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String acI = null;
    private SharedPreferences acJ = null;
    private String acK = null;
    private String acM = null;
    private static b acG = null;
    private static ContentResolver mContentResolver = null;
    public static boolean acH = true;
    private static HashMap<String, String> acL = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        acL = new HashMap<>();
        acL.put(a.acv, TbConfig.SETTINGFILE);
        acL.put(a.acw, "remote_settings");
        acL.put(a.acx, "bdservice_settings");
        acL.put(a.acy, a.acB);
        acL.put(a.acz, a.acC);
        acL.put(a.acA, a.acD);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b tX() {
        b bVar;
        synchronized (b.class) {
            if (acG == null) {
                acG = new b();
            }
            bVar = acG;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cM(str)) {
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
        this.acJ = getSharedPreferences();
        return this.acJ.getBoolean(str, z);
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
        if (cM(str)) {
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
        this.acJ = getSharedPreferences();
        return this.acJ.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cM(str)) {
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
        this.acJ = getSharedPreferences();
        return this.acJ.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cM(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.acJ = getSharedPreferences();
        return this.acJ.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cM(str)) {
            j(str, z);
            return;
        }
        this.acJ = getSharedPreferences();
        EditorHelper.putBoolean(this.acJ, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cM(str)) {
            T(str, str2);
            return;
        }
        this.acJ = getSharedPreferences();
        EditorHelper.putString(this.acJ, str, str2);
    }

    public void putInt(String str, int i) {
        if (cM(str)) {
            q(str, i);
            return;
        }
        this.acJ = getSharedPreferences();
        EditorHelper.putInt(this.acJ, str, i);
    }

    public void putLong(String str, long j) {
        if (cM(str)) {
            f(str, j);
            return;
        }
        this.acJ = getSharedPreferences();
        EditorHelper.putLong(this.acJ, str, j);
    }

    public void remove(String str) {
        if (cM(str)) {
            removeValue(str);
            return;
        }
        this.acJ = getSharedPreferences();
        EditorHelper.remove(this.acJ, str);
    }

    private boolean cM(String str) {
        if (str == null || str.length() == 0 || !acH) {
            return false;
        }
        int length = a.acE.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.acE[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(tZ()) + str));
    }

    private void T(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(tZ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(tZ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(tZ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(tZ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(tZ()) + str));
    }

    protected synchronized SharedPreferences getSharedPreferences() {
        if (this.acK == null || this.acK.length() == 0) {
            if (this.acI == null || this.acI.length() == 0) {
                this.acI = getProcessName();
            }
            if (acL.containsKey(this.acI)) {
                this.acK = acL.get(this.acI);
            } else {
                this.acK = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.acK, 0);
    }

    private String getProcessName() {
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
        return a.acv;
    }

    public void tY() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            tX().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                tX().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                tX().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                tX().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                tX().putString("client_id", string5);
            }
        }
    }

    protected String tZ() {
        if (this.acM == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.acM = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.acM = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.acM;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.hA()) {
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
        if (k.hA()) {
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

    public static String cN(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
