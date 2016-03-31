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
    private String Zl = null;
    private SharedPreferences Zm = null;
    private String Zn = null;
    private String Zp = null;
    private static b Zj = null;
    private static ContentResolver mContentResolver = null;
    public static boolean Zk = true;
    private static HashMap<String, String> Zo = null;

    private b() {
        Zo = new HashMap<>();
        Zo.put(a.YY, TbConfig.SETTINGFILE);
        Zo.put(a.YZ, "remote_settings");
        Zo.put(a.Za, "bdservice_settings");
        Zo.put(a.Zb, a.Ze);
        Zo.put(a.Zc, a.Zf);
        Zo.put(a.Zd, a.Zg);
        mContentResolver = TbadkCoreApplication.m411getInst().getContentResolver();
    }

    public static synchronized b vk() {
        b bVar;
        synchronized (b.class) {
            if (Zj == null) {
                Zj = new b();
            }
            bVar = Zj;
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
        this.Zm = getSharedPreferences();
        return this.Zm.getBoolean(str, z);
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
        this.Zm = getSharedPreferences();
        return this.Zm.getInt(str, i);
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
        this.Zm = getSharedPreferences();
        return this.Zm.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cM(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.Zm = getSharedPreferences();
        return this.Zm.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cM(str)) {
            i(str, z);
            return;
        }
        this.Zm = getSharedPreferences();
        EditorHelper.putBoolean(this.Zm, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cM(str)) {
            V(str, str2);
            return;
        }
        this.Zm = getSharedPreferences();
        EditorHelper.putString(this.Zm, str, str2);
    }

    public void putInt(String str, int i) {
        if (cM(str)) {
            p(str, i);
            return;
        }
        this.Zm = getSharedPreferences();
        EditorHelper.putInt(this.Zm, str, i);
    }

    public void putLong(String str, long j) {
        if (cM(str)) {
            f(str, j);
            return;
        }
        this.Zm = getSharedPreferences();
        EditorHelper.putLong(this.Zm, str, j);
    }

    public void remove(String str) {
        if (cM(str)) {
            removeValue(str);
            return;
        }
        this.Zm = getSharedPreferences();
        EditorHelper.remove(this.Zm, str);
    }

    private boolean cM(String str) {
        if (str == null || str.length() == 0 || !Zk) {
            return false;
        }
        int length = a.Zh.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Zh[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(vm()) + str));
    }

    private void V(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(vm()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void p(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(vm()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void f(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(vm()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(vm()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(vm()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.Zn == null || this.Zn.length() == 0) {
            if (this.Zl == null || this.Zl.length() == 0) {
                this.Zl = hF();
            }
            if (Zo.containsKey(this.Zl)) {
                this.Zn = Zo.get(this.Zl);
            } else {
                this.Zn = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getSharedPreferences(this.Zn, 0);
    }

    private String hF() {
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
        return a.YY;
    }

    public void vl() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            vk().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                vk().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                vk().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                vk().putString(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                vk().putString("client_id", string5);
            }
        }
    }

    protected String vm() {
        if (this.Zp == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.Zp = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.Zp = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.Zp;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (k.jv()) {
            com.baidu.adp.lib.h.k.hy().c(new c(this, uri, contentValues));
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
        if (k.jv()) {
            com.baidu.adp.lib.h.k.hy().c(new d(this, uri));
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
