package com.baidu.android.imsdk.db;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class DBOperationFactory {
    private static final String TAG = "DBOperationFactory";
    private static String sUid = null;
    private static long sUk = 0;
    private static long sAppid = -1;
    private static long sEnv = -1;
    private static HashMap<String, DBOperation> sDbOperatioContainer = new HashMap<>();

    private static DBOperation getDbOperation(Context context, String str) {
        DBOperation dBOperation;
        if (str == null) {
            LogUtils.e(TAG, "dbname should not be null!");
            return null;
        }
        if (!sDbOperatioContainer.containsKey(str)) {
            synchronized (sDbOperatioContainer) {
                LogUtils.e(TAG, "dbname : " + str);
                if (!sDbOperatioContainer.containsKey(str) && (dBOperation = new DBOperation(context, new DBConnection(context, str, 41))) != null) {
                    DBGroupTableManager dBGroupTableManager = new DBGroupTableManager();
                    dBGroupTableManager.init(dBOperation);
                    dBOperation.setTag(DBGroupTableManager.KEY, dBGroupTableManager);
                    sDbOperatioContainer.put(str, dBOperation);
                }
            }
        }
        return sDbOperatioContainer.get(str);
    }

    private static void closeDb(String str) {
        if (sDbOperatioContainer.containsKey(str)) {
            sDbOperatioContainer.remove(str).closeDb();
        }
    }

    public static DBOperation getNewDb(Context context) {
        if (context == null) {
            LogUtils.d(TAG, "pls call init method first!");
            return null;
        }
        long uk = AccountManagerImpl.getInstance(context).getUK();
        long appid = AccountManagerImpl.getInstance(context).getAppid();
        if (0 == uk || -1 == appid) {
            LogUtils.d(TAG, "UK OR appid Not initialize!");
            if (0 == uk) {
                LogUtils.d(TAG, "mUid Not initialize!");
            }
            if (-1 == appid) {
                LogUtils.d(TAG, "appid Not initialize!");
                return null;
            }
            return null;
        }
        if ((sAppid != -1 && sAppid != appid) || (sUk != 0 && sUk != uk)) {
            closeDb(context.getDatabasePath(DBTableDefine.DB_NAME_PREFIX + sUk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + sAppid + ".db").getPath());
        }
        sUk = uk;
        sAppid = appid;
        return getDbOperation(context, context.getDatabasePath(DBTableDefine.DB_NAME_PREFIX + uk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + appid + ".db").getPath());
    }

    public static DBOperation getOldDb(Context context) {
        if (context == null) {
            LogUtils.d(TAG, "pls call init method first!");
            return null;
        }
        String uid = AccountManagerImpl.getInstance(context).getUid();
        long appid = AccountManagerImpl.getInstance(context).getAppid();
        if (TextUtils.isEmpty(uid) || -1 == appid) {
            LogUtils.d(TAG, "UK OR appid Not initialize!");
            if (TextUtils.isEmpty(uid)) {
                LogUtils.d(TAG, "mUid Not initialize!");
            }
            if (-1 == appid) {
                LogUtils.d(TAG, "appid Not initialize!");
                return null;
            }
            return null;
        }
        int env = Constants.getEnv(context);
        if ((sAppid != -1 && sAppid != appid) || ((sUid != null && !sUid.equals(uid)) || (sEnv != -1 && sEnv != env))) {
            closeDb(context.getDatabasePath("bdimsdk_new_" + sUid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + sAppid + ".db").getPath());
        }
        sUid = uid;
        sAppid = appid;
        sEnv = env;
        String str = TableDefine.DB_NAME_PREFIX + uid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + appid + ".db";
        if (1 == env) {
            str = TableDefine.DB_NAME_PREFIX + uid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + appid + "_rd.db";
        }
        return getDbOperation(context, context.getDatabasePath(str).getPath());
    }
}
