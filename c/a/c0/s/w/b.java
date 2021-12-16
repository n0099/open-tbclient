package c.a.c0.s.w;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.v0.p;
import c.a.c0.s.w.a;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "CloudClarityConfig")
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1178789961, "Lc/a/c0/s/w/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1178789961, "Lc/a/c0/s/w/b;");
                return;
            }
        }
        a = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sd", "hd", "sc", "1080p"});
    }

    public static final Pair<Integer, Integer> a(ClarityUrlList list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            String b2 = b(true);
            int i2 = 0;
            String b3 = b(false);
            int size = list.size() - 1;
            int i3 = 0;
            for (ClarityUrlList.c entity : list) {
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                if (TextUtils.equals(entity.c(), b2)) {
                    i2 = i3;
                } else if (TextUtils.equals(entity.c(), b3)) {
                    size = i3;
                }
                i3++;
            }
            return new Pair<>(Integer.valueOf(size), Integer.valueOf(i2));
        }
        return (Pair) invokeL.objValue;
    }

    public static final String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return f();
            }
            return e();
        }
        return (String) invokeZ.objValue;
    }

    public static final a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String a2 = p.a();
            if (a2 != null) {
                int hashCode = a2.hashCode();
                if (hashCode != 49) {
                    if (hashCode == 50 && a2.equals("2")) {
                        return a.C0070a.a;
                    }
                } else if (a2.equals("1")) {
                    return a.b.a;
                }
            }
            return a.C0070a.a;
        }
        return (a) invokeV.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String condition = p.b();
            for (String str : a) {
                Intrinsics.checkNotNullExpressionValue(condition, "condition");
                if (StringsKt__StringsKt.contains$default((CharSequence) condition, (CharSequence) str, false, 2, (Object) null)) {
                    return condition;
                }
            }
            return "1080p";
        }
        return (String) invokeV.objValue;
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String mobileNetClarity = p.c();
            if (a.contains(mobileNetClarity)) {
                Intrinsics.checkNotNullExpressionValue(mobileNetClarity, "mobileNetClarity");
                return mobileNetClarity;
            }
            return "sd";
        }
        return (String) invokeV.objValue;
    }

    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String wifiClarity = p.e();
            if (a.contains(wifiClarity)) {
                Intrinsics.checkNotNullExpressionValue(wifiClarity, "wifiClarity");
                return wifiClarity;
            }
            return "sc";
        }
        return (String) invokeV.objValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? TextUtils.equals("1", p.d()) : invokeV.booleanValue;
    }
}
