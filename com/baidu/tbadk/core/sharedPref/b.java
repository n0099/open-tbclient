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
    private String ZZ = null;
    private SharedPreferences aaa = null;
    private String aab = null;
    private String aad = null;
    private static b ZX = null;
    private static ContentResolver mContentResolver = null;
    public static boolean ZY = true;
    private static HashMap<String, String> aac = null;

    private b() {
        aac = new HashMap<>();
        aac.put(a.ZM, TbConfig.SETTINGFILE);
        aac.put(a.ZN, "remote_settings");
        aac.put(a.ZO, "bdservice_settings");
        aac.put(a.ZP, a.ZS);
        aac.put(a.ZQ, a.ZT);
        aac.put(a.ZR, a.ZU);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b uO() {
        b bVar;
        synchronized (b.class) {
            if (ZX == null) {
                ZX = new b();
            }
            bVar = ZX;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cJ(str)) {
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
        this.aaa = getSharedPreferences();
        return this.aaa.getBoolean(str, z);
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
        if (cJ(str)) {
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
        this.aaa = getSharedPreferences();
        return this.aaa.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cJ(str)) {
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
        this.aaa = getSharedPreferences();
        return this.aaa.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cJ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.aaa = getSharedPreferences();
        return this.aaa.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cJ(str)) {
            j(str, z);
            return;
        }
        this.aaa = getSharedPreferences();
        EditorHelper.putBoolean(this.aaa, str, z);
    }

    public void i(String str, boolean z) {
        j(str, z);
    }

    public void putString(String str, String str2) {
        if (cJ(str)) {
            T(str, str2);
            return;
        }
        this.aaa = getSharedPreferences();
        EditorHelper.putString(this.aaa, str, str2);
    }

    public void putInt(String str, int i) {
        if (cJ(str)) {
            p(str, i);
            return;
        }
        this.aaa = getSharedPreferences();
        EditorHelper.putInt(this.aaa, str, i);
    }

    public void putLong(String str, long j) {
        if (cJ(str)) {
            f(str, j);
            return;
        }
        this.aaa = getSharedPreferences();
        EditorHelper.putLong(this.aaa, str, j);
    }

    public void remove(String str) {
        if (cJ(str)) {
            removeValue(str);
            return;
        }
        this.aaa = getSharedPreferences();
        EditorHelper.remove(this.aaa, str);
    }

    private boolean cJ(String str) {
        if (str == null || str.length() == 0 || !ZY) {
            return false;
        }
        int length = a.ZV.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.ZV[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(uQ()) + str));
    }

    private void T(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(uQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void p(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(uQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(uQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void j(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(uQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(uQ()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.aab == null || this.aab.length() == 0) {
            if (this.ZZ == null || this.ZZ.length() == 0) {
                this.ZZ = hz();
            }
            if (aac.containsKey(this.ZZ)) {
                this.aab = aac.get(this.ZZ);
            } else {
                this.aab = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.aab, 0);
    }

    private String hz() {
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
        return a.ZM;
    }

    public void uP() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            uO().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                uO().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                uO().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                uO().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                uO().putString("client_id", string5);
            }
        }
    }

    protected String uQ() {
        if (this.aad == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.aad = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.aad = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.aad;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.jp()) {
            com.baidu.adp.lib.h.k.hs().c(new c(this, uri, contentValues));
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
        if (k.jp()) {
            com.baidu.adp.lib.h.k.hs().c(new d(this, uri));
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
