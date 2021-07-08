package com.baidu.apollon.statistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.sqlite.MyDb;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CustomerService extends MyDb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CS_GET_DATA_ERROR = "CS_getDbDataError";
    public static final String CS_OPEN_DB_ERROR = "CS_openDbError";
    public static final String sMarkString = "kf";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3934a;

    /* renamed from: b  reason: collision with root package name */
    public long f3935b;

    /* renamed from: c  reason: collision with root package name */
    public int f3936c;

    /* renamed from: com.baidu.apollon.statistics.CustomerService$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f3937a = 2;

        /* renamed from: b  reason: collision with root package name */
        public static final String f3938b = "customerservice.db";

        /* renamed from: c  reason: collision with root package name */
        public static final CustomerService f3939c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-198095755, "Lcom/baidu/apollon/statistics/CustomerService$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-198095755, "Lcom/baidu/apollon/statistics/CustomerService$a;");
                    return;
                }
            }
            f3939c = new CustomerService(PayStatisticsUtil.c(), f3938b, f3937a, null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ CustomerService(Context context, String str, int i2, AnonymousClass1 anonymousClass1) {
        this(context, str, i2);
    }

    private e[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            SQLiteDatabase sQLiteDatabase = this.mDb;
            if (sQLiteDatabase == null) {
                PayStatisticsUtil.onEvent(CS_GET_DATA_ERROR);
                return new e[0];
            }
            Cursor cursor = null;
            try {
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select * from stat_event", null);
                    if (rawQuery == null) {
                        e[] eVarArr = new e[0];
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return eVarArr;
                    }
                    e[] eVarArr2 = new e[rawQuery.getCount()];
                    int i2 = 0;
                    while (rawQuery.moveToNext()) {
                        e eVar = new e();
                        eVar.f3981h = rawQuery.getString(0);
                        eVar.f3982i = rawQuery.getLong(1);
                        eVar.j = rawQuery.getString(2);
                        eVar.k = rawQuery.getString(3);
                        eVar.l = rawQuery.getString(4);
                        eVar.m = rawQuery.getLong(5);
                        if (1 < a.f3937a) {
                            eVar.n = rawQuery.getString(6);
                        }
                        int i3 = i2 + 1;
                        eVarArr2[i2] = eVar;
                        i2 = i3;
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return eVarArr2;
                } catch (Exception e2) {
                    LogUtil.errord(e2.getMessage());
                    e[] eVarArr3 = new e[0];
                    if (0 != 0) {
                        cursor.close();
                    }
                    return eVarArr3;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return (e[]) invokeV.objValue;
    }

    public static CustomerService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f3939c : (CustomerService) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0150 -> B:66:0x0172). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enqueEvent(e eVar) {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || TextUtils.isEmpty(eVar.f3981h)) {
            return;
        }
        if (this.mDb != null) {
            StringBuilder sb = new StringBuilder();
            ContentValues contentValues = new ContentValues();
            contentValues.put("en", eVar.f3981h);
            contentValues.put("et", Long.valueOf(eVar.f3982i));
            contentValues.put("ev", eVar.j);
            contentValues.put("eg", eVar.k);
            contentValues.put("lk", eVar.l);
            contentValues.put("nu", Long.valueOf(eVar.m));
            contentValues.put("at", eVar.n);
            this.mDb.beginTransaction();
            sb.delete(0, sb.length());
            sb.append("select count(*) from stat_event");
            Cursor cursor2 = null;
            try {
                try {
                    long insert = this.mDb.insert("stat_event", null, contentValues);
                    Cursor rawQuery = this.mDb.rawQuery(sb.toString(), null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.moveToFirst()) {
                                if (this.f3936c < rawQuery.getLong(0)) {
                                    sb.delete(0, sb.length());
                                    if (0 < this.f3935b) {
                                        sb.append("select min(rowid), max(rowid) from stat_event where ");
                                        sb.append("rowid <= ");
                                        sb.append(insert - this.f3936c);
                                        sb.append(" and et < ");
                                        sb.append(eVar.f3982i);
                                        sb.append(" - ");
                                        sb.append(this.f3935b);
                                        cursor2 = this.mDb.rawQuery(sb.toString(), null);
                                        if (cursor2 != null && cursor2.moveToFirst()) {
                                            sb.delete(0, sb.length());
                                            long j = cursor2.getLong(0);
                                            long j2 = cursor2.getLong(1);
                                            sb.append("delete from stat_event where rowid <= ");
                                            sb.append(j2);
                                            sb.append(" and rowid >= ");
                                            sb.append(j);
                                            this.mDb.execSQL(sb.toString());
                                        }
                                    } else {
                                        sb.append("delete from stat_event where rowid < ");
                                        sb.append(insert - this.f3936c);
                                        this.mDb.execSQL(sb.toString());
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Cursor cursor3 = cursor2;
                            cursor2 = rawQuery;
                            cursor = cursor3;
                            try {
                                LogUtil.errord(e.getMessage());
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                this.mDb.endTransaction();
                                if (g.a().a(eVar)) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                try {
                                    this.mDb.endTransaction();
                                } catch (Exception e3) {
                                    LogUtil.errord(e3.getMessage());
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            Cursor cursor4 = cursor2;
                            cursor2 = rawQuery;
                            cursor = cursor4;
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                            this.mDb.endTransaction();
                            throw th;
                        }
                    }
                    this.mDb.setTransactionSuccessful();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    this.mDb.endTransaction();
                } catch (Exception e4) {
                    LogUtil.errord(e4.getMessage());
                }
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        if (g.a().a(eVar)) {
            return;
        }
        LogSender.getInstance().triggerSending(Config.w);
    }

    public String getSendData() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e[] a2 = a();
            if (a2.length == 0) {
                return null;
            }
            synchronized (this.f3934a) {
                try {
                    StatisticsSettings a3 = PayStatisticsUtil.getInstance().a();
                    jSONObject = a3 != null ? new JSONObject(a3.getCommonHeader()) : null;
                } catch (JSONException unused) {
                    return null;
                }
            }
            if (jSONObject == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (e eVar : a2) {
                jSONArray.put(eVar.a());
            }
            try {
                jSONObject.put("array", jSONArray);
                return jSONObject.toString();
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3936c > 0 || 0 < this.f3935b : invokeV.booleanValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            this.mDb = sQLiteDatabase;
            MyDb.createTable(sQLiteDatabase, "stat_event", new String[]{"en VARCHAR(64) not null", "et BIGINT", "ev TEXT", "eg VARCHAR(20) default(null)", "lk VARCHAR(10) default(null)", "nu BIGINT", "at VARCHAR(1024) default(null)", "primary key (en,et,nu)"});
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            this.mDb = sQLiteDatabase;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
            this.mDb = sQLiteDatabase;
            if (1 == i2 && 2 == i3 && sQLiteDatabase != null) {
                sQLiteDatabase.execSQL("alter table stat_event add at VARCHAR(1024)");
            }
        }
    }

    public void setConfig(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.f3935b = i2;
            this.f3936c = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerService(Context context, String str, int i2) {
        super(context, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3934a = new byte[0];
        this.f3935b = 0L;
        this.f3936c = 200;
        if (this.mDb == null) {
            PayStatisticsUtil.onEvent(CS_OPEN_DB_ERROR);
        }
    }

    public void enqueEvent(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        e eVar = new e();
        eVar.f3981h = str;
        eVar.j = str2;
        eVar.k = str3;
        eVar.l = com.baidu.apollon.statistics.a.a();
        eVar.f3982i = System.currentTimeMillis();
        eVar.m = f.a();
        eVar.n = str4;
        enqueEvent(eVar);
    }
}
