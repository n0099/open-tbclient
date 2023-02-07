package com.baidu.searchbox.cloudcommand.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CloudCommandDao {
    public static /* synthetic */ Interceptable $ic;
    public static CloudCommandDao mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase mDB;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(394125723, "Lcom/baidu/searchbox/cloudcommand/dao/CloudCommandDao;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(394125723, "Lcom/baidu/searchbox/cloudcommand/dao/CloudCommandDao;");
        }
    }

    public CloudCommandDao() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDB = CommandDatabaseHelper.getDatabase();
    }

    public static synchronized CloudCommandDao getInstance() {
        InterceptResult invokeV;
        CloudCommandDao cloudCommandDao;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (CloudCommandDao.class) {
                if (mInstance == null) {
                    mInstance = new CloudCommandDao();
                }
                cloudCommandDao = mInstance;
            }
            return cloudCommandDao;
        }
        return (CloudCommandDao) invokeV.objValue;
    }

    public boolean addCommand(String str, String str2, int i, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), str3, Long.valueOf(j)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", str);
            contentValues.put(CloudCommandTable.MSG_ID, str2);
            contentValues.put(CloudCommandTable.DISPATCHED, Integer.valueOf(i));
            contentValues.put("version", str3);
            contentValues.put("timestamp", Long.valueOf(j));
            if (this.mDB.insert(CloudCommandTable.TABLE_NAME, null, contentValues) != -1) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x006b, code lost:
        if (r1 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0079, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CloudCommandBean> queryAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = this.mDB.query(CloudCommandTable.TABLE_NAME, null, null, null, null, null, null);
                    while (cursor.moveToNext()) {
                        CloudCommandBean cloudCommandBean = new CloudCommandBean();
                        cloudCommandBean.setType(cursor.getString(cursor.getColumnIndex("type")));
                        cloudCommandBean.setMsgId(cursor.getString(cursor.getColumnIndex(CloudCommandTable.MSG_ID)));
                        cloudCommandBean.setDispatched(cursor.getInt(cursor.getColumnIndex(CloudCommandTable.DISPATCHED)));
                        cloudCommandBean.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                        cloudCommandBean.setTimeStamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                        arrayList.add(cloudCommandBean);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            return (List) invokeV.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0085, code lost:
        if (r1 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008e, code lost:
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0090, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0093, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CloudCommandBean> queryDispatched(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    SQLiteDatabase sQLiteDatabase = this.mDB;
                    cursor = sQLiteDatabase.query(CloudCommandTable.TABLE_NAME, null, "msgId =? and dispatched =?", new String[]{str, i + ""}, null, null, null);
                    while (cursor.moveToNext()) {
                        CloudCommandBean cloudCommandBean = new CloudCommandBean();
                        cloudCommandBean.setType(cursor.getString(cursor.getColumnIndex("type")));
                        cloudCommandBean.setMsgId(cursor.getString(cursor.getColumnIndex(CloudCommandTable.MSG_ID)));
                        cloudCommandBean.setDispatched(cursor.getInt(cursor.getColumnIndex(CloudCommandTable.DISPATCHED)));
                        cloudCommandBean.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                        cloudCommandBean.setTimeStamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                        arrayList.add(cloudCommandBean);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            return (List) invokeLI.objValue;
        }
    }
}
