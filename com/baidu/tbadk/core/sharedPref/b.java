package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b spHelper = null;
    private static ContentResolver mContentResolver = null;
    public static boolean IS_CHECK_COMMON_SHAREDPRE = true;
    private static HashMap<String, String> mProcessMap = null;
    private String mProcess = null;
    private SharedPreferences mSP = null;
    private String mFile = null;
    private String cachedPrefix = null;

    protected b() {
        mProcessMap = new HashMap<>();
        mProcessMap.put(a.adA, TbConfig.SETTINGFILE);
        mProcessMap.put(a.adB, "remote_settings");
        mProcessMap.put(a.adC, "bdservice_settings");
        mProcessMap.put(a.adD, a.adG);
        mProcessMap.put(a.adE, a.adH);
        mProcessMap.put(a.adF, a.adI);
        mContentResolver = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static void clearInstance() {
        if (mProcessMap != null) {
            mProcessMap.clear();
        }
        spHelper = null;
    }

    public static synchronized b getInstance() {
        b bVar;
        synchronized (b.class) {
            if (spHelper == null) {
                spHelper = new b();
            }
            bVar = spHelper;
        }
        return bVar;
    }

    public boolean getBoolean(String str, boolean z) {
        if (checkIsCommon(str)) {
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
        this.mSP = getSharedPreferences();
        return this.mSP.getBoolean(str, z);
    }

    public boolean getBooleanFromCommon(String str, boolean z) {
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

    public float getFloat(String str, float f) {
        if (checkIsCommon(str)) {
            String value = getValue(str);
            if (value != null) {
                try {
                    return Float.parseFloat(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return f;
                }
            }
            return f;
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        if (checkIsCommon(str)) {
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
        this.mSP = getSharedPreferences();
        return this.mSP.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (checkIsCommon(str)) {
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
        this.mSP = getSharedPreferences();
        return this.mSP.getLong(str, j);
    }

    public String getString(String str, String str2) {
        if (checkIsCommon(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (checkIsCommon(str)) {
            putValue(str, z);
            return;
        }
        this.mSP = getSharedPreferences();
        EditorHelper.putBoolean(this.mSP, str, z);
    }

    public void putBooleanFromCommon(String str, boolean z) {
        putValue(str, z);
    }

    public void putString(String str, String str2) {
        if (checkIsCommon(str)) {
            putValue(str, str2);
            return;
        }
        this.mSP = getSharedPreferences();
        EditorHelper.putString(this.mSP, str, str2);
    }

    public void putFloat(String str, float f) {
        if (checkIsCommon(str)) {
            putValue(str, f);
            return;
        }
        this.mSP = getSharedPreferences();
        EditorHelper.putFloat(this.mSP, str, f);
    }

    public void putInt(String str, int i) {
        if (checkIsCommon(str)) {
            putValue(str, i);
            return;
        }
        this.mSP = getSharedPreferences();
        EditorHelper.putInt(this.mSP, str, i);
    }

    public void putLong(String str, long j) {
        if (checkIsCommon(str)) {
            putValue(str, j);
            return;
        }
        this.mSP = getSharedPreferences();
        EditorHelper.putLong(this.mSP, str, j);
    }

    public void remove(String str) {
        if (checkIsCommon(str)) {
            removeValue(str);
            return;
        }
        this.mSP = getSharedPreferences();
        EditorHelper.remove(this.mSP, str);
    }

    private boolean checkIsCommon(String str) {
        if (str == null || str.length() == 0 || !IS_CHECK_COMMON_SHAREDPRE) {
            return false;
        }
        int length = a.adJ.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.adJ[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return getValue(Uri.parse(getContentPrefix() + str));
    }

    private void putValue(String str, String str2) {
        Uri parse = Uri.parse(getContentPrefix() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        setValue(parse, contentValues);
    }

    private void putValue(String str, int i) {
        Uri parse = Uri.parse(getContentPrefix() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        setValue(parse, contentValues);
    }

    private void putValue(String str, float f) {
        Uri parse = Uri.parse(getContentPrefix() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(f));
        setValue(parse, contentValues);
    }

    private void putValue(String str, long j) {
        Uri parse = Uri.parse(getContentPrefix() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        setValue(parse, contentValues);
    }

    private void putValue(String str, boolean z) {
        Uri parse = Uri.parse(getContentPrefix() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        setValue(parse, contentValues);
    }

    private void removeValue(String str) {
        deleteValue(Uri.parse(getContentPrefix() + str));
    }

    protected synchronized SharedPreferences getSharedPreferences() {
        if (this.mFile == null || this.mFile.length() == 0) {
            if (this.mProcess == null || this.mProcess.length() == 0) {
                this.mProcess = getProcessName();
            }
            if (mProcessMap.containsKey(this.mProcess)) {
                this.mFile = mProcessMap.get(this.mProcess);
            } else {
                this.mFile = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.mFile, 0);
    }

    private String getProcessName() {
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
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
        return a.adA;
    }

    public void migrateToNewVersion() {
        SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        String string = sharedPreferences.getString("lase_version", "");
        String version = TbConfig.getVersion();
        if (string != null && string.length() != 0 && version != null && version.length() != 0 && !string.equals(version) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(version) <= 0) {
            getInstance().putInt("skin_" + TbadkCoreApplication.getCurrentAccount(), sharedPreferences.getInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                getInstance().putString("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                getInstance().putString("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString("cuid", null);
            if (string4 != null && string4.length() > 0) {
                getInstance().putString("cuid", string4);
            }
            String string5 = sharedPreferences.getString("client_id", null);
            if (string5 != null && string5.length() > 0) {
                getInstance().putString("client_id", string5);
            }
        }
    }

    protected String getContentPrefix() {
        if (this.cachedPrefix == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if (TbConfig.MAIN_PACKAGE_NAME.equals(packageName)) {
                this.cachedPrefix = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.cachedPrefix = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.cachedPrefix;
    }

    protected void setValue(final Uri uri, final ContentValues contentValues) {
        if (k.hx()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.setValueInner(uri, contentValues);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            setValueInner(uri, contentValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueInner(Uri uri, ContentValues contentValues) {
        try {
            mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    protected String getValue(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void deleteValue(final Uri uri) {
        if (k.hx()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.deleteValueInner(uri);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            deleteValueInner(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteValueInner(Uri uri) {
        try {
            mContentResolver.delete(uri, null, null);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }

    public static String getSharedPrefKeyWithAccount(String str) {
        return str + "_" + TbadkCoreApplication.getCurrentAccount();
    }
}
