package com.baidu.android.imsdk.db;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class DBOperationFactory {
    public static final String TAG = "DBOperationFactory";
    public static long sAppid = -1;
    public static HashMap<String, DBOperation> sDbOperatioContainer = new HashMap<>();
    public static long sEnv = -1;
    public static String sUid;
    public static long sUk;

    public static void closeDb(String str) {
        if (sDbOperatioContainer.containsKey(str)) {
            sDbOperatioContainer.remove(str).closeDb();
        }
    }

    public static DBOperation getDbOperation(Context context, String str) {
        if (str == null) {
            LogUtils.e(TAG, "dbname should not be null!");
            return null;
        }
        if (!sDbOperatioContainer.containsKey(str)) {
            synchronized (sDbOperatioContainer) {
                LogUtils.e(TAG, "dbname : " + str);
                if (!sDbOperatioContainer.containsKey(str)) {
                    DBOperation dBOperation = new DBOperation(context, new DBConnection(context, str, 49));
                    DBGroupTableManager dBGroupTableManager = new DBGroupTableManager();
                    dBGroupTableManager.init(dBOperation);
                    dBOperation.setTag(DBGroupTableManager.KEY, dBGroupTableManager);
                    sDbOperatioContainer.put(str, dBOperation);
                }
            }
        }
        return sDbOperatioContainer.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r0 != r2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DBOperation getNewDb(Context context) {
        if (context == null) {
            LogUtils.d(TAG, "pls call init method first!");
            return null;
        }
        long uk = AccountManagerImpl.getInstance(context).getUK();
        long appid = AccountManagerImpl.getInstance(context).getAppid();
        int i2 = (0L > uk ? 1 : (0L == uk ? 0 : -1));
        if (i2 != 0 && -1 != appid) {
            long j = sAppid;
            if (j == -1 || j == appid) {
                long j2 = sUk;
                if (j2 != 0) {
                }
                sUk = uk;
                sAppid = appid;
                return getDbOperation(context, context.getDatabasePath(DBTableDefine.DB_NAME_PREFIX + uk + "_" + appid + ".db").getPath());
            }
            closeDb(context.getDatabasePath(DBTableDefine.DB_NAME_PREFIX + sUk + "_" + sAppid + ".db").getPath());
            sUk = uk;
            sAppid = appid;
            return getDbOperation(context, context.getDatabasePath(DBTableDefine.DB_NAME_PREFIX + uk + "_" + appid + ".db").getPath());
        }
        LogUtils.d(TAG, "UK OR appid Not initialize!");
        if (i2 == 0) {
            LogUtils.d(TAG, "mUid Not initialize!");
        }
        if (-1 == appid) {
            LogUtils.d(TAG, "appid Not initialize!");
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        if (r8 != r0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DBOperation getOldDb(Context context) {
        String str;
        if (context == null) {
            LogUtils.d(TAG, "pls call init method first!");
            return null;
        }
        String uid = AccountManagerImpl.getInstance(context).getUid();
        long appid = AccountManagerImpl.getInstance(context).getAppid();
        if (!TextUtils.isEmpty(uid) && -1 != appid) {
            int env = Constants.getEnv(context);
            long j = sAppid;
            if ((j == -1 || j == appid) && ((str = sUid) == null || str.equals(uid))) {
                long j2 = sEnv;
                if (j2 != -1) {
                }
                sUid = uid;
                sAppid = appid;
                sEnv = env;
                String str2 = TableDefine.DB_NAME_PREFIX + uid + "_" + appid + ".db";
                if (1 == env) {
                    str2 = TableDefine.DB_NAME_PREFIX + uid + "_" + appid + "_rd.db";
                }
                return getDbOperation(context, context.getDatabasePath(str2).getPath());
            }
            closeDb(context.getDatabasePath("bdimsdk_new_" + sUid + "_" + sAppid + ".db").getPath());
            sUid = uid;
            sAppid = appid;
            sEnv = env;
            String str22 = TableDefine.DB_NAME_PREFIX + uid + "_" + appid + ".db";
            if (1 == env) {
            }
            return getDbOperation(context, context.getDatabasePath(str22).getPath());
        }
        LogUtils.d(TAG, "UK OR appid Not initialize!");
        if (TextUtils.isEmpty(uid)) {
            LogUtils.d(TAG, "mUid Not initialize!");
        }
        if (-1 == appid) {
            LogUtils.d(TAG, "appid Not initialize!");
        }
        return null;
    }
}
