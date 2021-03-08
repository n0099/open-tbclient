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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b {
    private static b fas;
    private static HashMap<String, String> fau;
    private static ContentResolver mContentResolver;
    private String daO;
    private String mFile;
    private SharedPreferences mSP;
    private String fav = null;
    private ConcurrentHashMap<String, Object> fat = new ConcurrentHashMap<>();

    protected b() {
        fau = new HashMap<>();
        fau.put(a.faj, "settings");
        fau.put(a.fak, "remote_settings");
        fau.put(a.fal, "bdservice_settings");
        fau.put(a.fam, a.fap);
        fau.put(a.fan, a.faq);
        fau.put(a.fao, a.far);
        mContentResolver = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b brR() {
        b bVar;
        synchronized (b.class) {
            if (fas == null) {
                fas = new b();
            }
            bVar = fas;
        }
        return bVar;
    }

    public boolean isContains(String str) {
        if (AQ(str)) {
            return false;
        }
        return this.fat.containsKey(str) || getSharedPreferences().contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        if (AQ(str)) {
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
        Object obj = this.fat.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        if (AQ(str)) {
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
        Object obj = this.fat.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (AQ(str)) {
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
        Object obj = this.fat.get(str);
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
        if (AQ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        Object obj = this.fat.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
    }

    public void commit() {
        SharedPreferences.Editor edit;
        if (!this.fat.isEmpty()) {
            this.mSP = getSharedPreferences();
            if (this.mSP != null && (edit = this.mSP.edit()) != null) {
                for (Map.Entry<String, Object> entry : this.fat.entrySet()) {
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
                this.fat.clear();
            }
        }
    }

    private void w(String str, Object obj) {
        if (str != null && obj != null) {
            this.fat.put(str, obj);
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
        if (AQ(str)) {
            av(str, z);
        } else if (l.isMainThread()) {
            w(str, Boolean.valueOf(z));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public void putString(String str, String str2) {
        if (AQ(str)) {
            dM(str, str2);
        } else if ("null".equals(str2)) {
            remove(str);
        } else if (l.isMainThread()) {
            w(str, str2);
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public void putInt(String str, int i) {
        if (AQ(str)) {
            ap(str, i);
        } else if (l.isMainThread()) {
            w(str, Integer.valueOf(i));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void putLong(String str, long j) {
        if (AQ(str)) {
            u(str, j);
        } else if (l.isMainThread()) {
            w(str, Long.valueOf(j));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void remove(String str) {
        if (AQ(str)) {
            removeValue(str);
        } else if (this.fat.containsKey(str)) {
            this.fat.remove(str);
        } else {
            this.mSP = getSharedPreferences();
            EditorHelper.remove(this.mSP, str);
        }
    }

    private boolean AQ(String str) {
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
        return w(Uri.parse(brS() + str));
    }

    private void dM(String str, String str2) {
        Uri parse = Uri.parse(brS() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        b(parse, contentValues);
    }

    private void ap(String str, int i) {
        Uri parse = Uri.parse(brS() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        b(parse, contentValues);
    }

    private void u(String str, long j) {
        Uri parse = Uri.parse(brS() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        b(parse, contentValues);
    }

    private void av(String str, boolean z) {
        Uri parse = Uri.parse(brS() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        b(parse, contentValues);
    }

    private void removeValue(String str) {
        x(Uri.parse(brS() + str));
    }

    public synchronized SharedPreferences getSharedPreferences() {
        if (this.mFile == null || this.mFile.length() == 0) {
            if (this.daO == null || this.daO.length() == 0) {
                this.daO = getProcessName();
            }
            if (fau.containsKey(this.daO)) {
                this.mFile = fau.get(this.daO);
            } else {
                this.mFile = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.mFile, 0);
    }

    private String getProcessName() {
        String str = a.faj;
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

    protected String brS() {
        if (this.fav == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.fav = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.fav = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.fav;
    }

    protected void b(final Uri uri, final ContentValues contentValues) {
        if (l.isMainThread()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.c(uri, contentValues);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            c(uri, contentValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Uri uri, ContentValues contentValues) {
        try {
            mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    protected String w(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void x(final Uri uri) {
        if (l.isMainThread()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.y(uri);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            y(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Uri uri) {
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
