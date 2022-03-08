package c.a.r0.y3.q0;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1176417408, "Lc/a/r0/y3/q0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1176417408, "Lc/a/r0/y3/q0/a;");
        }
    }

    public static boolean a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i2)});
            return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i2), "", str});
        }
        return invokeLI.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c(0);
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (i2 == 0) {
                mainDBDatabaseManager.d("delete from search_data");
            } else if (i2 != 1) {
            } else {
                mainDBDatabaseManager.d("delete from search_post_data");
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c(1);
        }
    }

    public static void e(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, null, i2) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i2), TbadkCoreApplication.getCurrentAccount()});
    }

    public static void f(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65542, null, i2, str) == null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i2), (str == null || str.length() == 0) ? "0" : "0"});
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f(13, str);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            i(0, str);
        }
    }

    public static void i(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i2, str) == null) {
            c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null) {
                if (i2 == 0) {
                    mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
                } else if (i2 != 1) {
                } else {
                    mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                }
            }
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            e(2);
        }
    }

    public static ArrayList<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? l(0) : (ArrayList) invokeV.objValue;
    }

    public static ArrayList<String> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursor = null;
            try {
                try {
                    if (i2 == 0) {
                        cursor = mainDBDatabaseManager.j("select * from search_data order by time desc limit 20", null);
                    } else if (i2 == 1) {
                        cursor = mainDBDatabaseManager.j("select * from search_post_data order by time desc limit 5", null);
                    }
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.length() > 0) {
                            arrayList.add(string);
                        }
                    }
                } catch (Exception e2) {
                    mainDBDatabaseManager.i(e2, "getAllSearchData");
                }
                return arrayList;
            } finally {
                c.a.d.f.m.a.a(cursor);
            }
        }
        return (ArrayList) invokeI.objValue;
    }

    public static ArrayList<String> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? l(1) : (ArrayList) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0 || TbadkCoreApplication.getCurrentAccountName() == null) {
            return;
        }
        c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            try {
                cursor = mainDBDatabaseManager.j("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                if (cursor != null && cursor.moveToFirst()) {
                    c.a.q0.s.d.d.d().H(cursor.getInt(cursor.getColumnIndex("frequency")));
                    c.a.q0.s.d.d.d().J(cursor.getInt(cursor.getColumnIndex("fans_switch")) == 1);
                    if (cursor.getInt(cursor.getColumnIndex("reply_me_switch")) == 0) {
                        c.a.q0.s.d.d.d().K(false);
                    } else {
                        c.a.q0.s.d.d.d().K(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("at_me_switch")) == 0) {
                        c.a.q0.s.d.d.d().F(false);
                    } else {
                        c.a.q0.s.d.d.d().F(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("zan_me_switch")) == 0) {
                        c.a.q0.s.d.d.d().N(false);
                    } else {
                        c.a.q0.s.d.d.d().N(true);
                    }
                    c.a.q0.s.d.d.d().a(cursor.getInt(cursor.getColumnIndex("remind_tone")));
                    if (cursor.getInt(cursor.getColumnIndex("msg_chat_switch")) == 0) {
                        c.a.q0.s.d.d.d().G(false);
                    } else {
                        c.a.q0.s.d.d.d().G(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("nodisturb_switch")) == 0) {
                        c.a.q0.s.d.d.d().P(false);
                    } else {
                        c.a.q0.s.d.d.d().P(true);
                    }
                    String string = cursor.getString(cursor.getColumnIndex("nodisturb_start_time"));
                    if (TextUtils.isEmpty(string)) {
                        c.a.q0.s.d.d.d().Q(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        c.a.q0.s.d.d.d().Q(string);
                    }
                    String string2 = cursor.getString(cursor.getColumnIndex("nodisturb_end_time"));
                    if (TextUtils.isEmpty(string2)) {
                        c.a.q0.s.d.d.d().O(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        c.a.q0.s.d.d.d().O(string2);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("remind_light")) == 0) {
                        c.a.q0.s.d.d.d().I(false);
                    } else {
                        c.a.q0.s.d.d.d().I(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("stranger_chat_switch")) == 0) {
                        c.a.q0.s.d.d.d().W(false);
                    } else {
                        c.a.q0.s.d.d.d().W(true);
                    }
                } else {
                    c.a.q0.s.d.d.d().H(300);
                    c.a.q0.s.d.d.d().J(true);
                    c.a.q0.s.d.d.d().K(true);
                    c.a.q0.s.d.d.d().F(true);
                    c.a.q0.s.d.d.d().N(true);
                    c.a.q0.s.d.d.d().L(true);
                    c.a.q0.s.d.d.d().M(false);
                    c.a.q0.s.d.d.d().I(true);
                    c.a.q0.s.d.d.d().W(false);
                    c.a.q0.s.d.d.d().G(true);
                    c.a.q0.s.d.d.d().P(false);
                    c.a.q0.s.d.d.d().Q(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    c.a.q0.s.d.d.d().O(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
            } catch (Exception e2) {
                mainDBDatabaseManager.i(e2, "getSettingData");
            }
            c.a.d.f.m.a.a(cursor);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
        } catch (Throwable th) {
            c.a.d.f.m.a.a(null);
            throw th;
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            p(0, str);
        }
    }

    public static void p(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i2, str) == null) {
            c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null) {
                if (i2 == 0) {
                    mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.e("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                } else if (i2 != 1) {
                } else {
                    mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.e("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                }
            }
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            p(1, str);
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, null) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
        mainDBDatabaseManager.e("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{TbadkCoreApplication.getCurrentAccount(), Integer.valueOf(c.a.q0.s.d.d.d().e()), Integer.valueOf(c.a.q0.s.d.d.d().t() ? 1 : 0), Integer.valueOf(c.a.q0.s.d.d.d().v() ? 1 : 0), Integer.valueOf(c.a.q0.s.d.d.d().q() ? 1 : 0), Integer.valueOf(c.a.q0.s.d.d.d().c()), Integer.valueOf(c.a.q0.s.d.d.d().r() ? 1 : 0), Integer.valueOf(c.a.q0.s.d.d.d().z() ? 1 : 0), c.a.q0.s.d.d.d().g(), c.a.q0.s.d.d.d().f(), Integer.valueOf(c.a.q0.s.d.d.d().s() ? 1 : 0), Integer.valueOf(c.a.q0.s.d.d.d().B() ? 1 : 0), Integer.valueOf(c.a.q0.s.d.d.d().y() ? 1 : 0)});
    }
}
