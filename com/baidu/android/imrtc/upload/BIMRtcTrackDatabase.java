package com.baidu.android.imrtc.upload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BIMRtcTrackDatabase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_NAME = "bimrtc_track.db";
    public static final int DB_VERSION = 1;
    public static final int MAX_QUERY_COUNT = 1000;
    public static String TAG = "BIMRtcTrackDatabase";
    public static DbOpenHelper dbOpenHelper;
    public static BIMRtcTrackDatabase instance;
    public static final Object myLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;

    /* loaded from: classes.dex */
    public class DbOpenHelper extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String SQL_TABLE_CREATE_REQUEST;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-377005314, "Lcom/baidu/android/imrtc/upload/BIMRtcTrackDatabase$DbOpenHelper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-377005314, "Lcom/baidu/android/imrtc/upload/BIMRtcTrackDatabase$DbOpenHelper;");
                    return;
                }
            }
            SQL_TABLE_CREATE_REQUEST = "CREATE TABLE request (" + RequestEnum.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RequestEnum.method.name() + " TEXT, " + RequestEnum.requestId.name() + " TEXT, " + RequestEnum.timestamp.name() + " LONG, " + RequestEnum.responseTime.name() + " LONG, " + RequestEnum.errorCode.name() + " LONG, " + RequestEnum.ext.name() + " TEXT, " + RequestEnum.aliasId.name() + " LONG NOT NULL);";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DbOpenHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.context = context;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DbOpenHelper(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i), databaseErrorHandler};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
                } catch (Exception e) {
                    String str = BIMRtcTrackDatabase.TAG;
                    LogUtils.d(str, "dropTables Exception: " + e);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_REQUEST);
                } catch (Exception e) {
                    String str = BIMRtcTrackDatabase.TAG;
                    LogUtils.d(str, "DbOpenHelper onCreate E: " + e);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                dropTables(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public final class RequestEnum {
        public static final /* synthetic */ RequestEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "request";
        public static final RequestEnum aliasId;
        public static final RequestEnum errorCode;
        public static final RequestEnum ext;
        public static final RequestEnum id;
        public static final RequestEnum method;
        public static final RequestEnum requestId;
        public static final RequestEnum responseTime;
        public static final RequestEnum timestamp;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-69237454, "Lcom/baidu/android/imrtc/upload/BIMRtcTrackDatabase$RequestEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-69237454, "Lcom/baidu/android/imrtc/upload/BIMRtcTrackDatabase$RequestEnum;");
                    return;
                }
            }
            id = new RequestEnum("id", 0);
            method = new RequestEnum("method", 1);
            requestId = new RequestEnum("requestId", 2);
            timestamp = new RequestEnum("timestamp", 3);
            responseTime = new RequestEnum("responseTime", 4);
            errorCode = new RequestEnum("errorCode", 5);
            ext = new RequestEnum("ext", 6);
            RequestEnum requestEnum = new RequestEnum("aliasId", 7);
            aliasId = requestEnum;
            $VALUES = new RequestEnum[]{id, method, requestId, timestamp, responseTime, errorCode, ext, requestEnum};
        }

        public RequestEnum(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RequestEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RequestEnum) Enum.valueOf(RequestEnum.class, str);
            }
            return (RequestEnum) invokeL.objValue;
        }

        public static RequestEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RequestEnum[]) $VALUES.clone();
            }
            return (RequestEnum[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(247191966, "Lcom/baidu/android/imrtc/upload/BIMRtcTrackDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(247191966, "Lcom/baidu/android/imrtc/upload/BIMRtcTrackDatabase;");
                return;
            }
        }
        myLock = new Object();
    }

    public BIMRtcTrackDatabase(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
    }

    public static SQLiteDatabase getDb(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (dbOpenHelper == null) {
                dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
            }
            try {
                return dbOpenHelper.getWritableDatabase();
            } catch (Throwable th) {
                LogUtils.e(TAG, "getDb Exception: ", th);
                return null;
            }
        }
        return (SQLiteDatabase) invokeL.objValue;
    }

    private List getCursorRequests(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            while (cursor != null && cursor.moveToNext()) {
                Request request = new Request();
                request.method = cursor.getString(cursor.getColumnIndex(RequestEnum.method.name()));
                request.requestId = cursor.getString(cursor.getColumnIndex(RequestEnum.requestId.name()));
                request.timestamp = cursor.getLong(cursor.getColumnIndex(RequestEnum.timestamp.name()));
                request.responseTime = cursor.getLong(cursor.getColumnIndex(RequestEnum.responseTime.name()));
                request.errorCode = cursor.getLong(cursor.getColumnIndex(RequestEnum.errorCode.name()));
                request.ext = cursor.getString(cursor.getColumnIndex(RequestEnum.ext.name()));
                request.aliasId = cursor.getLong(cursor.getColumnIndex(RequestEnum.aliasId.name()));
                arrayList.add(request);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static BIMRtcTrackDatabase getInstance(Context context) {
        InterceptResult invokeL;
        BIMRtcTrackDatabase bIMRtcTrackDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (myLock) {
                if (instance == null) {
                    instance = new BIMRtcTrackDatabase(context.getApplicationContext());
                }
                bIMRtcTrackDatabase = instance;
            }
            return bIMRtcTrackDatabase;
        }
        return (BIMRtcTrackDatabase) invokeL.objValue;
    }

    public void deleteRequests(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            synchronized (myLock) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    deleteRequest((Request) it.next());
                }
            }
        }
    }

    public void clearRequestTable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    db.delete("request", null, null);
                } catch (Exception e) {
                    String str = TAG;
                    LogUtils.e(str, "BIMRtcTrack clearRequestTable Exception: " + e);
                }
                db.close();
            }
        }
    }

    public void deleteRequest(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request) == null) {
            SQLiteDatabase db = getDb(this.context);
            try {
                if (db == null) {
                    return;
                }
                try {
                    db.delete("request", RequestEnum.responseTime + " = ?", new String[]{String.valueOf(request.responseTime)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteRequest :", e);
                }
            } finally {
                db.close();
            }
        }
    }

    public long getRequestCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (myLock) {
                long j = 0;
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return 0L;
                }
                Cursor cursor = null;
                try {
                    cursor = db.rawQuery("select count(*) from request", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "BIMRtcTrack insert Db exception : " + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return j;
            }
        }
        return invokeV.longValue;
    }

    public List getRequests() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                List arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from request limit 1000", null);
                    arrayList = getCursorRequests(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    String str = TAG;
                    LogUtils.e(str, "BIMRtcTrack getRequests error " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List getRequestsByAliasId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                List arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from request limit 1000 where " + RequestEnum.aliasId + " = " + j, null);
                    arrayList = getCursorRequests(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    String str = TAG;
                    LogUtils.e(str, "BIMRtcTrack getRequests error " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeJ.objValue;
    }

    public void insertRequest(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, request) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(RequestEnum.method.name(), request.method);
                    contentValues.put(RequestEnum.requestId.name(), request.requestId);
                    contentValues.put(RequestEnum.timestamp.name(), Long.valueOf(request.timestamp));
                    contentValues.put(RequestEnum.responseTime.name(), Long.valueOf(request.responseTime));
                    contentValues.put(RequestEnum.errorCode.name(), Long.valueOf(request.errorCode));
                    contentValues.put(RequestEnum.ext.name(), request.ext);
                    contentValues.put(RequestEnum.aliasId.name(), Long.valueOf(request.aliasId));
                    db.insert("request", null, contentValues);
                    String str = TAG;
                    LogUtils.d(str, "method :" + request.method + ", requestId :" + request.requestId + ", errorCode :" + request.errorCode + ", ext :" + request.ext);
                } catch (Exception e) {
                    String str2 = TAG;
                    LogUtils.e(str2, "BIMRtcTrack insert Request exception : " + e);
                }
                db.close();
            }
        }
    }
}
