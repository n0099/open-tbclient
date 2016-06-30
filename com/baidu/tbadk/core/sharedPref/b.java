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
    private String UT = null;
    private SharedPreferences UU = null;
    private String UV = null;
    private String UX = null;
    private static b UR = null;
    private static ContentResolver mContentResolver = null;
    public static boolean US = true;
    private static HashMap<String, String> UW = null;

    private b() {
        UW = new HashMap<>();
        UW.put(a.UF, TbConfig.SETTINGFILE);
        UW.put(a.UG, "remote_settings");
        UW.put(a.UH, "bdservice_settings");
        UW.put(a.UI, a.UL);
        UW.put(a.UJ, a.UM);
        UW.put(a.UK, a.UN);
        mContentResolver = TbadkCoreApplication.m9getInst().getContentResolver();
    }

    public static synchronized b sO() {
        b bVar;
        synchronized (b.class) {
            if (UR == null) {
                UR = new b();
            }
            bVar = UR;
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
        this.UU = getSharedPreferences();
        return this.UU.getBoolean(str, z);
    }

    public boolean g(String str, boolean z) {
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
        this.UU = getSharedPreferences();
        return this.UU.getInt(str, i);
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
        this.UU = getSharedPreferences();
        return this.UU.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cJ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.UU = getSharedPreferences();
        return this.UU.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cJ(str)) {
            i(str, z);
            return;
        }
        this.UU = getSharedPreferences();
        EditorHelper.putBoolean(this.UU, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cJ(str)) {
            U(str, str2);
            return;
        }
        this.UU = getSharedPreferences();
        EditorHelper.putString(this.UU, str, str2);
    }

    public void putInt(String str, int i) {
        if (cJ(str)) {
            q(str, i);
            return;
        }
        this.UU = getSharedPreferences();
        EditorHelper.putInt(this.UU, str, i);
    }

    public void putLong(String str, long j) {
        if (cJ(str)) {
            f(str, j);
            return;
        }
        this.UU = getSharedPreferences();
        EditorHelper.putLong(this.UU, str, j);
    }

    public void remove(String str) {
        if (cJ(str)) {
            removeValue(str);
            return;
        }
        this.UU = getSharedPreferences();
        EditorHelper.remove(this.UU, str);
    }

    private boolean cJ(String str) {
        if (str == null || str.length() == 0 || !US) {
            return false;
        }
        int length = a.UO.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.UO[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(sQ()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(sQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(sQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(sQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(sQ()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(sQ()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.UV == null || this.UV.length() == 0) {
            if (this.UT == null || this.UT.length() == 0) {
                this.UT = dU();
            }
            if (UW.containsKey(this.UT)) {
                this.UV = UW.get(this.UT);
            } else {
                this.UV = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m9getInst().getSharedPreferences(this.UV, 0);
    }

    private String dU() {
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
        return a.UF;
    }

    public void sP() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            sO().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                sO().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                sO().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                sO().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                sO().putString("client_id", string5);
            }
        }
    }

    protected String sQ() {
        if (this.UX == null) {
            String packageName = TbadkCoreApplication.m9getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.UX = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.UX = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.UX;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.fH()) {
            com.baidu.adp.lib.h.k.dN().c(new c(this, uri, contentValues));
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
        if (k.fH()) {
            com.baidu.adp.lib.h.k.dN().c(new d(this, uri));
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
