package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b {
    private static b che;
    private static HashMap<String, String> chg;
    private static ContentResolver mContentResolver;
    private String aPl;
    private String mFile;
    private SharedPreferences mSP;
    private String chh = null;
    private ConcurrentHashMap<String, Object> chf = new ConcurrentHashMap<>();

    protected b() {
        chg = new HashMap<>();
        chg.put(a.cgV, TbConfig.SETTINGFILE);
        chg.put(a.cgW, "remote_settings");
        chg.put(a.cgX, "bdservice_settings");
        chg.put(a.cgY, a.chb);
        chg.put(a.cgZ, a.chc);
        chg.put(a.cha, a.chd);
        mContentResolver = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b alP() {
        b bVar;
        synchronized (b.class) {
            if (che == null) {
                che = new b();
            }
            bVar = che;
        }
        return bVar;
    }

    public boolean isContains(String str) {
        if (nz(str)) {
            return false;
        }
        return this.chf.containsKey(str) || getSharedPreferences().contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        if (nz(str)) {
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
        Object obj = this.chf.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        if (nz(str)) {
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
        Object obj = this.chf.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (nz(str)) {
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
        Object obj = this.chf.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        this.mSP = getSharedPreferences();
        try {
            return this.mSP.getLong(str, j);
        } catch (ClassCastException e2) {
            BdLog.e(e2);
            return j;
        }
    }

    public String getString(String str, String str2) {
        if (nz(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        Object obj = this.chf.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
    }

    public void commit() {
        SharedPreferences.Editor edit;
        if (!this.chf.isEmpty()) {
            this.mSP = getSharedPreferences();
            if (this.mSP != null && (edit = this.mSP.edit()) != null) {
                for (Map.Entry<String, Object> entry : this.chf.entrySet()) {
                    if (entry != null) {
                        String valueOf = String.valueOf(entry.getKey());
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            edit.putString(valueOf, (String) value);
                        } else if (value instanceof Integer) {
                            edit.putInt(valueOf, ((Integer) value).intValue());
                        } else if (value instanceof Long) {
                            edit.putLong(valueOf, ((Long) value).longValue());
                        } else if (value instanceof Boolean) {
                            edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                        } else if (value instanceof Float) {
                            edit.putFloat(valueOf, ((Float) value).floatValue());
                        }
                    }
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                this.chf.clear();
            }
        }
    }

    private void k(String str, Object obj) {
        if (str != null && obj != null) {
            this.chf.put(str, obj);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tbadk.core.sharedPref.b.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    b.this.commit();
                    return false;
                }
            });
        }
    }

    public void putBoolean(String str, boolean z) {
        if (nz(str)) {
            O(str, z);
        } else if (l.isMainThread()) {
            k(str, Boolean.valueOf(z));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public void putString(String str, String str2) {
        if (nz(str)) {
            bQ(str, str2);
        } else if ("null".equals(str2)) {
            remove(str);
        } else if (l.isMainThread()) {
            k(str, str2);
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public void putInt(String str, int i) {
        if (nz(str)) {
            N(str, i);
        } else if (l.isMainThread()) {
            k(str, Integer.valueOf(i));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void putLong(String str, long j) {
        if (nz(str)) {
            o(str, j);
        } else if (l.isMainThread()) {
            k(str, Long.valueOf(j));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void remove(String str) {
        if (nz(str)) {
            removeValue(str);
        } else if (this.chf.containsKey(str)) {
            this.chf.remove(str);
        } else {
            this.mSP = getSharedPreferences();
            EditorHelper.remove(this.mSP, str);
        }
    }

    private boolean nz(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.COMMON_KEYS.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.COMMON_KEYS[i])) {
                return true;
            }
        }
        return false;
    }

    private String getValue(String str) {
        return l(Uri.parse(alQ() + str));
    }

    private void bQ(String str, String str2) {
        Uri parse = Uri.parse(alQ() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void N(String str, int i) {
        Uri parse = Uri.parse(alQ() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void o(String str, long j) {
        Uri parse = Uri.parse(alQ() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void O(String str, boolean z) {
        Uri parse = Uri.parse(alQ() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        m(Uri.parse(alQ() + str));
    }

    public synchronized SharedPreferences getSharedPreferences() {
        if (this.mFile == null || this.mFile.length() == 0) {
            if (this.aPl == null || this.aPl.length() == 0) {
                this.aPl = getProcessName();
            }
            if (chg.containsKey(this.aPl)) {
                this.mFile = chg.get(this.aPl);
            } else {
                this.mFile = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.mFile, 0);
    }

    private String getProcessName() {
        String str = a.cgV;
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        }
        return str;
    }

    protected String alQ() {
        if (this.chh == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.chh = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.chh = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.chh;
    }

    protected void a(final Uri uri, final ContentValues contentValues) {
        if (l.isMainThread()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.b(uri, contentValues);
                    return null;
                }
            }.execute(new Void[0]);
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

    protected String l(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void m(final Uri uri) {
        if (l.isMainThread()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.n(uri);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            n(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Uri uri) {
        try {
            mContentResolver.delete(uri, null, null);
        } catch (SecurityException e) {
            BdLog.detailException(e);
        }
    }

    public static String getSharedPrefKeyWithAccount(String str) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbadkCoreApplication.getCurrentAccount();
    }
}
