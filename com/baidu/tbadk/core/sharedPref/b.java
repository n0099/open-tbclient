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
    private String adm = null;
    private SharedPreferences adn = null;
    private String ado = null;
    private String adq = null;
    private static b adk = null;
    private static ContentResolver mContentResolver = null;
    public static boolean adl = true;
    private static HashMap<String, String> adp = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        adp = new HashMap<>();
        adp.put(a.acY, TbConfig.SETTINGFILE);
        adp.put(a.acZ, "remote_settings");
        adp.put(a.ada, "bdservice_settings");
        adp.put(a.adb, a.adf);
        adp.put(a.adc, a.adg);
        adp.put(a.ade, a.adh);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b uL() {
        b bVar;
        synchronized (b.class) {
            if (adk == null) {
                adk = new b();
            }
            bVar = adk;
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
        this.adn = getSharedPreferences();
        return this.adn.getBoolean(str, z);
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
        this.adn = getSharedPreferences();
        return this.adn.getInt(str, i);
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
        this.adn = getSharedPreferences();
        return this.adn.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cO(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.adn = getSharedPreferences();
        return this.adn.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cO(str)) {
            j(str, z);
            return;
        }
        this.adn = getSharedPreferences();
        EditorHelper.putBoolean(this.adn, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cO(str)) {
            T(str, str2);
            return;
        }
        this.adn = getSharedPreferences();
        EditorHelper.putString(this.adn, str, str2);
    }

    public void putInt(String str, int i) {
        if (cO(str)) {
            q(str, i);
            return;
        }
        this.adn = getSharedPreferences();
        EditorHelper.putInt(this.adn, str, i);
    }

    public void putLong(String str, long j) {
        if (cO(str)) {
            f(str, j);
            return;
        }
        this.adn = getSharedPreferences();
        EditorHelper.putLong(this.adn, str, j);
    }

    public void remove(String str) {
        if (cO(str)) {
            removeValue(str);
            return;
        }
        this.adn = getSharedPreferences();
        EditorHelper.remove(this.adn, str);
    }

    private boolean cO(String str) {
        if (str == null || str.length() == 0 || !adl) {
            return false;
        }
        int length = a.adi.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.adi[i])) {
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
        if (this.ado == null || this.ado.length() == 0) {
            if (this.adm == null || this.adm.length() == 0) {
                this.adm = getProcessName();
            }
            if (adp.containsKey(this.adm)) {
                this.ado = adp.get(this.adm);
            } else {
                this.ado = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.ado, 0);
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
        return a.acY;
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
        if (this.adq == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.adq = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.adq = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.adq;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.hz()) {
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
        if (k.hz()) {
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
