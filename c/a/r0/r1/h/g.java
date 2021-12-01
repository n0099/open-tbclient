package c.a.r0.r1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f22941b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, SQLiteDatabase> f22942c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1660040544, "Lc/a/r0/r1/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1660040544, "Lc/a/r0/r1/h/g;");
                return;
            }
        }
        f22942c = new HashMap<>();
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
                c.a.d.f.p.m.a(cursor);
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
                if (f22942c.containsKey(str)) {
                    return f22942c.get(str);
                }
                if (f22941b != null && str.equals(a) && f22941b.isOpen()) {
                    return f22941b;
                }
                if (f22941b != null) {
                    c.a.d.f.p.m.b(f22941b);
                }
                f fVar = new f(TbadkCoreApplication.getInst().getApp(), str);
                a = str;
                f22941b = fVar.getWritableDatabase();
                return f22941b;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
