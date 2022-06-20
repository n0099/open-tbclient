package com.baidu.sofire.rp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.rp.info.ReportItemInfo;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ReportDb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALTER_TABLE = "alter table r add i integer default 0;";
    public static final String CREATE_TABLE_COMMON = "create table if not exists c(a integer primary key autoincrement, b text); ";
    public static final String CREATE_TABLE_RECORD = "create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);";
    public static final String C_ID = "a";
    public static final String C_MD5 = "b";
    public static final int DATABASE_REPORT_VERSION = 3;
    public static final String EVENT_DATA = "h";
    public static final String EVENT_FREQUENCY = "e";
    public static final String EVENT_ID = "b";
    public static final String EVENT_MAX_FREQUENCY = "f";
    public static final String EVENT_NET_TYPE = "g";
    public static final String EVENT_REPORT_TYPE = "j";
    public static final String EVENT_TAG = "i";
    public static final String EVENT_TIME = "d";
    public static final String EVENT_TYPE = "c";
    public static final String KEY = "xVOTuxgN3lkRN2v4";
    public static final String R_ID = "a";
    public static final String TABLE_COMMON = "c";
    public static ReportDb instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public SQLiteDatabase mDB;
    public DataBaseHelper mDBHelper;

    /* loaded from: classes2.dex */
    public class DataBaseHelper extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportDb this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DataBaseHelper(ReportDb reportDb, Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportDb, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = reportDb;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL(ReportDb.CREATE_TABLE_RECORD);
                sQLiteDatabase.execSQL(ReportDb.CREATE_TABLE_COMMON);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                if (i <= 1) {
                    sQLiteDatabase.execSQL(ReportDb.ALTER_TABLE);
                }
                if (i <= 2) {
                    sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
                }
            }
        }
    }

    public ReportDb(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mDBHelper = new DataBaseHelper(this, context);
        initDBSafely();
    }

    public static synchronized ReportDb getInstance(Context context) {
        InterceptResult invokeL;
        ReportDb reportDb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (ReportDb.class) {
                if (instance == null) {
                    instance = new ReportDb(context);
                }
                reportDb = instance;
            }
            return reportDb;
        }
        return (ReportDb) invokeL.objValue;
    }

    private void initDBSafely() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                this.mDB = this.mDBHelper.getWritableDatabase();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public int deleteEvent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            try {
                return this.mDB.delete("r", "a=?", new String[]{String.valueOf(i)});
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return -1;
            }
        }
        return invokeI.intValue;
    }

    public int deleteOverTimeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(this.mContext);
            long currentTimeMillis = System.currentTimeMillis();
            int reportOverTime = sharedPreferenceManager.getReportOverTime() * 86400000;
            try {
                return this.mDB.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - reportOverTime)});
            } catch (Exception e) {
                CommonMethods.handleNuLException(e);
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public int getAllReportInfoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = this.mDB.query("r", null, null, null, null, null, null, null);
                        r1 = cursor != null ? cursor.getCount() : 0;
                    } catch (Throwable th) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e) {
                                CommonMethods.handleNuLException(e);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    CommonMethods.handleNuLException(e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e3) {
                CommonMethods.handleNuLException(e3);
            }
            return r1;
        }
        return invokeV.intValue;
    }

    public List<ReportItemInfo> getReportAllData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = this.mDB.query("r", null, null, null, null, null, null, null);
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                ReportItemInfo reportItemInfo = new ReportItemInfo();
                                reportItemInfo.id = cursor.getInt(cursor.getColumnIndex("a"));
                                reportItemInfo.eventId = cursor.getString(cursor.getColumnIndex("b"));
                                reportItemInfo.eventType = cursor.getInt(cursor.getColumnIndex("c"));
                                reportItemInfo.timestamp = cursor.getLong(cursor.getColumnIndex("d"));
                                reportItemInfo.network = cursor.getInt(cursor.getColumnIndex("g"));
                                reportItemInfo.frequency = cursor.getInt(cursor.getColumnIndex("e"));
                                reportItemInfo.maxFrequency = cursor.getInt(cursor.getColumnIndex("f"));
                                reportItemInfo.tag = cursor.getInt(cursor.getColumnIndex("i"));
                                reportItemInfo.reportTopic = cursor.getString(cursor.getColumnIndex(EVENT_REPORT_TYPE));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ae(Base64.decode(string, 0), KEY.getBytes(IMAudioTransRequest.CHARSET)));
                                } catch (Exception e) {
                                    CommonMethods.handleNuLException(e);
                                }
                                reportItemInfo.data = string;
                                arrayList.add(reportItemInfo);
                            }
                        }
                    } catch (Exception e2) {
                        CommonMethods.handleNuLException(e2);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                            CommonMethods.handleNuLException(e3);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                CommonMethods.handleNuLException(e4);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<ReportItemInfo> getReportData(int i) {
        InterceptResult invokeI;
        String str;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(this.mContext);
            int reportLastTime = sharedPreferenceManager.getReportLastTime() * 3600000;
            if (i == 2) {
                str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )";
            } else {
                str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - reportLastTime) + SmallTailInfo.EMOTION_SUFFIX;
            }
            String str2 = str;
            Cursor cursor = null;
            try {
                try {
                    try {
                        if (i == 2) {
                            query = this.mDB.query("r", null, str2, null, null, null, "d desc", Integer.toString(100));
                        } else {
                            query = this.mDB.query("r", null, str2, null, null, null, "d desc", Integer.toString(sharedPreferenceManager.getUploadNumberLimit()));
                        }
                        cursor = query;
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                ReportItemInfo reportItemInfo = new ReportItemInfo();
                                reportItemInfo.id = cursor.getInt(cursor.getColumnIndex("a"));
                                reportItemInfo.eventId = cursor.getString(cursor.getColumnIndex("b"));
                                reportItemInfo.eventType = cursor.getInt(cursor.getColumnIndex("c"));
                                reportItemInfo.timestamp = cursor.getLong(cursor.getColumnIndex("d"));
                                reportItemInfo.network = cursor.getInt(cursor.getColumnIndex("g"));
                                reportItemInfo.frequency = cursor.getInt(cursor.getColumnIndex("e"));
                                reportItemInfo.maxFrequency = cursor.getInt(cursor.getColumnIndex("f"));
                                reportItemInfo.tag = cursor.getInt(cursor.getColumnIndex("i"));
                                reportItemInfo.reportTopic = cursor.getString(cursor.getColumnIndex(EVENT_REPORT_TYPE));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), KEY.getBytes(IMAudioTransRequest.CHARSET)));
                                } catch (Exception e) {
                                    CommonMethods.handleNuLException(e);
                                }
                                reportItemInfo.data = string;
                                arrayList.add(reportItemInfo);
                            }
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                CommonMethods.handleNuLException(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    CommonMethods.handleNuLException(e3);
                }
            } catch (Exception e4) {
                CommonMethods.handleNuLException(e4);
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public List<ReportItemInfo> getReportDelayData(boolean z, int i) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                str = "(d < (" + currentTimeMillis + "-f*3600000) and f!= 0)";
            } else {
                str = "d<=" + (currentTimeMillis - ImagesInvalidService.FILE_VALID_TIME);
            }
            String str2 = str;
            Cursor cursor = null;
            try {
                try {
                    try {
                        if (i == 2) {
                            cursor = this.mDB.query("r", null, str2, null, null, null, "d desc", "100");
                        } else {
                            cursor = this.mDB.query("r", null, str2, null, null, null, "d desc", Integer.toString(SharedPreferenceManager.getInstance(this.mContext).getUploadNumberLimit()));
                        }
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                ReportItemInfo reportItemInfo = new ReportItemInfo();
                                reportItemInfo.id = cursor.getInt(cursor.getColumnIndex("a"));
                                reportItemInfo.eventId = cursor.getString(cursor.getColumnIndex("b"));
                                reportItemInfo.eventType = cursor.getInt(cursor.getColumnIndex("c"));
                                reportItemInfo.timestamp = cursor.getLong(cursor.getColumnIndex("d"));
                                reportItemInfo.network = cursor.getInt(cursor.getColumnIndex("g"));
                                reportItemInfo.frequency = cursor.getInt(cursor.getColumnIndex("e"));
                                reportItemInfo.maxFrequency = cursor.getInt(cursor.getColumnIndex("f"));
                                reportItemInfo.tag = cursor.getInt(cursor.getColumnIndex("i"));
                                reportItemInfo.reportTopic = cursor.getString(cursor.getColumnIndex(EVENT_REPORT_TYPE));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), KEY.getBytes(IMAudioTransRequest.CHARSET)));
                                } catch (Exception e) {
                                    CommonMethods.handleNuLException(e);
                                }
                                reportItemInfo.data = string;
                                arrayList.add(reportItemInfo);
                            }
                        }
                    } catch (Exception e2) {
                        CommonMethods.handleNuLException(e2);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                            CommonMethods.handleNuLException(e3);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                CommonMethods.handleNuLException(e4);
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public List<ReportItemInfo> getReportPriorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = this.mDB.query("r", null, "i=5", null, null, null, "d desc", "100");
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                ReportItemInfo reportItemInfo = new ReportItemInfo();
                                reportItemInfo.id = cursor.getInt(cursor.getColumnIndex("a"));
                                reportItemInfo.eventId = cursor.getString(cursor.getColumnIndex("b"));
                                reportItemInfo.eventType = cursor.getInt(cursor.getColumnIndex("c"));
                                reportItemInfo.timestamp = cursor.getLong(cursor.getColumnIndex("d"));
                                reportItemInfo.network = cursor.getInt(cursor.getColumnIndex("g"));
                                reportItemInfo.frequency = cursor.getInt(cursor.getColumnIndex("e"));
                                reportItemInfo.maxFrequency = cursor.getInt(cursor.getColumnIndex("f"));
                                reportItemInfo.tag = cursor.getInt(cursor.getColumnIndex("i"));
                                reportItemInfo.reportTopic = cursor.getString(cursor.getColumnIndex(EVENT_REPORT_TYPE));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), KEY.getBytes(IMAudioTransRequest.CHARSET)));
                                } catch (Exception e) {
                                    CommonMethods.handleNuLException(e);
                                }
                                reportItemInfo.data = string;
                                arrayList.add(reportItemInfo);
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e2) {
                        CommonMethods.handleNuLException(e2);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (Exception e3) {
                    CommonMethods.handleNuLException(e3);
                }
                return arrayList;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        CommonMethods.handleNuLException(e4);
                    }
                }
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    public long insertCommon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", str);
            try {
                return this.mDB.insert("c", null, contentValues);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public long insertEvent(ReportItemInfo reportItemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, reportItemInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", reportItemInfo.eventId);
            contentValues.put("c", Integer.valueOf(reportItemInfo.eventType));
            contentValues.put("d", Long.valueOf(reportItemInfo.timestamp));
            contentValues.put("e", Integer.valueOf(reportItemInfo.frequency));
            contentValues.put("g", Integer.valueOf(reportItemInfo.network));
            contentValues.put("f", Integer.valueOf(reportItemInfo.maxFrequency));
            contentValues.put("i", Integer.valueOf(reportItemInfo.tag));
            contentValues.put(EVENT_REPORT_TYPE, reportItemInfo.reportTopic);
            String str = reportItemInfo.data;
            try {
                str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), KEY.getBytes(IMAudioTransRequest.CHARSET)), 0);
            } catch (Exception e) {
                CommonMethods.handleNuLException(e);
            }
            contentValues.put("h", str);
            try {
                return this.mDB.insert("r", null, contentValues);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public boolean isCommonChanged(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            boolean z = true;
            try {
                Cursor query = this.mDB.query("c", null, "b=?", new String[]{str}, null, null, null);
                if (query != null && query.getCount() > 0) {
                    z = false;
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                CommonMethods.handleNuLException(e);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x0041
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public int deleteEvent(java.util.List<java.lang.Integer> r5) {
        /*
            r4 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.sofire.rp.db.ReportDb.$ic
            if (r0 != 0) goto L78
        L4:
            r0 = -1
            android.database.sqlite.SQLiteDatabase r1 = r4.mDB     // Catch: java.lang.Throwable -> L45
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L45
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L45
        Le:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L2b
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L45
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L45
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L45
            int r0 = r4.deleteEvent(r1)     // Catch: java.lang.Throwable -> L45
            if (r0 > 0) goto Le
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L45
            com.baidu.sofire.rp.service.Service.sFailTime = r1     // Catch: java.lang.Throwable -> L45
            goto Le
        L2b:
            android.database.sqlite.SQLiteDatabase r5 = r4.mDB     // Catch: java.lang.Throwable -> L45
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L45
            android.database.sqlite.SQLiteDatabase r5 = r4.mDB     // Catch: java.lang.Throwable -> L36
            r5.endTransaction()     // Catch: java.lang.Throwable -> L36
            goto L61
        L36:
            r5 = move-exception
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3e
            com.baidu.sofire.rp.service.Service.sFailTime = r1     // Catch: java.lang.Throwable -> L3e
            goto L41
        L3e:
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r5)
        L41:
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r5)
            goto L61
        L45:
            r5 = move-exception
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L4d
            com.baidu.sofire.rp.service.Service.sFailTime = r1     // Catch: java.lang.Throwable -> L4d
            goto L50
        L4d:
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r5)     // Catch: java.lang.Throwable -> L62
        L50:
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r5)     // Catch: java.lang.Throwable -> L62
            android.database.sqlite.SQLiteDatabase r5 = r4.mDB     // Catch: java.lang.Throwable -> L59
            r5.endTransaction()     // Catch: java.lang.Throwable -> L59
            goto L61
        L59:
            r5 = move-exception
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3e
            com.baidu.sofire.rp.service.Service.sFailTime = r1     // Catch: java.lang.Throwable -> L3e
            goto L41
        L61:
            return r0
        L62:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r0 = r4.mDB     // Catch: java.lang.Throwable -> L69
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
            goto L77
        L69:
            r0 = move-exception
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L71
            com.baidu.sofire.rp.service.Service.sFailTime = r1     // Catch: java.lang.Throwable -> L71
            goto L74
        L71:
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r0)
        L74:
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r0)
        L77:
            throw r5
        L78:
            r2 = r0
            r3 = 1048577(0x100001, float:1.46937E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
            if (r0 == 0) goto L4
            int r1 = r0.intValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.rp.db.ReportDb.deleteEvent(java.util.List):int");
    }
}
