package c.a.p0.u1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c.a.d.f.p.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f18770b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, SQLiteDatabase> f18771c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1395497509, "Lc/a/p0/u1/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1395497509, "Lc/a/p0/u1/h/g;");
                return;
            }
        }
        f18771c = new HashMap<>();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        h.d().f();
                        Iterator<String> it = b().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next != null) {
                                if (next.equals("tb_message_center")) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("is_hidden", (Integer) 1);
                                    h.d().update("tb_message_center", contentValues, null, null);
                                } else if (!next.equals("tb_new_friends")) {
                                    h.d().delete(next, null, null);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "ImDatabaseManager.deleteImDb", new Object[0]);
                    e2.printStackTrace();
                }
            } finally {
                h.d().b();
            }
        }
    }

    public static LinkedList<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SQLiteDatabase c2 = c();
            LinkedList<String> linkedList = new LinkedList<>();
            Cursor cursor = null;
            try {
                if (c2 != null) {
                    try {
                        cursor = c2.rawQuery("select * from sqlite_master where type='table'", null);
                        if (cursor != null) {
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        }
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseManager.getAllTables", new Object[0]);
                        e2.printStackTrace();
                    }
                }
                return linkedList;
            } finally {
                o.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    public static synchronized SQLiteDatabase c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (g.class) {
                try {
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.getImDataBase", new Object[0]);
                }
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (f18771c.containsKey(str)) {
                    return f18771c.get(str);
                }
                if (f18770b != null && str.equals(a) && f18770b.isOpen()) {
                    return f18770b;
                }
                if (f18770b != null) {
                    o.b(f18770b);
                }
                f fVar = new f(TbadkCoreApplication.getInst().getApp(), str);
                a = str;
                f18770b = fVar.getWritableDatabase();
                return f18770b;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
