package c.a.r0.k1.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class f extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 14);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
    }

    public static void b(SQLiteStatement sQLiteStatement, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, sQLiteStatement, i2, str) == null) {
            if (str == null) {
                sQLiteStatement.bindNull(i2);
            } else {
                sQLiteStatement.bindString(i2, str);
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sQLiteDatabase, str) == null) {
            sQLiteDatabase.execSQL(str);
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL, group_name TEXT, group_head TEXT, custom_group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, send_status int, last_content TEXT, is_friend int, pull_msgid TEXT,is_hidden int,is_delete int, sent_mid long, read_mid long, sid long, task_id TEXT, service_id TEXT, ext1 TEXT, ext2 TEXT, user_type int default 1, visit_time LONG DEFAULT -1, group_name_show TEXT);");
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL, group_name TEXT, group_head TEXT, custom_group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, send_status int, last_content TEXT, is_friend int, pull_msgid TEXT,is_hidden int,is_delete int);");
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
            a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid LONG NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER, name_show TEXT);");
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            try {
                a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
                c(sQLiteDatabase);
                e(sQLiteDatabase);
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.createTables", new Object[0]);
            }
        }
    }

    public final LinkedList<String> g(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sQLiteDatabase)) == null) {
            LinkedList<String> linkedList = new LinkedList<>();
            Cursor cursor = null;
            if (sQLiteDatabase != null) {
                try {
                    try {
                        cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        }
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.getAllTable", new Object[0]);
                        e2.printStackTrace();
                    }
                } finally {
                    c.a.e.e.p.m.a(cursor);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeL.objValue;
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        LinkedList<String> g2 = g(sQLiteDatabase);
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<String> it = g2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && next.startsWith("tb_group_msg_")) {
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD read_flag int default 0;");
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg1to2", new Object[0]);
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        LinkedList<String> g2 = g(sQLiteDatabase);
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<String> it = g2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && next.startsWith("tb_group_msg_")) {
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD rid BIGINT;");
                        sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD is_delete int default 0;");
                        sQLiteDatabase.execSQL("UPDATE " + next + " SET read_flag=0 WHERE read_flag is null");
                        sQLiteDatabase.execSQL("UPDATE " + next + " SET rid=mid WHERE rid is null");
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg2to3", new Object[0]);
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
        }
    }

    public final void k(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD custom_group_type int default 0;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg4to5", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void l(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sQLiteDatabase) == null) {
            a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid INTEGER NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
            if (sQLiteDatabase != null) {
                LinkedList<String> g2 = g(sQLiteDatabase);
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<String> it = g2.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && (next.startsWith(m.f21372e) || next.startsWith(l.f21370e))) {
                            try {
                                sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD is_friend int default 1;");
                            } catch (Exception e2) {
                                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg5to6", new Object[0]);
                                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    public final void m(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD sid long default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD task_id TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD ext1 TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD ext2 TEXT;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg10to11", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void n(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD group_name_show TEXT;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg11to12 for table message_center", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void o(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_new_friends ADD name_show TEXT;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg11to12 for table new_friends", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_new_friends");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sQLiteDatabase) == null) {
            f(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @SuppressLint({"Override"})
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, sQLiteDatabase, i2, i3) == null) {
            try {
                TbadkCoreApplication.getInst().getApp().deleteDatabase(TbadkCoreApplication.getCurrentAccount() + ".db");
                f(sQLiteDatabase);
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.onDowngrade", new Object[0]);
                e2.printStackTrace();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, sQLiteDatabase, i2, i3) == null) {
            switch (i2) {
                case 1:
                    try {
                        h(sQLiteDatabase);
                        i(sQLiteDatabase);
                        j(sQLiteDatabase);
                        k(sQLiteDatabase);
                        l(sQLiteDatabase);
                        s(sQLiteDatabase);
                        t(sQLiteDatabase);
                        u(sQLiteDatabase);
                        v(sQLiteDatabase);
                        m(sQLiteDatabase);
                        n(sQLiteDatabase);
                        o(sQLiteDatabase);
                        p(sQLiteDatabase);
                        q(sQLiteDatabase);
                        r(sQLiteDatabase);
                        return;
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.onUpgrade", new Object[0]);
                        TbadkCoreApplication.getInst().getApp().deleteDatabase(TbadkCoreApplication.getCurrentAccount() + ".db");
                        f(sQLiteDatabase);
                        return;
                    }
                case 2:
                    i(sQLiteDatabase);
                    j(sQLiteDatabase);
                    k(sQLiteDatabase);
                    l(sQLiteDatabase);
                    s(sQLiteDatabase);
                    t(sQLiteDatabase);
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 3:
                    j(sQLiteDatabase);
                    k(sQLiteDatabase);
                    l(sQLiteDatabase);
                    s(sQLiteDatabase);
                    t(sQLiteDatabase);
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 4:
                    k(sQLiteDatabase);
                    l(sQLiteDatabase);
                    s(sQLiteDatabase);
                    t(sQLiteDatabase);
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 5:
                    l(sQLiteDatabase);
                    s(sQLiteDatabase);
                    t(sQLiteDatabase);
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 6:
                    s(sQLiteDatabase);
                    t(sQLiteDatabase);
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 7:
                    t(sQLiteDatabase);
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 8:
                    u(sQLiteDatabase);
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 9:
                    v(sQLiteDatabase);
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 10:
                    m(sQLiteDatabase);
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 11:
                    n(sQLiteDatabase);
                    o(sQLiteDatabase);
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 12:
                    p(sQLiteDatabase);
                    q(sQLiteDatabase);
                    r(sQLiteDatabase);
                    return;
                case 13:
                    r(sQLiteDatabase);
                    return;
                default:
                    return;
            }
        }
    }

    public final void p(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD visit_time LONG DEFAULT -1;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg12to13 for table message_center", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void q(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        LinkedList<String> g2 = g(sQLiteDatabase);
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<String> it = g2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && (next.startsWith(m.f21372e) || next.startsWith(l.f21370e))) {
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD read_count LONG default -1;");
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg12to13", new Object[0]);
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void r(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD service_id TEXT;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg13to14", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void s(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, sQLiteDatabase) == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE tb_message_center RENAME TO test_table_temp;");
                        d(sQLiteDatabase);
                        sQLiteDatabase.execSQL("INSERT INTO tb_message_center SELECT gid,group_name,group_head,custom_group_type,group_ext,unread_count,last_msgId,last_user_name,last_content_time,'send_status' as send_status,last_content,'is_friend' as is_friend,'pull_msgid' as pull_msgid,is_hidden,is_delete FROM test_table_temp;");
                        sQLiteDatabase.execSQL("DROP TABLE test_table_temp;");
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.messageCenter6to7", new Object[0]);
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                        f(sQLiteDatabase);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    try {
                        sQLiteDatabase.beginTransaction();
                        HashMap<String, SQLiteDatabase> hashMap = g.f21360c;
                        hashMap.put(TbadkCoreApplication.getCurrentAccount() + ".db", sQLiteDatabase);
                        k.b();
                        sQLiteDatabase.setTransactionSuccessful();
                    } finally {
                        sQLiteDatabase.endTransaction();
                        HashMap<String, SQLiteDatabase> hashMap2 = g.f21360c;
                        hashMap2.remove(TbadkCoreApplication.getCurrentAccount() + ".db");
                    }
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    public final void t(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD sent_mid long default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD read_mid long default 0;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg7to8", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void u(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD user_type int default  1;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg8to9", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void v(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_new_friends RENAME TO tb_new_friends_tmp;");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid LONG NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
                sQLiteDatabase.execSQL("INSERT INTO tb_new_friends SELECT _id,uid,uname,ustatus,uportrait,ucontent,isread FROM tb_new_friends_tmp WHERE uid > 0;");
                sQLiteDatabase.execSQL("DROP TABLE tb_new_friends_tmp;");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.groupMsg9to10", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_new_friends");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
