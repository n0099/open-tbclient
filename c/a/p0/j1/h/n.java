package c.a.p0.j1.h;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f20473a = 1500;

    /* renamed from: b  reason: collision with root package name */
    public static int f20474b = 500;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(222891827, "Lc/a/p0/j1/h/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(222891827, "Lc/a/p0/j1/h/n;");
        }
    }

    public static void a() {
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (!StrangeCleanSwitch.isOn()) {
                c.a.o0.s.z.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
                return;
            }
            try {
                try {
                    h.e().i();
                    d2 = d();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(d2)) {
                    return;
                }
                boolean b2 = b(d2);
                c.a.o0.s.z.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + b2, new Object[0]);
            } finally {
                h.e().c();
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                h e2 = h.e();
                return e2.d("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
            } catch (Exception e3) {
                e3.printStackTrace();
                TiebaStatic.printDBExceptionLog(e3, "ImMessageCenterDao.deleteStrange", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.o0.s.d0.b.j().k("key_max_stranger", f20473a) : invokeV.intValue;
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
                c.a.o0.s.z.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + e2.size() + " max is " + c2, new Object[0]);
                if (e2.size() > c2) {
                    int i2 = 2000;
                    if (2000 >= e2.size() - c2) {
                        i2 = e2.size() - c2;
                    }
                    boolean z = true;
                    for (String str : e2.subList(0, i2)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = h.e().h("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
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
                c.a.e.e.p.m.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public static void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
            int i3 = f20474b;
            if (i2 < i3) {
                i2 = i3;
            }
            c.a.o0.s.d0.b.j().v("key_max_stranger", i2);
        }
    }
}
