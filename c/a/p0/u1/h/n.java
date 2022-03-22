package c.a.p0.u1.h;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1500;

    /* renamed from: b  reason: collision with root package name */
    public static int f18780b = 500;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1395497726, "Lc/a/p0/u1/h/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1395497726, "Lc/a/p0/u1/h/n;");
        }
    }

    public static void a() {
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (!StrangeCleanSwitch.isOn()) {
                c.a.o0.r.d0.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
                return;
            }
            try {
                try {
                    h.d().f();
                    d2 = d();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(d2)) {
                    return;
                }
                boolean b2 = b(d2);
                c.a.o0.r.d0.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + b2, new Object[0]);
            } finally {
                h.d().b();
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                h d2 = h.d();
                return d2.c("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.deleteStrange", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.o0.r.j0.b.k().l("key_max_stranger", a) : invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        List<String> e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                e2 = e();
            } catch (Exception e3) {
                e3.printStackTrace();
                TiebaStatic.printDBExceptionLog(e3, "ImMessageCenterDao.getStrangeData", new Object[0]);
            }
            if (e2 != null && e2.size() != 0) {
                int c2 = c();
                c.a.o0.r.d0.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + e2.size() + " max is " + c2, new Object[0]);
                if (e2.size() > c2) {
                    int i = 2000;
                    if (2000 >= e2.size() - c2) {
                        i = e2.size() - c2;
                    }
                    boolean z = true;
                    for (String str : e2.subList(0, i)) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append(str);
                    }
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = h.d().e("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
                }
                return arrayList;
            } finally {
                o.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public static void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            int i2 = f18780b;
            if (i < i2) {
                i = i2;
            }
            c.a.o0.r.j0.b.k().w("key_max_stranger", i);
        }
    }
}
