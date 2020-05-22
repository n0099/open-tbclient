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
    private static HashMap<String, String> dLA;
    private static b dLy;
    private static ContentResolver mContentResolver;
    private String ccb;
    private String dLB = null;
    private ConcurrentHashMap<String, Object> dLz = new ConcurrentHashMap<>();
    private String mFile;
    private SharedPreferences mSP;

    protected b() {
        dLA = new HashMap<>();
        dLA.put(a.dLp, "settings");
        dLA.put(a.dLq, "remote_settings");
        dLA.put(a.dLr, "bdservice_settings");
        dLA.put(a.dLs, a.dLv);
        dLA.put(a.dLt, a.dLw);
        dLA.put(a.dLu, a.dLx);
        mContentResolver = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b aTX() {
        b bVar;
        synchronized (b.class) {
            if (dLy == null) {
                dLy = new b();
            }
            bVar = dLy;
        }
        return bVar;
    }

    public boolean isContains(String str) {
        if (vZ(str)) {
            return false;
        }
        return this.dLz.containsKey(str) || getSharedPreferences().contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        if (vZ(str)) {
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
        Object obj = this.dLz.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        if (vZ(str)) {
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
        Object obj = this.dLz.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (vZ(str)) {
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
        Object obj = this.dLz.get(str);
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
        if (vZ(str)) {
            String value = getValue(str);
            return value != null ? value : str2;
        }
        Object obj = this.dLz.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
    }

    public void commit() {
        SharedPreferences.Editor edit;
        if (!this.dLz.isEmpty()) {
            this.mSP = getSharedPreferences();
            if (this.mSP != null && (edit = this.mSP.edit()) != null) {
                for (Map.Entry<String, Object> entry : this.dLz.entrySet()) {
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
                this.dLz.clear();
            }
        }
    }

    private void z(String str, Object obj) {
        if (str != null && obj != null) {
            this.dLz.put(str, obj);
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
        if (vZ(str)) {
            ak(str, z);
        } else if (l.isMainThread()) {
            z(str, Boolean.valueOf(z));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public void putString(String str, String str2) {
        if (vZ(str)) {
            df(str, str2);
        } else if ("null".equals(str2)) {
            remove(str);
        } else if (l.isMainThread()) {
            z(str, str2);
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public void putInt(String str, int i) {
        if (vZ(str)) {
            af(str, i);
        } else if (l.isMainThread()) {
            z(str, Integer.valueOf(i));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void putLong(String str, long j) {
        if (vZ(str)) {
            r(str, j);
        } else if (l.isMainThread()) {
            z(str, Long.valueOf(j));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void remove(String str) {
        if (vZ(str)) {
            removeValue(str);
        } else if (this.dLz.containsKey(str)) {
            this.dLz.remove(str);
        } else {
            this.mSP = getSharedPreferences();
            EditorHelper.remove(this.mSP, str);
        }
    }

    private boolean vZ(String str) {
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
        return q(Uri.parse(aTY() + str));
    }

    private void df(String str, String str2) {
        Uri parse = Uri.parse(aTY() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void af(String str, int i) {
        Uri parse = Uri.parse(aTY() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void r(String str, long j) {
        Uri parse = Uri.parse(aTY() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void ak(String str, boolean z) {
        Uri parse = Uri.parse(aTY() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        r(Uri.parse(aTY() + str));
    }

    public synchronized SharedPreferences getSharedPreferences() {
        if (this.mFile == null || this.mFile.length() == 0) {
            if (this.ccb == null || this.ccb.length() == 0) {
                this.ccb = getProcessName();
            }
            if (dLA.containsKey(this.ccb)) {
                this.mFile = dLA.get(this.ccb);
            } else {
                this.mFile = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.mFile, 0);
    }

    private String getProcessName() {
        String str = a.dLp;
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

    protected String aTY() {
        if (this.dLB == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.dLB = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.dLB = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.dLB;
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

    protected String q(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void r(final Uri uri) {
        if (l.isMainThread()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.s(uri);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            s(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Uri uri) {
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
