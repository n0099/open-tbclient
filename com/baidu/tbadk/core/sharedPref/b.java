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
    private String VC = null;
    private SharedPreferences VD = null;
    private String VE = null;
    private String VG = null;
    private static b VA = null;
    private static ContentResolver mContentResolver = null;
    public static boolean VB = true;
    private static HashMap<String, String> VF = null;

    private b() {
        VF = new HashMap<>();
        VF.put(a.Vp, TbConfig.SETTINGFILE);
        VF.put(a.Vq, "remote_settings");
        VF.put(a.Vr, "bdservice_settings");
        VF.put(a.Vs, a.Vv);
        VF.put(a.Vt, a.Vw);
        VF.put(a.Vu, a.Vx);
        mContentResolver = TbadkCoreApplication.m10getInst().getContentResolver();
    }

    public static synchronized b sN() {
        b bVar;
        synchronized (b.class) {
            if (VA == null) {
                VA = new b();
            }
            bVar = VA;
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
        this.VD = getSharedPreferences();
        return this.VD.getBoolean(str, z);
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
        this.VD = getSharedPreferences();
        return this.VD.getInt(str, i);
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
        this.VD = getSharedPreferences();
        return this.VD.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cJ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.VD = getSharedPreferences();
        return this.VD.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cJ(str)) {
            i(str, z);
            return;
        }
        this.VD = getSharedPreferences();
        EditorHelper.putBoolean(this.VD, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cJ(str)) {
            U(str, str2);
            return;
        }
        this.VD = getSharedPreferences();
        EditorHelper.putString(this.VD, str, str2);
    }

    public void putInt(String str, int i) {
        if (cJ(str)) {
            q(str, i);
            return;
        }
        this.VD = getSharedPreferences();
        EditorHelper.putInt(this.VD, str, i);
    }

    public void putLong(String str, long j) {
        if (cJ(str)) {
            f(str, j);
            return;
        }
        this.VD = getSharedPreferences();
        EditorHelper.putLong(this.VD, str, j);
    }

    public void remove(String str) {
        if (cJ(str)) {
            removeValue(str);
            return;
        }
        this.VD = getSharedPreferences();
        EditorHelper.remove(this.VD, str);
    }

    private boolean cJ(String str) {
        if (str == null || str.length() == 0 || !VB) {
            return false;
        }
        int length = a.Vy.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Vy[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return c(Uri.parse(String.valueOf(sP()) + str));
    }

    private void U(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(sP()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void q(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(sP()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(sP()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(sP()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        d(Uri.parse(String.valueOf(sP()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.VE == null || this.VE.length() == 0) {
            if (this.VC == null || this.VC.length() == 0) {
                this.VC = dT();
            }
            if (VF.containsKey(this.VC)) {
                this.VE = VF.get(this.VC);
            } else {
                this.VE = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m10getInst().getSharedPreferences(this.VE, 0);
    }

    private String dT() {
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.m10getInst().getSystemService("activity");
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
        return a.Vp;
    }

    public void sO() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m10getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            sN().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                sN().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                sN().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                sN().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                sN().putString("client_id", string5);
            }
        }
    }

    protected String sP() {
        if (this.VG == null) {
            String packageName = TbadkCoreApplication.m10getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.VG = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.VG = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.VG;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.fG()) {
            com.baidu.adp.lib.h.k.dM().f(new c(this, uri, contentValues));
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
        if (k.fG()) {
            com.baidu.adp.lib.h.k.dM().f(new d(this, uri));
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
}
