package c.a.u.a.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.u.a.a.c;
import c.a.u.a.a.h;
import c.a.u.a.h.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes9.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f26270f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ReentrantReadWriteLock f26271e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, "blcp_track.db", (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26271e = new ReentrantReadWriteLock(true);
    }

    public static void d(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, cursor) == null) || cursor == null) {
            return;
        }
        try {
            if (cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f26270f == null) {
                synchronized (a.class) {
                    if (f26270f == null) {
                        f26270f = new a(context);
                    }
                }
            }
            return f26270f;
        }
        return (a) invokeL.objValue;
    }

    public final boolean a(int i2, int i3, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, sQLiteDatabase)) == null) {
            this.f26271e.writeLock().lock();
            Cursor cursor = null;
            boolean z = false;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT flowid FROM flow WHERE flowid = " + i2 + " AND flowhandle = " + i3, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            z = true;
                        }
                    }
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
                d(cursor);
                this.f26271e.writeLock().unlock();
                e.a("TrackDBHelper", "flow checkFlowExist:" + z);
                return z;
            } catch (Throwable th) {
                d(cursor);
                this.f26271e.writeLock().unlock();
                throw th;
            }
        }
        return invokeIIL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0074, code lost:
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        r8.f26271e.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0082, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006b, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        this.f26271e.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransactionNonExclusive();
                int delete = sQLiteDatabase.delete("flow", "begintime < ? AND ? != ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000), "state", String.valueOf(1)});
                e.a("TrackDBHelper", "clear expired flow cout:" + delete);
                if (delete > 0) {
                    e.a("TrackDBHelper", "删除过期数据count:" + delete);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f26271e.writeLock().unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009d, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ab, code lost:
        r5.f26271e.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list) == null) || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.f26271e.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransactionNonExclusive();
                int size = list.size();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add("?");
                }
                int delete = sQLiteDatabase.delete("flow", "flowid = " + str + " AND flowhandle IN (" + TextUtils.join(",", arrayList) + SmallTailInfo.EMOTION_SUFFIX, (String[]) list.toArray(new String[list.size()]));
                sQLiteDatabase.setTransactionSuccessful();
                if (delete > 0) {
                    e.a("TrackDBHelper", "flow 删除：" + list.toString() + " success");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f26271e.writeLock().unlock();
            throw th;
        }
    }

    public void f(c cVar) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar == null) {
                e.a("TrackDBHelper", "flowData is null");
                return;
            }
            this.f26271e.writeLock().lock();
            e.a("TrackDBHelper", "flow insert to db:" + cVar.g());
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (SQLException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writableDatabase.beginTransactionNonExclusive();
                if (a(cVar.a, cVar.f26174b, writableDatabase)) {
                    ContentValues h2 = h(cVar);
                    String str = "flowid = " + cVar.a + " AND flowhandle = " + cVar.f26174b;
                    e.a("TrackDBHelper", "flow update where:" + str);
                    e.a("TrackDBHelper", "endFlow update count:" + writableDatabase.update("flow", h2, str, null));
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e3) {
                e = e3;
                sQLiteDatabase = writableDatabase;
                e.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.f26271e.writeLock().unlock();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.f26271e.writeLock().unlock();
                throw th;
            }
            this.f26271e.writeLock().unlock();
        }
    }

    public List<h> g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList2;
            }
            String str2 = "SELECT * FROM flow WHERE flowid=\"" + str + "\" AND state = 1  limit " + i2;
            e.a("TrackDBHelper", "flow getAllData querySql:" + str2);
            this.f26271e.readLock().lock();
            Cursor cursor = null;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str2, null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("flowhandle");
                    int columnIndex2 = cursor.getColumnIndex("detail");
                    do {
                        arrayList2.add(new h(str, cursor.getString(columnIndex), cursor.getString(columnIndex2)));
                        arrayList.add(cursor.getString(columnIndex2));
                    } while (cursor.moveToNext());
                    e.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
                    d(cursor);
                    this.f26271e.readLock().unlock();
                    e.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                    return arrayList2;
                }
                e.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
                d(cursor);
                this.f26271e.readLock().unlock();
                e.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                return arrayList2;
            } catch (Throwable th) {
                d(cursor);
                this.f26271e.readLock().unlock();
                throw th;
            }
        }
        return (List) invokeLI.objValue;
    }

    public final ContentValues h(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            ContentValues contentValues = new ContentValues();
            if (cVar != null) {
                contentValues.put("flowid", Integer.valueOf(cVar.a));
                contentValues.put("flowhandle", Integer.valueOf(cVar.f26174b));
                contentValues.put("begintime", Long.valueOf(cVar.f26175c));
                contentValues.put("endtime", Long.valueOf(cVar.f26176d));
                contentValues.put("detail", cVar.f());
                if (cVar.f26176d == 0) {
                    contentValues.put("state", (Integer) 0);
                } else {
                    contentValues.put("state", (Integer) 1);
                }
                contentValues.put("ext", "");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String str2 = "SELECT COUNT(*) FROM flow WHERE flowid=\"" + str + "\" AND state = 1 ";
            this.f26271e.readLock().lock();
            Cursor cursor = null;
            int i2 = 0;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str2, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        i2 = cursor.getInt(0);
                    }
                    e.a("TrackDBHelper", "flow getEndedFlowCount:" + i2);
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
                return i2;
            } finally {
                d(cursor);
                this.f26271e.readLock().unlock();
            }
        }
        return invokeL.intValue;
    }

    public void k(c cVar) {
        ContentValues h2;
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar == null) {
                e.a("TrackDBHelper", "flow must not be null");
                return;
            }
            this.f26271e.writeLock().lock();
            SQLiteDatabase sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            SQLiteDatabase sQLiteDatabase3 = null;
            try {
                try {
                    h2 = h(cVar);
                    writableDatabase = getWritableDatabase();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                writableDatabase.beginTransactionNonExclusive();
                if (!a(cVar.a, cVar.f26174b, writableDatabase)) {
                    long insert = writableDatabase.insert("flow", null, h2);
                    e.a("TrackDBHelper", "flow saveFlow,rowId:" + insert);
                    sQLiteDatabase2 = insert;
                }
                writableDatabase.setTransactionSuccessful();
                sQLiteDatabase = sQLiteDatabase2;
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    sQLiteDatabase = sQLiteDatabase2;
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase3 = writableDatabase;
                e.printStackTrace();
                sQLiteDatabase = sQLiteDatabase3;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.endTransaction();
                    sQLiteDatabase = sQLiteDatabase3;
                }
                this.f26271e.writeLock().unlock();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.f26271e.writeLock().unlock();
                throw th;
            }
            this.f26271e.writeLock().unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle TEXT,begintime LONG,endtime LONG,detail TEXT,state INTEGER,ext TEXT );");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, sQLiteDatabase, i2, i3) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i2 < i3) {
                    i2++;
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        }
    }
}
