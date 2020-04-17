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
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class DBOperation {
    public static final String TAG = "DBOperation";
    public static final int TIMEOUT_DB_OPERATION = 10;
    private static AtomicInteger sOperationId = new AtomicInteger(0);
    private Context mContext;
    private DBConnection mDBConnection;
    private SQLiteDatabase mDb;
    private Object mSyncObject = new Object();
    private HashMap<String, Object> mKeyObject = new HashMap<>();

    public DBOperation(Context context, DBConnection dBConnection) {
        this.mContext = context;
        this.mDBConnection = dBConnection;
    }

    public Object getTag(String str) {
        return this.mKeyObject.get(str);
    }

    public void setTag(String str, Object obj) {
        if (this.mKeyObject.containsKey(str)) {
            this.mKeyObject.remove(str);
        }
        this.mKeyObject.put(str, obj);
    }

    public Long insert(String str, ContentValues contentValues) {
        long j;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        if (contentValues == null || TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return -7001L;
        }
        LogUtils.d(TAG, str + " insert : " + contentValues.toString());
        Long.valueOf(-1L);
        try {
            j = (Long) TaskManager.getInstance(this.mContext).submitForLocalCallable(new InsertTask(valueOf, str, contentValues)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            j = -7005L;
            LogUtils.e(TAG, "Exception ", e);
        }
        LogUtils.leave(valueOf);
        return j;
    }

    public List<Long> insert(String str, List<ContentValues> list) {
        List<Long> list2;
        String valueOf = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            arrayList.add(-7001L);
            return arrayList;
        }
        LogUtils.d(TAG, str + " insertbacth: " + str + " " + valueOf);
        try {
            list2 = (List) TaskManager.getInstance(this.mContext).submitForLocalCallable(new InsertBatchTask(valueOf, str, list)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            arrayList.add(-7005L);
            LogUtils.e(TAG, "Exception ", e);
            list2 = arrayList;
        }
        LogUtils.leave(valueOf);
        return list2;
    }

    public Integer delete(String str, String str2, String[] strArr) {
        Integer valueOf;
        String valueOf2 = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf2);
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        LogUtils.d(TAG, str + " delete: whereClause: " + str2 + " ,whereArgs :" + strArr);
        Integer.valueOf(0);
        try {
            valueOf = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new DeleteTask(valueOf2, str, str2, strArr)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            valueOf = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
            LogUtils.e(TAG, "Exception ", e);
        }
        LogUtils.leave(valueOf2);
        return valueOf;
    }

    public Integer update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Integer valueOf;
        String valueOf2 = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf2);
        if (contentValues == null || TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        LogUtils.d(TAG, str + " update: whereClause: " + str2 + " ,whereArgs :" + strArr + " cv : " + contentValues);
        Integer.valueOf(0);
        try {
            valueOf = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new UpdateTask(valueOf2, str, contentValues, str2, strArr)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            valueOf = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
            LogUtils.e(TAG, "Exception ", e);
        }
        LogUtils.leave(valueOf2);
        return valueOf;
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
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            arrayList = null;
        }
        LogUtils.leave(valueOf);
        return arrayList;
    }

    public Integer execSQL(String str) {
        Integer valueOf;
        String valueOf2 = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf2);
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        LogUtils.d(TAG, " execSQL: " + str);
        Integer.valueOf(0);
        try {
            valueOf = (Integer) TaskManager.getInstance(this.mContext).submitForLocalCallable(new ExecSQLTask(valueOf2, str)).get(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            valueOf = Integer.valueOf((int) DBResponseCode.ERROR_TIMEOUT);
            LogUtils.e(TAG, "Exception ", e);
        }
        LogUtils.leave(valueOf2);
        return valueOf;
    }

    public Integer execTransaction(ITransaction iTransaction) {
        Integer valueOf;
        String valueOf2 = String.valueOf(sOperationId.incrementAndGet());
        LogUtils.enter(valueOf2);
        if (iTransaction == null) {
            LogUtils.e(TAG, "parameter is null");
            return Integer.valueOf((int) DBResponseCode.ERROR_PARAMETER);
        }
        Future submitForLocalCallable = TaskManager.getInstance(this.mContext).submitForLocalCallable(new ExecTransaction(valueOf2, iTransaction));
        Integer.valueOf(0);
        try {
            valueOf = (Integer) submitForLocalCallable.get(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            valueOf = Integer.valueOf((int) DBResponseCode.ERROR_INTERRUPTED);
            LogUtils.e(TAG, "Exception ", e);
        }
        LogUtils.leave(valueOf2);
        return valueOf;
    }

    public void closeDb() {
        if (this.mDb != null) {
            this.mDb.close();
            this.mDb = null;
        }
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

    /* loaded from: classes3.dex */
    private class InsertTask implements Callable<Long> {
        private ContentValues mCv;
        private String mOperationId;
        private String mTable;

        private InsertTask(String str, String str2, ContentValues contentValues) {
            this.mOperationId = str;
            this.mTable = str2;
            this.mCv = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            LogUtils.enter(this.mOperationId);
            long j = -70003L;
            SQLiteDatabase openDb = DBOperation.this.openDb();
            if (openDb != null) {
                try {
                    LogUtils.d(DBOperation.TAG, this.mTable + " insert: " + this.mCv);
                    j = Long.valueOf(openDb.insert(this.mTable, null, this.mCv));
                } catch (Exception e) {
                    j = -7004L;
                    LogUtils.e(DBOperation.TAG, "insert ", e);
                } finally {
                    DBOperation.this.closeDbInternal();
                }
            }
            LogUtils.d(DBOperation.TAG, "ret : " + j);
            LogUtils.leave(this.mOperationId);
            return j;
        }
    }

    /* loaded from: classes3.dex */
    private class InsertBatchTask implements Callable<List<Long>> {
        private List<ContentValues> mCvs;
        private String mOperationId;
        private String mTable;

        private InsertBatchTask(String str, String str2, List<ContentValues> list) {
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
                    LogUtils.d(DBOperation.TAG, this.mTable + " insertbatch: " + this.mCvs);
                    openDb.beginTransaction();
                    for (ContentValues contentValues : this.mCvs) {
                        arrayList.add(Long.valueOf(openDb.replace(this.mTable, null, contentValues)));
                    }
                    openDb.setTransactionSuccessful();
                } catch (Exception e) {
                    arrayList.add(-7004L);
                    LogUtils.e(DBOperation.TAG, "insert bacth", e);
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

    /* loaded from: classes3.dex */
    private class DeleteTask implements Callable<Integer> {
        private String mOperationId;
        private String mTable;
        private String[] mWhereArgs;
        private String mWhereClause;

        private DeleteTask(String str, String str2, String str3, String[] strArr) {
            this.mOperationId = str;
            this.mTable = str2;
            this.mWhereClause = str3;
            this.mWhereArgs = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            LogUtils.enter(this.mOperationId);
            int i = DBResponseCode.ERROR_DB_OPEN;
            SQLiteDatabase openDb = DBOperation.this.openDb();
            if (openDb != null) {
                try {
                    if (this.mWhereArgs != null) {
                        LogUtils.d(DBOperation.TAG, this.mTable + " delete : mWhereClause" + this.mWhereClause + ",mWhereArgs : " + Arrays.asList(this.mWhereArgs));
                    }
                    i = openDb.delete(this.mTable, this.mWhereClause, this.mWhereArgs);
                } catch (SQLException e) {
                    i = DBResponseCode.ERROR_SQLEXCEPTION;
                    LogUtils.e(DBOperation.TAG, "delete", e);
                } finally {
                    DBOperation.this.closeDbInternal();
                }
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i);
        }
    }

    /* loaded from: classes3.dex */
    private class UpdateTask implements Callable<Integer> {
        private ContentValues mCv;
        private String mOperationId;
        private String mTable;
        private String[] mWhereArgs;
        private String mWhereClause;

        private UpdateTask(String str, String str2, ContentValues contentValues, String str3, String[] strArr) {
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
            LogUtils.enter(this.mOperationId);
            int i = DBResponseCode.ERROR_DB_OPEN;
            SQLiteDatabase openDb = DBOperation.this.openDb();
            try {
            } catch (SQLException e) {
                i = DBResponseCode.ERROR_SQLEXCEPTION;
                LogUtils.e(DBOperation.TAG, "UpdateTask", e);
            } finally {
                DBOperation.this.closeDbInternal();
            }
            if (openDb != null) {
                LogUtils.d(DBOperation.TAG, this.mTable + " update : mWhereClause" + this.mWhereClause + ",mWhereArgs : " + this.mWhereArgs + " ,mCv : " + this.mCv);
                i = openDb.update(this.mTable, this.mCv, this.mWhereClause, this.mWhereArgs);
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i);
        }
    }

    /* loaded from: classes3.dex */
    private class QueryTask<T> implements Callable<ArrayList<T>> {
        private String[] mColumns;
        private String mGroupBy;
        private String mHaving;
        private String mLimit;
        private String mOperationId;
        private String mOrderBy;
        private IResultParse<T> mParse;
        private String mSelection;
        private String[] mSelectionArgs;
        private String mTable;

        private QueryTask(String str, IResultParse<T> iResultParse, String str2, String[] strArr, String str3, String[] strArr2, String str4, String str5, String str6, String str7) {
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
        @Override // java.util.concurrent.Callable
        public ArrayList<T> call() throws Exception {
            SQLException sQLException;
            ArrayList<T> arrayList;
            String[] strArr;
            Cursor cursor = null;
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
            if (openDb != null) {
                try {
                    try {
                        if (this.mSelectionArgs != null) {
                            LogUtils.d(DBOperation.TAG, this.mTable + ", mOperationId : " + this.mOperationId + " query: selection : " + this.mSelection + ", selectionArgs : " + Arrays.asList(this.mSelectionArgs) + ", limit " + this.mLimit);
                            int length = this.mSelectionArgs.length;
                            for (int i = 0; i < length; i++) {
                                LogUtils.d(DBOperation.TAG, "arg : " + strArr[i]);
                            }
                        }
                        Cursor query = openDb.query(this.mTable, this.mColumns, this.mSelection, this.mSelectionArgs, this.mGroupBy, this.mHaving, this.mOrderBy, this.mLimit);
                        if (query != null) {
                            try {
                                arrayList = new ArrayList<>();
                            } catch (SQLException e) {
                                arrayList = null;
                                cursor = query;
                                sQLException = e;
                            }
                            try {
                                if (query.moveToFirst()) {
                                    do {
                                        T onParse = this.mParse.onParse(query);
                                        if (onParse != null) {
                                            arrayList.add(onParse);
                                        } else {
                                            LogUtils.d(DBOperation.TAG, this.mTable + ", mOperationId : " + this.mOperationId + " item onParse is null");
                                        }
                                    } while (query.moveToNext());
                                    query.close();
                                } else {
                                    query.close();
                                }
                            } catch (SQLException e2) {
                                cursor = query;
                                sQLException = e2;
                                LogUtils.e(DBOperation.TAG, "query", sQLException);
                                LogUtils.d(DBOperation.TAG, "ret : " + cursor);
                                LogUtils.leave(this.mOperationId);
                                return arrayList;
                            }
                        } else {
                            arrayList = null;
                        }
                        DBOperation.this.closeDbInternal();
                        cursor = query;
                    } finally {
                        DBOperation.this.closeDbInternal();
                    }
                } catch (SQLException e3) {
                    sQLException = e3;
                    arrayList = null;
                }
            } else {
                arrayList = null;
            }
            LogUtils.d(DBOperation.TAG, "ret : " + cursor);
            LogUtils.leave(this.mOperationId);
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    private class ExecSQLTask implements Callable<Integer> {
        private String mOperationId;
        private String mSql;

        private ExecSQLTask(String str, String str2) {
            this.mOperationId = str;
            this.mSql = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
            int i = DBResponseCode.ERROR_DB_OPEN;
            if (openDb != null) {
                try {
                    LogUtils.d(DBOperation.TAG, " execSQL: " + this.mSql);
                    openDb.execSQL(this.mSql);
                    i = 0;
                } catch (SQLException e) {
                    i = DBResponseCode.ERROR_SQLEXCEPTION;
                    LogUtils.e(DBOperation.TAG, "execSQL", e);
                } finally {
                    DBOperation.this.closeDbInternal();
                }
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i);
        }
    }

    /* loaded from: classes3.dex */
    private class ExecTransaction implements Callable<Integer> {
        private String mOperationId;
        private ITransaction mTransaction;

        private ExecTransaction(String str, ITransaction iTransaction) {
            this.mOperationId = str;
            this.mTransaction = iTransaction;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            LogUtils.enter(this.mOperationId);
            SQLiteDatabase openDb = DBOperation.this.openDb();
            int i = DBResponseCode.ERROR_DB_OPEN;
            if (openDb != null) {
                try {
                    openDb.beginTransaction();
                    this.mTransaction.execTransaction(openDb);
                    openDb.setTransactionSuccessful();
                    i = 0;
                } catch (SQLException e) {
                    i = DBResponseCode.ERROR_SQLEXCEPTION;
                    LogUtils.e(DBOperation.TAG, "transaction", e);
                } finally {
                    openDb.endTransaction();
                    DBOperation.this.closeDbInternal();
                }
            }
            LogUtils.d(DBOperation.TAG, "ret : " + i);
            LogUtils.leave(this.mOperationId);
            return Integer.valueOf(i);
        }
    }
}
