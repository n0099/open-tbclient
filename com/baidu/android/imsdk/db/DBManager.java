package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBManager";
    public static volatile DBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class CmdQueueMsgParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CmdQueueMsg msg;
        public final /* synthetic */ DBManager this$0;

        public CmdQueueMsgParse(DBManager dBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBManager;
            this.msg = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null && cursor.moveToFirst()) {
                this.msg = new CmdQueueMsg();
                String string = cursor.getString(cursor.getColumnIndex("uuid"));
                String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_PARAM));
                String string3 = !cursor.isNull(cursor.getColumnIndex("extra")) ? cursor.getString(cursor.getColumnIndex("extra")) : "";
                int i2 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_METHOD_ID));
                this.msg.setUuid(string);
                this.msg.setBody(string2);
                this.msg.setMethodId(i2);
                this.msg.setExtra(string3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public CmdQueueMsg getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msg : (CmdQueueMsg) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-799319594, "Lcom/baidu/android/imsdk/db/DBManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-799319594, "Lcom/baidu/android/imsdk/db/DBManager;");
        }
    }

    public DBManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContext(context);
    }

    public static DBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (mInstance == null) {
                synchronized (DBManager.class) {
                    if (mInstance == null) {
                        mInstance = new DBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (DBManager) invokeL.objValue;
    }

    private String[] transToStringArray(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, iArr)) == null) {
            if (iArr == null || iArr.length == 0) {
                return null;
            }
            int length = iArr.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = String.valueOf(iArr[i2]);
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public void cleanAllData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase != null) {
                    openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, null, null);
                    openDatabase.delete("message", null, null);
                    openDatabase.delete(TableDefine.DB_TABLE_USERINFO, null, null);
                    openDatabase.delete("groupinfo", null, null);
                    openDatabase.delete("groupmember", null, null);
                }
            }
        }
    }

    public boolean deleteCmdMsg(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (DBBase.mSyncLock) {
                LogUtils.d("DBManager", "deleteCmdMsg( uuid:" + str + SmallTailInfo.EMOTION_SUFFIX);
                z = true;
                if (delete(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid=?", new String[]{str}) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public CmdQueueMsg getCmdQueueMsg(int i2) {
        InterceptResult invokeI;
        CmdQueueMsg result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            synchronized (DBBase.mSyncLock) {
                CmdQueueMsgParse cmdQueueMsgParse = new CmdQueueMsgParse(this);
                query(TableDefine.DB_TABLE_PA_CMD_QUEUE, null, "send_status=? AND type=?", new String[]{String.valueOf(1), String.valueOf(i2)}, null, null, "priority desc", cmdQueueMsgParse);
                result = cmdQueueMsgParse.getResult();
            }
            return result;
        }
        return (CmdQueueMsg) invokeI.objValue;
    }

    public boolean saveCmdMsg(String str, int i2, String str2, String str3, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            synchronized (DBBase.mSyncLock) {
                LogUtils.d("DBManager", "saveCmdMsg( uuid:" + str + "  ,methodId:" + i2 + " , cmdMsgBody:" + str2 + " , extra" + str3 + SmallTailInfo.EMOTION_SUFFIX);
                boolean z = true;
                if (getCmdQueueMsg(str, i4) != null) {
                    return true;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("uuid", str);
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_METHOD_ID, Integer.valueOf(i2));
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_PARAM, str2);
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, (Integer) 1);
                contentValues.put("priority", Integer.valueOf(i3));
                contentValues.put("type", Integer.valueOf(i4));
                if (str3 != null) {
                    contentValues.put("extra", str3);
                }
                if (insert(TableDefine.DB_TABLE_PA_CMD_QUEUE, contentValues) <= 0) {
                    z = false;
                }
                return z;
            }
        }
        return invokeCommon.booleanValue;
    }

    public int setCentainTypeIDel(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                String makePlaceholders = makePlaceholders(iArr.length);
                if (makePlaceholders == null) {
                    return -1;
                }
                String[] transToStringArray = transToStringArray(iArr);
                if (transToStringArray == null) {
                    return -1;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, (Integer) 1);
                return update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "type IN (" + makePlaceholders + SmallTailInfo.EMOTION_SUFFIX, transToStringArray, contentValues);
            }
        }
        return invokeL.intValue;
    }

    public boolean updateCmdMsgSendStatus(String str, int i2) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            synchronized (DBBase.mSyncLock) {
                LogUtils.d("DBManager", "updateCmdMsgSendStatus( uuid:" + str + ", sendStatus:" + i2 + SmallTailInfo.EMOTION_SUFFIX);
                ContentValues contentValues = new ContentValues();
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(i2));
                z = true;
                if (update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid = ?", new String[]{str}, contentValues) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public CmdQueueMsg getCmdQueueMsg(String str, int i2) {
        InterceptResult invokeLI;
        CmdQueueMsg result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            synchronized (DBBase.mSyncLock) {
                CmdQueueMsgParse cmdQueueMsgParse = new CmdQueueMsgParse(this);
                query(TableDefine.DB_TABLE_PA_CMD_QUEUE, null, "uuid= ? AND type=?", new String[]{str, String.valueOf(i2)}, null, null, null, cmdQueueMsgParse);
                result = cmdQueueMsgParse.getResult();
            }
            return result;
        }
        return (CmdQueueMsg) invokeLI.objValue;
    }

    public boolean updateCmdMsgSendStatus(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048583, this, str, str2, str3, i2)) == null) {
            synchronized (DBBase.mSyncLock) {
                LogUtils.d("DBManager", "updateCmdMsgSendStatus( uuid:" + str + ", sendStatus:" + i2 + SmallTailInfo.EMOTION_SUFFIX);
                ContentValues contentValues = new ContentValues();
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(i2));
                contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_PARAM, str2);
                contentValues.put("extra", str3);
                z = true;
                if (update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid = ?", new String[]{str}, contentValues) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeLLLI.booleanValue;
    }
}
