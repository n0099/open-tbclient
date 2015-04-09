package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.g.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String SB = null;
    private SharedPreferences SC = null;
    private String SD = null;
    private String SF = null;
    private static b SA = null;
    private static ContentResolver mContentResolver = null;
    private static HashMap<String, String> SE = null;

    private b() {
        SE = new HashMap<>();
        SE.put(a.Sp, TbConfig.SETTINGFILE);
        SE.put(a.Sq, "remote_settings");
        SE.put(a.Sr, "bdservice_settings");
        SE.put(a.Ss, a.Sv);
        SE.put(a.St, a.Sw);
        SE.put(a.Su, a.Sx);
        mContentResolver = TbadkCoreApplication.m411getInst().getApp().getContentResolver();
    }

    public static void fR() {
        if (SE != null) {
            SE.clear();
        }
        SA = null;
    }

    public static synchronized b rB() {
        b bVar;
        synchronized (b.class) {
            if (SA == null) {
                SA = new b();
            }
            bVar = SA;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (cd(str)) {
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
        this.SC = getSharedPreferences();
        return this.SC.getBoolean(str, z);
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
        if (cd(str)) {
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
        this.SC = getSharedPreferences();
        return this.SC.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (cd(str)) {
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
        this.SC = getSharedPreferences();
        return this.SC.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cd(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.SC = getSharedPreferences();
        return this.SC.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cd(str)) {
            i(str, z);
            return;
        }
        this.SC = getSharedPreferences();
        EditorHelper.putBoolean(this.SC, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cd(str)) {
            V(str, str2);
            return;
        }
        this.SC = getSharedPreferences();
        EditorHelper.putString(this.SC, str, str2);
    }

    public void putInt(String str, int i) {
        if (cd(str)) {
            m(str, i);
            return;
        }
        this.SC = getSharedPreferences();
        EditorHelper.putInt(this.SC, str, i);
    }

    public void putLong(String str, long j) {
        if (cd(str)) {
            c(str, j);
            return;
        }
        this.SC = getSharedPreferences();
        EditorHelper.putLong(this.SC, str, j);
    }

    public void remove(String str) {
        if (cd(str)) {
            removeValue(str);
            return;
        }
        this.SC = getSharedPreferences();
        EditorHelper.remove(this.SC, str);
    }

    private boolean cd(String str) {
        if (str == null || str.length() == 0 || TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
            return false;
        }
        int length = a.Sy.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Sy[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return b(Uri.parse(String.valueOf(rE()) + str));
    }

    private void V(String str, String str2) {
        Uri parse = Uri.parse(String.valueOf(rE()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void m(String str, int i) {
        Uri parse = Uri.parse(String.valueOf(rE()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void c(String str, long j) {
        Uri parse = Uri.parse(String.valueOf(rE()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void i(String str, boolean z) {
        Uri parse = Uri.parse(String.valueOf(rE()) + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        c(Uri.parse(String.valueOf(rE()) + str));
    }

    private synchronized SharedPreferences getSharedPreferences() {
        if (this.SD == null || this.SD.length() == 0) {
            if (this.SB == null || this.SB.length() == 0) {
                this.SB = rC();
            }
            if (SE.containsKey(this.SB)) {
                this.SD = SE.get(this.SB);
            } else {
                this.SD = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getApp().getSharedPreferences(this.SD, 0);
    }

    private String rC() {
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("activity");
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
        return a.Sp;
    }

    public void rD() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getApp().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            rB().putInt("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                rB().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                rB().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                rB().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                rB().putString("client_id", string5);
            }
        }
    }

    protected String rE() {
        if (this.SF == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.SF = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.SF = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.SF;
    }

    protected void a(Uri uri, ContentValues contentValues) {
        if (n.iW()) {
            l.hJ().c(new c(this, uri, contentValues));
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
        if (n.iW()) {
            l.hJ().c(new d(this, uri));
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
