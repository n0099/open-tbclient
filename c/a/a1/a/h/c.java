package c.a.a1.a.h;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.a.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f1383f;

    /* renamed from: g  reason: collision with root package name */
    public static c f1384g;

    /* renamed from: h  reason: collision with root package name */
    public static ReentrantLock f1385h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ReentrantReadWriteLock f1386e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1725770374, "Lc/a/a1/a/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1725770374, "Lc/a/a1/a/h/c;");
                return;
            }
        }
        f1383f = AppConfig.isDebug();
        f1384g = null;
        f1385h = new ReentrantLock();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, "voyager.db", (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f1386e = new ReentrantReadWriteLock(true);
    }

    public static c f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f1384g == null) {
                f1385h.lock();
                if (f1384g == null) {
                    f1384g = new c(context);
                }
                f1385h.unlock();
            }
            return f1384g;
        }
        return (c) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f1386e.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        long delete = writableDatabase.delete("task", null, null);
                        if (f1383f) {
                            String str = "clear task data from table task, count = " + delete;
                        }
                        writableDatabase.setTransactionSuccessful();
                        return true;
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e2) {
                    if (f1383f) {
                        e2.printStackTrace();
                    }
                    this.f1386e.writeLock().unlock();
                    return false;
                }
            } finally {
                this.f1386e.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: all -> 0x0095, SQLException -> 0x0097, Merged into TryCatch #1 {all -> 0x0095, SQLException -> 0x0097, blocks: (B:5:0x0010, B:16:0x0078, B:17:0x007b, B:25:0x008e, B:26:0x0091, B:27:0x0094, B:31:0x0098, B:33:0x009c), top: B:43:0x0010 }, TRY_ENTER] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c() {
        InterceptResult invokeV;
        Cursor cursor;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (String) invokeV.objValue;
        }
        this.f1386e.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                cursor = writableDatabase.rawQuery("SELECT * FROM task ORDER BY timestamp LIMIT 1", null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            string = cursor.getString(cursor.getColumnIndex("task_id"));
                            long delete = writableDatabase.delete("task", "task_id =? ", new String[]{string});
                            if (f1383f) {
                                String str = "delete task data count: " + delete;
                            }
                            writableDatabase.setTransactionSuccessful();
                            if (cursor != null) {
                                cursor.close();
                            }
                            writableDatabase.endTransaction();
                            return string;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                string = null;
                writableDatabase.setTransactionSuccessful();
                if (cursor != null) {
                }
                writableDatabase.endTransaction();
                return string;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (SQLException e2) {
            if (f1383f) {
                e2.printStackTrace();
            }
            return null;
        } finally {
            this.f1386e.writeLock().unlock();
        }
    }

    public final ContentValues d(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("task_id", aVar.j());
            contentValues.put("timestamp", Long.valueOf(aVar.i()));
            contentValues.put("biz_type", aVar.a());
            contentValues.put("file_list", aVar.g().toString());
            if (!aVar.l()) {
                contentValues.put("zip_src", (Integer) 0);
            } else {
                contentValues.put("zip_src", (Integer) 1);
            }
            contentValues.put("priority", Integer.valueOf(aVar.h()));
            contentValues.put("upload_count", Integer.valueOf(aVar.k()));
            contentValues.put("network_type", Integer.valueOf(aVar.f()));
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject b2 = aVar.b();
                if (b2 != null) {
                    jSONObject.put("ext_info", b2);
                }
                JSONObject c2 = aVar.c();
                if (c2 != null) {
                    jSONObject.put("file_meta", c2);
                }
                jSONObject.put("max_zip_size", aVar.e());
            } catch (JSONException e2) {
                if (f1383f) {
                    e2.printStackTrace();
                }
            }
            if (jSONObject.length() > 0) {
                contentValues.put("extend", jSONObject.toString());
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final String e(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(next);
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0140 A[LOOP:0: B:12:0x003a->B:47:0x0140, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014c A[Catch: all -> 0x0185, SQLException -> 0x0187, TRY_ENTER, TryCatch #0 {SQLException -> 0x0187, blocks: (B:5:0x0011, B:52:0x014c, B:53:0x014f, B:57:0x015f, B:60:0x0181, B:61:0x0184), top: B:75:0x0011, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0155 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015f A[Catch: all -> 0x0185, SQLException -> 0x0187, TRY_ENTER, TryCatch #0 {SQLException -> 0x0187, blocks: (B:5:0x0011, B:52:0x014c, B:53:0x014f, B:57:0x015f, B:60:0x0181, B:61:0x0184), top: B:75:0x0011, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014a A[EDGE_INSN: B:83:0x014a->B:51:0x014a ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(@NonNull ArrayList<String> arrayList, @NonNull LinkedList<a> linkedList) {
        SQLiteDatabase writableDatabase;
        Cursor cursor;
        long j2;
        ArrayList<String> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048580, this, arrayList, linkedList) != null) {
            return;
        }
        this.f1386e.writeLock().lock();
        try {
            try {
                writableDatabase = getWritableDatabase();
                cursor = null;
            } catch (SQLException e2) {
                if (f1383f) {
                    e2.printStackTrace();
                }
            }
            try {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM task", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0) {
                            rawQuery.moveToFirst();
                            long currentTimeMillis = System.currentTimeMillis();
                            while (true) {
                                String string = rawQuery.getString(rawQuery.getColumnIndex("task_id"));
                                String string2 = rawQuery.getString(rawQuery.getColumnIndex("biz_type"));
                                long j3 = rawQuery.getLong(rawQuery.getColumnIndex("timestamp"));
                                long b2 = c.a.a1.a.b.b.f().b(string2);
                                int i2 = rawQuery.getInt(rawQuery.getColumnIndex("upload_count"));
                                int e3 = c.a.a1.a.b.b.f().e(string2);
                                if (b2 + j3 < currentTimeMillis) {
                                    j2 = currentTimeMillis;
                                    arrayList2 = arrayList;
                                } else if (i2 >= e3) {
                                    arrayList2 = arrayList;
                                    j2 = currentTimeMillis;
                                } else {
                                    int i3 = rawQuery.getInt(rawQuery.getColumnIndex("priority"));
                                    String string3 = rawQuery.getString(rawQuery.getColumnIndex("file_list"));
                                    int i4 = rawQuery.getInt(rawQuery.getColumnIndex("network_type"));
                                    j2 = currentTimeMillis;
                                    ArrayList arrayList3 = new ArrayList(Arrays.asList(string3));
                                    boolean z = rawQuery.getInt(rawQuery.getColumnIndex("zip_src")) != 0;
                                    a.b bVar = new a.b(string, string2, arrayList3, j3);
                                    bVar.o(i3);
                                    bVar.n(i4);
                                    bVar.p(z);
                                    a k = bVar.k();
                                    k.s(i2);
                                    String string4 = rawQuery.getString(rawQuery.getColumnIndex("extend"));
                                    if (!TextUtils.isEmpty(string4)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(string4);
                                            if (jSONObject.length() > 0) {
                                                JSONObject optJSONObject = jSONObject.optJSONObject("ext_info");
                                                if (optJSONObject != null && optJSONObject.length() > 0) {
                                                    k.m(optJSONObject);
                                                }
                                                JSONObject optJSONObject2 = jSONObject.optJSONObject("file_meta");
                                                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                                                    k.n(optJSONObject2);
                                                }
                                                long optLong = jSONObject.optLong("max_zip_size", 0L);
                                                if (optLong > 0) {
                                                    k.o(optLong);
                                                }
                                            }
                                        } catch (JSONException e4) {
                                            if (f1383f) {
                                                e4.printStackTrace();
                                            }
                                        }
                                    }
                                    linkedList.addFirst(k);
                                    if (rawQuery.moveToNext()) {
                                        break;
                                    }
                                    currentTimeMillis = j2;
                                }
                                arrayList2.add(string);
                                if (rawQuery.moveToNext()) {
                                }
                            }
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            if (arrayList.size() != 0) {
                                return;
                            }
                            writableDatabase.delete("task", "task_id IN ( " + e(arrayList) + " )", null);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                }
                if (arrayList.size() != 0) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } finally {
            this.f1386e.writeLock().unlock();
        }
    }

    public boolean h(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.j()) && !TextUtils.isEmpty(aVar.a())) {
                this.f1386e.writeLock().lock();
                try {
                    ContentValues d2 = d(aVar);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        long insert = writableDatabase.insert("task", null, d2);
                        if (f1383f) {
                            String str = "insert task data into table task, rowId = " + insert;
                        }
                        writableDatabase.setTransactionSuccessful();
                        return true;
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e2) {
                    if (f1383f) {
                        e2.printStackTrace();
                    }
                    return false;
                } finally {
                    this.f1386e.writeLock().unlock();
                }
            }
            boolean z = f1383f;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.j()) && !TextUtils.isEmpty(aVar.a())) {
                this.f1386e.writeLock().lock();
                try {
                    try {
                        int delete = getWritableDatabase().delete("task", "task_id =? ", new String[]{aVar.j()});
                        if (f1383f) {
                            String str = "delete data from table task, del count = " + delete;
                        }
                    } catch (SQLException e2) {
                        if (f1383f) {
                            e2.printStackTrace();
                        }
                    }
                    return;
                } finally {
                    this.f1386e.writeLock().unlock();
                }
            }
            boolean z = f1383f;
        }
    }

    public void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.j()) && !TextUtils.isEmpty(aVar.a())) {
                this.f1386e.writeLock().lock();
                try {
                    try {
                        long update = getWritableDatabase().update("task", d(aVar), null, null);
                        if (f1383f) {
                            String str = "update data into table task, update count = " + update;
                        }
                    } catch (SQLException e2) {
                        if (f1383f) {
                            e2.printStackTrace();
                        }
                    }
                    return;
                } finally {
                    this.f1386e.writeLock().unlock();
                }
            }
            boolean z = f1383f;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            sQLiteDatabase.enableWriteAheadLogging();
            super.onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
            boolean z = f1383f;
            try {
                sQLiteDatabase.execSQL("CREATE TABLE task (_id INTEGER PRIMARY KEY AUTOINCREMENT,task_id TEXT,timestamp LONG,biz_type TEXT,file_list TEXT,zip_src INTEGER,priority INTEGER,upload_count INTEGER,network_type INTEGER,extend TEXT,reserve1 TEXT);");
            } catch (Exception e2) {
                if (f1383f) {
                    String str = "Error while creating db: " + e2.toString();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048586, this, sQLiteDatabase, i2, i3) == null) && f1383f) {
            String str = "old version: " + i2 + ", new version: " + i3;
        }
    }
}
