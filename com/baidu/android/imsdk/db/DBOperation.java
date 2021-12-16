package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class DBOperation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBOperation";
    public static final int TIMEOUT_DB_OPERATION = 10;
    public static AtomicInteger sOperationId;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public DBConnection mDBConnection;
    public SQLiteDatabase mDb;
    public HashMap<String, Object> mKeyObject;
    public Object mSyncObject;

    /* renamed from: com.baidu.android.imsdk.db.DBOperation$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class DeleteTask implements Callable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mOperationId;
        public String mTable;
        public String[] mWhereArgs;
        public String mWhereClause;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ DeleteTask(DBOperation dBOperation, String str, String str2, String str3, String[] strArr, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, str2, str3, strArr);
        }

        public DeleteTask(DBOperation dBOperation, String str, String str2, String str3, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBOperation, str, str2, str3, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mTable = str2;
            this.mWhereClause = str3;
            this.mWhereArgs = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtils.enter(this.mOperationId);
                SQLiteDatabase openDb = this.this$0.openDb();
                try {
                    if (openDb != null) {
                        try {
                            if (this.mWhereArgs != null) {
                                LogUtils.d(DBOperation.TAG, this.mTable + " delete : mWhereClause" + this.mWhereClause + ",mWhereArgs : " + Arrays.asList(this.mWhereArgs));
                            }
                            i2 = openDb.delete(this.mTable, this.mWhereClause, this.mWhereArgs);
                        } catch (SQLException e2) {
                            LogUtils.e(DBOperation.TAG, "delete", e2);
                            this.this$0.closeDbInternal();
                            i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                        }
                    } else {
                        i2 = DBResponseCode.ERROR_DB_OPEN;
                    }
                    LogUtils.d(DBOperation.TAG, "ret : " + i2);
                    LogUtils.leave(this.mOperationId);
                    return Integer.valueOf(i2);
                } finally {
                    this.this$0.closeDbInternal();
                }
            }
            return (Integer) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class ExecSQLTask implements Callable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mOperationId;
        public String mSql;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ ExecSQLTask(DBOperation dBOperation, String str, String str2, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, str2);
        }

        public ExecSQLTask(DBOperation dBOperation, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBOperation, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mSql = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtils.enter(this.mOperationId);
                SQLiteDatabase openDb = this.this$0.openDb();
                if (openDb != null) {
                    try {
                        try {
                            LogUtils.d(DBOperation.TAG, " execSQL: " + this.mSql);
                            openDb.execSQL(this.mSql);
                            i2 = 0;
                        } catch (SQLException e2) {
                            LogUtils.e(DBOperation.TAG, "execSQL", e2);
                            this.this$0.closeDbInternal();
                            i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                        }
                    } finally {
                        this.this$0.closeDbInternal();
                    }
                } else {
                    i2 = DBResponseCode.ERROR_DB_OPEN;
                }
                LogUtils.d(DBOperation.TAG, "ret : " + i2);
                LogUtils.leave(this.mOperationId);
                return Integer.valueOf(i2);
            }
            return (Integer) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class ExecTransaction implements Callable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mOperationId;
        public ITransaction mTransaction;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ ExecTransaction(DBOperation dBOperation, String str, ITransaction iTransaction, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, iTransaction);
        }

        public ExecTransaction(DBOperation dBOperation, String str, ITransaction iTransaction) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBOperation, str, iTransaction};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mTransaction = iTransaction;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtils.enter(this.mOperationId);
                SQLiteDatabase openDb = this.this$0.openDb();
                if (openDb != null) {
                    try {
                        try {
                            openDb.beginTransaction();
                            this.mTransaction.execTransaction(openDb);
                            openDb.setTransactionSuccessful();
                            i2 = 0;
                        } catch (SQLException e2) {
                            LogUtils.e(DBOperation.TAG, "transaction", e2);
                            openDb.endTransaction();
                            this.this$0.closeDbInternal();
                            i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                        }
                    } finally {
                        openDb.endTransaction();
                        this.this$0.closeDbInternal();
                    }
                } else {
                    i2 = DBResponseCode.ERROR_DB_OPEN;
                }
                LogUtils.d(DBOperation.TAG, "ret : " + i2);
                LogUtils.leave(this.mOperationId);
                return Integer.valueOf(i2);
            }
            return (Integer) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class InsertBatchTask implements Callable<List<Long>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ContentValues> mCvs;
        public String mOperationId;
        public String mTable;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ InsertBatchTask(DBOperation dBOperation, String str, String str2, List list, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, str2, list);
        }

        public InsertBatchTask(DBOperation dBOperation, String str, String str2, List<ContentValues> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBOperation, str, str2, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mTable = str2;
            this.mCvs = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                LogUtils.enter(this.mOperationId);
                SQLiteDatabase openDb = this.this$0.openDb();
                ArrayList arrayList = new ArrayList();
                if (openDb != null) {
                    try {
                        try {
                            LogUtils.d(DBOperation.TAG, this.mTable + " insertbatch: " + this.mCvs);
                            openDb.beginTransaction();
                            for (ContentValues contentValues : this.mCvs) {
                                arrayList.add(Long.valueOf(openDb.replace(this.mTable, null, contentValues)));
                            }
                            openDb.setTransactionSuccessful();
                        } catch (Exception e2) {
                            arrayList.add(-7004L);
                            LogUtils.e(DBOperation.TAG, "insert bacth", e2);
                        }
                    } finally {
                        openDb.endTransaction();
                        this.this$0.closeDbInternal();
                    }
                } else {
                    arrayList.add(-70003L);
                }
                LogUtils.d(DBOperation.TAG, "ret : " + arrayList);
                LogUtils.leave(this.mOperationId);
                return arrayList;
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class InsertTask implements Callable<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentValues mCv;
        public String mOperationId;
        public String mTable;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ InsertTask(DBOperation dBOperation, String str, String str2, ContentValues contentValues, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, str2, contentValues);
        }

        public InsertTask(DBOperation dBOperation, String str, String str2, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBOperation, str, str2, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mTable = str2;
            this.mCv = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtils.enter(this.mOperationId);
                Long l = -70003L;
                SQLiteDatabase openDb = this.this$0.openDb();
                if (openDb != null) {
                    try {
                        try {
                            LogUtils.d(DBOperation.TAG, this.mTable + " insert: " + this.mCv);
                            l = Long.valueOf(openDb.insert(this.mTable, null, this.mCv));
                        } catch (Exception e2) {
                            LogUtils.e(DBOperation.TAG, "insert ", e2);
                            this.this$0.closeDbInternal();
                            l = -7004L;
                        }
                    } finally {
                        this.this$0.closeDbInternal();
                    }
                }
                LogUtils.d(DBOperation.TAG, "ret : " + l);
                LogUtils.leave(this.mOperationId);
                return l;
            }
            return (Long) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class QueryTask<T> implements Callable<ArrayList<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] mColumns;
        public String mGroupBy;
        public String mHaving;
        public String mLimit;
        public String mOperationId;
        public String mOrderBy;
        public IResultParse<T> mParse;
        public String mSelection;
        public String[] mSelectionArgs;
        public String mTable;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ QueryTask(DBOperation dBOperation, String str, IResultParse iResultParse, String str2, String[] strArr, String str3, String[] strArr2, String str4, String str5, String str6, String str7, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, iResultParse, str2, strArr, str3, strArr2, str4, str5, str6, str7);
        }

        public QueryTask(DBOperation dBOperation, String str, IResultParse<T> iResultParse, String str2, String[] strArr, String str3, String[] strArr2, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {dBOperation, str, iResultParse, str2, strArr, str3, strArr2, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mTable = str2;
            this.mColumns = strArr;
            this.mSelection = str3;
            this.mSelectionArgs = strArr2;
            this.mGroupBy = str4;
            this.mHaving = str5;
            this.mOrderBy = str6;
            this.mLimit = str7;
            this.mParse = iResultParse;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        public ArrayList<T> call() throws Exception {
            InterceptResult invokeV;
            SQLException e2;
            Cursor cursor;
            ArrayList<T> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                LogUtils.enter(this.mOperationId);
                SQLiteDatabase openDb = this.this$0.openDb();
                Cursor cursor2 = null;
                if (openDb != null) {
                    try {
                        try {
                            if (this.mSelectionArgs != null) {
                                LogUtils.d(DBOperation.TAG, this.mTable + ", mOperationId : " + this.mOperationId + " query: selection : " + this.mSelection + ", selectionArgs : " + Arrays.asList(this.mSelectionArgs) + ", limit " + this.mLimit);
                                for (String str : this.mSelectionArgs) {
                                    LogUtils.d(DBOperation.TAG, "arg : " + str);
                                }
                            }
                            cursor = openDb.query(this.mTable, this.mColumns, this.mSelection, this.mSelectionArgs, this.mGroupBy, this.mHaving, this.mOrderBy, this.mLimit);
                            if (cursor != null) {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    try {
                                        if (cursor.moveToFirst()) {
                                            do {
                                                T onParse = this.mParse.onParse(cursor);
                                                if (onParse != null) {
                                                    arrayList2.add(onParse);
                                                } else {
                                                    LogUtils.d(DBOperation.TAG, this.mTable + ", mOperationId : " + this.mOperationId + " item onParse is null");
                                                }
                                            } while (cursor.moveToNext());
                                            cursor.close();
                                            cursor2 = arrayList2;
                                        } else {
                                            cursor.close();
                                            cursor2 = arrayList2;
                                        }
                                    } catch (SQLException e3) {
                                        e2 = e3;
                                        cursor2 = arrayList2;
                                        LogUtils.e(DBOperation.TAG, "query", e2);
                                        this.this$0.closeDbInternal();
                                        Cursor cursor3 = cursor;
                                        arrayList = (ArrayList<T>) cursor2;
                                        cursor2 = cursor3;
                                        LogUtils.d(DBOperation.TAG, "ret : " + cursor2);
                                        LogUtils.leave(this.mOperationId);
                                        return arrayList;
                                    }
                                } catch (SQLException e4) {
                                    e2 = e4;
                                }
                            }
                        } catch (SQLException e5) {
                            e2 = e5;
                            cursor = null;
                        }
                        this.this$0.closeDbInternal();
                        Cursor cursor32 = cursor;
                        arrayList = (ArrayList<T>) cursor2;
                        cursor2 = cursor32;
                    } catch (Throwable th) {
                        this.this$0.closeDbInternal();
                        throw th;
                    }
                } else {
                    arrayList = null;
                }
                LogUtils.d(DBOperation.TAG, "ret : " + cursor2);
                LogUtils.leave(this.mOperationId);
                return arrayList;
            }
            return (ArrayList) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class UpdateTask implements Callable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentValues mCv;
        public String mOperationId;
        public String mTable;
        public String[] mWhereArgs;
        public String mWhereClause;
        public final /* synthetic */ DBOperation this$0;

        public /* synthetic */ UpdateTask(DBOperation dBOperation, String str, String str2, ContentValues contentValues, String str3, String[] strArr, AnonymousClass1 anonymousClass1) {
            this(dBOperation, str, str2, contentValues, str3, strArr);
        }

        public UpdateTask(DBOperation dBOperation, String str, String str2, ContentValues contentValues, String str3, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBOperation, str, str2, contentValues, str3, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBOperation;
            this.mOperationId = str;
            this.mTable = str2;
            this.mWhereClause = str3;
            this.mWhereArgs = strArr;
            this.mCv = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtils.enter(this.mOperationId);
                SQLiteDatabase openDb = this.this$0.openDb();
                if (openDb != null) {
                    try {
                        try {
                            LogUtils.d(DBOperation.TAG, this.mTable + " update : mWhereClause" + this.mWhereClause + ",mWhereArgs : " + this.mWhereArgs + " ,mCv : " + this.mCv);
                            i2 = openDb.update(this.mTable, this.mCv, this.mWhereClause, this.mWhereArgs);
                        } catch (SQLException e2) {
                            LogUtils.e(DBOperation.TAG, "UpdateTask", e2);
                            this.this$0.closeDbInternal();
                            i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                        }
                    } finally {
                        this.this$0.closeDbInternal();
                    }
                } else {
                    i2 = DBResponseCode.ERROR_DB_OPEN;
                }
                LogUtils.d(DBOperation.TAG, "ret : " + i2);
                LogUtils.leave(this.mOperationId);
                return Integer.valueOf(i2);
            }
            return (Integer) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1837891236, "Lcom/baidu/android/imsdk/db/DBOperation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1837891236, "Lcom/baidu/android/imsdk/db/DBOperation;");
                return;
            }
        }
        sOperationId = new AtomicInteger(0);
    }

    public DBOperation(Context context, DBConnection dBConnection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dBConnection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSyncObject = new Object();
        this.mKeyObject = new HashMap<>();
        this.mContext = context;
        this.mDBConnection = dBConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDbInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase openDb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            synchronized (this.mSyncObject) {
                if (this.mDb == null) {
                    this.mDb = this.mDBConnection.getWritableDatabase();
                }
            }
            return this.mDb;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public void closeDb() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sQLiteDatabase = this.mDb) == null) {
            return;
        }
        sQLiteDatabase.close();
        this.mDb = null;
    }

    public Integer delete(String str, String str2, String[] strArr) {
        InterceptResult invokeLLL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, strArr)) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            if (TextUtils.isEmpty(str)) {
                LogUtils.e(TAG, "parameter is null");
                return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
            }
            LogUtils.d(TAG, str + " delete: whereClause: " + str2 + " ,whereArgs :" + strArr);
            try {
                num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new DeleteTask(this, valueOf, str, str2, strArr, null)).get(10L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
                LogUtils.e(TAG, "Exception ", e2);
                num = valueOf2;
            }
            LogUtils.leave(valueOf);
            return num;
        }
        return (Integer) invokeLLL.objValue;
    }

    public Integer execSQL(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            if (TextUtils.isEmpty(str)) {
                LogUtils.e(TAG, "parameter is null");
                return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
            }
            LogUtils.d(TAG, " execSQL: " + str);
            try {
                num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new ExecSQLTask(this, valueOf, str, null)).get(10L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
                LogUtils.e(TAG, "Exception ", e2);
                num = valueOf2;
            }
            LogUtils.leave(valueOf);
            return num;
        }
        return (Integer) invokeL.objValue;
    }

    public Integer execTransaction(ITransaction iTransaction) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iTransaction)) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            if (iTransaction == null) {
                LogUtils.e(TAG, "parameter is null");
                return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
            }
            try {
                num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new ExecTransaction(this, valueOf, iTransaction, null)).get(10L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_INTERRUPTED);
                LogUtils.e(TAG, "Exception ", e2);
                num = valueOf2;
            }
            LogUtils.leave(valueOf);
            return num;
        }
        return (Integer) invokeL.objValue;
    }

    public Object getTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.mKeyObject.get(str) : invokeL.objValue;
    }

    public Long insert(String str, ContentValues contentValues) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, contentValues)) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            if (contentValues != null && !TextUtils.isEmpty(str)) {
                LogUtils.d(TAG, str + " insert : " + contentValues.toString());
                try {
                    l = (Long) TaskManager.getInstance(this.mContext).submitForLocalCallable(new InsertTask(this, valueOf, str, contentValues, null)).get(10L, TimeUnit.SECONDS);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                    l = -7005L;
                }
                LogUtils.leave(valueOf);
                return l;
            }
            LogUtils.e(TAG, "parameter is null");
            return -7001L;
        }
        return (Long) invokeLL.objValue;
    }

    public <T> ArrayList<T> query(IResultParse<T> iResultParse, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        ArrayList<T> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{iResultParse, str, strArr, str2, strArr2, str3, str4, str5, str6})) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            if (TextUtils.isEmpty(str)) {
                LogUtils.e(TAG, "parameter is null");
                return null;
            }
            LogUtils.d(TAG, str + " query: selection : " + str2 + ", limit " + str6);
            try {
                arrayList = (ArrayList) TaskManager.getInstance(this.mContext).submitForLocalCallable(new QueryTask(this, valueOf, iResultParse, str, strArr, str2, strArr2, str3, str4, str5, str6, null)).get(10L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                LogUtils.e(TAG, "Exception ", e2);
                arrayList = null;
            }
            LogUtils.leave(valueOf);
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void setTag(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj) == null) {
            if (this.mKeyObject.containsKey(str)) {
                this.mKeyObject.remove(str);
            }
            this.mKeyObject.put(str, obj);
        }
    }

    public Integer update(String str, ContentValues contentValues, String str2, String[] strArr) {
        InterceptResult invokeLLLL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, str, contentValues, str2, strArr)) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            if (contentValues != null && !TextUtils.isEmpty(str)) {
                LogUtils.d(TAG, str + " update: whereClause: " + str2 + " ,whereArgs :" + strArr + " cv : " + contentValues);
                try {
                    num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new UpdateTask(this, valueOf, str, contentValues, str2, strArr, null)).get(10L, TimeUnit.SECONDS);
                } catch (Exception e2) {
                    Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
                    LogUtils.e(TAG, "Exception ", e2);
                    num = valueOf2;
                }
                LogUtils.leave(valueOf);
                return num;
            }
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        return (Integer) invokeLLLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.List] */
    public List<Long> insert(String str, List<ContentValues> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, list)) == null) {
            String valueOf = String.valueOf(sOperationId.incrementAndGet());
            LogUtils.enter(valueOf);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
                LogUtils.d(TAG, str + " insertbacth: " + str + " " + valueOf);
                try {
                    arrayList = (List) TaskManager.getInstance(this.mContext).submitForLocalCallable(new InsertBatchTask(this, valueOf, str, list, null)).get(10L, TimeUnit.SECONDS);
                } catch (Exception e2) {
                    arrayList.add(-7005L);
                    LogUtils.e(TAG, "Exception ", e2);
                }
                LogUtils.leave(valueOf);
                return arrayList;
            }
            LogUtils.e(TAG, "parameter is null");
            arrayList.add(-7001L);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
