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
    private String acW = null;
    private SharedPreferences acX = null;
    private String acY = null;
    private String ada = null;
    private static b acU = null;
    private static ContentResolver mContentResolver = null;
    public static boolean acV = true;
    private static HashMap<String, String> acZ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        acZ = new HashMap<>();
        acZ.put(a.acJ, TbConfig.SETTINGFILE);
        acZ.put(a.acK, "remote_settings");
        acZ.put(a.acL, "bdservice_settings");
        acZ.put(a.acM, a.acP);
        acZ.put(a.acN, a.acQ);
        acZ.put(a.acO, a.acR);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b uo() {
        b bVar;
        synchronized (b.class) {
            if (acU == null) {
                acU = new b();
            }
            bVar = acU;
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
        this.acX = getSharedPreferences();
        return this.acX.getBoolean(str, z);
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
        this.acX = getSharedPreferences();
        return this.acX.getInt(str, i);
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
        this.acX = getSharedPreferences();
        return this.acX.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cH(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.acX = getSharedPreferences();
        return this.acX.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cH(str)) {
            j(str, z);
            return;
        }
        this.acX = getSharedPreferences();
        EditorHelper.putBoolean(this.acX, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cH(str)) {
            S(str, str2);
            return;
        }
        this.acX = getSharedPreferences();
        EditorHelper.putString(this.acX, str, str2);
    }

    public void putInt(String str, int i) {
        if (cH(str)) {
            q(str, i);
            return;
        }
        this.acX = getSharedPreferences();
        EditorHelper.putInt(this.acX, str, i);
    }

    public void putLong(String str, long j) {
        if (cH(str)) {
            f(str, j);
            return;
        }
        this.acX = getSharedPreferences();
        EditorHelper.putLong(this.acX, str, j);
    }

    public void remove(String str) {
        if (cH(str)) {
            removeValue(str);
            return;
        }
        this.acX = getSharedPreferences();
        EditorHelper.remove(this.acX, str);
    }

    private boolean cH(String str) {
        if (str == null || str.length() == 0 || !acV) {
            return false;
        }
        int length = a.acS.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.acS[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(uq()) + str));
    }

    private void S(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(uq()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(uq()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(uq()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(uq()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(uq()) + str));
    }

    protected synchronized SharedPreferences getSharedPreferences() {
        if (this.acY == null || this.acY.length() == 0) {
            if (this.acW == null || this.acW.length() == 0) {
                this.acW = getProcessName();
            }
            if (acZ.containsKey(this.acW)) {
                this.acY = acZ.get(this.acW);
            } else {
                this.acY = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.acY, 0);
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
        return a.acJ;
    }

    public void up() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            uo().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                uo().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                uo().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                uo().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                uo().putString("client_id", string5);
            }
        }
    }

    protected String uq() {
        if (this.ada == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.ada = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.ada = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.ada;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.hu()) {
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
        if (k.hu()) {
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

    public static String cI(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
