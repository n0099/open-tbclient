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
    private String adn = null;
    private SharedPreferences ado = null;
    private String adp = null;
    private String adr = null;
    private static b adl = null;
    private static ContentResolver mContentResolver = null;
    public static boolean adm = true;
    private static HashMap<String, String> adq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        adq = new HashMap<>();
        adq.put(a.acZ, TbConfig.SETTINGFILE);
        adq.put(a.ada, "remote_settings");
        adq.put(a.adb, "bdservice_settings");
        adq.put(a.adc, a.adg);
        adq.put(a.ade, a.adh);
        adq.put(a.adf, a.adi);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b uL() {
        b bVar;
        synchronized (b.class) {
            if (adl == null) {
                adl = new b();
            }
            bVar = adl;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cO(str)) {
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
        this.ado = getSharedPreferences();
        return this.ado.getBoolean(str, z);
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
        if (cO(str)) {
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
        this.ado = getSharedPreferences();
        return this.ado.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cO(str)) {
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
        this.ado = getSharedPreferences();
        return this.ado.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cO(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.ado = getSharedPreferences();
        return this.ado.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cO(str)) {
            j(str, z);
            return;
        }
        this.ado = getSharedPreferences();
        EditorHelper.putBoolean(this.ado, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cO(str)) {
            T(str, str2);
            return;
        }
        this.ado = getSharedPreferences();
        EditorHelper.putString(this.ado, str, str2);
    }

    public void putInt(String str, int i) {
        if (cO(str)) {
            q(str, i);
            return;
        }
        this.ado = getSharedPreferences();
        EditorHelper.putInt(this.ado, str, i);
    }

    public void putLong(String str, long j) {
        if (cO(str)) {
            f(str, j);
            return;
        }
        this.ado = getSharedPreferences();
        EditorHelper.putLong(this.ado, str, j);
    }

    public void remove(String str) {
        if (cO(str)) {
            removeValue(str);
            return;
        }
        this.ado = getSharedPreferences();
        EditorHelper.remove(this.ado, str);
    }

    private boolean cO(String str) {
        if (str == null || str.length() == 0 || !adm) {
            return false;
        }
        int length = a.adj.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.adj[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(uN()) + str));
    }

    private void T(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(uN()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(uN()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(uN()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(uN()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(uN()) + str));
    }

    protected synchronized SharedPreferences getSharedPreferences() {
        if (this.adp == null || this.adp.length() == 0) {
            if (this.adn == null || this.adn.length() == 0) {
                this.adn = getProcessName();
            }
            if (adq.containsKey(this.adn)) {
                this.adp = adq.get(this.adn);
            } else {
                this.adp = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.adp, 0);
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
        return a.acZ;
    }

    public void uM() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            uL().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                uL().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                uL().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                uL().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                uL().putString("client_id", string5);
            }
        }
    }

    protected String uN() {
        if (this.adr == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.adr = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.adr = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.adr;
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

    public static String cP(String str) {
        return String.valueOf(str) + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
