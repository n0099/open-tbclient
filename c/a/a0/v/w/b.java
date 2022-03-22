package c.a.a0.v.w;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.v0.o;
import c.a.a0.v.w.a;
import com.baidu.mobstat.Config;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(584619044, "Lc/a/a0/v/w/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(584619044, "Lc/a/a0/v/w/b;");
                return;
            }
        }
        a = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sd", "hd", Config.STAT_SDK_CHANNEL, "1080p"});
    }

    public static final Pair<Integer, Integer> a(ClarityUrlList list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            String b2 = b(true);
            int i = 0;
            String b3 = b(false);
            int size = list.size() - 1;
            int i2 = 0;
            for (ClarityUrlList.c entity : list) {
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                if (TextUtils.equals(entity.c(), b2)) {
                    i = i2;
                } else if (TextUtils.equals(entity.c(), b3)) {
                    size = i2;
                }
                i2++;
            }
            return new Pair<>(Integer.valueOf(size), Integer.valueOf(i));
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
            String a2 = o.a();
            if (a2 != null) {
                int hashCode = a2.hashCode();
                if (hashCode != 49) {
                    if (hashCode == 50 && a2.equals("2")) {
                        return a.C0079a.a;
                    }
                } else if (a2.equals("1")) {
                    return a.b.a;
                }
            }
            return a.C0079a.a;
        }
        return (a) invokeV.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String condition = o.b();
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
            String mobileNetClarity = o.c();
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
            String wifiClarity = o.e();
            if (a.contains(wifiClarity)) {
                Intrinsics.checkNotNullExpressionValue(wifiClarity, "wifiClarity");
                return wifiClarity;
            }
            return Config.STAT_SDK_CHANNEL;
        }
        return (String) invokeV.objValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? TextUtils.equals("1", o.d()) : invokeV.booleanValue;
    }
}
