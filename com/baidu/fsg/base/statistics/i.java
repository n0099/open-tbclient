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
public class i extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39570a = "logsender";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39571b = "rim_stat_event";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39572c = "rim_stat_event.db";

    /* renamed from: d  reason: collision with root package name */
    public static final int f39573d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final String f39574e = "CREATE TABLE IF NOT EXISTS rim_stat_event(en VARCHAR(64) not null ,extra1 VARCHAR(64)  ,extra2 VARCHAR(64)  ,extra3 VARCHAR(64),extra4 VARCHAR(64)  ,extra5 VARCHAR(64) ,et BIGINT,ev TEXT,extra6 TEXT,extra7 TEXT,extra8 TEXT,extra9 TEXT,eg VARCHAR(20) default(null),lk VARCHAR(10) default(null),nu INTEGER PRIMARY KEY autoincrement)";

    /* renamed from: f  reason: collision with root package name */
    public static i f39575f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteDatabase f39576g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f39577h;

    /* renamed from: i  reason: collision with root package name */
    public int f39578i;

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
        this.f39577h = new byte[0];
        this.f39578i = 200;
        this.f39576g = getWritableDatabase();
    }

    public static synchronized i a(Context context) {
        InterceptResult invokeL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (i.class) {
                if (f39575f == null) {
                    f39575f = new i(context, f39572c, null, 1);
                }
                iVar = f39575f;
            }
            return iVar;
        }
        return (i) invokeL.objValue;
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            synchronized (this.f39577h) {
                if (hVar != null) {
                    if (!TextUtils.isEmpty(hVar.p)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.f39560a, hVar.p);
                        contentValues.put("et", Long.valueOf(hVar.q));
                        contentValues.put("ev", hVar.r);
                        contentValues.put(h.f39563d, hVar.s);
                        contentValues.put(h.f39564e, hVar.t);
                        try {
                            this.f39576g.insert(f39571b, null, contentValues);
                        } catch (Exception unused) {
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("插入一条数据");
                        sb.append(hVar.p);
                        LogUtil.d("logsender", sb.toString());
                    }
                }
            }
        }
    }

    public void a(h[] hVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVarArr) == null) {
            synchronized (this.f39577h) {
                if (hVarArr != null) {
                    if (hVarArr.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("=====removeEvents-begin=====size=");
                        sb.append(hVarArr.length);
                        LogUtil.d("logsender", sb.toString());
                        for (h hVar : hVarArr) {
                            if (hVar != null) {
                                SQLiteDatabase sQLiteDatabase = this.f39576g;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("nu=");
                                sb2.append(hVar.u);
                                sQLiteDatabase.delete(f39571b, sb2.toString(), null);
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
        if (r3 != null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d A[Catch: all -> 0x0098, TryCatch #3 {all -> 0x0098, blocks: (B:13:0x0017, B:14:0x001a, B:50:0x009d, B:51:0x009f, B:45:0x0094, B:40:0x008a, B:41:0x008d), top: B:59:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h[] a() {
        InterceptResult invokeV;
        h[] hVarArr;
        h[] hVarArr2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return (h[]) invokeV.objValue;
        }
        synchronized (this.f39577h) {
            Cursor cursor = null;
            try {
                try {
                    Cursor cursor2 = this.f39576g.rawQuery("select * from rim_stat_event", null);
                    try {
                        if (cursor2 == null) {
                            h[] hVarArr3 = new h[0];
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            return hVarArr3;
                        }
                        hVarArr2 = new h[cursor2.getCount()];
                        int i2 = 0;
                        while (cursor2.moveToNext()) {
                            h hVar = new h();
                            hVar.p = cursor2.getString(cursor2.getColumnIndex(h.f39560a));
                            hVar.q = cursor2.getLong(cursor2.getColumnIndex("et"));
                            hVar.r = cursor2.getString(cursor2.getColumnIndex("ev"));
                            hVar.s = cursor2.getString(cursor2.getColumnIndex(h.f39563d));
                            hVar.t = cursor2.getString(cursor2.getColumnIndex(h.f39564e));
                            hVar.u = cursor2.getInt(cursor2.getColumnIndex(h.f39565f));
                            int i3 = i2 + 1;
                            hVarArr2[i2] = hVar;
                            i2 = i3;
                        }
                    } catch (Exception unused) {
                        hVarArr = null;
                        cursor = cursor2;
                        if (cursor == null) {
                            hVarArr2 = hVarArr;
                            if (hVarArr2 == null) {
                            }
                            return hVarArr2;
                        }
                        h[] hVarArr4 = hVarArr;
                        cursor2 = cursor;
                        hVarArr2 = hVarArr4;
                        cursor2.close();
                        if (hVarArr2 == null) {
                            hVarArr2 = new h[0];
                        }
                        return hVarArr2;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Exception unused2) {
                hVarArr = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SQLiteDatabase sQLiteDatabase = this.f39576g;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.f39576g.close();
            }
            this.f39576g = null;
            super.finalize();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0031, code lost:
        if (r1 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.f39577h) {
                Cursor rawQuery = this.f39576g.rawQuery("SELECT COUNT(*) FROM rim_stat_event", null);
                if (rawQuery == null) {
                    return 0;
                }
                try {
                } catch (Exception unused) {
                } catch (Throwable th) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
                if (!rawQuery.moveToFirst()) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return 0;
                }
                int i2 = rawQuery.getInt(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return i2;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(f39574e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
        }
    }
}
