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
    private static b Sy = null;
    private static ContentResolver mContentResolver = null;
    private static HashMap<String, String> SC = null;
    private String Sz = null;
    private SharedPreferences SA = null;
    private String SB = null;
    private String SD = null;

    private b() {
        SC = new HashMap<>();
        SC.put(a.Sn, TbConfig.SETTINGFILE);
        SC.put(a.So, "remote_settings");
        SC.put(a.Sp, "bdservice_settings");
        SC.put(a.Sq, a.St);
        SC.put(a.Sr, a.Su);
        SC.put(a.Ss, a.Sv);
        mContentResolver = TbadkCoreApplication.m411getInst().getApp().getContentResolver();
    }

    public static void fR() {
        if (SC != null) {
            SC.clear();
        }
        Sy = null;
    }

    public static synchronized b rB() {
        b bVar;
        synchronized (b.class) {
            if (Sy == null) {
                Sy = new b();
            }
            bVar = Sy;
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
        this.SA = getSharedPreferences();
        return this.SA.getBoolean(str, z);
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
        this.SA = getSharedPreferences();
        return this.SA.getInt(str, i);
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
        this.SA = getSharedPreferences();
        return this.SA.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (cd(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.SA = getSharedPreferences();
        return this.SA.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (cd(str)) {
            i(str, z);
            return;
        }
        this.SA = getSharedPreferences();
        EditorHelper.putBoolean(this.SA, str, z);
    }

    public void h(String str, boolean z) {
        i(str, z);
    }

    public void putString(String str, String str2) {
        if (cd(str)) {
            V(str, str2);
            return;
        }
        this.SA = getSharedPreferences();
        EditorHelper.putString(this.SA, str, str2);
    }

    public void putInt(String str, int i) {
        if (cd(str)) {
            m(str, i);
            return;
        }
        this.SA = getSharedPreferences();
        EditorHelper.putInt(this.SA, str, i);
    }

    public void putLong(String str, long j) {
        if (cd(str)) {
            c(str, j);
            return;
        }
        this.SA = getSharedPreferences();
        EditorHelper.putLong(this.SA, str, j);
    }

    public void remove(String str) {
        if (cd(str)) {
            removeValue(str);
            return;
        }
        this.SA = getSharedPreferences();
        EditorHelper.remove(this.SA, str);
    }

    private boolean cd(String str) {
        if (str == null || str.length() == 0 || TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
            return false;
        }
        int length = a.Sw.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.Sw[i])) {
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
        if (this.SB == null || this.SB.length() == 0) {
            if (this.Sz == null || this.Sz.length() == 0) {
                this.Sz = rC();
            }
            if (SC.containsKey(this.Sz)) {
                this.SB = SC.get(this.Sz);
            } else {
                this.SB = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.m411getInst().getApp().getSharedPreferences(this.SB, 0);
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
        return a.Sn;
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
        if (this.SD == null) {
            String packageName = TbadkCoreApplication.m411getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.SD = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.SD = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.SD;
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
