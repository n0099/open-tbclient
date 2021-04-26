package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class DBOperation {
    public static final String TAG = "DBOperation";
    public static final int TIMEOUT_DB_OPERATION = 10;
    public static AtomicInteger sOperationId = new AtomicInteger(0);
    public Context mContext;
    public DBConnection mDBConnection;
    public SQLiteDatabase mDb;
    public Object mSyncObject = new Object();
    public HashMap<String, Object> mKeyObject = new HashMap<>();

    /* loaded from: classes.dex */
    public class DeleteTask implements Callable<Integer> {
        public String mOperationId;
        public String mTable;
        public String[] mWhereArgs;
        public String mWhereClause;

        public DeleteTask(String str, String str2, String str3, String[] strArr) {
            this.mOperationId = str;
            this.mTable = str2;
            this.mWhereClause = str3;
            this.mWhereArgs = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            int i2;
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
            if (openDb != null) {
                try {
                    try {
                        if (this.mWhereArgs != null) {
                            LogUtils.d(DBOperation.TAG, this.mTable + " delete : mWhereClause" + this.mWhereClause + ",mWhereArgs : " + Arrays.asList(this.mWhereArgs));
                        }
                        i2 = openDb.delete(this.mTable, this.mWhereClause, this.mWhereArgs);
                    } catch (SQLException e2) {
                        LogUtils.e(DBOperation.TAG, "delete", e2);
                        DBOperation.this.closeDbInternal();
                        i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                    }
                } finally {
                    DBOperation.this.closeDbInternal();
                }
            } else {
                i2 = DBResponseCode.ERROR_DB_OPEN;
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i2);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i2);
        }
    }

    /* loaded from: classes.dex */
    public class ExecSQLTask implements Callable<Integer> {
        public String mOperationId;
        public String mSql;

        public ExecSQLTask(String str, String str2) {
            this.mOperationId = str;
            this.mSql = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            int i2;
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
            if (openDb != null) {
                try {
                    try {
                        LogUtils.d(DBOperation.TAG, " execSQL: " + this.mSql);
                        openDb.execSQL(this.mSql);
                        i2 = 0;
                    } catch (SQLException e2) {
                        LogUtils.e(DBOperation.TAG, "execSQL", e2);
                        DBOperation.this.closeDbInternal();
                        i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                    }
                } finally {
                    DBOperation.this.closeDbInternal();
                }
            } else {
                i2 = DBResponseCode.ERROR_DB_OPEN;
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i2);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i2);
        }
    }

    /* loaded from: classes.dex */
    public class ExecTransaction implements Callable<Integer> {
        public String mOperationId;
        public ITransaction mTransaction;

        public ExecTransaction(String str, ITransaction iTransaction) {
            this.mOperationId = str;
            this.mTransaction = iTransaction;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            int i2;
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
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
                        DBOperation.this.closeDbInternal();
                        i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                    }
                } finally {
                    openDb.endTransaction();
                    DBOperation.this.closeDbInternal();
                }
            } else {
                i2 = DBResponseCode.ERROR_DB_OPEN;
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i2);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i2);
        }
    }

    /* loaded from: classes.dex */
    public class InsertBatchTask implements Callable<List<Long>> {
        public List<ContentValues> mCvs;
        public String mOperationId;
        public String mTable;

        public InsertBatchTask(String str, String str2, List<ContentValues> list) {
            this.mOperationId = str;
            this.mTable = str2;
            this.mCvs = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
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
                    DBOperation.this.closeDbInternal();
                }
            } else {
                arrayList.add(-70003L);
            }
            LogUtils.d(DBOperation.TAG, "ret : " + arrayList);
            LogUtils.leave(this.mOperationId);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public class InsertTask implements Callable<Long> {
        public ContentValues mCv;
        public String mOperationId;
        public String mTable;

        public InsertTask(String str, String str2, ContentValues contentValues) {
            this.mOperationId = str;
            this.mTable = str2;
            this.mCv = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            LogUtils.enter(this.mOperationId);
            Long l = -70003L;
            SQLiteDatabase openDb = DBOperation.this.openDb();
            try {
                if (openDb != null) {
                    try {
                        LogUtils.d(DBOperation.TAG, this.mTable + " insert: " + this.mCv);
                        l = Long.valueOf(openDb.insert(this.mTable, null, this.mCv));
                    } catch (Exception e2) {
                        LogUtils.e(DBOperation.TAG, "insert ", e2);
                        DBOperation.this.closeDbInternal();
                        l = -7004L;
                    }
                }
                LogUtils.d(DBOperation.TAG, "ret : " + l);
                LogUtils.leave(this.mOperationId);
                return l;
            } finally {
                DBOperation.this.closeDbInternal();
            }
        }
    }

    /* loaded from: classes.dex */
    public class QueryTask<T> implements Callable<ArrayList<T>> {
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

        public QueryTask(String str, IResultParse<T> iResultParse, String str2, String[] strArr, String str3, String[] strArr2, String str4, String str5, String str6, String str7) {
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
            SQLException e2;
            Cursor cursor;
            ArrayList<T> arrayList;
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
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
                                    DBOperation.this.closeDbInternal();
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
                    DBOperation.this.closeDbInternal();
                    Cursor cursor32 = cursor;
                    arrayList = (ArrayList<T>) cursor2;
                    cursor2 = cursor32;
                } catch (Throwable th) {
                    DBOperation.this.closeDbInternal();
                    throw th;
                }
            } else {
                arrayList = null;
            }
            LogUtils.d(DBOperation.TAG, "ret : " + cursor2);
            LogUtils.leave(this.mOperationId);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public class UpdateTask implements Callable<Integer> {
        public ContentValues mCv;
        public String mOperationId;
        public String mTable;
        public String[] mWhereArgs;
        public String mWhereClause;

        public UpdateTask(String str, String str2, ContentValues contentValues, String str3, String[] strArr) {
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
            int i2;
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
            try {
                if (openDb != null) {
                    try {
                        LogUtils.d(DBOperation.TAG, this.mTable + " update : mWhereClause" + this.mWhereClause + ",mWhereArgs : " + this.mWhereArgs + " ,mCv : " + this.mCv);
                        i2 = openDb.update(this.mTable, this.mCv, this.mWhereClause, this.mWhereArgs);
                    } catch (SQLException e2) {
                        LogUtils.e(DBOperation.TAG, "UpdateTask", e2);
                        DBOperation.this.closeDbInternal();
                        i2 = DBResponseCode.ERROR_SQLEXCEPTION;
                    }
                } else {
                    i2 = DBResponseCode.ERROR_DB_OPEN;
                }
                LogUtils.d(DBOperation.TAG, "ret : " + i2);
                LogUtils.leave(this.mOperationId);
                return Integer.valueOf(i2);
            } finally {
                DBOperation.this.closeDbInternal();
            }
        }
    }

    public DBOperation(Context context, DBConnection dBConnection) {
        this.mContext = context;
        this.mDBConnection = dBConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDbInternal() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase openDb() {
        synchronized (this.mSyncObject) {
            if (this.mDb == null) {
                this.mDb = this.mDBConnection.getWritableDatabase();
            }
        }
        return this.mDb;
    }

    public void closeDb() {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.mDb = null;
        }
    }

    public Integer delete(String str, String str2, String[] strArr) {
        Integer num;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        LogUtils.d(TAG, str + " delete: whereClause: " + str2 + " ,whereArgs :" + strArr);
        try {
            num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new DeleteTask(valueOf, str, str2, strArr)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
            LogUtils.e(TAG, "Exception ", e2);
            num = valueOf2;
        }
        LogUtils.leave(valueOf);
        return num;
    }

    public Integer execSQL(String str) {
        Integer num;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        LogUtils.d(TAG, " execSQL: " + str);
        try {
            num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new ExecSQLTask(valueOf, str)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
            LogUtils.e(TAG, "Exception ", e2);
            num = valueOf2;
        }
        LogUtils.leave(valueOf);
        return num;
    }

    public Integer execTransaction(ITransaction iTransaction) {
        Integer num;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (iTransaction == null) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        try {
            num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new ExecTransaction(valueOf, iTransaction)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            Integer valueOf2 = Integer.valueOf((int) DBResponseCode.ERROR_INTERRUPTED);
            LogUtils.e(TAG, "Exception ", e2);
            num = valueOf2;
        }
        LogUtils.leave(valueOf);
        return num;
    }

    public Object getTag(String str) {
        return this.mKeyObject.get(str);
    }

    public Long insert(String str, ContentValues contentValues) {
        Long l;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            LogUtils.d(TAG, str + " insert : " + contentValues.toString());
            try {
                l = (Long) TaskManager.getInstance(this.mContext).submitForLocalCallable(new InsertTask(valueOf, str, contentValues)).get(10L, TimeUnit.SECONDS);
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

    public <T> ArrayList<T> query(IResultParse<T> iResultParse, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        ArrayList<T> arrayList;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return null;
        }
        LogUtils.d(TAG, str + " query: selection : " + str2 + ", limit " + str6);
        try {
            arrayList = (ArrayList) TaskManager.getInstance(this.mContext).submitForLocalCallable(new QueryTask(valueOf, iResultParse, str, strArr, str2, strArr2, str3, str4, str5, str6)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
            arrayList = null;
        }
        LogUtils.leave(valueOf);
        return arrayList;
    }

    public void setTag(String str, Object obj) {
        if (this.mKeyObject.containsKey(str)) {
            this.mKeyObject.remove(str);
        }
        this.mKeyObject.put(str, obj);
    }

    public Integer update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Integer num;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            LogUtils.d(TAG, str + " update: whereClause: " + str2 + " ,whereArgs :" + strArr + " cv : " + contentValues);
            try {
                num = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new UpdateTask(valueOf, str, contentValues, str2, strArr)).get(10L, TimeUnit.SECONDS);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.List] */
    public List<Long> insert(String str, List<ContentValues> list) {
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            LogUtils.d(TAG, str + " insertbacth: " + str + " " + valueOf);
            try {
                arrayList = (List) TaskManager.getInstance(this.mContext).submitForLocalCallable(new InsertBatchTask(valueOf, str, list)).get(10L, TimeUnit.SECONDS);
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
}
