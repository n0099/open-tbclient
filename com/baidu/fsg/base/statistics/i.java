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
/* loaded from: classes2.dex */
public class i extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5322a = "logsender";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5323d = "rim_stat_event";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5324e = "rim_stat_event.db";

    /* renamed from: f  reason: collision with root package name */
    public static final int f5325f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f5326g = "CREATE TABLE IF NOT EXISTS rim_stat_event(en VARCHAR(64) not null ,extra1 VARCHAR(64)  ,extra2 VARCHAR(64)  ,extra3 VARCHAR(64),extra4 VARCHAR(64)  ,extra5 VARCHAR(64) ,et BIGINT,ev TEXT,extra6 TEXT,extra7 TEXT,extra8 TEXT,extra9 TEXT,eg VARCHAR(20) default(null),lk VARCHAR(10) default(null),nu INTEGER PRIMARY KEY autoincrement)";

    /* renamed from: i  reason: collision with root package name */
    public static i f5327i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f5328b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f5329c;

    /* renamed from: h  reason: collision with root package name */
    public int f5330h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
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
        this.f5329c = new byte[0];
        this.f5330h = 200;
        this.f5328b = getWritableDatabase();
    }

    public static synchronized i a(Context context) {
        InterceptResult invokeL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (i.class) {
                if (f5327i == null) {
                    f5327i = new i(context, f5324e, null, 1);
                }
                iVar = f5327i;
            }
            return iVar;
        }
        return (i) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e A[Catch: all -> 0x0099, TryCatch #1 {all -> 0x0099, blocks: (B:11:0x0018, B:12:0x001b, B:20:0x0080, B:35:0x009e, B:36:0x00a0, B:26:0x008e, B:27:0x0091, B:30:0x0095), top: B:44:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h[] b() {
        InterceptResult invokeV;
        h[] hVarArr;
        h[] hVarArr2;
        Cursor rawQuery;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f5329c) {
                Cursor cursor = null;
                try {
                    try {
                        rawQuery = this.f5328b.rawQuery("select * from rim_stat_event", null);
                        try {
                        } catch (Exception unused) {
                            hVarArr = null;
                            cursor = rawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            hVarArr2 = hVarArr;
                            if (hVarArr2 == null) {
                            }
                            return hVarArr2;
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
                    hVarArr = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (rawQuery == null) {
                    h[] hVarArr3 = new h[0];
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return hVarArr3;
                }
                hVarArr2 = new h[rawQuery.getCount()];
                int i2 = 0;
                while (rawQuery.moveToNext()) {
                    h hVar = new h();
                    hVar.p = rawQuery.getString(rawQuery.getColumnIndex("en"));
                    hVar.q = rawQuery.getLong(rawQuery.getColumnIndex("et"));
                    hVar.r = rawQuery.getString(rawQuery.getColumnIndex("ev"));
                    hVar.s = rawQuery.getString(rawQuery.getColumnIndex("eg"));
                    hVar.t = rawQuery.getString(rawQuery.getColumnIndex("lk"));
                    hVar.u = rawQuery.getInt(rawQuery.getColumnIndex("nu"));
                    int i3 = i2 + 1;
                    hVarArr2[i2] = hVar;
                    i2 = i3;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (hVarArr2 == null) {
                    hVarArr2 = new h[0];
                }
                return hVarArr2;
            }
        }
        return (h[]) invokeV.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SQLiteDatabase sQLiteDatabase = this.f5328b;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.f5328b.close();
            }
            this.f5328b = null;
            super.finalize();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(f5326g);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
        }
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            synchronized (this.f5329c) {
                if (hVar != null) {
                    if (!TextUtils.isEmpty(hVar.p)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("en", hVar.p);
                        contentValues.put("et", Long.valueOf(hVar.q));
                        contentValues.put("ev", hVar.r);
                        contentValues.put("eg", hVar.s);
                        contentValues.put("lk", hVar.t);
                        try {
                            this.f5328b.insert(f5323d, null, contentValues);
                        } catch (Exception unused) {
                        }
                        LogUtil.d("logsender", "插入一条数据" + hVar.p);
                    }
                }
            }
        }
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
        synchronized (this.f5329c) {
            Cursor rawQuery = this.f5328b.rawQuery("SELECT COUNT(*) FROM rim_stat_event", null);
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

    public void a(h[] hVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVarArr) == null) {
            synchronized (this.f5329c) {
                if (hVarArr != null) {
                    if (hVarArr.length != 0) {
                        LogUtil.d("logsender", "=====removeEvents-begin=====size=" + hVarArr.length);
                        for (h hVar : hVarArr) {
                            if (hVar != null) {
                                this.f5328b.delete(f5323d, "nu=" + hVar.u, null);
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
}
