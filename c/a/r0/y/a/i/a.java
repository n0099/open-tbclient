package c.a.r0.y.a.i;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.f;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f24684b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f24685c;

    /* renamed from: d  reason: collision with root package name */
    public static long f24686d;

    /* renamed from: e  reason: collision with root package name */
    public static String f24687e;

    /* renamed from: f  reason: collision with root package name */
    public static long f24688f;

    /* renamed from: g  reason: collision with root package name */
    public static String f24689g;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST_SUCCESS_NOT_SHOW);
            statisticItem.param("obj_source", str);
            statisticItem.param("obj_type", "a064");
            if (b.f24690b.equals(str)) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
            statisticItem.param("fid", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f24684b && a && f24685c) {
            if (b.f24690b.equals(f24689g)) {
                a(b.f24691c, null, f24686d);
            } else {
                a(b.f24690b, f24687e, f24688f);
            }
            c();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f24684b = false;
            a = false;
            f24685c = false;
            f24686d = 0L;
            f24687e = null;
            f24688f = 0L;
            f24689g = null;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f24685c = true;
            f24689g = str;
            b();
        }
    }

    public static void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2) == null) {
            a = true;
            f24686d = j2;
            b();
        }
    }

    public static void f(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (i2 != 3 || f.m()) {
                f24684b = true;
                f24687e = f.g(i2);
                f24688f = j2;
                b();
            }
        }
    }
}
