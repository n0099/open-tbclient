package com.baidu.fsg.base.statistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39509a = "logsender";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39510d = "rim_stat_event";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39511e = "rim_stat_event.db";

    /* renamed from: f  reason: collision with root package name */
    public static final int f39512f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f39513g = "CREATE TABLE IF NOT EXISTS rim_stat_event(en VARCHAR(64) not null ,extra1 VARCHAR(64)  ,extra2 VARCHAR(64)  ,extra3 VARCHAR(64),extra4 VARCHAR(64)  ,extra5 VARCHAR(64) ,et BIGINT,ev TEXT,extra6 TEXT,extra7 TEXT,extra8 TEXT,extra9 TEXT,eg VARCHAR(20) default(null),lk VARCHAR(10) default(null),nu INTEGER PRIMARY KEY autoincrement)";

    /* renamed from: i  reason: collision with root package name */
    public static g f39514i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f39515b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f39516c;

    /* renamed from: h  reason: collision with root package name */
    public int f39517h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cursorFactory, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39516c = new byte[0];
        this.f39517h = 200;
        this.f39515b = getWritableDatabase();
    }

    public static synchronized g a(Context context) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (g.class) {
                if (f39514i == null) {
                    f39514i = new g(context, f39511e, null, 1);
                }
                gVar = f39514i;
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return invokeV.intValue;
        }
        synchronized (this.f39516c) {
            Cursor rawQuery = this.f39515b.rawQuery("SELECT COUNT(*) FROM rim_stat_event", null);
            if (rawQuery == null) {
                return 0;
            }
            try {
                if (rawQuery.moveToFirst()) {
                    int i2 = rawQuery.getInt(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return i2;
                }
            } catch (Exception unused) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return 0;
            }
        }
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            synchronized (this.f39516c) {
                if (fVar != null) {
                    if (!TextUtils.isEmpty(fVar.p)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(f.f39499a, fVar.p);
                        contentValues.put("et", Long.valueOf(fVar.q));
                        contentValues.put("ev", fVar.r);
                        contentValues.put(f.f39502d, fVar.s);
                        contentValues.put(f.f39503e, fVar.t);
                        try {
                            this.f39515b.insert(f39510d, null, contentValues);
                        } catch (Exception unused) {
                        }
                        LogUtil.d("logsender", "插入一条数据" + fVar.p);
                    }
                }
            }
        }
    }

    public void a(f[] fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVarArr) == null) {
            synchronized (this.f39516c) {
                if (fVarArr != null) {
                    if (fVarArr.length != 0) {
                        LogUtil.d("logsender", "=====removeEvents-begin=====size=" + fVarArr.length);
                        for (f fVar : fVarArr) {
                            if (fVar != null) {
                                this.f39515b.delete(f39510d, "nu=" + fVar.u, null);
                            }
                        }
                        LogUtil.d("logsender", "=====removeEvents-end=====");
                        return;
                    }
                }
                LogUtil.d("logsender", "=====removeEvents=====size=0");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d A[Catch: all -> 0x0098, TryCatch #1 {all -> 0x0098, blocks: (B:11:0x0017, B:12:0x001a, B:20:0x007f, B:35:0x009d, B:36:0x009f, B:26:0x008d, B:27:0x0090, B:30:0x0094), top: B:44:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f[] b() {
        InterceptResult invokeV;
        f[] fVarArr;
        f[] fVarArr2;
        Cursor rawQuery;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f39516c) {
                Cursor cursor = null;
                try {
                    try {
                        rawQuery = this.f39515b.rawQuery("select * from rim_stat_event", null);
                        try {
                        } catch (Exception unused) {
                            fVarArr = null;
                            cursor = rawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            fVarArr2 = fVarArr;
                            if (fVarArr2 == null) {
                            }
                            return fVarArr2;
                        } catch (Throwable th) {
                            th = th;
                            cursor = rawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (Exception unused2) {
                    fVarArr = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (rawQuery == null) {
                    f[] fVarArr3 = new f[0];
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return fVarArr3;
                }
                fVarArr2 = new f[rawQuery.getCount()];
                int i2 = 0;
                while (rawQuery.moveToNext()) {
                    f fVar = new f();
                    fVar.p = rawQuery.getString(rawQuery.getColumnIndex(f.f39499a));
                    fVar.q = rawQuery.getLong(rawQuery.getColumnIndex("et"));
                    fVar.r = rawQuery.getString(rawQuery.getColumnIndex("ev"));
                    fVar.s = rawQuery.getString(rawQuery.getColumnIndex(f.f39502d));
                    fVar.t = rawQuery.getString(rawQuery.getColumnIndex(f.f39503e));
                    fVar.u = rawQuery.getInt(rawQuery.getColumnIndex(f.f39504f));
                    int i3 = i2 + 1;
                    fVarArr2[i2] = fVar;
                    i2 = i3;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (fVarArr2 == null) {
                    fVarArr2 = new f[0];
                }
                return fVarArr2;
            }
        }
        return (f[]) invokeV.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SQLiteDatabase sQLiteDatabase = this.f39515b;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.f39515b.close();
            }
            this.f39515b = null;
            super.finalize();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(f39513g);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
        }
    }
}
