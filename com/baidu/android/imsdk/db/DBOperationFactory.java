package com.baidu.android.imsdk.db;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class DBOperationFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBOperationFactory";
    public static long sAppid = -1;
    public static HashMap<String, DBOperation> sDbOperatioContainer = null;
    public static long sEnv = -1;
    public static String sUid;
    public static long sUk;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-359334832, "Lcom/baidu/android/imsdk/db/DBOperationFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-359334832, "Lcom/baidu/android/imsdk/db/DBOperationFactory;");
                return;
            }
        }
        sDbOperatioContainer = new HashMap<>();
    }

    public DBOperationFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void closeDb(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && sDbOperatioContainer.containsKey(str)) {
            sDbOperatioContainer.remove(str).closeDb();
        }
    }

    public static DBOperation getDbOperation(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (str == null) {
                LogUtils.e(TAG, "dbname should not be null!");
                return null;
            }
            if (!sDbOperatioContainer.containsKey(str)) {
                synchronized (sDbOperatioContainer) {
                    LogUtils.e(TAG, "dbname : " + str);
                    if (!sDbOperatioContainer.containsKey(str)) {
                        DBOperation dBOperation = new DBOperation(context, new DBConnection(context, str, 50));
                        DBGroupTableManager dBGroupTableManager = new DBGroupTableManager();
                        dBGroupTableManager.init(dBOperation);
                        dBOperation.setTag(DBGroupTableManager.KEY, dBGroupTableManager);
                        sDbOperatioContainer.put(str, dBOperation);
                    }
                }
            }
            return sDbOperatioContainer.get(str);
        }
        return (DBOperation) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r0 != r2) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DBOperation getNewDb(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                LogUtils.d(TAG, "pls call init method first!");
                return null;
            }
            long uk = AccountManagerImpl.getInstance(context).getUK();
            long appid = AccountManagerImpl.getInstance(context).getAppid();
            int i2 = (0L > uk ? 1 : (0L == uk ? 0 : -1));
            if (i2 != 0 && -1 != appid) {
                long j2 = sAppid;
                if (j2 == -1 || j2 == appid) {
                    long j3 = sUk;
                    if (j3 != 0) {
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
        return (DBOperation) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r8 != r0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DBOperation getOldDb(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                LogUtils.d(TAG, "pls call init method first!");
                return null;
            }
            String uid = AccountManagerImpl.getInstance(context).getUid();
            long appid = AccountManagerImpl.getInstance(context).getAppid();
            if (!TextUtils.isEmpty(uid) && -1 != appid) {
                int env = Constants.getEnv(context);
                long j2 = sAppid;
                if ((j2 == -1 || j2 == appid) && ((str = sUid) == null || str.equals(uid))) {
                    long j3 = sEnv;
                    if (j3 != -1) {
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
        return (DBOperation) invokeL.objValue;
    }
}
