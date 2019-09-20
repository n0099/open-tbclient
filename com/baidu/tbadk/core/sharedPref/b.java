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
    private static b bQU;
    private static HashMap<String, String> bQX;
    private static ContentResolver mContentResolver;
    private String awo;
    private String bQV;
    private SharedPreferences mSP;
    private String bQY = null;
    private ConcurrentHashMap<String, Object> bQW = new ConcurrentHashMap<>();

    protected b() {
        bQX = new HashMap<>();
        bQX.put(a.bQJ, TbConfig.SETTINGFILE);
        bQX.put(a.bQK, "remote_settings");
        bQX.put(a.bQL, "bdservice_settings");
        bQX.put(a.bQM, a.bQP);
        bQX.put(a.bQN, a.bQQ);
        bQX.put(a.bQO, a.bQR);
        mContentResolver = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b ahU() {
        b bVar;
        synchronized (b.class) {
            if (bQU == null) {
                bQU = new b();
            }
            bVar = bQU;
        }
        return bVar;
    }

    public boolean isContains(String str) {
        if (nc(str)) {
            return false;
        }
        return this.bQW.containsKey(str) || getSharedPreferences().contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        if (nc(str)) {
            String nd = nd(str);
            if (nd != null) {
                try {
                    return Boolean.parseBoolean(nd);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            return z;
        }
        Object obj = this.bQW.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        if (nc(str)) {
            String nd = nd(str);
            if (nd != null) {
                try {
                    return Integer.parseInt(nd);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            return i;
        }
        Object obj = this.bQW.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getInt(str, i);
    }

    public long getLong(String str, long j) {
        if (nc(str)) {
            String nd = nd(str);
            if (nd != null) {
                try {
                    return Long.parseLong(nd);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            return j;
        }
        Object obj = this.bQW.get(str);
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
        if (nc(str)) {
            String nd = nd(str);
            return nd != null ? nd : str2;
        }
        Object obj = this.bQW.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
    }

    public void commit() {
        SharedPreferences.Editor edit;
        if (!this.bQW.isEmpty()) {
            this.mSP = getSharedPreferences();
            if (this.mSP != null && (edit = this.mSP.edit()) != null) {
                for (Map.Entry<String, Object> entry : this.bQW.entrySet()) {
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
                this.bQW.clear();
            }
        }
    }

    private void n(String str, Object obj) {
        if (str != null && obj != null) {
            this.bQW.put(str, obj);
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
        if (nc(str)) {
            L(str, z);
        } else if (l.ks()) {
            n(str, Boolean.valueOf(z));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public void putString(String str, String str2) {
        if (nc(str)) {
            bM(str, str2);
        } else if ("null".equals(str2)) {
            remove(str);
        } else if (l.ks()) {
            n(str, str2);
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public void putInt(String str, int i) {
        if (nc(str)) {
            N(str, i);
        } else if (l.ks()) {
            n(str, Integer.valueOf(i));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void putLong(String str, long j) {
        if (nc(str)) {
            m(str, j);
        } else if (l.ks()) {
            n(str, Long.valueOf(j));
        } else {
            this.mSP = getSharedPreferences();
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void remove(String str) {
        if (nc(str)) {
            removeValue(str);
        } else if (this.bQW.containsKey(str)) {
            this.bQW.remove(str);
        } else {
            this.mSP = getSharedPreferences();
            EditorHelper.remove(this.mSP, str);
        }
    }

    private boolean nc(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.bQS.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.bQS[i])) {
                return true;
            }
        }
        return false;
    }

    private String nd(String str) {
        return o(Uri.parse(ahV() + str));
    }

    private void bM(String str, String str2) {
        Uri parse = Uri.parse(ahV() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        a(parse, contentValues);
    }

    private void N(String str, int i) {
        Uri parse = Uri.parse(ahV() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        a(parse, contentValues);
    }

    private void m(String str, long j) {
        Uri parse = Uri.parse(ahV() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        a(parse, contentValues);
    }

    private void L(String str, boolean z) {
        Uri parse = Uri.parse(ahV() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        a(parse, contentValues);
    }

    private void removeValue(String str) {
        p(Uri.parse(ahV() + str));
    }

    public synchronized SharedPreferences getSharedPreferences() {
        if (this.bQV == null || this.bQV.length() == 0) {
            if (this.awo == null || this.awo.length() == 0) {
                this.awo = getProcessName();
            }
            if (bQX.containsKey(this.awo)) {
                this.bQV = bQX.get(this.awo);
            } else {
                this.bQV = TbConfig.SETTINGFILE;
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.bQV, 0);
    }

    private String getProcessName() {
        String str = a.bQJ;
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

    protected String ahV() {
        if (this.bQY == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.bQY = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.bQY = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.bQY;
    }

    protected void a(final Uri uri, final ContentValues contentValues) {
        if (l.ks()) {
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

    protected String o(Uri uri) {
        try {
            return mContentResolver.getType(uri);
        } catch (SecurityException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    protected void p(final Uri uri) {
        if (l.ks()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.sharedPref.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    b.this.q(uri);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            q(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Uri uri) {
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
