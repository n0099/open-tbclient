package c.a.p0.a0.a.i;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.f;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f11923b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f11924c;

    /* renamed from: d  reason: collision with root package name */
    public static long f11925d;

    /* renamed from: e  reason: collision with root package name */
    public static String f11926e;

    /* renamed from: f  reason: collision with root package name */
    public static long f11927f;

    /* renamed from: g  reason: collision with root package name */
    public static String f11928g;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST_SUCCESS_NOT_SHOW);
            statisticItem.param("obj_source", str);
            statisticItem.param("obj_type", "a064");
            if (b.f11929b.equals(str)) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
            statisticItem.param("fid", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f11923b && a && f11924c) {
            if (b.f11929b.equals(f11928g)) {
                a(b.f11930c, null, f11925d);
            } else {
                a(b.f11929b, f11926e, f11927f);
            }
            c();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f11923b = false;
            a = false;
            f11924c = false;
            f11925d = 0L;
            f11926e = null;
            f11927f = 0L;
            f11928g = null;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f11924c = true;
            f11928g = str;
            b();
        }
    }

    public static void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j) == null) {
            a = true;
            f11925d = j;
            b();
        }
    }

    public static void f(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i != 3 || f.v()) {
                f11923b = true;
                f11926e = f.m(i);
                f11927f = j;
                b();
            }
        }
    }
}
