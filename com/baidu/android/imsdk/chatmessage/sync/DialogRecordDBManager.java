package com.baidu.android.imsdk.chatmessage.sync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class DialogRecordDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DialogRecordDBManager";
    public static DialogRecordDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class Parse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int count;
        public List<DialogRecord> result;
        public final /* synthetic */ DialogRecordDBManager this$0;

        public Parse(DialogRecordDBManager dialogRecordDBManager, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogRecordDBManager, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dialogRecordDBManager;
            this.result = null;
            this.count = i2;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public Object getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor) == null) || (r1 = cursor) == null) {
                return;
            }
            this.result = new ArrayList();
            while (cursor.moveToNext()) {
                int i2 = r1.getInt(r1.getColumnIndex("category"));
                long j2 = r1.getLong(r1.getColumnIndex("contacter"));
                long j3 = r1.getLong(r1.getColumnIndex(TableDefine.DRColumns.COLUMN_MAXMSGID));
                long j4 = r1.getLong(r1.getColumnIndex(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID));
                int i3 = r1.getInt(r1.getColumnIndex("state"));
                long j5 = r1.getLong(r1.getColumnIndex("update_time"));
                int i4 = r1.getInt(r1.getColumnIndex(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT));
                DialogRecord dialogRecord = new DialogRecord();
                String str = DialogRecordDBManager.TAG;
                LogUtils.i(str, "parseCursor dialogRecord : " + dialogRecord);
                dialogRecord.setCategory(i2).setContacter(j2).setState(i3).setJumpToRecent(i4).setMaxMsgid(j3).setUpdateTime(j5).setDialogueMsgid(j4);
                this.result.add(dialogRecord);
                Cursor cursor2 = cursor;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(439389330, "Lcom/baidu/android/imsdk/chatmessage/sync/DialogRecordDBManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(439389330, "Lcom/baidu/android/imsdk/chatmessage/sync/DialogRecordDBManager;");
        }
    }

    public DialogRecordDBManager(Context context) {
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
        this.mContext = context;
    }

    public static DialogRecordDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (DialogRecordDBManager.class) {
                if (mInstance == null) {
                    mInstance = new DialogRecordDBManager(context.getApplicationContext());
                }
            }
            return mInstance;
        }
        return (DialogRecordDBManager) invokeL.objValue;
    }

    public long add(DialogRecord dialogRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dialogRecord)) == null) {
            String str = TAG;
            LogUtils.i(str, "add DialogRecord : " + dialogRecord);
            LinkedList linkedList = new LinkedList();
            linkedList.add(dialogRecord);
            return addBatch(linkedList);
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long addBatch(List<DialogRecord> list) {
        InterceptResult invokeL;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            long j2 = -1;
            if (list == null) {
                return -1L;
            }
            long j3 = 0;
            if (list.size() == 0) {
                return 0L;
            }
            Cursor cursor2 = null;
            try {
                try {
                    sQLiteDatabase = openDatabase();
                    try {
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase == null) {
                LogUtils.e(TAG, "getWritableDb fail!");
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                return -1L;
            }
            sQLiteDatabase.beginTransaction();
            Iterator<DialogRecord> it = list.iterator();
            Cursor cursor3 = null;
            while (true) {
                try {
                    if (!it.hasNext()) {
                        cursor = cursor3;
                        break;
                    }
                    DialogRecord next = it.next();
                    String[] strArr = {String.valueOf(next.getCategory()), String.valueOf(next.getContacter())};
                    Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "category=? AND contacter=?", strArr, null, null, null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        return j2;
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(TableDefine.DRColumns.COLUMN_MAXMSGID, Long.valueOf(next.getMaxMsgid()));
                        contentValues.put("state", Integer.valueOf(next.getState()));
                        contentValues.put("update_time", Long.valueOf(next.getUpdateTime()));
                        contentValues.put(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID, Long.valueOf(next.getDialogueMsgid()));
                        if (query.getCount() > 0) {
                            contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 0);
                            j2 = sQLiteDatabase.update(TableDefine.DB_TABLE_DIALOG_RECORD, contentValues, "category=? AND contacter=?", strArr);
                        } else {
                            contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 1);
                            contentValues.put("category", Integer.valueOf(next.getCategory()));
                            contentValues.put("contacter", Long.valueOf(next.getContacter()));
                            j2 = sQLiteDatabase.insert(TableDefine.DB_TABLE_DIALOG_RECORD, null, contentValues);
                        }
                        if (query != null) {
                            query.close();
                            cursor3 = null;
                        } else {
                            cursor3 = query;
                        }
                        if (j2 < 0) {
                            cursor = cursor3;
                            j3 = 0;
                            break;
                        }
                        j3 = 0;
                    } catch (Exception e4) {
                        e = e4;
                        cursor2 = query;
                        try {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "deleteCmdMsg:", e);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            return j2;
                        } catch (Throwable th3) {
                            th = th3;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursor2 = query;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    cursor2 = cursor3;
                } catch (Throwable th5) {
                    th = th5;
                    cursor2 = cursor3;
                }
            }
            if (j2 >= j3) {
                sQLiteDatabase.setTransactionSuccessful();
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public int delete(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int delete = delete(TableDefine.DB_TABLE_DIALOG_RECORD, "category=? AND contacter=?", new String[]{String.valueOf(i2), String.valueOf(j2)});
            LogUtils.d("delete dialog record ", delete + GlideException.IndentedAppendable.INDENT + j2 + i2);
            return delete;
        }
        return invokeCommon.intValue;
    }

    public List<DialogRecord> getDialogRecord(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            Parse parse = new Parse(this, i2);
            query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "localmsgid < dialogueMsgid", null, null, null, "update_time desc", parse);
            return (List) parse.getResult();
        }
        return (List) invokeI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (0 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return invokeV.longValue;
        }
        Cursor cursor = null;
        long j2 = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                    return -1L;
                }
                cursor = openDatabase.rawQuery("select max(localmsgid) from dialog_record", null);
                if (cursor != null) {
                    j2 = 0;
                    if (cursor.moveToNext()) {
                        j2 = cursor.getLong(0);
                    }
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "maxMsgid:", e2);
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public List<DialogRecord> getUnCompleteDialogRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Parse parse = new Parse(this, 1);
            query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "localmsgid < dialogueMsgid", null, null, null, "update_time desc", parse);
            return (List) parse.getResult();
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnCompleteItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048583, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = 0;
        Cursor cursor = null;
        int i3 = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                    return -1;
                }
                cursor = openDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid", null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            i2 = cursor.getInt(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i3 = 0;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                        return i3;
                    }
                } else {
                    i2 = -1;
                }
                try {
                    String str = TAG;
                    LogUtils.i(str, "getUnCompleteItemCount : " + i2);
                    if (cursor != null) {
                        cursor.close();
                        return i2;
                    }
                    return i2;
                } catch (Exception e3) {
                    i3 = i2;
                    e = e3;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                    return i3;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public DialogRecord getDialogRecord(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            Parse parse = new Parse(this, 1);
            query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "category=? AND contacter=?", new String[]{String.valueOf(i2), String.valueOf(j2)}, null, null, null, parse);
            List list = (List) parse.getResult();
            if (list == null || list.size() == 0) {
                return null;
            }
            return (DialogRecord) list.get(0);
        }
        return (DialogRecord) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnCompleteItemCount(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) != null) {
            return invokeJ.intValue;
        }
        int i2 = 0;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                    return -1;
                }
                cursor = openDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid AND contacter = " + j2, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            i2 = cursor.getInt(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                    }
                } else {
                    i2 = -1;
                }
                String str = TAG;
                LogUtils.i(str, "getUnCompleteItemCount : " + i2);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e3) {
            e = e3;
            i2 = -1;
        }
    }
}
